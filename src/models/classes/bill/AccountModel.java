/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes.bill;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AccountModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return items.get(rowIndex).getName();
            case 1:
                return items.get(rowIndex).getPrice();
            case 2:
                return items.get(rowIndex).getQuantity();
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Item name";
            case 1:
                return "Item price";
            case 2:
                return "Quantity";
        }

        return null;
    }

    List<AccountItem> items;

    public AccountModel(List<AccountItem> items) {
        this.items = items;
    }

}
