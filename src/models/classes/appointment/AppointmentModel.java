/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes.appointment;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amd
 */
public class AppointmentModel extends AbstractTableModel {

    List<Appointment> appointments;

    @Override
    public int getRowCount() {
        return appointments.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return appointments.get(rowIndex).getIdAppointment();
            case 1:
                return appointments.get(rowIndex).getDoctor().getIdDoctor();
            case 2:
                return appointments.get(rowIndex).getDoctor().getName() + " "
                        + appointments.get(rowIndex).getDoctor().getSurname();
            case 3:
                return appointments.get(rowIndex).getDoctor().getSpecialization().getSpecializationName();
            case 4:
                return appointments.get(rowIndex).getPatientFull().getIdPatientFull();
            case 5:
                return appointments.get(rowIndex).getPatientFull().getPatientShortData().getName() + " "
                        + appointments.get(rowIndex).getPatientFull().getPatientShortData().getSurname();
            case 6:
                return appointments.get(rowIndex).getApointmentDate();
            case 7:
                return appointments.get(rowIndex).getAppointmentStart();
            case 8:
                return appointments.get(rowIndex).getAppointmentEnd();
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Doctor ID";
            case 2:
                return "Doctor name";
            case 3:
                return "Specialization";
            case 4:
                return "Patient ID";
            case 5:
                return "Patient name";
            case 6:
                return "Date";
            case 7:
                return "Start time";
            case 8:
                return "End time";
        }

        return null;
    }

    public AppointmentModel(List<Appointment> apps) {
        this.appointments = apps;
    }

}
