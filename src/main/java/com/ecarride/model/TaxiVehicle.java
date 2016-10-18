package com.ecarride.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by hanmei on 10/14/16.
 */
@Entity
@Table(name = "taxi_vehicle", schema = "operr_db_qa", catalog = "")
public class TaxiVehicle {
    private int id;
    private int driverId;
    private String vin;
    private int year;
    private String brand;
    private String model;
    private int vehicleTypeId;
    private String vehicleLicenseState;
    private String profilePhoto;
    private String vehiclePlateNum;
    private String vehicleRegistration;
    private Date vehicleRegistrationStart;
    private Date vehicleRegistrationExpire;
    private int vehicleRegistrationStatus;
    private String liabilityInsurance;
    private int liabilityAmount;
    private int liabilityEcarrideCertificateHolder;
    private int liabilityEcarrideAdditionalInsured;
    private int liabilitySelfInsured;
    private String liabilityNameInsurer;
    private Date liabilityInsuranceStart;
    private Date liabilityInsuranceExpire;
    private int liabilityInsuranceStatus;
    private String extraInsurance;
    private Date extraInsuranceStart;
    private Date extraInsuranceExpire;
    private int extraInsuranceStatus;
    private String vehicleTlcFhvLicense;
    private String vehicleTlcFhvLicenseNum;
    private Date vehicleTlcFhvLicenseStart;
    private Date vehicleTlcFhvLicenseExpire;
    private int vehicleTlcFhvLicenseStatus;
    private String vehicleInspection;
    private Date vehicleInspectionStart;
    private Date vehicleInspectionExpire;
    private int vehicleInspectionStatus;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int status;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "driver_id", nullable = false)
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "vin", nullable = false, length = 255)
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Basic
    @Column(name = "year", nullable = false)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "brand", nullable = false, length = 255)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "model", nullable = false, length = 255)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "vehicle_type_id", nullable = false)
    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    @Basic
    @Column(name = "vehicle_license_state", nullable = false, length = 255)
    public String getVehicleLicenseState() {
        return vehicleLicenseState;
    }

    public void setVehicleLicenseState(String vehicleLicenseState) {
        this.vehicleLicenseState = vehicleLicenseState;
    }

    @Basic
    @Column(name = "profile_photo", nullable = false, length = 255)
    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    @Basic
    @Column(name = "vehicle_plate_num", nullable = false, length = 255)
    public String getVehiclePlateNum() {
        return vehiclePlateNum;
    }

    public void setVehiclePlateNum(String vehiclePlateNum) {
        this.vehiclePlateNum = vehiclePlateNum;
    }

    @Basic
    @Column(name = "vehicle_registration", nullable = false, length = 255)
    public String getVehicleRegistration() {
        return vehicleRegistration;
    }

    public void setVehicleRegistration(String vehicleRegistration) {
        this.vehicleRegistration = vehicleRegistration;
    }

    @Basic
    @Column(name = "vehicle_registration_start", nullable = false)
    public Date getVehicleRegistrationStart() {
        return vehicleRegistrationStart;
    }

    public void setVehicleRegistrationStart(Date vehicleRegistrationStart) {
        this.vehicleRegistrationStart = vehicleRegistrationStart;
    }

    @Basic
    @Column(name = "vehicle_registration_expire", nullable = false)
    public Date getVehicleRegistrationExpire() {
        return vehicleRegistrationExpire;
    }

    public void setVehicleRegistrationExpire(Date vehicleRegistrationExpire) {
        this.vehicleRegistrationExpire = vehicleRegistrationExpire;
    }

    @Basic
    @Column(name = "vehicle_registration_status", nullable = false)
    public int getVehicleRegistrationStatus() {
        return vehicleRegistrationStatus;
    }

    public void setVehicleRegistrationStatus(int vehicleRegistrationStatus) {
        this.vehicleRegistrationStatus = vehicleRegistrationStatus;
    }

    @Basic
    @Column(name = "liability_insurance", nullable = false, length = 255)
    public String getLiabilityInsurance() {
        return liabilityInsurance;
    }

    public void setLiabilityInsurance(String liabilityInsurance) {
        this.liabilityInsurance = liabilityInsurance;
    }

    @Basic
    @Column(name = "liability_amount", nullable = false)
    public int getLiabilityAmount() {
        return liabilityAmount;
    }

    public void setLiabilityAmount(int liabilityAmount) {
        this.liabilityAmount = liabilityAmount;
    }

    @Basic
    @Column(name = "liability_ecarride_certificate_holder", nullable = false)
    public int getLiabilityEcarrideCertificateHolder() {
        return liabilityEcarrideCertificateHolder;
    }

    public void setLiabilityEcarrideCertificateHolder(int liabilityEcarrideCertificateHolder) {
        this.liabilityEcarrideCertificateHolder = liabilityEcarrideCertificateHolder;
    }

    @Basic
    @Column(name = "liability_ecarride_additional_insured", nullable = false)
    public int getLiabilityEcarrideAdditionalInsured() {
        return liabilityEcarrideAdditionalInsured;
    }

    public void setLiabilityEcarrideAdditionalInsured(int liabilityEcarrideAdditionalInsured) {
        this.liabilityEcarrideAdditionalInsured = liabilityEcarrideAdditionalInsured;
    }

    @Basic
    @Column(name = "liability_self_insured", nullable = false)
    public int getLiabilitySelfInsured() {
        return liabilitySelfInsured;
    }

    public void setLiabilitySelfInsured(int liabilitySelfInsured) {
        this.liabilitySelfInsured = liabilitySelfInsured;
    }

    @Basic
    @Column(name = "liability_name_insurer", nullable = false, length = 255)
    public String getLiabilityNameInsurer() {
        return liabilityNameInsurer;
    }

    public void setLiabilityNameInsurer(String liabilityNameInsurer) {
        this.liabilityNameInsurer = liabilityNameInsurer;
    }

    @Basic
    @Column(name = "liability_insurance_start", nullable = false)
    public Date getLiabilityInsuranceStart() {
        return liabilityInsuranceStart;
    }

    public void setLiabilityInsuranceStart(Date liabilityInsuranceStart) {
        this.liabilityInsuranceStart = liabilityInsuranceStart;
    }

    @Basic
    @Column(name = "liability_insurance_expire", nullable = false)
    public Date getLiabilityInsuranceExpire() {
        return liabilityInsuranceExpire;
    }

    public void setLiabilityInsuranceExpire(Date liabilityInsuranceExpire) {
        this.liabilityInsuranceExpire = liabilityInsuranceExpire;
    }

    @Basic
    @Column(name = "liability_insurance_status", nullable = false)
    public int getLiabilityInsuranceStatus() {
        return liabilityInsuranceStatus;
    }

    public void setLiabilityInsuranceStatus(int liabilityInsuranceStatus) {
        this.liabilityInsuranceStatus = liabilityInsuranceStatus;
    }

    @Basic
    @Column(name = "extra_insurance", nullable = false, length = 255)
    public String getExtraInsurance() {
        return extraInsurance;
    }

    public void setExtraInsurance(String extraInsurance) {
        this.extraInsurance = extraInsurance;
    }

    @Basic
    @Column(name = "extra_insurance_start", nullable = false)
    public Date getExtraInsuranceStart() {
        return extraInsuranceStart;
    }

    public void setExtraInsuranceStart(Date extraInsuranceStart) {
        this.extraInsuranceStart = extraInsuranceStart;
    }

    @Basic
    @Column(name = "extra_insurance_expire", nullable = false)
    public Date getExtraInsuranceExpire() {
        return extraInsuranceExpire;
    }

    public void setExtraInsuranceExpire(Date extraInsuranceExpire) {
        this.extraInsuranceExpire = extraInsuranceExpire;
    }

    @Basic
    @Column(name = "extra_insurance_status", nullable = false)
    public int getExtraInsuranceStatus() {
        return extraInsuranceStatus;
    }

    public void setExtraInsuranceStatus(int extraInsuranceStatus) {
        this.extraInsuranceStatus = extraInsuranceStatus;
    }

    @Basic
    @Column(name = "vehicle_tlc_fhv_license", nullable = false, length = 255)
    public String getVehicleTlcFhvLicense() {
        return vehicleTlcFhvLicense;
    }

    public void setVehicleTlcFhvLicense(String vehicleTlcFhvLicense) {
        this.vehicleTlcFhvLicense = vehicleTlcFhvLicense;
    }

    @Basic
    @Column(name = "vehicle_tlc_fhv_license_num", nullable = false, length = 255)
    public String getVehicleTlcFhvLicenseNum() {
        return vehicleTlcFhvLicenseNum;
    }

    public void setVehicleTlcFhvLicenseNum(String vehicleTlcFhvLicenseNum) {
        this.vehicleTlcFhvLicenseNum = vehicleTlcFhvLicenseNum;
    }

    @Basic
    @Column(name = "vehicle_tlc_fhv_license_start", nullable = false)
    public Date getVehicleTlcFhvLicenseStart() {
        return vehicleTlcFhvLicenseStart;
    }

    public void setVehicleTlcFhvLicenseStart(Date vehicleTlcFhvLicenseStart) {
        this.vehicleTlcFhvLicenseStart = vehicleTlcFhvLicenseStart;
    }

    @Basic
    @Column(name = "vehicle_tlc_fhv_license_expire", nullable = false)
    public Date getVehicleTlcFhvLicenseExpire() {
        return vehicleTlcFhvLicenseExpire;
    }

    public void setVehicleTlcFhvLicenseExpire(Date vehicleTlcFhvLicenseExpire) {
        this.vehicleTlcFhvLicenseExpire = vehicleTlcFhvLicenseExpire;
    }

    @Basic
    @Column(name = "vehicle_tlc_fhv_license_status", nullable = false)
    public int getVehicleTlcFhvLicenseStatus() {
        return vehicleTlcFhvLicenseStatus;
    }

    public void setVehicleTlcFhvLicenseStatus(int vehicleTlcFhvLicenseStatus) {
        this.vehicleTlcFhvLicenseStatus = vehicleTlcFhvLicenseStatus;
    }

    @Basic
    @Column(name = "vehicle_inspection", nullable = false, length = 255)
    public String getVehicleInspection() {
        return vehicleInspection;
    }

    public void setVehicleInspection(String vehicleInspection) {
        this.vehicleInspection = vehicleInspection;
    }

    @Basic
    @Column(name = "vehicle_inspection_start", nullable = false)
    public Date getVehicleInspectionStart() {
        return vehicleInspectionStart;
    }

    public void setVehicleInspectionStart(Date vehicleInspectionStart) {
        this.vehicleInspectionStart = vehicleInspectionStart;
    }

    @Basic
    @Column(name = "vehicle_inspection_expire", nullable = false)
    public Date getVehicleInspectionExpire() {
        return vehicleInspectionExpire;
    }

    public void setVehicleInspectionExpire(Date vehicleInspectionExpire) {
        this.vehicleInspectionExpire = vehicleInspectionExpire;
    }

    @Basic
    @Column(name = "vehicle_inspection_status", nullable = false)
    public int getVehicleInspectionStatus() {
        return vehicleInspectionStatus;
    }

    public void setVehicleInspectionStatus(int vehicleInspectionStatus) {
        this.vehicleInspectionStatus = vehicleInspectionStatus;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at", nullable = false)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxiVehicle that = (TaxiVehicle) o;

        if (id != that.id) return false;
        if (driverId != that.driverId) return false;
        if (year != that.year) return false;
        if (vehicleTypeId != that.vehicleTypeId) return false;
        if (vehicleRegistrationStatus != that.vehicleRegistrationStatus) return false;
        if (liabilityAmount != that.liabilityAmount) return false;
        if (liabilityEcarrideCertificateHolder != that.liabilityEcarrideCertificateHolder) return false;
        if (liabilityEcarrideAdditionalInsured != that.liabilityEcarrideAdditionalInsured) return false;
        if (liabilitySelfInsured != that.liabilitySelfInsured) return false;
        if (liabilityInsuranceStatus != that.liabilityInsuranceStatus) return false;
        if (extraInsuranceStatus != that.extraInsuranceStatus) return false;
        if (vehicleTlcFhvLicenseStatus != that.vehicleTlcFhvLicenseStatus) return false;
        if (vehicleInspectionStatus != that.vehicleInspectionStatus) return false;
        if (status != that.status) return false;
        if (vin != null ? !vin.equals(that.vin) : that.vin != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (vehicleLicenseState != null ? !vehicleLicenseState.equals(that.vehicleLicenseState) : that.vehicleLicenseState != null)
            return false;
        if (profilePhoto != null ? !profilePhoto.equals(that.profilePhoto) : that.profilePhoto != null) return false;
        if (vehiclePlateNum != null ? !vehiclePlateNum.equals(that.vehiclePlateNum) : that.vehiclePlateNum != null)
            return false;
        if (vehicleRegistration != null ? !vehicleRegistration.equals(that.vehicleRegistration) : that.vehicleRegistration != null)
            return false;
        if (vehicleRegistrationStart != null ? !vehicleRegistrationStart.equals(that.vehicleRegistrationStart) : that.vehicleRegistrationStart != null)
            return false;
        if (vehicleRegistrationExpire != null ? !vehicleRegistrationExpire.equals(that.vehicleRegistrationExpire) : that.vehicleRegistrationExpire != null)
            return false;
        if (liabilityInsurance != null ? !liabilityInsurance.equals(that.liabilityInsurance) : that.liabilityInsurance != null)
            return false;
        if (liabilityNameInsurer != null ? !liabilityNameInsurer.equals(that.liabilityNameInsurer) : that.liabilityNameInsurer != null)
            return false;
        if (liabilityInsuranceStart != null ? !liabilityInsuranceStart.equals(that.liabilityInsuranceStart) : that.liabilityInsuranceStart != null)
            return false;
        if (liabilityInsuranceExpire != null ? !liabilityInsuranceExpire.equals(that.liabilityInsuranceExpire) : that.liabilityInsuranceExpire != null)
            return false;
        if (extraInsurance != null ? !extraInsurance.equals(that.extraInsurance) : that.extraInsurance != null)
            return false;
        if (extraInsuranceStart != null ? !extraInsuranceStart.equals(that.extraInsuranceStart) : that.extraInsuranceStart != null)
            return false;
        if (extraInsuranceExpire != null ? !extraInsuranceExpire.equals(that.extraInsuranceExpire) : that.extraInsuranceExpire != null)
            return false;
        if (vehicleTlcFhvLicense != null ? !vehicleTlcFhvLicense.equals(that.vehicleTlcFhvLicense) : that.vehicleTlcFhvLicense != null)
            return false;
        if (vehicleTlcFhvLicenseNum != null ? !vehicleTlcFhvLicenseNum.equals(that.vehicleTlcFhvLicenseNum) : that.vehicleTlcFhvLicenseNum != null)
            return false;
        if (vehicleTlcFhvLicenseStart != null ? !vehicleTlcFhvLicenseStart.equals(that.vehicleTlcFhvLicenseStart) : that.vehicleTlcFhvLicenseStart != null)
            return false;
        if (vehicleTlcFhvLicenseExpire != null ? !vehicleTlcFhvLicenseExpire.equals(that.vehicleTlcFhvLicenseExpire) : that.vehicleTlcFhvLicenseExpire != null)
            return false;
        if (vehicleInspection != null ? !vehicleInspection.equals(that.vehicleInspection) : that.vehicleInspection != null)
            return false;
        if (vehicleInspectionStart != null ? !vehicleInspectionStart.equals(that.vehicleInspectionStart) : that.vehicleInspectionStart != null)
            return false;
        if (vehicleInspectionExpire != null ? !vehicleInspectionExpire.equals(that.vehicleInspectionExpire) : that.vehicleInspectionExpire != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + driverId;
        result = 31 * result + (vin != null ? vin.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + vehicleTypeId;
        result = 31 * result + (vehicleLicenseState != null ? vehicleLicenseState.hashCode() : 0);
        result = 31 * result + (profilePhoto != null ? profilePhoto.hashCode() : 0);
        result = 31 * result + (vehiclePlateNum != null ? vehiclePlateNum.hashCode() : 0);
        result = 31 * result + (vehicleRegistration != null ? vehicleRegistration.hashCode() : 0);
        result = 31 * result + (vehicleRegistrationStart != null ? vehicleRegistrationStart.hashCode() : 0);
        result = 31 * result + (vehicleRegistrationExpire != null ? vehicleRegistrationExpire.hashCode() : 0);
        result = 31 * result + vehicleRegistrationStatus;
        result = 31 * result + (liabilityInsurance != null ? liabilityInsurance.hashCode() : 0);
        result = 31 * result + liabilityAmount;
        result = 31 * result + liabilityEcarrideCertificateHolder;
        result = 31 * result + liabilityEcarrideAdditionalInsured;
        result = 31 * result + liabilitySelfInsured;
        result = 31 * result + (liabilityNameInsurer != null ? liabilityNameInsurer.hashCode() : 0);
        result = 31 * result + (liabilityInsuranceStart != null ? liabilityInsuranceStart.hashCode() : 0);
        result = 31 * result + (liabilityInsuranceExpire != null ? liabilityInsuranceExpire.hashCode() : 0);
        result = 31 * result + liabilityInsuranceStatus;
        result = 31 * result + (extraInsurance != null ? extraInsurance.hashCode() : 0);
        result = 31 * result + (extraInsuranceStart != null ? extraInsuranceStart.hashCode() : 0);
        result = 31 * result + (extraInsuranceExpire != null ? extraInsuranceExpire.hashCode() : 0);
        result = 31 * result + extraInsuranceStatus;
        result = 31 * result + (vehicleTlcFhvLicense != null ? vehicleTlcFhvLicense.hashCode() : 0);
        result = 31 * result + (vehicleTlcFhvLicenseNum != null ? vehicleTlcFhvLicenseNum.hashCode() : 0);
        result = 31 * result + (vehicleTlcFhvLicenseStart != null ? vehicleTlcFhvLicenseStart.hashCode() : 0);
        result = 31 * result + (vehicleTlcFhvLicenseExpire != null ? vehicleTlcFhvLicenseExpire.hashCode() : 0);
        result = 31 * result + vehicleTlcFhvLicenseStatus;
        result = 31 * result + (vehicleInspection != null ? vehicleInspection.hashCode() : 0);
        result = 31 * result + (vehicleInspectionStart != null ? vehicleInspectionStart.hashCode() : 0);
        result = 31 * result + (vehicleInspectionExpire != null ? vehicleInspectionExpire.hashCode() : 0);
        result = 31 * result + vehicleInspectionStatus;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }
}
