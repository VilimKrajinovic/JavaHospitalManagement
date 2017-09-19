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
public class BasicComplaints {

    /**
     * @return the idBasicComplaints
     */
    public int getIdBasicComplaints() {
        return idBasicComplaints;
    }

    /**
     * @param idBasicComplaints the idBasicComplaints to set
     */
    public void setIdBasicComplaints(int idBasicComplaints) {
        this.idBasicComplaints = idBasicComplaints;
    }

    /**
     * @return the statementOfComplaint
     */
    public String getStatementOfComplaint() {
        return statementOfComplaint;
    }

    /**
     * @param statementOfComplaint the statementOfComplaint to set
     */
    public void setStatementOfComplaint(String statementOfComplaint) {
        this.statementOfComplaint = statementOfComplaint;
    }

    /**
     * @return the historyOfPreviousTreatment
     */
    public String getHistoryOfPreviousTreatment() {
        return historyOfPreviousTreatment;
    }

    /**
     * @param historyOfPreviousTreatment the historyOfPreviousTreatment to set
     */
    public void setHistoryOfPreviousTreatment(String historyOfPreviousTreatment) {
        this.historyOfPreviousTreatment = historyOfPreviousTreatment;
    }

    /**
     * @return the physicianOrHospital
     */
    public String getPhysicianOrHospital() {
        return physicianOrHospital;
    }

    /**
     * @param physicianOrHospital the physicianOrHospital to set
     */
    public void setPhysicianOrHospital(String physicianOrHospital) {
        this.physicianOrHospital = physicianOrHospital;
    }
    
    private int    idBasicComplaints;
    private String statementOfComplaint;
    private String historyOfPreviousTreatment;
    private String physicianOrHospital;
}
