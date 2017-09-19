/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes.bill;

import java.sql.Time;
import java.sql.Date;
import models.classes.patient.PatientFull;

/**
 *
 * @author amd
 */
public class Bill {

    /**
     * @return the idBill
     */
    public int getIdBill() {
        return idBill;
    }

    /**
     * @param idBill the idBill to set
     */
    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    /**
     * @return the patientFull
     */
    public PatientFull getPatientFull() {
        return patientFull;
    }

    /**
     * @param patientFull the patientFull to set
     */
    public void setPatientFull(PatientFull patientFull) {
        this.patientFull = patientFull;
    }

    /**
     * @return the billDate
     */
    public Date getBillDate() {
        return billDate;
    }

    /**
     * @param billDate the billDate to set
     */
    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    /**
     * @return the billTime
     */
    public Time getBillTime() {
        return billTime;
    }

    /**
     * @param billTime the billTime to set
     */
    public void setBillTime(Time billTime) {
        this.billTime = billTime;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod the paymentMethod to set
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    private int idBill;
    private PatientFull patientFull;
    private Date billDate;
    private Time billTime;
    private double total;
    private String paymentMethod;
}
