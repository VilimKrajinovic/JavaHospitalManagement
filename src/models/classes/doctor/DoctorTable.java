/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes.doctor;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amd
 */
public class DoctorTable extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return doctors.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return doctors.get(rowIndex).getIdDoctor();
            case 1:
                return doctors.get(rowIndex).getName();
            case 2:
                return doctors.get(rowIndex).getSurname();
            case 3:
                return doctors.get(rowIndex).getSpecialization().getSpecializationName();
            case 4:
                return (doctors.get(rowIndex).getAddressDetails().getStreet());
            case 5:
                return doctors.get(rowIndex).getAddressDetails().getCity();
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
                return "Specialization";
            case 4:
                return "Street";
            case 5:
                return "City";
        }

        return null;
    }
    

    List<Doctor> doctors;

    public DoctorTable(List<Doctor> doctors) {
        this.doctors = doctors;
    }

}
