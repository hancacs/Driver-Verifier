package com.ecarride.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by hanmei on 10/13/16.
 */
@Entity
@Table(name = "taxi_driver", schema = "operr_db_qa", catalog = "")
public class Driver {
    private int id;
    private String merchantAccountId;
    private int baseId;
    private int companyId;
    private String username;
    private String password;
    private int driverType;
    private String firstName;
    private String lastName;
    private String fleetNum;
    private String phone;
    private String secondaryPhone;
    private String email;
    private Date dob;
    private int gender;
    private String nationality;
    private int drivingExperience;
    private String verificationCode;
    private String profilePhoto;
    private String signature;
    private String driverLicense;
    private String driverLicenseNum;
    private String driverLicenseClass;
    private String driverLicenseState;
    private Date driverLicenseStart;
    private Date driverLicenseExpire;
    private int driverLicenseStatus;
    private String driverTlcFhvLicense;
    private String driverTlcFhvLicenseNum;
    private Date driverTlcFhvLicenseStart;
    private Date driverTlcFhvLicenseExpire;
    private int driverTlcFhvLicenseStatus;
    private String backgroundCheck;
    private Date backgroundCheckStart;
    private Date backgroundCheckExpire;
    private int backgroundCheckStatus;
    private String drivingRecord;
    private Date drivingRecordStart;
    private Date drivingRecordExpire;
    private int drivingRecordStatus;
    private String drugScreen;
    private Date drugScreenStart;
    private Date drugScreenExpire;
    private int drugScreenStatus;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private int vehicleId;
    private int allowPets;
    private int allowWheelchair;
    private int dutyStatus;
    private String appLanguage;
    private String deviceToken;
    private String deviceId;
    private String mobileOs;
    private String objectId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int approvableMail;
    private int baseApproved;
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
    @Column(name = "merchant_account_id", nullable = false, length = 255)
    public String getMerchantAccountId() {
        return merchantAccountId;
    }

    public void setMerchantAccountId(String merchantAccountId) {
        this.merchantAccountId = merchantAccountId;
    }

    @Basic
    @Column(name = "base_id", nullable = false)
    public int getBaseId() {
        return baseId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    @Basic
    @Column(name = "company_id", nullable = false)
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "driver_type", nullable = false)
    public int getDriverType() {
        return driverType;
    }

    public void setDriverType(int driverType) {
        this.driverType = driverType;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "fleet_num", nullable = false, length = 255)
    public String getFleetNum() {
        return fleetNum;
    }

