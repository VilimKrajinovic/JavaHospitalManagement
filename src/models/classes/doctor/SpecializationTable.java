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
public class SpecializationTable extends AbstractTableModel {

    List<Specialization> specializations;

    @Override
    public int getRowCount() {
        return specializations.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return specializations.get(rowIndex).getIdSpecialization();
            case 1:
                return specializations.get(rowIndex).getSpecializationName();
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Specialization";
        }

        return null;
    }

    public SpecializationTable(List<Specialization> specializations) {
        this.specializations = specializations;
    }

}
