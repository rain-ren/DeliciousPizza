package TableListener;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.PizzaOrderGUI;
import model.OrderTableModel;

public class TableListener implements MouseListener {
    private PizzaOrderGUI view;
    private OrderTableModel model;
    private JTable table;
    private JTextField nameF, phoneF, addressF;
    private JToggleButton [] pizzaS, pizzaT;
    JButton saveB, updateB;
    private ButtonGroup sizes;
    private JCheckBox [] pizzaTop;

    public TableListener(PizzaOrderGUI view, OrderTableModel model){
        this.view = view;
        this.model = model;
        this.table = view.getTable();
        this.nameF = view.getNameField();
        this.phoneF = view.getPhoneNumField();
        this.addressF = view.getAddressField();
        this.pizzaS = view.getSizesRButton();
        this.pizzaT = view.getThicknessRButton();
        this.pizzaTop = view.getToppingsBox();
        this.sizes = view.getSizes();
        this.saveB = view.getSaveBT();
        this.updateB = view.getUpdateBT();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2){
            int selectedRow = table.getSelectedRow();

            String nameToSet = model.getName(selectedRow);
            nameF.setText(nameToSet);

            String phoneToSet = model.getPhone(selectedRow);
            phoneF.setText(phoneToSet);

            String addressToSet = model.getAddress(selectedRow);
            addressF.setText(addressToSet);

            for(int counter = 0; counter < pizzaS.length; counter++){
                String selectedSize = model.getPizzaSize(selectedRow);
                if(pizzaS[counter].getText().equals(selectedSize)){
                    pizzaS[counter].setSelected(true);
                    break;
                }
            }
            for(int counter = 0; counter < pizzaS.length; counter++){
                String selectedThickness = model.getPizzaThickness(selectedRow);
                if(pizzaT[counter].getText().equals(selectedThickness)){
                    pizzaT[counter].setSelected(true);
                    break;
                }
            }
            for(int counter = 0; counter < pizzaTop.length; counter++){
                String[] selectedThickness = model.getPizzaToppings(selectedRow);
                if(pizzaTop[counter].getText().equals(selectedThickness[counter])){
                    pizzaTop[counter].setSelected(true);
                }
            }
            saveB.setVisible(false);
            updateB.setVisible(true);
        }else {
            view.getDeleteBT().setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
