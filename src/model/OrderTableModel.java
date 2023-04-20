package model;

import data.Customer;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class OrderTableModel extends AbstractTableModel {

    private String[] headers = {
            "Name", "Phone", "Address", "Size", "Thickness", "Toppings"
    };
    private int [] selectedRows;

    private ArrayList<Customer> customers = new ArrayList<>();
    private Customer c;

    public void addCustomer(String name,String phone,String address,String pizzaSize,String pizzaThickness,String[] pizzaToppings) {
        c = new Customer(name, phone, address, pizzaSize, pizzaThickness, pizzaToppings);
        customers.add(c);
        fireTableDataChanged();
    }
    public void removeCustomer(JTable table){
        selectedRows = table.getSelectedRows();
        for(int counter = selectedRows.length -1; counter >= 0; counter--){
            customers.remove(counter);
            fireTableRowsDeleted(counter,counter);
            table.repaint();
        }
    }
    public void updateCustomer(int selectedRow, String name,String phone,String address,String pizzaSize,String pizzaThickness,String[] pizzaToppings) {
        customers.set(selectedRow, new Customer(name, phone,address, pizzaSize,pizzaThickness, pizzaToppings));
        fireTableDataChanged();
    }
    public String getName(int selectedRow){
        String name = customers.get(selectedRow).getName();
        return name;
    }
    public String getPhone(int selectedRow){
        String phone = customers.get(selectedRow).getPhone();
        return phone;
    }
    public String getAddress(int selectedRow){
        String address = customers.get(selectedRow).getAddress();
        return address;
    }public String getPizzaSize(int selectedRow){
        String pizzaSize = customers.get(selectedRow).getPizzaSize();
        return pizzaSize;
    }
    public String getPizzaThickness(int selectedRow){
        String pizzaThickness = customers.get(selectedRow).getPizzaThickness();
        return pizzaThickness;
    }

    public String[] getPizzaToppings(int selectedRow){
        String[] pizzaToppings = customers.get(selectedRow).getPizzaToppings1();
        return pizzaToppings;
    }

    @Override
    public int getRowCount() {
        return customers.size();
    }


    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return customers.get(rowIndex).getName();
            case 1:
                return customers.get(rowIndex).getPhone();
            case 2:
                return customers.get(rowIndex).getAddress();
            case 3:
                return customers.get(rowIndex).getPizzaSize();
            case 4:
                return customers.get(rowIndex).getPizzaThickness();
            case 5:
                return customers.get(rowIndex).getPizzaToppings();
        }
        return customers.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
}
