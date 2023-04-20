package ButtonListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.PizzaOrderGUI;
import model.OrderTableModel;
import fieldActions.ClearForm;
import Validations.*;

public class SaveBTListener extends Component implements ActionListener {

    private PizzaOrderGUI view;
    private ClearForm clear;
    private JTextField nameField, phoneField, addressField;
    private  JToggleButton[] pizzaSizeF, pizzaThicknessF, pizzaToppingsF;
    private OrderTableModel model;
    private ButtonGroup pizzaS, pizzaT;
    private JCheckBox[] pizzaTop;
    private int orderCounter = 0;
    private ValidateForm validateForm;
    private ValidateButtons validateButtons;
    public SaveBTListener(PizzaOrderGUI view, OrderTableModel model, ClearForm clear){
        this.view = view;
        this.model = model;
        this.nameField = view.getNameField();
        this.phoneField= view.getPhoneNumField();
        this.addressField = view.getAddressField();
        this.pizzaSizeF = view.getSizesRButton();
        this.pizzaThicknessF = view.getThicknessRButton();
        this.pizzaToppingsF = view.getToppingsBox();
        this.pizzaS = view.getSizes();
        this.pizzaT = view.getThickness();
        this.pizzaTop = view.getToppingsBox();
        this.clear = clear;
        validateForm = new ValidateForm(view,model);
        validateButtons = new ValidateButtons(view,model);
    }
    String getActive(JToggleButton[] buttons) {
        String active = "";
        for(var i : buttons) {
            if (i.isSelected()) {
                active += i.getActionCommand();
                break;
            }
        }
        return active;
    }
    String[] getActiveCheck(JToggleButton[] checkBox) {
        String[] active = new String[checkBox.length];
        for(int counter = 0; counter < checkBox.length; counter++) {
            if (checkBox[counter].isSelected()) {
                active[counter] = checkBox[counter].getText();
            }
        }
        return active;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean fValidation = validateForm.fValidation();
        boolean bValidation = validateButtons.bValidation();
        System.out.println(fValidation);
        System.out.println(bValidation);
        if(fValidation == false && bValidation == false){
            model.addCustomer(nameField.getText(),phoneField.getText(),addressField.getText(),
                    getActive(pizzaSizeF) ,
                    getActive(pizzaThicknessF) ,getActiveCheck(pizzaToppingsF));
            orderCounter ++;
            clear.clear();
            view.getDeleteBT().setVisible(false);
            JOptionPane.showMessageDialog(this, "Order Entry Saved\nOrder Number: " + String.format("%04d",orderCounter), "SAVE SUCCESS" ,JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
