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
	public static int fhvDriverActiveNum = 0, fhvShlActiveNum = 0, fhvVehichleActiveNum = 0, baseChangedNum = 0;
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	public static final String[] ADMIN_RECIPIENTS = {"han@cacsnyc.com"};
	public static  List<String> DriverRecipientsList = new ArrayList<>();
	public static  String[] DriverRecipients;

	public static void main(String[] args) throws IOException, JSONException, MessagingException {
		getDrivers();
		checkDriver(fhvActiveAPI);
		checkDriver(streetHailLiveryAPI);
		checkDriver(fhvVehicleAPI);
		Map<String, String> adminEmailContent = generateAdminEmailContent(tlcDrivers);
//		Map<String, String> driverEmailContent = generateDriverEmailContent(tlcDrivers);
		Email.sendEmail(adminEmailContent, ADMIN_RECIPIENTS);
//		Email.sendEmail(contents, ADMIN_RECIPIENTS);
//		ResetDriverWorkStatus();



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
			query.setParameter("id", temp.getDriverId());
			query.executeUpdate();
			updateTransaction.commit();
		}
	}

	public static Map<String, String> generateDriverEmailContent(Set<TlcDriver> tlcDrivers) {
		Iterator<TlcDriver> iterator = tlcDrivers.iterator();
		Map<String, String> result = new LinkedHashMap<>();
		String driverAlart = "";
		while(iterator.hasNext()) {
			TlcDriver tlcDriver = iterator.next();
			if(!tlcDriver.isActiveInvehiclesFhv() || !tlcDriver.isActiveInStreetHailLivery() || !tlcDriver.isActiveInFhvDrivers() || tlcDriver.isBaseChanged()) {
				tlcDriver.setInTrouble(true);
//				System.out.println(tlcDriver.getFirstname() + " in trouble? : " + tlcDriver.isInTrouble() + " T1: " + tlcDriver.isActiveInFhvDrivers() + " T2: " + tlcDriver.isActiveInStreetHailLivery() + " T3: " + tlcDriver.isActiveInvehiclesFhv() + " T3-2: " + tlcDriver.isBaseChanged());

			}
		}
		return null;
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
				FhvDriverActiveResult += "<tr><td><b>Name: </b>" + driver.getFirstname() + " " + driver.getLastname() + "</td><td><b>TLC_FHV_License_Number: </b>" +
						driver.getDriverTlcLicenseNum() + "  </td><td><b>TLC_FHV_Vehicle_License_Number: </b>" + driver.getVehicleTlcFhvLicenseNum() + "</td></tr>";

			}

			if(!driver.isActiveInStreetHailLivery()) {
				ShlActiveResult += "<tr><td><b>Name: </b>" + driver.getFirstname() + " " + driver.getLastname() + "</td><td><b>TLC_FHV_License_Number: </b>" +
						driver.getDriverTlcLicenseNum() + "  </td><td><b>TLC_FHV_Vehicle_License_Number: </b>" + driver.getVehicleTlcFhvLicenseNum() + "</td></tr>";
			}
			if(!driver.isActiveInvehiclesFhv()) {
				FhvVehicleResult += "<tr><td><b>Name: </b>" + driver.getFirstname() + " " + driver.getLastname() + "</td><td><b>TLC_FHV_License_Number: </b>" +
						driver.getDriverTlcLicenseNum() + "  </td><td><b>TLC_FHV_Vehicle_License_Number: </b>" + driver.getVehicleTlcFhvLicenseNum() + "</td></tr>";
			}
			if(driver.isBaseChanged()) {
				BaseChangedResult += "<tr><td><b>Name: </b>" + driver.getFirstname() + " " + driver.getLastname() + "</td><td><b>TLC_FHV_License_Number: </b>" +
						driver.getDriverTlcLicenseNum() + "  </td><td><b>TLC_FHV_Vehicle_License_Number: </b>" + driver.getVehicleTlcFhvLicenseNum() + "</td></tr>";
			}
		}
		result.put("DriverFhvActive", FhvDriverActiveResult);
		result.put("DriverShlActive", ShlActiveResult);
		result.put("VehicleActive", FhvVehicleResult);
		result.put("BaseChanged", BaseChangedResult);

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
				if(!jsonObj.getString("base_number").substring(jsonObj.getString("base_number").length() - 4).equals(tempDriver.getBaseTlcLicenseNum())) {
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

//		TypedQuery<Object[]> query = entityManager.createQuery(
//				"SELECT d.driverTlcFhvLicenseNum, d.firstName, d.lastName, v.vehicleTlcFhvLicenseNum, b.tlcLicenseNum, d.id, d.baseApproved, d.status FROM Driver AS d, TaxiVehicle AS v, TaxiBase AS b WHERE d.id = v.driverId AND d.baseId = b.id", Object[].class);
//		List<Object[]> results = query.getResultList();
//		for (Object[] result : results) {
//			if(result[1].toString().contains("test") || result[1].toString().contains("Test") || result[1].toString().contains("TEST") ||
//					result[2].toString().contains("test") || result[2].toString().contains("Test") || result[2].toString().contains("TEST")||
//					Integer.parseInt(result[6].toString()) == 0) {
//				continue;
//			}
//			TlcDriver tlcDriver = new TlcDriver(result[0].toString(), result[1].toString(), result[2].toString(), result[3].toString(), result[4].toString(), Integer.parseInt(result[5].toString()), Integer.parseInt(result[6].toString()), Integer.parseInt(result[7].toString()));
//			tlcDrivers.add(tlcDriver);
//			tlcDriverMap.put(tlcDriver.getDriverTlcLicenseNum(), tlcDriver);
//			tlcVehicleMap.put(tlcDriver.getVehicleTlcFhvLicenseNum(), tlcDriver);
//		}
//		return results;
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
			TlcDriver tlcDriver = new TlcDriver(driver.getDriverTlcFhvLicenseNum(), driver.getFirstName(), driver.getLastName(), taxiVehicle.getVehicleTlcFhvLicenseNum(), String.valueOf(taxiBase.getTlcLicenseNum()), driver.getId(), driver.getBaseApproved(), driver.getStatus());
			tlcDrivers.add(tlcDriver);
			tlcDriverMap.put(tlcDriver.getDriverTlcLicenseNum(), tlcDriver);
			tlcVehicleMap.put(tlcDriver.getVehicleTlcFhvLicenseNum(), tlcDriver);
//			System.out.println(tlcDriver.getFirstname() + " " + tlcDriver.getDriverTlcLicenseNum() + " " + tlcDriver.getVehicleTlcFhvLicenseNum());
		}

	}

}
