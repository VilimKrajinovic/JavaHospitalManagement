/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes.doctor;

import models.classes.patient.ContactDetailsAddress;
import models.classes.patient.ContactDetailsContact;

/**
 *
 * @author amd
 */
public class Doctor {

    /**
     * @return the idDoctor
     */
    public int getIdDoctor() {
        return idDoctor;
    }

    /**
     * @param idDoctor the idDoctor to set
     */
    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the isWorking
     */
    public boolean isIsWorking() {
        return isWorking;
    }

    /**
     * @param isWorking the isWorking to set
     */
    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
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

    /**
     * @return the addressDetails
     */
    public ContactDetailsAddress getAddressDetails() {
        return addressDetails;
    }

    /**
     * @param addressDetails the addressDetails to set
     */
    public void setAddressDetails(ContactDetailsAddress addressDetails) {
        this.addressDetails = addressDetails;
    }

    /**
     * @return the specialization
     */
    public Specialization getSpecialization() {
        return specialization;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
 
    
    private int idDoctor;
    private String name;
    private String surname;
    private boolean isWorking;
    private ContactDetailsContact contactDetails;
    private ContactDetailsAddress addressDetails;
    private Specialization specialization;
}
