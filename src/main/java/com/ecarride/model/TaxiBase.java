package com.ecarride.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by hanmei on 10/14/16.
 */
@Entity
@Table(name = "taxi_base", schema = "operr_db_qa", catalog = "")
public class TaxiBase {
    private int id;
    private int companyId;
    private String name;
    private int baseTypeId;
    private int fareCalTypeId;
    private String dispatchingLicenseNum;
    private String mainContact;
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private int phone;
    private int fax;
    private String tlcLicense;
    private int tlcLicenseNum;
    private Date tlcLicenseStart;
    private Date tlcLicenseExpire;
    private int tlcLicenseStatus;
    private String automobileLiability;
    private int automobileLiabilityAmount;
    private int automobileLiabilityOperrCertificateHolder;
    private int automobileLiabilitySelfInsured;
    private int automobileLiabilityOperrAdditionalInsured;
    private String automobileLiabilityNameInsurer;
    private Date automobileLiabilityStart;
    private Date automobileLiabilityExpire;
    private int automobileLiabilityStatus;
    private String generalLiability;
    private int generalLiabilityAmount;
    private int generalLiabilityOperrCertificateHolder;
    private int generalLiabilitySelfInsured;
    private int generalLiabilityOperrAdditionalInsured;
    private String generalLiabilityNameInsurer;
    private Date generalLiabilityStart;
    private Date generalLiabilityExpire;
    private int generalLiabilityStatus;
    private String irsRegisteredBusinessName;
    private String federalTax;
    private String tinEinSsn;
    private String federalTaxNum;
    private Date federalTaxStart;
    private Date federalTaxExpire;
    private int federalTaxStatus;
    private String workersCompensation;
    private int workersCompensationAmount;
    private Date workersCompensationStart;
    private Date workersCompensationExpire;
    private int workersCompensationStatus;
    private String trainingAttestation;
    private Date trainingAttestationStart;
    private Date trainingAttestationExpire;
    private int trainingAttestationStatus;
    private String scheduleA;
    private Date scheduleAStart;
    private Date scheduleAExpire;
    private int scheduleAStatus;
    private String scheduleB;
    private Date scheduleBStart;
    private Date scheduleBExpire;
    private int scheduleBStatus;
    private String aetnaInsuranceAmendment;
    private Date aetnaInsuranceAmendmentStart;
    private Date aetnaInsuranceAmendmentExpire;
    private int aetnaInsuranceAmendmentStatus;
    private String wellcareInsuranceAmendment;
    private Date wellcareInsuranceAmendmentStart;
    private Date wellcareInsuranceAmendmentExpire;
    private int wellcareInsuranceAmendmentStatus;
    private String insuranceEndorsementAmendment;
    private Date insuranceEndorsementAmendmentStart;
    private Date insuranceEndorsementAmendmentExpire;
    private int insuranceEndorsementAmendmentStatus;
    private String nyctAmendment;
    private Date nyctAmendmentStart;
    private Date nyctAmendmentExpire;
    private int nyctAmendmentStatus;
    private String serviceAgreement;
    private Date serviceAgreementStart;
    private Date serviceAgreementExpire;
    private int serviceAgreementStatus;
    private Date visitDate;
    private String visitPerformedBy;
    private String visitType;
    private int apptCancelledByVendor;
    private int noShow;
    private String providerAudit;
    private Date providerAuditStart;
    private Date providerAuditExpire;
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
    @Column(name = "company_id", nullable = false)
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "base_type_id", nullable = false)
    public int getBaseTypeId() {
        return baseTypeId;
    }

    public void setBaseTypeId(int baseTypeId) {
        this.baseTypeId = baseTypeId;
    }

    @Basic
    @Column(name = "fare_cal_type_id", nullable = false)
    public int getFareCalTypeId() {
        return fareCalTypeId;
    }

    public void setFareCalTypeId(int fareCalTypeId) {
        this.fareCalTypeId = fareCalTypeId;
    }

    @Basic
    @Column(name = "dispatching_license_num", nullable = false, length = 255)
    public String getDispatchingLicenseNum() {
        return dispatchingLicenseNum;
    }

    public void setDispatchingLicenseNum(String dispatchingLicenseNum) {
        this.dispatchingLicenseNum = dispatchingLicenseNum;
    }

    @Basic
    @Column(name = "main_contact", nullable = false, length = 255)
    public String getMainContact() {
        return mainContact;
    }

    public void setMainContact(String mainContact) {
        this.mainContact = mainContact;
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
    @Column(name = "zipcode", nullable = false)
    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "phone", nullable = false)
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "fax", nullable = false)
    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "tlc_license", nullable = false, length = 255)
    public String getTlcLicense() {
        return tlcLicense;
    }

    public void setTlcLicense(String tlcLicense) {
        this.tlcLicense = tlcLicense;
    }

    @Basic
    @Column(name = "tlc_license_num", nullable = false)
    public int getTlcLicenseNum() {
        return tlcLicenseNum;
    }

    public void setTlcLicenseNum(int tlcLicenseNum) {
        this.tlcLicenseNum = tlcLicenseNum;
    }

    @Basic
    @Column(name = "tlc_license_start", nullable = false)
    public Date getTlcLicenseStart() {
        return tlcLicenseStart;
    }

    public void setTlcLicenseStart(Date tlcLicenseStart) {
        this.tlcLicenseStart = tlcLicenseStart;
    }

    @Basic
    @Column(name = "tlc_license_expire", nullable = false)
    public Date getTlcLicenseExpire() {
        return tlcLicenseExpire;
    }

    public void setTlcLicenseExpire(Date tlcLicenseExpire) {
        this.tlcLicenseExpire = tlcLicenseExpire;
    }

    @Basic
    @Column(name = "tlc_license_status", nullable = false)
    public int getTlcLicenseStatus() {
        return tlcLicenseStatus;
    }

    public void setTlcLicenseStatus(int tlcLicenseStatus) {
        this.tlcLicenseStatus = tlcLicenseStatus;
    }

    @Basic
    @Column(name = "automobile_liability", nullable = false, length = 255)
    public String getAutomobileLiability() {
        return automobileLiability;
    }

    public void setAutomobileLiability(String automobileLiability) {
        this.automobileLiability = automobileLiability;
    }

    @Basic
    @Column(name = "automobile_liability_amount", nullable = false)
    public int getAutomobileLiabilityAmount() {
        return automobileLiabilityAmount;
    }

    public void setAutomobileLiabilityAmount(int automobileLiabilityAmount) {
        this.automobileLiabilityAmount = automobileLiabilityAmount;
    }

    @Basic
    @Column(name = "automobile_liability_operr_certificate_holder", nullable = false)
    public int getAutomobileLiabilityOperrCertificateHolder() {
        return automobileLiabilityOperrCertificateHolder;
    }

    public void setAutomobileLiabilityOperrCertificateHolder(int automobileLiabilityOperrCertificateHolder) {
        this.automobileLiabilityOperrCertificateHolder = automobileLiabilityOperrCertificateHolder;
    }

    @Basic
    @Column(name = "automobile_liability_self_insured", nullable = false)
    public int getAutomobileLiabilitySelfInsured() {
        return automobileLiabilitySelfInsured;
    }

    public void setAutomobileLiabilitySelfInsured(int automobileLiabilitySelfInsured) {
        this.automobileLiabilitySelfInsured = automobileLiabilitySelfInsured;
    }

    @Basic
    @Column(name = "automobile_liability_operr_additional_insured", nullable = false)
    public int getAutomobileLiabilityOperrAdditionalInsured() {
        return automobileLiabilityOperrAdditionalInsured;
    }

    public void setAutomobileLiabilityOperrAdditionalInsured(int automobileLiabilityOperrAdditionalInsured) {
        this.automobileLiabilityOperrAdditionalInsured = automobileLiabilityOperrAdditionalInsured;
    }

    @Basic
    @Column(name = "automobile_liability_name_insurer", nullable = false, length = 255)
    public String getAutomobileLiabilityNameInsurer() {
        return automobileLiabilityNameInsurer;
    }

    public void setAutomobileLiabilityNameInsurer(String automobileLiabilityNameInsurer) {
        this.automobileLiabilityNameInsurer = automobileLiabilityNameInsurer;
    }

    @Basic
    @Column(name = "automobile_liability_start", nullable = false)
    public Date getAutomobileLiabilityStart() {
        return automobileLiabilityStart;
    }

    public void setAutomobileLiabilityStart(Date automobileLiabilityStart) {
        this.automobileLiabilityStart = automobileLiabilityStart;
    }

    @Basic
    @Column(name = "automobile_liability_expire", nullable = false)
    public Date getAutomobileLiabilityExpire() {
        return automobileLiabilityExpire;
    }

    public void setAutomobileLiabilityExpire(Date automobileLiabilityExpire) {
        this.automobileLiabilityExpire = automobileLiabilityExpire;
    }

    @Basic
    @Column(name = "automobile_liability_status", nullable = false)
    public int getAutomobileLiabilityStatus() {
        return automobileLiabilityStatus;
    }

    public void setAutomobileLiabilityStatus(int automobileLiabilityStatus) {
        this.automobileLiabilityStatus = automobileLiabilityStatus;
    }

    @Basic
    @Column(name = "general_liability", nullable = false, length = 255)
    public String getGeneralLiability() {
        return generalLiability;
    }

    public void setGeneralLiability(String generalLiability) {
        this.generalLiability = generalLiability;
    }

    @Basic
    @Column(name = "general_liability_amount", nullable = false)
    public int getGeneralLiabilityAmount() {
        return generalLiabilityAmount;
    }

    public void setGeneralLiabilityAmount(int generalLiabilityAmount) {
        this.generalLiabilityAmount = generalLiabilityAmount;
    }

    @Basic
    @Column(name = "general_liability_operr_certificate_holder", nullable = false)
    public int getGeneralLiabilityOperrCertificateHolder() {
        return generalLiabilityOperrCertificateHolder;
    }

    public void setGeneralLiabilityOperrCertificateHolder(int generalLiabilityOperrCertificateHolder) {
        this.generalLiabilityOperrCertificateHolder = generalLiabilityOperrCertificateHolder;
    }

    @Basic
    @Column(name = "general_liability_self_insured", nullable = false)
    public int getGeneralLiabilitySelfInsured() {
        return generalLiabilitySelfInsured;
    }

    public void setGeneralLiabilitySelfInsured(int generalLiabilitySelfInsured) {
        this.generalLiabilitySelfInsured = generalLiabilitySelfInsured;
    }

    @Basic
    @Column(name = "general_liability_operr_additional_insured", nullable = false)
    public int getGeneralLiabilityOperrAdditionalInsured() {
        return generalLiabilityOperrAdditionalInsured;
    }

    public void setGeneralLiabilityOperrAdditionalInsured(int generalLiabilityOperrAdditionalInsured) {
        this.generalLiabilityOperrAdditionalInsured = generalLiabilityOperrAdditionalInsured;
    }

    @Basic
    @Column(name = "general_liability_name_insurer", nullable = false, length = 255)
    public String getGeneralLiabilityNameInsurer() {
        return generalLiabilityNameInsurer;
    }

    public void setGeneralLiabilityNameInsurer(String generalLiabilityNameInsurer) {
        this.generalLiabilityNameInsurer = generalLiabilityNameInsurer;
    }

    @Basic
    @Column(name = "general_liability_start", nullable = false)
    public Date getGeneralLiabilityStart() {
        return generalLiabilityStart;
    }

    public void setGeneralLiabilityStart(Date generalLiabilityStart) {
        this.generalLiabilityStart = generalLiabilityStart;
    }

    @Basic
    @Column(name = "general_liability_expire", nullable = false)
    public Date getGeneralLiabilityExpire() {
        return generalLiabilityExpire;
    }

    public void setGeneralLiabilityExpire(Date generalLiabilityExpire) {
        this.generalLiabilityExpire = generalLiabilityExpire;
    }

    @Basic
    @Column(name = "general_liability_status", nullable = false)
    public int getGeneralLiabilityStatus() {
        return generalLiabilityStatus;
    }

    public void setGeneralLiabilityStatus(int generalLiabilityStatus) {
        this.generalLiabilityStatus = generalLiabilityStatus;
    }

    @Basic
    @Column(name = "irs_registered_business_name", nullable = false, length = 255)
    public String getIrsRegisteredBusinessName() {
        return irsRegisteredBusinessName;
    }

    public void setIrsRegisteredBusinessName(String irsRegisteredBusinessName) {
        this.irsRegisteredBusinessName = irsRegisteredBusinessName;
    }

    @Basic
    @Column(name = "federal_tax", nullable = false, length = 255)
    public String getFederalTax() {
        return federalTax;
    }

    public void setFederalTax(String federalTax) {
        this.federalTax = federalTax;
    }

    @Basic
    @Column(name = "tin_ein_ssn", nullable = false, length = 255)
    public String getTinEinSsn() {
        return tinEinSsn;
    }

    public void setTinEinSsn(String tinEinSsn) {
        this.tinEinSsn = tinEinSsn;
    }

    @Basic
    @Column(name = "federal_tax_num", nullable = false, length = 255)
    public String getFederalTaxNum() {
        return federalTaxNum;
    }

    public void setFederalTaxNum(String federalTaxNum) {
        this.federalTaxNum = federalTaxNum;
    }

    @Basic
    @Column(name = "federal_tax_start", nullable = false)
    public Date getFederalTaxStart() {
        return federalTaxStart;
    }

    public void setFederalTaxStart(Date federalTaxStart) {
        this.federalTaxStart = federalTaxStart;
    }

    @Basic
    @Column(name = "federal_tax_expire", nullable = false)
    public Date getFederalTaxExpire() {
        return federalTaxExpire;
    }

    public void setFederalTaxExpire(Date federalTaxExpire) {
        this.federalTaxExpire = federalTaxExpire;
    }

    @Basic
    @Column(name = "federal_tax_status", nullable = false)
    public int getFederalTaxStatus() {
        return federalTaxStatus;
    }

    public void setFederalTaxStatus(int federalTaxStatus) {
        this.federalTaxStatus = federalTaxStatus;
    }

    @Basic
    @Column(name = "workers_compensation", nullable = false, length = 255)
    public String getWorkersCompensation() {
        return workersCompensation;
    }

    public void setWorkersCompensation(String workersCompensation) {
        this.workersCompensation = workersCompensation;
    }

    @Basic
    @Column(name = "workers_compensation_amount", nullable = false)
    public int getWorkersCompensationAmount() {
        return workersCompensationAmount;
    }

    public void setWorkersCompensationAmount(int workersCompensationAmount) {
        this.workersCompensationAmount = workersCompensationAmount;
    }

    @Basic
    @Column(name = "workers_compensation_start", nullable = false)
    public Date getWorkersCompensationStart() {
        return workersCompensationStart;
    }

    public void setWorkersCompensationStart(Date workersCompensationStart) {
        this.workersCompensationStart = workersCompensationStart;
    }

    @Basic
    @Column(name = "workers_compensation_expire", nullable = false)
    public Date getWorkersCompensationExpire() {
        return workersCompensationExpire;
    }

    public void setWorkersCompensationExpire(Date workersCompensationExpire) {
        this.workersCompensationExpire = workersCompensationExpire;
    }

    @Basic
    @Column(name = "workers_compensation_status", nullable = false)
    public int getWorkersCompensationStatus() {
        return workersCompensationStatus;
    }

    public void setWorkersCompensationStatus(int workersCompensationStatus) {
        this.workersCompensationStatus = workersCompensationStatus;
    }

    @Basic
    @Column(name = "training_attestation", nullable = false, length = 255)
    public String getTrainingAttestation() {
        return trainingAttestation;
    }

    public void setTrainingAttestation(String trainingAttestation) {
        this.trainingAttestation = trainingAttestation;
    }

    @Basic
    @Column(name = "training_attestation_start", nullable = false)
    public Date getTrainingAttestationStart() {
        return trainingAttestationStart;
    }

    public void setTrainingAttestationStart(Date trainingAttestationStart) {
        this.trainingAttestationStart = trainingAttestationStart;
    }

    @Basic
    @Column(name = "training_attestation_expire", nullable = false)
    public Date getTrainingAttestationExpire() {
        return trainingAttestationExpire;
    }

    public void setTrainingAttestationExpire(Date trainingAttestationExpire) {
        this.trainingAttestationExpire = trainingAttestationExpire;
    }

    @Basic
    @Column(name = "training_attestation_status", nullable = false)
    public int getTrainingAttestationStatus() {
        return trainingAttestationStatus;
    }

    public void setTrainingAttestationStatus(int trainingAttestationStatus) {
        this.trainingAttestationStatus = trainingAttestationStatus;
    }

    @Basic
    @Column(name = "schedule_a", nullable = false, length = 255)
    public String getScheduleA() {
        return scheduleA;
    }

    public void setScheduleA(String scheduleA) {
        this.scheduleA = scheduleA;
    }

    @Basic
    @Column(name = "schedule_a_start", nullable = false)
    public Date getScheduleAStart() {
        return scheduleAStart;
    }

    public void setScheduleAStart(Date scheduleAStart) {
        this.scheduleAStart = scheduleAStart;
    }

    @Basic
    @Column(name = "schedule_a_expire", nullable = false)
    public Date getScheduleAExpire() {
        return scheduleAExpire;
    }

    public void setScheduleAExpire(Date scheduleAExpire) {
        this.scheduleAExpire = scheduleAExpire;
    }

    @Basic
    @Column(name = "schedule_a_status", nullable = false)
    public int getScheduleAStatus() {
        return scheduleAStatus;
    }

    public void setScheduleAStatus(int scheduleAStatus) {
        this.scheduleAStatus = scheduleAStatus;
    }

    @Basic
    @Column(name = "schedule_b", nullable = false, length = 255)
    public String getScheduleB() {
        return scheduleB;
    }

    public void setScheduleB(String scheduleB) {
        this.scheduleB = scheduleB;
    }

    @Basic
    @Column(name = "schedule_b_start", nullable = false)
    public Date getScheduleBStart() {
        return scheduleBStart;
    }

    public void setScheduleBStart(Date scheduleBStart) {
        this.scheduleBStart = scheduleBStart;
    }

    @Basic
    @Column(name = "schedule_b_expire", nullable = false)
    public Date getScheduleBExpire() {
        return scheduleBExpire;
    }

    public void setScheduleBExpire(Date scheduleBExpire) {
        this.scheduleBExpire = scheduleBExpire;
    }

    @Basic
    @Column(name = "schedule_b_status", nullable = false)
    public int getScheduleBStatus() {
        return scheduleBStatus;
    }

    public void setScheduleBStatus(int scheduleBStatus) {
        this.scheduleBStatus = scheduleBStatus;
    }

    @Basic
    @Column(name = "aetna_insurance_amendment", nullable = false, length = 255)
    public String getAetnaInsuranceAmendment() {
        return aetnaInsuranceAmendment;
    }

    public void setAetnaInsuranceAmendment(String aetnaInsuranceAmendment) {
        this.aetnaInsuranceAmendment = aetnaInsuranceAmendment;
    }

    @Basic
    @Column(name = "aetna_insurance_amendment_start", nullable = false)
    public Date getAetnaInsuranceAmendmentStart() {
        return aetnaInsuranceAmendmentStart;
    }

    public void setAetnaInsuranceAmendmentStart(Date aetnaInsuranceAmendmentStart) {
        this.aetnaInsuranceAmendmentStart = aetnaInsuranceAmendmentStart;
    }

    @Basic
    @Column(name = "aetna_insurance_amendment_expire", nullable = false)
    public Date getAetnaInsuranceAmendmentExpire() {
        return aetnaInsuranceAmendmentExpire;
    }

    public void setAetnaInsuranceAmendmentExpire(Date aetnaInsuranceAmendmentExpire) {
        this.aetnaInsuranceAmendmentExpire = aetnaInsuranceAmendmentExpire;
    }

    @Basic
    @Column(name = "aetna_insurance_amendment_status", nullable = false)
    public int getAetnaInsuranceAmendmentStatus() {
        return aetnaInsuranceAmendmentStatus;
    }

    public void setAetnaInsuranceAmendmentStatus(int aetnaInsuranceAmendmentStatus) {
        this.aetnaInsuranceAmendmentStatus = aetnaInsuranceAmendmentStatus;
    }

    @Basic
    @Column(name = "wellcare_insurance_amendment", nullable = false, length = 255)
    public String getWellcareInsuranceAmendment() {
        return wellcareInsuranceAmendment;
    }

    public void setWellcareInsuranceAmendment(String wellcareInsuranceAmendment) {
        this.wellcareInsuranceAmendment = wellcareInsuranceAmendment;
    }

    @Basic
    @Column(name = "wellcare_insurance_amendment_start", nullable = false)
    public Date getWellcareInsuranceAmendmentStart() {
        return wellcareInsuranceAmendmentStart;
    }

    public void setWellcareInsuranceAmendmentStart(Date wellcareInsuranceAmendmentStart) {
        this.wellcareInsuranceAmendmentStart = wellcareInsuranceAmendmentStart;
    }

    @Basic
    @Column(name = "wellcare_insurance_amendment_expire", nullable = false)
    public Date getWellcareInsuranceAmendmentExpire() {
        return wellcareInsuranceAmendmentExpire;
    }

    public void setWellcareInsuranceAmendmentExpire(Date wellcareInsuranceAmendmentExpire) {
        this.wellcareInsuranceAmendmentExpire = wellcareInsuranceAmendmentExpire;
    }

    @Basic
    @Column(name = "wellcare_insurance_amendment_status", nullable = false)
    public int getWellcareInsuranceAmendmentStatus() {
        return wellcareInsuranceAmendmentStatus;
    }

    public void setWellcareInsuranceAmendmentStatus(int wellcareInsuranceAmendmentStatus) {
        this.wellcareInsuranceAmendmentStatus = wellcareInsuranceAmendmentStatus;
    }

    @Basic
    @Column(name = "insurance_endorsement_amendment", nullable = false, length = 255)
    public String getInsuranceEndorsementAmendment() {
        return insuranceEndorsementAmendment;
    }

    public void setInsuranceEndorsementAmendment(String insuranceEndorsementAmendment) {
        this.insuranceEndorsementAmendment = insuranceEndorsementAmendment;
    }

    @Basic
    @Column(name = "insurance_endorsement_amendment_start", nullable = false)
    public Date getInsuranceEndorsementAmendmentStart() {
        return insuranceEndorsementAmendmentStart;
    }

    public void setInsuranceEndorsementAmendmentStart(Date insuranceEndorsementAmendmentStart) {
        this.insuranceEndorsementAmendmentStart = insuranceEndorsementAmendmentStart;
    }

    @Basic
    @Column(name = "insurance_endorsement_amendment_expire", nullable = false)
    public Date getInsuranceEndorsementAmendmentExpire() {
        return insuranceEndorsementAmendmentExpire;
    }

    public void setInsuranceEndorsementAmendmentExpire(Date insuranceEndorsementAmendmentExpire) {
        this.insuranceEndorsementAmendmentExpire = insuranceEndorsementAmendmentExpire;
    }

    @Basic
    @Column(name = "insurance_endorsement_amendment_status", nullable = false)
    public int getInsuranceEndorsementAmendmentStatus() {
        return insuranceEndorsementAmendmentStatus;
    }

    public void setInsuranceEndorsementAmendmentStatus(int insuranceEndorsementAmendmentStatus) {
        this.insuranceEndorsementAmendmentStatus = insuranceEndorsementAmendmentStatus;
    }

    @Basic
    @Column(name = "nyct_amendment", nullable = false, length = 255)
    public String getNyctAmendment() {
        return nyctAmendment;
    }

    public void setNyctAmendment(String nyctAmendment) {
        this.nyctAmendment = nyctAmendment;
    }

    @Basic
    @Column(name = "nyct_amendment_start", nullable = false)
    public Date getNyctAmendmentStart() {
        return nyctAmendmentStart;
    }

    public void setNyctAmendmentStart(Date nyctAmendmentStart) {
        this.nyctAmendmentStart = nyctAmendmentStart;
    }

    @Basic
    @Column(name = "nyct_amendment_expire", nullable = false)
    public Date getNyctAmendmentExpire() {
        return nyctAmendmentExpire;
    }

    public void setNyctAmendmentExpire(Date nyctAmendmentExpire) {
        this.nyctAmendmentExpire = nyctAmendmentExpire;
    }

    @Basic
    @Column(name = "nyct_amendment_status", nullable = false)
    public int getNyctAmendmentStatus() {
        return nyctAmendmentStatus;
    }

    public void setNyctAmendmentStatus(int nyctAmendmentStatus) {
        this.nyctAmendmentStatus = nyctAmendmentStatus;
    }

    @Basic
    @Column(name = "service_agreement", nullable = false, length = 255)
    public String getServiceAgreement() {
        return serviceAgreement;
    }

    public void setServiceAgreement(String serviceAgreement) {
        this.serviceAgreement = serviceAgreement;
    }

    @Basic
    @Column(name = "service_agreement_start", nullable = false)
    public Date getServiceAgreementStart() {
        return serviceAgreementStart;
    }

    public void setServiceAgreementStart(Date serviceAgreementStart) {
        this.serviceAgreementStart = serviceAgreementStart;
    }

    @Basic
    @Column(name = "service_agreement_expire", nullable = false)
    public Date getServiceAgreementExpire() {
        return serviceAgreementExpire;
    }

    public void setServiceAgreementExpire(Date serviceAgreementExpire) {
        this.serviceAgreementExpire = serviceAgreementExpire;
    }

    @Basic
    @Column(name = "service_agreement_status", nullable = false)
    public int getServiceAgreementStatus() {
        return serviceAgreementStatus;
    }

    public void setServiceAgreementStatus(int serviceAgreementStatus) {
        this.serviceAgreementStatus = serviceAgreementStatus;
    }

    @Basic
    @Column(name = "visit_date", nullable = false)
    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    @Basic
    @Column(name = "visit_performed_by", nullable = false, length = 255)
    public String getVisitPerformedBy() {
        return visitPerformedBy;
    }

    public void setVisitPerformedBy(String visitPerformedBy) {
        this.visitPerformedBy = visitPerformedBy;
    }

    @Basic
    @Column(name = "visit_type", nullable = false, length = 255)
    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    @Basic
    @Column(name = "appt_cancelled_by_vendor", nullable = false)
    public int getApptCancelledByVendor() {
        return apptCancelledByVendor;
    }

    public void setApptCancelledByVendor(int apptCancelledByVendor) {
        this.apptCancelledByVendor = apptCancelledByVendor;
    }

    @Basic
    @Column(name = "no_show", nullable = false)
    public int getNoShow() {
        return noShow;
    }

    public void setNoShow(int noShow) {
        this.noShow = noShow;
    }

    @Basic
    @Column(name = "provider_audit", nullable = false, length = 255)
    public String getProviderAudit() {
        return providerAudit;
    }

    public void setProviderAudit(String providerAudit) {
        this.providerAudit = providerAudit;
    }

    @Basic
    @Column(name = "provider_audit_start", nullable = false)
    public Date getProviderAuditStart() {
        return providerAuditStart;
    }

    public void setProviderAuditStart(Date providerAuditStart) {
        this.providerAuditStart = providerAuditStart;
    }

    @Basic
    @Column(name = "provider_audit_expire", nullable = false)
    public Date getProviderAuditExpire() {
        return providerAuditExpire;
    }

    public void setProviderAuditExpire(Date providerAuditExpire) {
        this.providerAuditExpire = providerAuditExpire;
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

        TaxiBase taxiBase = (TaxiBase) o;

        if (id != taxiBase.id) return false;
        if (companyId != taxiBase.companyId) return false;
        if (baseTypeId != taxiBase.baseTypeId) return false;
        if (fareCalTypeId != taxiBase.fareCalTypeId) return false;
        if (zipcode != taxiBase.zipcode) return false;
        if (phone != taxiBase.phone) return false;
        if (fax != taxiBase.fax) return false;
        if (tlcLicenseNum != taxiBase.tlcLicenseNum) return false;
        if (tlcLicenseStatus != taxiBase.tlcLicenseStatus) return false;
        if (automobileLiabilityAmount != taxiBase.automobileLiabilityAmount) return false;
        if (automobileLiabilityOperrCertificateHolder != taxiBase.automobileLiabilityOperrCertificateHolder)
            return false;
        if (automobileLiabilitySelfInsured != taxiBase.automobileLiabilitySelfInsured) return false;
        if (automobileLiabilityOperrAdditionalInsured != taxiBase.automobileLiabilityOperrAdditionalInsured)
            return false;
        if (automobileLiabilityStatus != taxiBase.automobileLiabilityStatus) return false;
        if (generalLiabilityAmount != taxiBase.generalLiabilityAmount) return false;
        if (generalLiabilityOperrCertificateHolder != taxiBase.generalLiabilityOperrCertificateHolder) return false;
        if (generalLiabilitySelfInsured != taxiBase.generalLiabilitySelfInsured) return false;
        if (generalLiabilityOperrAdditionalInsured != taxiBase.generalLiabilityOperrAdditionalInsured) return false;
        if (generalLiabilityStatus != taxiBase.generalLiabilityStatus) return false;
        if (federalTaxStatus != taxiBase.federalTaxStatus) return false;
        if (workersCompensationAmount != taxiBase.workersCompensationAmount) return false;
        if (workersCompensationStatus != taxiBase.workersCompensationStatus) return false;
        if (trainingAttestationStatus != taxiBase.trainingAttestationStatus) return false;
        if (scheduleAStatus != taxiBase.scheduleAStatus) return false;
        if (scheduleBStatus != taxiBase.scheduleBStatus) return false;
        if (aetnaInsuranceAmendmentStatus != taxiBase.aetnaInsuranceAmendmentStatus) return false;
        if (wellcareInsuranceAmendmentStatus != taxiBase.wellcareInsuranceAmendmentStatus) return false;
        if (insuranceEndorsementAmendmentStatus != taxiBase.insuranceEndorsementAmendmentStatus) return false;
        if (nyctAmendmentStatus != taxiBase.nyctAmendmentStatus) return false;
        if (serviceAgreementStatus != taxiBase.serviceAgreementStatus) return false;
        if (apptCancelledByVendor != taxiBase.apptCancelledByVendor) return false;
        if (noShow != taxiBase.noShow) return false;
        if (status != taxiBase.status) return false;
        if (name != null ? !name.equals(taxiBase.name) : taxiBase.name != null) return false;
        if (dispatchingLicenseNum != null ? !dispatchingLicenseNum.equals(taxiBase.dispatchingLicenseNum) : taxiBase.dispatchingLicenseNum != null)
            return false;
        if (mainContact != null ? !mainContact.equals(taxiBase.mainContact) : taxiBase.mainContact != null)
            return false;
        if (address != null ? !address.equals(taxiBase.address) : taxiBase.address != null) return false;
        if (city != null ? !city.equals(taxiBase.city) : taxiBase.city != null) return false;
        if (state != null ? !state.equals(taxiBase.state) : taxiBase.state != null) return false;
        if (tlcLicense != null ? !tlcLicense.equals(taxiBase.tlcLicense) : taxiBase.tlcLicense != null) return false;
        if (tlcLicenseStart != null ? !tlcLicenseStart.equals(taxiBase.tlcLicenseStart) : taxiBase.tlcLicenseStart != null)
            return false;
        if (tlcLicenseExpire != null ? !tlcLicenseExpire.equals(taxiBase.tlcLicenseExpire) : taxiBase.tlcLicenseExpire != null)
            return false;
        if (automobileLiability != null ? !automobileLiability.equals(taxiBase.automobileLiability) : taxiBase.automobileLiability != null)
            return false;
        if (automobileLiabilityNameInsurer != null ? !automobileLiabilityNameInsurer.equals(taxiBase.automobileLiabilityNameInsurer) : taxiBase.automobileLiabilityNameInsurer != null)
            return false;
        if (automobileLiabilityStart != null ? !automobileLiabilityStart.equals(taxiBase.automobileLiabilityStart) : taxiBase.automobileLiabilityStart != null)
            return false;
        if (automobileLiabilityExpire != null ? !automobileLiabilityExpire.equals(taxiBase.automobileLiabilityExpire) : taxiBase.automobileLiabilityExpire != null)
            return false;
        if (generalLiability != null ? !generalLiability.equals(taxiBase.generalLiability) : taxiBase.generalLiability != null)
            return false;
        if (generalLiabilityNameInsurer != null ? !generalLiabilityNameInsurer.equals(taxiBase.generalLiabilityNameInsurer) : taxiBase.generalLiabilityNameInsurer != null)
            return false;
        if (generalLiabilityStart != null ? !generalLiabilityStart.equals(taxiBase.generalLiabilityStart) : taxiBase.generalLiabilityStart != null)
            return false;
        if (generalLiabilityExpire != null ? !generalLiabilityExpire.equals(taxiBase.generalLiabilityExpire) : taxiBase.generalLiabilityExpire != null)
            return false;
        if (irsRegisteredBusinessName != null ? !irsRegisteredBusinessName.equals(taxiBase.irsRegisteredBusinessName) : taxiBase.irsRegisteredBusinessName != null)
            return false;
        if (federalTax != null ? !federalTax.equals(taxiBase.federalTax) : taxiBase.federalTax != null) return false;
        if (tinEinSsn != null ? !tinEinSsn.equals(taxiBase.tinEinSsn) : taxiBase.tinEinSsn != null) return false;
        if (federalTaxNum != null ? !federalTaxNum.equals(taxiBase.federalTaxNum) : taxiBase.federalTaxNum != null)
            return false;
        if (federalTaxStart != null ? !federalTaxStart.equals(taxiBase.federalTaxStart) : taxiBase.federalTaxStart != null)
            return false;
        if (federalTaxExpire != null ? !federalTaxExpire.equals(taxiBase.federalTaxExpire) : taxiBase.federalTaxExpire != null)
            return false;
        if (workersCompensation != null ? !workersCompensation.equals(taxiBase.workersCompensation) : taxiBase.workersCompensation != null)
            return false;
        if (workersCompensationStart != null ? !workersCompensationStart.equals(taxiBase.workersCompensationStart) : taxiBase.workersCompensationStart != null)
            return false;
        if (workersCompensationExpire != null ? !workersCompensationExpire.equals(taxiBase.workersCompensationExpire) : taxiBase.workersCompensationExpire != null)
            return false;
        if (trainingAttestation != null ? !trainingAttestation.equals(taxiBase.trainingAttestation) : taxiBase.trainingAttestation != null)
            return false;
        if (trainingAttestationStart != null ? !trainingAttestationStart.equals(taxiBase.trainingAttestationStart) : taxiBase.trainingAttestationStart != null)
            return false;
        if (trainingAttestationExpire != null ? !trainingAttestationExpire.equals(taxiBase.trainingAttestationExpire) : taxiBase.trainingAttestationExpire != null)
            return false;
        if (scheduleA != null ? !scheduleA.equals(taxiBase.scheduleA) : taxiBase.scheduleA != null) return false;
        if (scheduleAStart != null ? !scheduleAStart.equals(taxiBase.scheduleAStart) : taxiBase.scheduleAStart != null)
            return false;
        if (scheduleAExpire != null ? !scheduleAExpire.equals(taxiBase.scheduleAExpire) : taxiBase.scheduleAExpire != null)
            return false;
        if (scheduleB != null ? !scheduleB.equals(taxiBase.scheduleB) : taxiBase.scheduleB != null) return false;
        if (scheduleBStart != null ? !scheduleBStart.equals(taxiBase.scheduleBStart) : taxiBase.scheduleBStart != null)
            return false;
        if (scheduleBExpire != null ? !scheduleBExpire.equals(taxiBase.scheduleBExpire) : taxiBase.scheduleBExpire != null)
            return false;
        if (aetnaInsuranceAmendment != null ? !aetnaInsuranceAmendment.equals(taxiBase.aetnaInsuranceAmendment) : taxiBase.aetnaInsuranceAmendment != null)
            return false;
        if (aetnaInsuranceAmendmentStart != null ? !aetnaInsuranceAmendmentStart.equals(taxiBase.aetnaInsuranceAmendmentStart) : taxiBase.aetnaInsuranceAmendmentStart != null)
            return false;
        if (aetnaInsuranceAmendmentExpire != null ? !aetnaInsuranceAmendmentExpire.equals(taxiBase.aetnaInsuranceAmendmentExpire) : taxiBase.aetnaInsuranceAmendmentExpire != null)
            return false;
        if (wellcareInsuranceAmendment != null ? !wellcareInsuranceAmendment.equals(taxiBase.wellcareInsuranceAmendment) : taxiBase.wellcareInsuranceAmendment != null)
            return false;
        if (wellcareInsuranceAmendmentStart != null ? !wellcareInsuranceAmendmentStart.equals(taxiBase.wellcareInsuranceAmendmentStart) : taxiBase.wellcareInsuranceAmendmentStart != null)
            return false;
        if (wellcareInsuranceAmendmentExpire != null ? !wellcareInsuranceAmendmentExpire.equals(taxiBase.wellcareInsuranceAmendmentExpire) : taxiBase.wellcareInsuranceAmendmentExpire != null)
            return false;
        if (insuranceEndorsementAmendment != null ? !insuranceEndorsementAmendment.equals(taxiBase.insuranceEndorsementAmendment) : taxiBase.insuranceEndorsementAmendment != null)
            return false;
        if (insuranceEndorsementAmendmentStart != null ? !insuranceEndorsementAmendmentStart.equals(taxiBase.insuranceEndorsementAmendmentStart) : taxiBase.insuranceEndorsementAmendmentStart != null)
            return false;
        if (insuranceEndorsementAmendmentExpire != null ? !insuranceEndorsementAmendmentExpire.equals(taxiBase.insuranceEndorsementAmendmentExpire) : taxiBase.insuranceEndorsementAmendmentExpire != null)
            return false;
        if (nyctAmendment != null ? !nyctAmendment.equals(taxiBase.nyctAmendment) : taxiBase.nyctAmendment != null)
            return false;
        if (nyctAmendmentStart != null ? !nyctAmendmentStart.equals(taxiBase.nyctAmendmentStart) : taxiBase.nyctAmendmentStart != null)
            return false;
        if (nyctAmendmentExpire != null ? !nyctAmendmentExpire.equals(taxiBase.nyctAmendmentExpire) : taxiBase.nyctAmendmentExpire != null)
            return false;
        if (serviceAgreement != null ? !serviceAgreement.equals(taxiBase.serviceAgreement) : taxiBase.serviceAgreement != null)
            return false;
        if (serviceAgreementStart != null ? !serviceAgreementStart.equals(taxiBase.serviceAgreementStart) : taxiBase.serviceAgreementStart != null)
            return false;
        if (serviceAgreementExpire != null ? !serviceAgreementExpire.equals(taxiBase.serviceAgreementExpire) : taxiBase.serviceAgreementExpire != null)
            return false;
        if (visitDate != null ? !visitDate.equals(taxiBase.visitDate) : taxiBase.visitDate != null) return false;
        if (visitPerformedBy != null ? !visitPerformedBy.equals(taxiBase.visitPerformedBy) : taxiBase.visitPerformedBy != null)
            return false;
        if (visitType != null ? !visitType.equals(taxiBase.visitType) : taxiBase.visitType != null) return false;
        if (providerAudit != null ? !providerAudit.equals(taxiBase.providerAudit) : taxiBase.providerAudit != null)
            return false;
        if (providerAuditStart != null ? !providerAuditStart.equals(taxiBase.providerAuditStart) : taxiBase.providerAuditStart != null)
            return false;
        if (providerAuditExpire != null ? !providerAuditExpire.equals(taxiBase.providerAuditExpire) : taxiBase.providerAuditExpire != null)
            return false;
        if (createdAt != null ? !createdAt.equals(taxiBase.createdAt) : taxiBase.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(taxiBase.updatedAt) : taxiBase.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + companyId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + baseTypeId;
        result = 31 * result + fareCalTypeId;
        result = 31 * result + (dispatchingLicenseNum != null ? dispatchingLicenseNum.hashCode() : 0);
        result = 31 * result + (mainContact != null ? mainContact.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + zipcode;
        result = 31 * result + phone;
        result = 31 * result + fax;
        result = 31 * result + (tlcLicense != null ? tlcLicense.hashCode() : 0);
        result = 31 * result + tlcLicenseNum;
        result = 31 * result + (tlcLicenseStart != null ? tlcLicenseStart.hashCode() : 0);
        result = 31 * result + (tlcLicenseExpire != null ? tlcLicenseExpire.hashCode() : 0);
        result = 31 * result + tlcLicenseStatus;
        result = 31 * result + (automobileLiability != null ? automobileLiability.hashCode() : 0);
        result = 31 * result + automobileLiabilityAmount;
        result = 31 * result + automobileLiabilityOperrCertificateHolder;
        result = 31 * result + automobileLiabilitySelfInsured;
        result = 31 * result + automobileLiabilityOperrAdditionalInsured;
        result = 31 * result + (automobileLiabilityNameInsurer != null ? automobileLiabilityNameInsurer.hashCode() : 0);
        result = 31 * result + (automobileLiabilityStart != null ? automobileLiabilityStart.hashCode() : 0);
        result = 31 * result + (automobileLiabilityExpire != null ? automobileLiabilityExpire.hashCode() : 0);
        result = 31 * result + automobileLiabilityStatus;
        result = 31 * result + (generalLiability != null ? generalLiability.hashCode() : 0);
        result = 31 * result + generalLiabilityAmount;
        result = 31 * result + generalLiabilityOperrCertificateHolder;
        result = 31 * result + generalLiabilitySelfInsured;
        result = 31 * result + generalLiabilityOperrAdditionalInsured;
        result = 31 * result + (generalLiabilityNameInsurer != null ? generalLiabilityNameInsurer.hashCode() : 0);
        result = 31 * result + (generalLiabilityStart != null ? generalLiabilityStart.hashCode() : 0);
        result = 31 * result + (generalLiabilityExpire != null ? generalLiabilityExpire.hashCode() : 0);
        result = 31 * result + generalLiabilityStatus;
        result = 31 * result + (irsRegisteredBusinessName != null ? irsRegisteredBusinessName.hashCode() : 0);
        result = 31 * result + (federalTax != null ? federalTax.hashCode() : 0);
        result = 31 * result + (tinEinSsn != null ? tinEinSsn.hashCode() : 0);
        result = 31 * result + (federalTaxNum != null ? federalTaxNum.hashCode() : 0);
        result = 31 * result + (federalTaxStart != null ? federalTaxStart.hashCode() : 0);
        result = 31 * result + (federalTaxExpire != null ? federalTaxExpire.hashCode() : 0);
        result = 31 * result + federalTaxStatus;
        result = 31 * result + (workersCompensation != null ? workersCompensation.hashCode() : 0);
        result = 31 * result + workersCompensationAmount;
        result = 31 * result + (workersCompensationStart != null ? workersCompensationStart.hashCode() : 0);
        result = 31 * result + (workersCompensationExpire != null ? workersCompensationExpire.hashCode() : 0);
        result = 31 * result + workersCompensationStatus;
        result = 31 * result + (trainingAttestation != null ? trainingAttestation.hashCode() : 0);
        result = 31 * result + (trainingAttestationStart != null ? trainingAttestationStart.hashCode() : 0);
        result = 31 * result + (trainingAttestationExpire != null ? trainingAttestationExpire.hashCode() : 0);
        result = 31 * result + trainingAttestationStatus;
        result = 31 * result + (scheduleA != null ? scheduleA.hashCode() : 0);
        result = 31 * result + (scheduleAStart != null ? scheduleAStart.hashCode() : 0);
        result = 31 * result + (scheduleAExpire != null ? scheduleAExpire.hashCode() : 0);
        result = 31 * result + scheduleAStatus;
        result = 31 * result + (scheduleB != null ? scheduleB.hashCode() : 0);
        result = 31 * result + (scheduleBStart != null ? scheduleBStart.hashCode() : 0);
        result = 31 * result + (scheduleBExpire != null ? scheduleBExpire.hashCode() : 0);
        result = 31 * result + scheduleBStatus;
        result = 31 * result + (aetnaInsuranceAmendment != null ? aetnaInsuranceAmendment.hashCode() : 0);
        result = 31 * result + (aetnaInsuranceAmendmentStart != null ? aetnaInsuranceAmendmentStart.hashCode() : 0);
        result = 31 * result + (aetnaInsuranceAmendmentExpire != null ? aetnaInsuranceAmendmentExpire.hashCode() : 0);
        result = 31 * result + aetnaInsuranceAmendmentStatus;
        result = 31 * result + (wellcareInsuranceAmendment != null ? wellcareInsuranceAmendment.hashCode() : 0);
        result = 31 * result + (wellcareInsuranceAmendmentStart != null ? wellcareInsuranceAmendmentStart.hashCode() : 0);
        result = 31 * result + (wellcareInsuranceAmendmentExpire != null ? wellcareInsuranceAmendmentExpire.hashCode() : 0);
        result = 31 * result + wellcareInsuranceAmendmentStatus;
        result = 31 * result + (insuranceEndorsementAmendment != null ? insuranceEndorsementAmendment.hashCode() : 0);
        result = 31 * result + (insuranceEndorsementAmendmentStart != null ? insuranceEndorsementAmendmentStart.hashCode() : 0);
        result = 31 * result + (insuranceEndorsementAmendmentExpire != null ? insuranceEndorsementAmendmentExpire.hashCode() : 0);
        result = 31 * result + insuranceEndorsementAmendmentStatus;
        result = 31 * result + (nyctAmendment != null ? nyctAmendment.hashCode() : 0);
        result = 31 * result + (nyctAmendmentStart != null ? nyctAmendmentStart.hashCode() : 0);
        result = 31 * result + (nyctAmendmentExpire != null ? nyctAmendmentExpire.hashCode() : 0);
        result = 31 * result + nyctAmendmentStatus;
        result = 31 * result + (serviceAgreement != null ? serviceAgreement.hashCode() : 0);
        result = 31 * result + (serviceAgreementStart != null ? serviceAgreementStart.hashCode() : 0);
        result = 31 * result + (serviceAgreementExpire != null ? serviceAgreementExpire.hashCode() : 0);
        result = 31 * result + serviceAgreementStatus;
        result = 31 * result + (visitDate != null ? visitDate.hashCode() : 0);
        result = 31 * result + (visitPerformedBy != null ? visitPerformedBy.hashCode() : 0);
        result = 31 * result + (visitType != null ? visitType.hashCode() : 0);
        result = 31 * result + apptCancelledByVendor;
        result = 31 * result + noShow;
        result = 31 * result + (providerAudit != null ? providerAudit.hashCode() : 0);
        result = 31 * result + (providerAuditStart != null ? providerAuditStart.hashCode() : 0);
        result = 31 * result + (providerAuditExpire != null ? providerAuditExpire.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }
}
