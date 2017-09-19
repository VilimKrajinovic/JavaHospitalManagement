/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes.patient;

/**
 *
 * @author amd
 */
public class NextOfKin {

    /**
     * @return the idNextOfKin
     */
    public int getIdNextOfKin() {
        return idNextOfKin;
    }

    /**
     * @param idNextOfKin the idNextOfKin to set
     */
    public void setIdNextOfKin(int idNextOfKin) {
        this.idNextOfKin = idNextOfKin;
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
     * @return the middlename
     */
    public String getMiddlename() {
        return middlename;
    }

    /**
     * @param middlename the middlename to set
     */
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    /**
     * @return the relationship
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * @param relationship the relationship to set
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
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
    
    
    
    
    private int                   idNextOfKin;
    private String                name;
    private String                surname;
    private String                middlename;
    private String                relationship;
    private ContactDetailsContact contactDetails;
    private ContactDetailsAddress addressDetails;
    
}
