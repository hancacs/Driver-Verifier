package com.ecarride;

import javax.mail.MessagingException;
import javax.persistence.*;

import com.ecarride.model.*;

import com.oracle.tools.packager.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class App {
	private static Set<TlcDriver> tlcDrivers = new HashSet<>();
	private static Map<String,TlcDriver> tlcDriverMap = new HashMap<>();
	private static Map<String,TlcDriver> tlcVehicleMap = new HashMap<>();
	private static final String FHV_ACTIVE_API = "https://data.cityofnewyork.us/resource/p8xb-39i5.json";
	private static final String STREET_HAIL_LIVERY_API = "https://data.cityofnewyork.us/resource/n9g6-5xfa.json";
	private static final String FHV_VEHICLE_API = "https://data.cityofnewyork.us/resource/k5sk-y8y9.json";
	private static int fhvDriverActiveNum = 0, fhvShlActiveNum = 0, fhvVehichleActiveNum = 0, baseChangedNum = 0, inTroubleNum = 0;
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	private static final String[] ADMIN_RECIPIENTS = Credentials.ADMIN_RECIPIENTS;
//	private static final String[] ADMIN_RECIPIENTS = {
//		"han@cacsnyc.com"
//	};
	public static void main(String[] args) throws IOException, JSONException, MessagingException, InterruptedException {
		getDrivers();
		checkDriver();
		Map<String, String> adminEmailContent = generateAdminEmailContent(tlcDrivers);
		Email.sendEmail(adminEmailContent, "Driver Verification", ADMIN_RECIPIENTS);

		//sendEmailToDrivers(tlcDrivers);
		////////////////////////////////ResetDriverWorkStatus();
	}




	public static void ResetDriverWorkStatus() {
		Iterator<TlcDriver> iterator = tlcDrivers.iterator();
		while(iterator.hasNext()) {
			TlcDriver temp = iterator.next();
			if(!temp.isInTrouble()) continue;
			EntityTransaction updateTransaction = entityManager
					.getTransaction();
			updateTransaction.begin();
			Query query = entityManager
					.createQuery("UPDATE Driver d SET d.baseApproved = 0, d.status = 0"
							+ "WHERE d.id= :id");
			query.setParameter("id", temp.getDriver().getId());
			query.executeUpdate();
			updateTransaction.commit();
		}
	}

	public static void sendEmailToDrivers(Set<TlcDriver> tlcDrivers) throws MessagingException {
		Iterator<TlcDriver> iterator = tlcDrivers.iterator();
		Map<String, String> result = new LinkedHashMap<>();
		String driverAlert = "";
		while(iterator.hasNext()) {
			TlcDriver tlcDriver = iterator.next();
			if(tlcDriver.isInTrouble()) {
				inTroubleNum++;
				driverAlert += "<b>Your work has been suspended due to a driver and/or vehicle status change. <br>" +
						"Please contact your base. <br><br> </b>  Your info: <br>";
				driverAlert += "Name: " + tlcDriver.getDriver().getFirstName() + " " + tlcDriver.getDriver().getLastName() + " <br>" +
						"TLC_FHV_License_Number: " + tlcDriver.getDriver().getDriverTlcFhvLicenseNum() + "  <br>" +
						"TLC_FHV_Vehicle_License_Number: " + tlcDriver.getTaxiVehicle().getVehicleTlcFhvLicenseNum() + "<br> <br>";
				driverAlert += "Reason: <br>";
				if(!tlcDriver.isActiveInFhvDrivers()) {
					driverAlert += "You are not a <b> For-Hire Vehicles FHV Active Driver. Please contact your base</b> <br>";
				}
				if(!tlcDriver.isActiveInStreetHailLivery()) {
					driverAlert += "You are not a <b> Street-Hail-Livery Active Driver. Please contact your base</b> <br>";
				}
				if(!tlcDriver.isActiveInvehiclesFhv()) {
					driverAlert += "Your vehicle is not  <b> For-Hire Vehicles FHV Active. Please contact your base</b> <br>";
				}
				if(tlcDriver.isBaseChanged()) {
					driverAlert += "Your record is no longer under our base. Please contact your base<br>";
				}
			}
		}
		String[] driverRecipients = new String[inTroubleNum];
		result.put("Driver_Alert", driverAlert);
		Email.sendEmail(result, "Driver Status Alert",new String[]{"han@cacsnyc.com"});
	}

	public static Map<String, String> generateAdminEmailContent(Set<TlcDriver> tlcDrivers) {
		Iterator<TlcDriver> iterator = tlcDrivers.iterator();
		Map<String, String> result = new LinkedHashMap<>();
		String FhvDriverActiveResult = "<b><a href=\"https://data.cityofnewyork.us/Transportation/For-Hire-Vehicles-FHV-Active-Drivers/xjfq-wh2d/data\">These drivers are not active in For-Hire-Vehicles-FHV-Active-Drivers table</a>: " + "(" + (tlcDrivers.size() - fhvDriverActiveNum) + "/" + tlcDrivers.size() + ")" + "</b> <br><table>";
		String ShlActiveResult = "<b><a href=\"https://data.cityofnewyork.us/Transportation/Street-Hail-Livery-Drivers-Active/5tub-eh45/data\">These drivers are not active in Street-Hail-Livery-Drivers-Active table</a>: " + "(" +(tlcDrivers.size() - fhvShlActiveNum) + "/" + tlcDrivers.size() + ")" + "</b> <br><table>";
		String FhvVehicleResult = "<b><a href=\"https://data.cityofnewyork.us/Transportation/For-Hire-Vehicles-FHV-Active-and-Inactive-Vehicles/8wbx-tsch/data\">These drivers are not active in For-Hire-Vehicles-FHV-Active-and-Inactive-Vehicles table</a>: " + "(" +(tlcDrivers.size() - fhvVehichleActiveNum) + "/" + tlcDrivers.size() + ")" + "</b> <br><table>";
		String BaseChangedResult = "<b><a href=\"https://data.cityofnewyork.us/Transportation/For-Hire-Vehicles-FHV-Active-and-Inactive-Vehicles/8wbx-tsch/data\">These drivers are not affiliated to our base</a>: " + "(" +baseChangedNum +  "/" + tlcDrivers.size() + ")" + "<b></br><table>";
		while(iterator.hasNext()) {
			TlcDriver driver = iterator.next();
			if(!driver.isActiveInFhvDrivers()) {
				FhvDriverActiveResult += "<tr><td><b>Name: </b><span style='padding-left:5px;'>" + driver.getDriver().getFirstName() + " " + driver.getDriver().getLastName() + "</span></td><td><b>TLC_FHV_License_Number: </b><span style='padding-left:5px;color:red;'>" +
						driver.getDriver().getDriverTlcFhvLicenseNum() + "  </span></td><td><b>TLC_FHV_Vehicle_License_Number: </b><span style='padding-left:5px;'>" + driver.getTaxiVehicle().getVehicleTlcFhvLicenseNum() + "</span></td></tr>";
			}

			if(!driver.isActiveInStreetHailLivery()) {
				ShlActiveResult += "<tr><td><b>Name: </b><span style='padding-left:5px;'>" + driver.getDriver().getFirstName() + " " + driver.getDriver().getLastName() + "</span></td><td><b>TLC_FHV_License_Number: </b><span style='padding-left:5px;color:red;'>" +
						driver.getDriver().getDriverTlcFhvLicenseNum() + "  </span></td><td><b>TLC_FHV_Vehicle_License_Number: </b><span style='padding-left:5px;'>" + driver.getTaxiVehicle().getVehicleTlcFhvLicenseNum() + "</span></td></tr>";
			}
			if(!driver.isActiveInvehiclesFhv()) {
				FhvVehicleResult += "<tr><td><b>Name: </b><span style='padding-left:5px;'>" + driver.getDriver().getFirstName() + " " + driver.getDriver().getLastName() + "</span></td><td><b>TLC_FHV_License_Number: </b><span style='padding-left:5px;'>" +
						driver.getDriver().getDriverTlcFhvLicenseNum() + "  </span></td><td><b>TLC_FHV_Vehicle_License_Number: </b><span style='padding-left:5px;color:red;'>" + driver.getTaxiVehicle().getVehicleTlcFhvLicenseNum() + "</span></td></tr>";
			}
			if(driver.isBaseChanged()) {
				BaseChangedResult += "<tr><td><b>Name: </b><span style='padding-left:5px;'>" + driver.getDriver().getFirstName() + " " + driver.getDriver().getLastName() + "</span></td><td><b>TLC_FHV_License_Number: </b><span style='padding-left:5px;'>" +
						driver.getDriver().getDriverTlcFhvLicenseNum() + "  </span></td><td><b>TLC_FHV_Vehicle_License_Number: </b><span style='padding-left:5px; color:red;'>" + driver.getTaxiVehicle().getVehicleTlcFhvLicenseNum() + "</span></td></tr>";
			}
		}

		FhvDriverActiveResult += "</table>";
		ShlActiveResult += "</table>";
		FhvVehicleResult += "</table>";
		BaseChangedResult += "</table>";

		result.put("Admin_FhvDriver", FhvDriverActiveResult);
		result.put("Admin_Shl", ShlActiveResult);
		result.put("Admin_FhvVehicle", FhvVehicleResult);
		result.put("Admin_BaseChanged", BaseChangedResult);

		return result;
	}

//	public static void checkDriver(String url) throws JSONException {
//		String json = loadJson(url);
//		System.out.println(url);
//		String licenseNumber = "", vehicleLicenseNumber = "";
//		JSONArray array = new JSONArray(json);
//		System.out.println(array.length());
//		for(int i=0; i<array.length(); i++){
//			JSONObject jsonObj  = array.getJSONObject(i);
//			if(url.equals("https://data.cityofnewyork.us/resource/k5sk-y8y9.json")) {
//				vehicleLicenseNumber = jsonObj.getString("vehicle_license_number").trim();
//				if(!tlcVehicleMap.containsKey(vehicleLicenseNumber))
//					continue;
//				TlcDriver tempDriver = tlcVehicleMap.get(vehicleLicenseNumber);
//				System.out.println("333333 " + tempDriver.getDriver().getFirstName() + "  " + tempDriver.getDriver().getDriverTlcFhvLicenseNum() + "   " + tempDriver.getTaxiVehicle().getVehicleTlcFhvLicenseNum());
//				if(jsonObj.getString("active").toLowerCase().equals("yes")) {
//					tempDriver.setActiveInvehiclesFhv(true);
//					fhvVehichleActiveNum++;
//				}
//				if(!jsonObj.getString("base_number").substring(jsonObj.getString("base_number").length() - 4).equals(String.valueOf(tempDriver.getTaxiBase().getTlcLicenseNum()))) {
//					tempDriver.setBaseChanged(true);
//					baseChangedNum++;
//				}
//			}
//			else {
//				licenseNumber = jsonObj.getString("license_number").trim();
////				if (licenseNumber.equals("5643885")) {
////					System.out.println("\n\n\n\n\n\n  hahahahahahahaah \n\n\n\n\n\n");
////				}
//				if(!tlcDriverMap.containsKey(licenseNumber))
//					continue;
////				if (licenseNumber.equals("5643885")) {
////					System.out.println(licenseNumber +"\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n       " + tlcDriverMap.get("5643885").getDriver().getFirstName());
////				}
//				TlcDriver tempDriver = tlcDriverMap.get(licenseNumber);
//				switch (url) {
//					case "https://data.cityofnewyork.us/resource/p8xb-39i5.json" :
//						System.out.println("111111 " + tempDriver.getDriver().getFirstName() + "  " + tempDriver.getDriver().getDriverTlcFhvLicenseNum() + "   " + tempDriver.getTaxiVehicle().getVehicleTlcFhvLicenseNum());
//						tempDriver.setActiveInFhvDrivers(true);
//						fhvDriverActiveNum++;
//						break;
//					case "https://data.cityofnewyork.us/resource/n9g6-5xfa.json" :
//						System.out.println("222222 " + tempDriver.getDriver().getFirstName() + "  " + tempDriver.getDriver().getDriverTlcFhvLicenseNum() + "   " + tempDriver.getTaxiVehicle().getVehicleTlcFhvLicenseNum());
//						tempDriver.setActiveInStreetHailLivery(true);
//						fhvShlActiveNum++;
//						break;
//				}
//			}
//
//		}
//
//	}




	public static void checkDriver() throws JSONException, InterruptedException {

		for (TlcDriver thisDriver : tlcDrivers) {
//			String url = "https://data.cityofnewyork.us/resource/k5sk-y8y9.json?vehicle_license_number=5675001";

			JSONArray jsonDriverArray = null;
			JSONArray jsonSHLArray = null;
			JSONArray jsonVehicleArray = null;

			jsonDriverArray = loadJson(FHV_ACTIVE_API + "?license_number=" + thisDriver.getDriver().getDriverTlcFhvLicenseNum());
			jsonSHLArray = loadJson(STREET_HAIL_LIVERY_API + "?license_number=" + thisDriver.getDriver().getDriverTlcFhvLicenseNum());
			jsonVehicleArray = loadJson(FHV_VEHICLE_API + "?vehicle_license_number=" + thisDriver.getTaxiVehicle().getVehicleTlcFhvLicenseNum());

			if (jsonDriverArray == null) {
				TimeUnit.SECONDS.sleep(1);
				jsonDriverArray = loadJson(FHV_ACTIVE_API + "?license_number=" + thisDriver.getDriver().getDriverTlcFhvLicenseNum());
			}

			if (jsonSHLArray == null) {
				TimeUnit.SECONDS.sleep(1);
				jsonSHLArray = loadJson(STREET_HAIL_LIVERY_API + "?license_number=" + thisDriver.getDriver().getDriverTlcFhvLicenseNum());
			}

			if (jsonVehicleArray == null) {
				TimeUnit.SECONDS.sleep(1);
				jsonVehicleArray = loadJson(FHV_VEHICLE_API + "?vehicle_license_number=" + thisDriver.getTaxiVehicle().getVehicleTlcFhvLicenseNum());
			}


			// check driver
			if (jsonDriverArray.length() != 0) {
				thisDriver.setActiveInFhvDrivers(true);
				fhvDriverActiveNum++;
			}
			// check SHL
			if (jsonSHLArray.length() != 0) {
				thisDriver.setActiveInStreetHailLivery(true);
				fhvShlActiveNum++;
			}
			//check vehicle
			if (jsonVehicleArray.length() != 0 && jsonVehicleArray.getJSONObject(0).getString("active").trim().toLowerCase().equals("yes")) {
				thisDriver.setActiveInvehiclesFhv(true);
				fhvVehichleActiveNum++;
			}
			//check base change
			if (jsonVehicleArray.length() != 0) {
				JSONObject thisJSON = jsonVehicleArray.getJSONObject(0);
				String baseNumberInJSON = thisJSON.getString("base_number").trim();
				if (!baseNumberInJSON.substring(baseNumberInJSON.length() - 4).equals(String.valueOf(thisDriver.getTaxiBase().getTlcLicenseNum()))) {
					thisDriver.setBaseChanged(true);
					baseChangedNum++;
				}
			}

		}
	}
	public static JSONArray loadJson (String url) throws JSONException {
		StringBuilder json = new StringBuilder();
		try {
			URL urlObject = new URL(url);
			URLConnection uc = urlObject.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));

			String inputLine = null;
//			int count = 0;
			while ( (inputLine = in.readLine()) != null ) {
				json.append(inputLine);
				/*if (count++ <= 2)
					System.out.println(inputLine);*/
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JSONArray(json.toString());
	}

	public static void getDrivers() {
		Query query = entityManager.createQuery("SELECT d FROM Driver d");
		Collection<Driver> allDrivers =  query.getResultList();
		for(Driver driver : allDrivers) {
			TaxiVehicle taxiVehicle = entityManager.getReference(TaxiVehicle.class, driver.getVehicleId());
			TaxiBase taxiBase = entityManager.getReference(TaxiBase.class, driver.getBaseId());


			if(driver.getLastName().contains("test") || driver.getLastName().contains("Test") || driver.getFirstName().contains("TEST") ||
					driver.getFirstName().contains("test") || driver.getFirstName().contains("Test") || driver.getFirstName().contains("TEST")||
					driver.getBaseApproved() == 0) {
				continue;
			}
			TlcDriver tlcDriver = new TlcDriver(driver, taxiBase, taxiVehicle);
			tlcDrivers.add(tlcDriver);
			tlcDriverMap.put(tlcDriver.getDriver().getDriverTlcFhvLicenseNum(), tlcDriver);
			tlcVehicleMap.put(tlcDriver.getTaxiVehicle().getVehicleTlcFhvLicenseNum(), tlcDriver);
//			System.out.println(tlcDriver.getDriver().getFirstName() + " " + tlcDriver.getDriver().getDriverTlcFhvLicenseNum() + " " + tlcDriver.getTaxiVehicle().getVehicleTlcFhvLicenseNum());
		}

	}

}
