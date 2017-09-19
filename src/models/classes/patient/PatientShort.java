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
public class PatientShort {

    /**
     * @return the idPatient
     */
    public int getIdPatient() {
        return idPatient;
    }

    /**
     * @param idPatient the idPatient to set
     */
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
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
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
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
     * @return the contact_1
     */
    public String getContact_1() {
        return contact_1;
    }

    /**
     * @param contact_1 the contact_1 to set
     */
    public void setContact_1(String contact_1) {
        this.contact_1 = contact_1;
    }

    /**
     * @return the contact_2
     */
    public String getContact_2() {
        return contact_2;
    }

    /**
     * @param contact_2 the contact_2 to set
     */
    public void setContact_2(String contact_2) {
        this.contact_2 = contact_2;
    }

    /**
     * @return the nextOfKin
     */
    public NextOfKin getNextOfKin() {
        return nextOfKin;
    }

    /**
     * @param nextOfKin the nextOfKin to set
     */
    public void setNextOfKin(NextOfKin nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    /**
     * @return the isFollowUp
     */
    public boolean isIsFollowUp() {
        return isFollowUp;
    }

    /**
     * @param isFollowUp the isFollowUp to set
     */
    public void setIsFollowUp(boolean isFollowUp) {
        this.isFollowUp = isFollowUp;
    }
    
    
    
    
    private int       idPatient;
    private String    name;
    private String    surname;
    private String    middlename;
    private String    sex;
    private String    statementOfComplaint;
    private String    contact_1;
    private String    contact_2;
    private NextOfKin nextOfKin;
    private boolean   isFollowUp;
    
}
