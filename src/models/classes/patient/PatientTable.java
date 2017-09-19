/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes.patient;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amd
 */
public class PatientTable extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return patients.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return patients.get(rowIndex).getIdPatientFull();
            case 1:
                return patients.get(rowIndex).getPatientShortData().getName();
            case 2:
                return patients.get(rowIndex).getPatientShortData().getSurname();
            case 3:
                return patients.get(rowIndex).getPermanentAddress().getCity();
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Name";
            case 2:
                return "Surname";
            case 3:
                return "City";
        }

        return null;
    }

    public PatientTable(List<PatientFull> patients) {
        this.patients = patients;
    }

    List<PatientFull> patients;

}
