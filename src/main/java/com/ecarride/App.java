package com.ecarride;

import javax.mail.MessagingException;
import javax.persistence.*;

import com.ecarride.model.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

import static com.ecarride.App.generateDriverEmailContent;


/**
 * Simple standalone JPA app.
 * Will load the user inserted by the script import-users.sql
 * 
 * @author Geoffroy Warin (https://github.com/geowarin)
 *
 */
public class App {

	public static Set<TlcDriver> tlcDrivers = new HashSet<>();
	public static Map<String,TlcDriver> tlcDriverMap = new HashMap<>();
	public static Map<String,TlcDriver> tlcVehicleMap = new HashMap<>();
	public static String fhvActiveAPI = "https://data.cityofnewyork.us/resource/p8xb-39i5.json";
	public static String streetHailLiveryAPI = "https://data.cityofnewyork.us/resource/n9g6-5xfa.json";
	public static String fhvVehicleAPI = "https://data.cityofnewyork.us/resource/k5sk-y8y9.json";
	public static int fhvDriverActiveNum = 0, fhvShlActiveNum = 0, fhvVehichleActiveNum = 0, baseChangedNum = 0, inTroubleNum = 0;
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	public static final String[] ADMIN_RECIPIENTS = {"han@cacsnyc.com"};
	public static  String[] driverRecipients;

