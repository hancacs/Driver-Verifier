package com.ecarride.model;

/**
 * Created by hanmei on 10/14/16.
 */
public class TlcDriver {
    private Driver driver;
    private TaxiBase taxiBase;
    private TaxiVehicle taxiVehicle;
    private boolean isActiveInvehiclesFhv;
    private boolean isActiveInStreetHailLivery;
    private boolean isActiveInFhvDrivers;
    private boolean isBaseChanged;

    public boolean isInTrouble() {
        return !this.isActiveInvehiclesFhv || !this.isActiveInFhvDrivers() || !this.isActiveInStreetHailLivery() || this.isBaseChanged();
    }

    public void setInTrouble(boolean inTrouble) {
        this.inTrouble = inTrouble;
    }

    private boolean inTrouble;

    public boolean isActiveInvehiclesFhv() {
        return isActiveInvehiclesFhv;
    }

    public void setActiveInvehiclesFhv(boolean activeInvehiclesFhv) {
        isActiveInvehiclesFhv = activeInvehiclesFhv;
    }

    public boolean isActiveInStreetHailLivery() {
        return isActiveInStreetHailLivery;
    }

    public void setActiveInStreetHailLivery(boolean activeInStreetHailLivery) {
        isActiveInStreetHailLivery = activeInStreetHailLivery;
    }

    public boolean isActiveInFhvDrivers() {
        return isActiveInFhvDrivers;
    }

    public void setActiveInFhvDrivers(boolean activeInFhvDrivers) {
        isActiveInFhvDrivers = activeInFhvDrivers;
    }

    public boolean isBaseChanged() {
        return isBaseChanged;
    }

    public void setBaseChanged(boolean baseChanged) {
        isBaseChanged = baseChanged;
    }



    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public TaxiBase getTaxiBase() {
        return taxiBase;
    }

    public void setTaxiBase(TaxiBase taxiBase) {
        this.taxiBase = taxiBase;
    }

    public TaxiVehicle getTaxiVehicle() {
        return taxiVehicle;
    }

    public void setTaxiVehicle(TaxiVehicle taxiVehicle) {
        this.taxiVehicle = taxiVehicle;
    }

    public TlcDriver(Driver driver, TaxiBase taxiBase, TaxiVehicle taxiVehicle) {
        this.driver = driver;
        this.taxiBase = taxiBase;
        this.taxiVehicle = taxiVehicle;
    }
}
