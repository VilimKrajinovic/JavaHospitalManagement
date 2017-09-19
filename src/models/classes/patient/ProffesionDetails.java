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
public class ProffesionDetails {

    /**
     * @return the idProffessionDetails
     */
    public int getIdProffessionDetails() {
        return idProffessionDetails;
    }

    /**
     * @param idProffessionDetails the idProffessionDetails to set
     */
    public void setIdProffessionDetails(int idProffessionDetails) {
        this.idProffessionDetails = idProffessionDetails;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the grossAnnualIncome
     */
    public int getGrossAnnualIncome() {
        return grossAnnualIncome;
    }

    /**
     * @param grossAnnualIncome the grossAnnualIncome to set
     */
    public void setGrossAnnualIncome(int grossAnnualIncome) {
        this.grossAnnualIncome = grossAnnualIncome;
    }
 
    
    private int    idProffessionDetails;
    private String occupation;
    private int    grossAnnualIncome;
}