    public void setFleetNum(String fleetNum) {
        this.fleetNum = fleetNum;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "secondary_phone", nullable = false, length = 255)
    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "dob", nullable = false)
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "gender", nullable = false)
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "nationality", nullable = false, length = 255)
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "driving_experience", nullable = false)
    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    @Basic
    @Column(name = "verification_code", nullable = false, length = 64)
    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
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
    @Column(name = "signature", nullable = false, length = 255)
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Basic
    @Column(name = "driver_license", nullable = false, length = 255)
    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    @Basic
    @Column(name = "driver_license_num", nullable = false, length = 255)
    public String getDriverLicenseNum() {
        return driverLicenseNum;
    }

    public void setDriverLicenseNum(String driverLicenseNum) {
        this.driverLicenseNum = driverLicenseNum;
    }

    @Basic
    @Column(name = "driver_license_class", nullable = false, length = 255)
    public String getDriverLicenseClass() {
        return driverLicenseClass;
    }

    public void setDriverLicenseClass(String driverLicenseClass) {
        this.driverLicenseClass = driverLicenseClass;
    }

    @Basic
    @Column(name = "driver_license_state", nullable = false, length = 255)
    public String getDriverLicenseState() {
        return driverLicenseState;
    }

    public void setDriverLicenseState(String driverLicenseState) {
        this.driverLicenseState = driverLicenseState;
    }

    @Basic
    @Column(name = "driver_license_start", nullable = false)
    public Date getDriverLicenseStart() {
        return driverLicenseStart;
    }

    public void setDriverLicenseStart(Date driverLicenseStart) {
        this.driverLicenseStart = driverLicenseStart;
    }

    @Basic
    @Column(name = "driver_license_expire", nullable = false)
    public Date getDriverLicenseExpire() {
        return driverLicenseExpire;
    }

    public void setDriverLicenseExpire(Date driverLicenseExpire) {
        this.driverLicenseExpire = driverLicenseExpire;
    }

    @Basic
    @Column(name = "driver_license_status", nullable = false)
    public int getDriverLicenseStatus() {
        return driverLicenseStatus;
    }

    public void setDriverLicenseStatus(int driverLicenseStatus) {
        this.driverLicenseStatus = driverLicenseStatus;
    }

    @Basic
    @Column(name = "driver_tlc_fhv_license", nullable = false, length = 255)
    public String getDriverTlcFhvLicense() {
        return driverTlcFhvLicense;
    }

    public void setDriverTlcFhvLicense(String driverTlcFhvLicense) {
        this.driverTlcFhvLicense = driverTlcFhvLicense;
    }

    @Basic
    @Column(name = "driver_tlc_fhv_license_num", nullable = false, length = 255)
    public String getDriverTlcFhvLicenseNum() {
        return driverTlcFhvLicenseNum;
    }

    public void setDriverTlcFhvLicenseNum(String driverTlcFhvLicenseNum) {
        this.driverTlcFhvLicenseNum = driverTlcFhvLicenseNum;
    }

    @Basic
    @Column(name = "driver_tlc_fhv_license_start", nullable = false)
    public Date getDriverTlcFhvLicenseStart() {
        return driverTlcFhvLicenseStart;
    }

    public void setDriverTlcFhvLicenseStart(Date driverTlcFhvLicenseStart) {
        this.driverTlcFhvLicenseStart = driverTlcFhvLicenseStart;
    }

    @Basic
    @Column(name = "driver_tlc_fhv_license_expire", nullable = false)
    public Date getDriverTlcFhvLicenseExpire() {
        return driverTlcFhvLicenseExpire;
    }

    public void setDriverTlcFhvLicenseExpire(Date driverTlcFhvLicenseExpire) {
        this.driverTlcFhvLicenseExpire = driverTlcFhvLicenseExpire;
    }

    @Basic
    @Column(name = "driver_tlc_fhv_license_status", nullable = false)
    public int getDriverTlcFhvLicenseStatus() {
        return driverTlcFhvLicenseStatus;
    }

    public void setDriverTlcFhvLicenseStatus(int driverTlcFhvLicenseStatus) {
        this.driverTlcFhvLicenseStatus = driverTlcFhvLicenseStatus;
    }

    @Basic
    @Column(name = "background_check", nullable = false, length = 255)
    public String getBackgroundCheck() {
        return backgroundCheck;
    }

    public void setBackgroundCheck(String backgroundCheck) {
        this.backgroundCheck = backgroundCheck;
    }

    @Basic
    @Column(name = "background_check_start", nullable = false)
    public Date getBackgroundCheckStart() {
        return backgroundCheckStart;
    }

    public void setBackgroundCheckStart(Date backgroundCheckStart) {
        this.backgroundCheckStart = backgroundCheckStart;
    }

    @Basic
    @Column(name = "background_check_expire", nullable = false)
    public Date getBackgroundCheckExpire() {
        return backgroundCheckExpire;
    }

    public void setBackgroundCheckExpire(Date backgroundCheckExpire) {
        this.backgroundCheckExpire = backgroundCheckExpire;
    }

    @Basic
    @Column(name = "background_check_status", nullable = false)
    public int getBackgroundCheckStatus() {
        return backgroundCheckStatus;
    }

    public void setBackgroundCheckStatus(int backgroundCheckStatus) {
        this.backgroundCheckStatus = backgroundCheckStatus;
    }

    @Basic
    @Column(name = "driving_record", nullable = false, length = 255)
    public String getDrivingRecord() {
        return drivingRecord;
    }

    public void setDrivingRecord(String drivingRecord) {
        this.drivingRecord = drivingRecord;
    }

    @Basic
    @Column(name = "driving_record_start", nullable = false)
    public Date getDrivingRecordStart() {
        return drivingRecordStart;
    }

    public void setDrivingRecordStart(Date drivingRecordStart) {
        this.drivingRecordStart = drivingRecordStart;
    }

    @Basic
    @Column(name = "driving_record_expire", nullable = false)
    public Date getDrivingRecordExpire() {
        return drivingRecordExpire;
    }

    public void setDrivingRecordExpire(Date drivingRecordExpire) {
        this.drivingRecordExpire = drivingRecordExpire;
    }

    @Basic
    @Column(name = "driving_record_status", nullable = false)
    public int getDrivingRecordStatus() {
        return drivingRecordStatus;
    }

    public void setDrivingRecordStatus(int drivingRecordStatus) {
        this.drivingRecordStatus = drivingRecordStatus;
    }

    @Basic
    @Column(name = "drug_screen", nullable = false, length = 255)
    public String getDrugScreen() {
        return drugScreen;
    }

    public void setDrugScreen(String drugScreen) {
        this.drugScreen = drugScreen;
    }

    @Basic
    @Column(name = "drug_screen_start", nullable = false)
    public Date getDrugScreenStart() {
        return drugScreenStart;
    }

    public void setDrugScreenStart(Date drugScreenStart) {
        this.drugScreenStart = drugScreenStart;
    }

    @Basic
    @Column(name = "drug_screen_expire", nullable = false)
    public Date getDrugScreenExpire() {
        return drugScreenExpire;
    }

    public void setDrugScreenExpire(Date drugScreenExpire) {
        this.drugScreenExpire = drugScreenExpire;
    }

    @Basic
    @Column(name = "drug_screen_status", nullable = false)
    public int getDrugScreenStatus() {
        return drugScreenStatus;
    }

    public void setDrugScreenStatus(int drugScreenStatus) {
        this.drugScreenStatus = drugScreenStatus;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state", nullable = false, length = 255)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "zipcode", nullable = false, length = 255)
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "vehicle_id", nullable = false)
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "allow_pets", nullable = false)
    public int getAllowPets() {
        return allowPets;
    }

    public void setAllowPets(int allowPets) {
        this.allowPets = allowPets;
    }

    @Basic
    @Column(name = "allow_wheelchair", nullable = false)
    public int getAllowWheelchair() {
        return allowWheelchair;
    }

    public void setAllowWheelchair(int allowWheelchair) {
        this.allowWheelchair = allowWheelchair;
    }

    @Basic
    @Column(name = "duty_status", nullable = false)
    public int getDutyStatus() {
        return dutyStatus;
    }

    public void setDutyStatus(int dutyStatus) {
        this.dutyStatus = dutyStatus;
    }

    @Basic
    @Column(name = "app_language", nullable = false, length = 255)
    public String getAppLanguage() {
        return appLanguage;
    }

    public void setAppLanguage(String appLanguage) {
        this.appLanguage = appLanguage;
    }

    @Basic
    @Column(name = "device_token", nullable = false, length = 255)
    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    @Basic
    @Column(name = "device_id", nullable = false, length = 255)
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "mobile_os", nullable = false, length = 255)
    public String getMobileOs() {
        return mobileOs;
    }

    public void setMobileOs(String mobileOs) {
        this.mobileOs = mobileOs;
    }

    @Basic
    @Column(name = "object_id", nullable = false, length = 255)
    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
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
    @Column(name = "approvable_mail", nullable = false)
    public int getApprovableMail() {
        return approvableMail;
    }

    public void setApprovableMail(int approvableMail) {
        this.approvableMail = approvableMail;
    }

    @Basic
    @Column(name = "base_approved", nullable = false)
    public int getBaseApproved() {
        return baseApproved;
    }

    public void setBaseApproved(int baseApproved) {
        this.baseApproved = baseApproved;
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
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", merchantAccountId='" + merchantAccountId + '\'' +
                ", baseId=" + baseId +
                ", companyId=" + companyId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", driverType=" + driverType +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fleetNum='" + fleetNum + '\'' +
                ", phone='" + phone + '\'' +
                ", secondaryPhone='" + secondaryPhone + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", nationality='" + nationality + '\'' +
                ", drivingExperience=" + drivingExperience +
                ", verificationCode='" + verificationCode + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", signature='" + signature + '\'' +
                ", driverLicense='" + driverLicense + '\'' +
                ", driverLicenseNum='" + driverLicenseNum + '\'' +
                ", driverLicenseClass='" + driverLicenseClass + '\'' +
                ", driverLicenseState='" + driverLicenseState + '\'' +
                ", driverLicenseStart=" + driverLicenseStart +
                ", driverLicenseExpire=" + driverLicenseExpire +
                ", driverLicenseStatus=" + driverLicenseStatus +
                ", driverTlcFhvLicense='" + driverTlcFhvLicense + '\'' +
                ", driverTlcFhvLicenseNum='" + driverTlcFhvLicenseNum + '\'' +
                ", driverTlcFhvLicenseStart=" + driverTlcFhvLicenseStart +
                ", driverTlcFhvLicenseExpire=" + driverTlcFhvLicenseExpire +
                ", driverTlcFhvLicenseStatus=" + driverTlcFhvLicenseStatus +
                ", backgroundCheck='" + backgroundCheck + '\'' +
                ", backgroundCheckStart=" + backgroundCheckStart +
                ", backgroundCheckExpire=" + backgroundCheckExpire +
                ", backgroundCheckStatus=" + backgroundCheckStatus +
                ", drivingRecord='" + drivingRecord + '\'' +
                ", drivingRecordStart=" + drivingRecordStart +
                ", drivingRecordExpire=" + drivingRecordExpire +
                ", drivingRecordStatus=" + drivingRecordStatus +
                ", drugScreen='" + drugScreen + '\'' +
                ", drugScreenStart=" + drugScreenStart +
                ", drugScreenExpire=" + drugScreenExpire +
                ", drugScreenStatus=" + drugScreenStatus +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", vehicleId=" + vehicleId +
                ", allowPets=" + allowPets +
                ", allowWheelchair=" + allowWheelchair +
                ", dutyStatus=" + dutyStatus +
                ", appLanguage='" + appLanguage + '\'' +
                ", deviceToken='" + deviceToken + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", mobileOs='" + mobileOs + '\'' +
                ", objectId='" + objectId + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", approvableMail=" + approvableMail +
                ", baseApproved=" + baseApproved +
                ", status=" + status +
                '}';
    }
}
