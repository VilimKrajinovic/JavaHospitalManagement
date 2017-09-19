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
public class ImportantMedicalComplaints {

    /**
     * @return the idImportantMedicalComplaints
     */
    public int getIdImportantMedicalComplaints() {
        return idImportantMedicalComplaints;
    }

    /**
     * @param idImportantMedicalComplaints the idImportantMedicalComplaints to set
     */
    public void setIdImportantMedicalComplaints(int idImportantMedicalComplaints) {
        this.idImportantMedicalComplaints = idImportantMedicalComplaints;
    }

    /**
     * @return the isDiabetic
     */
    public boolean isIsDiabetic() {
        return isDiabetic;
    }

    /**
     * @param isDiabetic the isDiabetic to set
     */
    public void setIsDiabetic(boolean isDiabetic) {
        this.isDiabetic = isDiabetic;
    }

    /**
     * @return the isHypertenisve
     */
    public boolean isIsHypertenisve() {
        return isHypertenisve;
    }

    /**
     * @param isHypertenisve the isHypertenisve to set
     */
    public void setIsHypertenisve(boolean isHypertenisve) {
        this.isHypertenisve = isHypertenisve;
    }

    /**
     * @return the cardiacCondition
     */
    public String getCardiacCondition() {
        return cardiacCondition;
    }

    /**
     * @param cardiacCondition the cardiacCondition to set
     */
    public void setCardiacCondition(String cardiacCondition) {
        this.cardiacCondition = cardiacCondition;
    }

    /**
     * @return the digestiveCondition
     */
    public String getDigestiveCondition() {
        return digestiveCondition;
    }

    /**
     * @param digestiveCondition the digestiveCondition to set
     */
    public void setDigestiveCondition(String digestiveCondition) {
        this.digestiveCondition = digestiveCondition;
    }

    /**
     * @return the orthopedicCondition
     */
    public String getOrthopedicCondition() {
        return orthopedicCondition;
    }

    /**
     * @param orthopedicCondition the orthopedicCondition to set
     */
    public void setOrthopedicCondition(String orthopedicCondition) {
        this.orthopedicCondition = orthopedicCondition;
    }

    /**
     * @return the muscularCondition
     */
    public String getMuscularCondition() {
        return muscularCondition;
    }

    /**
     * @param muscularCondition the muscularCondition to set
     */
    public void setMuscularCondition(String muscularCondition) {
        this.muscularCondition = muscularCondition;
    }

    /**
     * @return the neurologicalCondition
     */
    public String getNeurologicalCondition() {
        return neurologicalCondition;
    }

    /**
     * @param neurologicalCondition the neurologicalCondition to set
     */
    public void setNeurologicalCondition(String neurologicalCondition) {
        this.neurologicalCondition = neurologicalCondition;
    }

    /**
     * @return the knownAllegries
     */
    public String getKnownAllegries() {
        return knownAllegries;
    }

    /**
     * @param knownAllegries the knownAllegries to set
     */
    public void setKnownAllegries(String knownAllegries) {
        this.knownAllegries = knownAllegries;
    }

    /**
     * @return the knownReactionToDrugs
     */
    public String getKnownReactionToDrugs() {
        return knownReactionToDrugs;
    }

    /**
     * @param knownReactionToDrugs the knownReactionToDrugs to set
     */
    public void setKnownReactionToDrugs(String knownReactionToDrugs) {
        this.knownReactionToDrugs = knownReactionToDrugs;
    }

    /**
     * @return the majorSurgeries
     */
    public String getMajorSurgeries() {
        return majorSurgeries;
    }

    /**
     * @param majorSurgeries the majorSurgeries to set
     */
    public void setMajorSurgeries(String majorSurgeries) {
        this.majorSurgeries = majorSurgeries;
    }
    
    private int idImportantMedicalComplaints;
    private boolean isDiabetic;
    private boolean isHypertenisve;
    private String  cardiacCondition;
    private String  digestiveCondition;
    private String  orthopedicCondition;
    private String  muscularCondition;
    private String  neurologicalCondition;
    private String  knownAllegries;
    private String  knownReactionToDrugs;
    private String  majorSurgeries;
}
