package Validations;

import model.OrderTableModel;
import view.PizzaOrderGUI;

import javax.swing.*;

public class ValidateForm {
    private PizzaOrderGUI view;
    private OrderTableModel model;
    private JTextField[] fields;
    private JLabel[] labels;
    private JTextField nameF, phoneF, addressF;
    private  JLabel nameMSG, phoneMSG, addressMSG;
    public ValidateForm(PizzaOrderGUI view, OrderTableModel model){
        this.view = view;
        this.model = model;
        this.nameF = view.getNameField();
        this.phoneF= view.getPhoneNumField();
        this.addressF = view.getAddressField();
        this.nameMSG = view.getNameMSG();
        this.phoneMSG = view.getPhoneMSG();
        this.addressMSG = view.getAddressMSG();
    }



    public boolean fValidation() {
        boolean validate = false;
        int emptyCounter = 0;

        fields = new JTextField[]{nameF, phoneF, addressF};
        labels = new JLabel[]{nameMSG, phoneMSG, addressMSG};
        for (int counter = 0; counter < fields.length; counter++) {
            if (fields[counter].getText().isEmpty() && counter != 1) {
                labels[counter].setVisible(true);
                emptyCounter++;
                if (emptyCounter >= 1){
                    validate = true;
                }
            } else if(fields[counter].getText().equals("    -   -    ") && counter == 1){
                labels[counter].setVisible(true);
                emptyCounter++;
                if (emptyCounter >= 1){
                    validate = true;
                }
            }else {
                labels[counter].setVisible(false);
                validate = false;
            }
        }
        emptyCounter = 0;
        return validate;
    }
}
