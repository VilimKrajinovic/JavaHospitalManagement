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
public class PersonalDetails {

    /**
     * @return the idPersonalDetails
     */
    public int getIdPersonalDetails() {
        return idPersonalDetails;
    }

    /**
     * @param idPersonalDetails the idPersonalDetails to set
     */
    public void setIdPersonalDetails(int idPersonalDetails) {
        this.idPersonalDetails = idPersonalDetails;
    }

    /**
     * @return the maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the numberOfDependents
     */
    public String getNumberOfDependents() {
        return numberOfDependents;
    }

    /**
     * @param numberOfDependents the numberOfDependents to set
     */
    public void setNumberOfDependents(String numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    /**
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return the bloodType
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * @param bloodType the bloodType to set
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
 
    
    
    
    private int    idPersonalDetails;
    private String maritalStatus;
    private String numberOfDependents;
    private String height;
    private String weight;
    private String bloodType;
}
