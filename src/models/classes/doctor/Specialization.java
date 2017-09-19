/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes.doctor;

/**
 *
 * @author amd
 */
public class Specialization {

    /**
     * @return the idSpecialization
     */
    public int getIdSpecialization() {
        return idSpecialization;
    }

    /**
     * @param idSpecialization the idSpecialization to set
     */
    public void setIdSpecialization(int idSpecialization) {
        this.idSpecialization = idSpecialization;
    }

    /**
     * @return the specializationName
     */
    public String getSpecializationName() {
        return specializationName;
    }

    /**
     * @param specializationName the specializationName to set
     */
    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }
    
    private int idSpecialization;
    private String specializationName;
}
