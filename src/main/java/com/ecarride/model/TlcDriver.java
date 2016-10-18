package com.ecarride.model;

/**
 * Created by hanmei on 10/14/16.
 */
public class TlcDriver {
    private int driverId;
    private int baseApproved;
    private int status;
    private String driverTlcLicenseNum;
    private String firstname;
    private String lastname;
    private String vehicleTlcFhvLicenseNum;
    private String baseTlcLicenseNum;
    private boolean activeInFhvDrivers;
    private boolean activeInStreetHailLivery;
    private boolean baseChanged;
    private boolean inTrouble;  //default is false, no problem
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getBaseApproved() {
        return baseApproved;
    }

    public void setBaseApproved(int baseApproved) {
        this.baseApproved = baseApproved;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public boolean isBaseChanged() {
        return baseChanged;
    }

    public void setBaseChanged(boolean baseChanged) {
        this.baseChanged = baseChanged;
    }

    public boolean isActiveInvehiclesFhv() {
        return activeInvehiclesFhv;
    }

    public void setActiveInvehiclesFhv(boolean activeInvehiclesFhv) {
        this.activeInvehiclesFhv = activeInvehiclesFhv;
    }

    private boolean activeInvehiclesFhv;

    public boolean isActiveInFhvDrivers() {
        return activeInFhvDrivers;
    }

    public void setActiveInFhvDrivers(boolean activeInFhvDrivers) {
        this.activeInFhvDrivers = activeInFhvDrivers;
    }

    public boolean isActiveInStreetHailLivery() {
        return activeInStreetHailLivery;
    }

    public void setActiveInStreetHailLivery(boolean activeInStreetHailLivery) {
        this.activeInStreetHailLivery = activeInStreetHailLivery;
    }

    public TlcDriver() {};

    public String getDriverTlcLicenseNum() {
        return driverTlcLicenseNum;
    }

    public void setDriverTlcLicenseNum(String driverTlcLicenseNum) {
        this.driverTlcLicenseNum = driverTlcLicenseNum;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getVehicleTlcFhvLicenseNum() {
        return vehicleTlcFhvLicenseNum;
    }

    public boolean isInTrouble() {
        return inTrouble;
    }

    public void setInTrouble(boolean inTrouble) {
        this.inTrouble = inTrouble;
    }

    public void setVehicleTlcFhvLicenseNum(String vehicleTlcFhvLicenseNum) {
        this.vehicleTlcFhvLicenseNum = vehicleTlcFhvLicenseNum;
    }

    public String getBaseTlcLicenseNum() {
        return baseTlcLicenseNum;
    }

    public void setBaseTlcLicenseNum(String baseTlcLicenseNum) {
        this.baseTlcLicenseNum = baseTlcLicenseNum;
    }

    public TlcDriver(String driverTlcLicenseNum,String firstname, String lastname, String vehicleTlcFhvLicenseNum, String baseTlcLicenseNum, int driverId, int baseApproved, int status) {
        this.driverTlcLicenseNum = driverTlcLicenseNum;
        this.firstname = firstname;
        this.lastname = lastname;
        this.vehicleTlcFhvLicenseNum = vehicleTlcFhvLicenseNum;
        this.driverId = driverId;
        this.baseTlcLicenseNum = baseTlcLicenseNum;
        this.baseApproved = baseApproved;
        this.status = status;
        this.inTrouble = false;
    }
}
