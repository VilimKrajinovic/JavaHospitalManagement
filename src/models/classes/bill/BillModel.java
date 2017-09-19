/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes.bill;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amd
 */
public class BillModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return bills.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return bills.get(rowIndex).getIdBill();
            case 1:
                return bills.get(rowIndex).getPatientFull().getPatientShortData().getName();
            case 2:
                return bills.get(rowIndex).getPatientFull().getPatientShortData().getSurname();
            case 3:
                return bills.get(rowIndex).getPatientFull().getIdPatientFull();
            case 4:
                return bills.get(rowIndex).getBillDate();
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Patient name";
            case 2:
                return "Patient surname";
            case 3:
                return "Patient ID";
            case 4:
                return "Date";
        }

        return null;
    }

    List<Bill> bills;

    public BillModel(List<Bill> bills) {
        this.bills = bills;
    }
}