	public static void main(String[] args) throws IOException, JSONException, MessagingException {
		getDrivers();
		checkDriver(fhvActiveAPI);
		checkDriver(streetHailLiveryAPI);
		checkDriver(fhvVehicleAPI);
		Map<String, String> adminEmailContent = generateAdminEmailContent(tlcDrivers);
//		Map<String, String> driverEmailContent = generateDriverEmailContent(tlcDrivers);
		Email.sendEmail(adminEmailContent, "Driver Verification", ADMIN_RECIPIENTS);
		generateDriverEmailContent(tlcDrivers);
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

	public static void generateDriverEmailContent(Set<TlcDriver> tlcDrivers) throws MessagingException {
		Iterator<TlcDriver> iterator = tlcDrivers.iterator();
		Map<String, String> result = new LinkedHashMap<>();
		String driverAlert = "";
		while(iterator.hasNext()) {
			TlcDriver tlcDriver = iterator.next();
			if(tlcDriver.isInTrouble()) {
				inTroubleNum++;
				driverAlert += "<b>Because your driver or vehicle status has changed, you work has been suspend. <br>" +
						"Please contact your base. <br><br> </b>  Your info: <br>";
				driverAlert += "Name: " + tlcDriver.getDriver().getFirstName() + " " + tlcDriver.getDriver().getLastName() + " <br>" +
						"TLC_FHV_License_Number: " + tlcDriver.getDriver().getDriverTlcFhvLicenseNum() + "  <br>" +
						"TLC_FHV_Vehicle_License_Number: " + tlcDriver.getTaxiVehicle().getVehicleTlcFhvLicenseNum() + "<br> <br>";
				driverAlert += "Reason: <br>";
				if(!tlcDriver.isActiveInFhvDrivers()) {
					driverAlert += "You are not a <b> For-Hire Vehicles FHV Active Driver</b> <br>";
				}
				if(!tlcDriver.isActiveInStreetHailLivery()) {
					driverAlert += "You are not a <b> Street-Hail-Livery Active Driver</b> <br>";
				}
				if(!tlcDriver.isActiveInvehiclesFhv()) {
					driverAlert += "Your vehicle is not  <b> For-Hire Vehicles FHV Active</b> <br>";
				}
				if(tlcDriver.isBaseChanged()) {
					driverAlert += "You are no longer a driver in our base<br>";
				}
			}
		}
		driverRecipients = new String[inTroubleNum];
		result.put("Driver_Alert", driverAlert);
		Email.sendEmail(result, "Driver Status Alert",new String[]{"han@cacsnyc.com"});
	}

	public static Map<String, String> generateAdminEmailContent(Set<TlcDriver> tlcDrivers) {
		Iterator<TlcDriver> iterator = tlcDrivers.iterator();
		Map<String, String> result = new LinkedHashMap<>();
		String FhvDriverActiveResult = "<b>These drivers are not active in For-Hire-Vehicles-FHV-Active-Drivers table: " + "(" + (tlcDrivers.size() - fhvDriverActiveNum) + "/" + tlcDrivers.size() + ")" + "</b> <br>";
		String ShlActiveResult = "<b>These drivers are not active in Street-Hail-Livery-Drivers-Active table: " + "(" +(tlcDrivers.size() - fhvShlActiveNum) + ")" + "</b> <br>";
		String FhvVehicleResult = "<b>These drivers are not active in For-Hire-Vehicles-FHV-Active-and-Inactive-Vehicles: " + "(" +(tlcDrivers.size() - fhvVehichleActiveNum) + "/" + tlcDrivers.size() + ")" + "</b> <br>";
		String BaseChangedResult = "<b>There drivers are not in base any more: " + "(" +baseChangedNum +  "/" + tlcDrivers.size() + ")" + "<b></br>";
		while(iterator.hasNext()) {
			TlcDriver driver = iterator.next();
			if(!driver.isActiveInFhvDrivers()) {
				FhvDriverActiveResult += "<tr><td><b>Name: </b>" + driver.getDriver().getFirstName() + " " + driver.getDriver().getLastName() + "</td><td><b>TLC_FHV_License_Number: </b>" +
						driver.getDriver().getDriverTlcFhvLicenseNum() + "  </td><td><b>TLC_FHV_Vehicle_License_Number: </b>" + driver.getTaxiVehicle().getVehicleTlcFhvLicenseNum() + "</td></tr>";

			}

			if(!driver.isActiveInStreetHailLivery()) {
				ShlActiveResult += "<tr><td><b>Name: </b>" + driver.getDriver().getFirstName() + " " + driver.getDriver().getLastName() + "</td><td><b>TLC_FHV_License_Number: </b>" +
						driver.getDriver().getDriverTlcFhvLicenseNum() + "  </td><td><b>TLC_FHV_Vehicle_License_Number: </b>" + driver.getTaxiVehicle().getVehicleTlcFhvLicenseNum() + "</td></tr>";
			}
			if(!driver.isActiveInvehiclesFhv()) {
				FhvVehicleResult += "<tr><td><b>Name: </b>" + driver.getDriver().getFirstName() + " " + driver.getDriver().getLastName() + "</td><td><b>TLC_FHV_License_Number: </b>" +
						driver.getDriver().getDriverTlcFhvLicenseNum() + "  </td><td><b>TLC_FHV_Vehicle_License_Number: </b>" + driver.getTaxiVehicle().getVehicleTlcFhvLicenseNum() + "</td></tr>";
			}
			if(driver.isBaseChanged()) {
				BaseChangedResult += "<tr><td><b>Name: </b>" + driver.getDriver().getFirstName() + " " + driver.getDriver().getLastName() + "</td><td><b>TLC_FHV_License_Number: </b>" +
						driver.getDriver().getDriverTlcFhvLicenseNum() + "  </td><td><b>TLC_FHV_Vehicle_License_Number: </b>" + driver.getTaxiVehicle().getVehicleTlcFhvLicenseNum() + "</td></tr>";
			}
		}
		result.put("Admin_FhvDriver", FhvDriverActiveResult);
		result.put("Admin_Shl", ShlActiveResult);
		result.put("Admin_FhvVehicle", FhvVehicleResult);
		result.put("Admin_BaseChanged", BaseChangedResult);

		return result;
	}

	public static void checkDriver(String url) throws JSONException {
		String json = loadJson(url);
		String licenseNumber = "", vehicleLicenseNumber = "";
		JSONArray array = new JSONArray(json);
		for(int i=0; i<array.length(); i++){
			JSONObject jsonObj  = array.getJSONObject(i);

			if(url.equals("https://data.cityofnewyork.us/resource/k5sk-y8y9.json")) {
				vehicleLicenseNumber = jsonObj.getString("vehicle_license_number").trim();
				if(!tlcVehicleMap.containsKey(vehicleLicenseNumber))
					continue;
				TlcDriver tempDriver = tlcVehicleMap.get(vehicleLicenseNumber);
				if(jsonObj.getString("active").toLowerCase().equals("yes")) {
					tempDriver.setActiveInvehiclesFhv(true);
					fhvVehichleActiveNum++;
				}
				if(!jsonObj.getString("base_number").substring(jsonObj.getString("base_number").length() - 4).equals(String.valueOf(tempDriver.getTaxiBase().getTlcLicenseNum()))) {
					tempDriver.setBaseChanged(true);
					baseChangedNum++;
				}
			}
			else {
				licenseNumber = jsonObj.getString("license_number").trim();
				if(!tlcDriverMap.containsKey(licenseNumber))
					continue;
				TlcDriver tempDriver = tlcDriverMap.get(licenseNumber);
				switch (url) {
					case "https://data.cityofnewyork.us/resource/p8xb-39i5.json" :
						tempDriver.setActiveInFhvDrivers(true);
						fhvDriverActiveNum++;
						break;
					case "https://data.cityofnewyork.us/resource/n9g6-5xfa.json" :
						tempDriver.setActiveInStreetHailLivery(true);
						fhvShlActiveNum++;
						break;
				}
			}

		}

	}

	public static String loadJson (String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL urlObject = new URL(url);
			URLConnection uc = urlObject.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));
			String inputLine = null;
			while ( (inputLine = in.readLine()) != null ) {
				json.append(inputLine);
//				System.out.println(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json.toString();
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
//			System.out.println(tlcDriver.getFirstname() + " " + tlcDriver.getDriverTlcLicenseNum() + " " + tlcDriver.getVehicleTlcFhvLicenseNum());
		}

	}

}
