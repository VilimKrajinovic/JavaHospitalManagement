/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes.patient;

import java.sql.Date;



/**
 *
 * @author amd
 */
public class PatientFull {

    /**
     * @return the idPatientFull
     */
    public int getIdPatientFull() {
        return idPatientFull;
    }

    /**
     * @param idPatientFull the idPatientFull to set
     */
    public void setIdPatientFull(int idPatientFull) {
        this.idPatientFull = idPatientFull;
    }

    /**
     * @return the patientShortData
     */
    public PatientShort getPatientShortData() {
        return patientShortData;
    }

    /**
     * @param patientShortData the patientShortData to set
     */
    public void setPatientShortData(PatientShort patientShortData) {
        this.patientShortData = patientShortData;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the permanentAddress
     */
    public ContactDetailsAddress getPermanentAddress() {
        return permanentAddress;
    }

    /**
     * @param permanentAddress the permanentAddress to set
     */
    public void setPermanentAddress(ContactDetailsAddress permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    /**
     * @return the presentAddress
     */
    public ContactDetailsAddress getPresentAddress() {
        return presentAddress;
    }

    /**
     * @param presentAddress the presentAddress to set
     */
    public void setPresentAddress(ContactDetailsAddress presentAddress) {
        this.presentAddress = presentAddress;
    }

    /**
     * @return the personalDetails
     */
    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    /**
     * @param personalDetails the personalDetails to set
     */
    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    /**
     * @return the proffesionDetails
     */
    public ProffesionDetails getProffesionDetails() {
        return proffesionDetails;
    }

    /**
     * @param proffesionDetails the proffesionDetails to set
     */
    public void setProffesionDetails(ProffesionDetails proffesionDetails) {
        this.proffesionDetails = proffesionDetails;
    }

    /**
     * @return the lifestyle
     */
    public Lifestyle getLifestyle() {
        return lifestyle;
    }

    /**
     * @param lifestyle the lifestyle to set
     */
    public void setLifestyle(Lifestyle lifestyle) {
        this.lifestyle = lifestyle;
    }

    /**
     * @return the basicComplaints
     */
    public BasicComplaints getBasicComplaints() {
        return basicComplaints;
    }

    /**
     * @param basicComplaints the basicComplaints to set
     */
    public void setBasicComplaints(BasicComplaints basicComplaints) {
        this.basicComplaints = basicComplaints;
    }

    /**
     * @return the medicalComplaints
     */
    public ImportantMedicalComplaints getMedicalComplaints() {
        return medicalComplaints;
    }

    /**
     * @param medicalComplaints the medicalComplaints to set
     */
    public void setMedicalComplaints(ImportantMedicalComplaints medicalComplaints) {
        this.medicalComplaints = medicalComplaints;
    }

    /**
     * @return the contactDetails
     */
    public ContactDetailsContact getContactDetails() {
        return contactDetails;
    }

    /**
     * @param contactDetails the contactDetails to set
     */
    public void setContactDetails(ContactDetailsContact contactDetails) {
        this.contactDetails = contactDetails;
    }
    
    
    
    
    
    private int                        idPatientFull;
    private PatientShort               patientShortData;
    private Date                       dateOfBirth;
    private ContactDetailsAddress      permanentAddress;
    private ContactDetailsAddress      presentAddress;
    private PersonalDetails            personalDetails;
    private ProffesionDetails          proffesionDetails;
    private Lifestyle                  lifestyle;
    private BasicComplaints            basicComplaints;
    private ImportantMedicalComplaints medicalComplaints;
    private ContactDetailsContact      contactDetails;
}
