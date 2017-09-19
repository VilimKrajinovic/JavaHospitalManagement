/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes.appointment;

import java.sql.Time;
import java.sql.Date;
import java.text.SimpleDateFormat;
import models.classes.doctor.Doctor;
import models.classes.patient.PatientFull;

/**
 *
 * @author amd
 */
public class Appointment {

    /**
     * @return the idAppointment
     */
    public int getIdAppointment() {
        return idAppointment;
    }

    /**
     * @param idAppointment the idAppointment to set
     */
    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    /**
     * @return the apointmentDate
     */
    public Date getApointmentDate() {
        return apointmentDate;
    }

    /**
     * @param apointmentDate the apointmentDate to set
     */
    public void setApointmentDate(Date apointmentDate) {
        this.apointmentDate = apointmentDate;
    }

    /**
     * @return the appointmentStart
     */
    public Time getAppointmentStart() {
        return appointmentStart;
    }

    /**
     * @param appointmentStart the appointmentStart to set
     */
    public void setAppointmentStart(Time appointmentStart) {
        this.appointmentStart = appointmentStart;
    }

    /**
     * @return the appointmentEnd
     */
    public Time getAppointmentEnd() {
        return appointmentEnd;
    }

    /**
     * @param appointmentEnd the appointmentEnd to set
     */
    public void setAppointmentEnd(Time appointmentEnd) {
        this.appointmentEnd = appointmentEnd;
    }

    /**
     * @return the doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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
     * @return the appointmentSummary
     */
    public String getAppointmentSummary() {
        return appointmentSummary;
    }

    /**
     * @param appointmentSummary the appointmentSummary to set
     */
    public void setAppointmentSummary(String appointmentSummary) {
        this.appointmentSummary = appointmentSummary;
    }

    /**
     * @return the orderedTests
     */
    public String getOrderedTests() {
        return orderedTests;
    }

    /**
     * @param orderedTests the orderedTests to set
     */
    public void setOrderedTests(String orderedTests) {
        this.orderedTests = orderedTests;
    }

    /**
     * @return the medicine
     */
    public String getMedicine() {
        return medicine;
    }

    /**
     * @param medicine the medicine to set
     */
    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    /**
     * @return the treatment
     */
    public String getTreatment() {
        return treatment;
    }

    /**
     * @param treatment the treatment to set
     */
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    private int idAppointment;
    private Date apointmentDate;
    private Time appointmentStart;
    private Time appointmentEnd;
    private Doctor doctor;
    private PatientFull patientFull;
    private String appointmentSummary;
    private String orderedTests;
    private String medicine;
    private String treatment;
    
    
      @Override
    public String toString() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");

        return String.format("ID: %-4d Date: %-20s Doctor: %-20s Patient: %-20s Start time: %-20s End time: %s%n",
                idAppointment,
                sdfDate.format(apointmentDate),
                getDoctor().getName() + " " + getDoctor().getSurname(),
                getPatientFull().getPatientShortData().getName() + " " + getPatientFull().getPatientShortData().getSurname(),
                sdfTime.format(appointmentStart),
                sdfTime.format(appointmentEnd));
    }
    
    
}
