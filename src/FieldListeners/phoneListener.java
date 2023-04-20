package FieldListeners;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import view.PizzaOrderGUI;
import model.OrderTableModel;

public class phoneListener implements KeyListener {
    private PizzaOrderGUI view;
    private OrderTableModel model;
    private JLabel phoneM;
    private JFormattedTextField phoneF;
    public phoneListener(PizzaOrderGUI view, OrderTableModel model){
        this.view = view;
        this.model = model;
        phoneM = view.getPhoneMSG();
        phoneF = view.getPhoneNumField();
        phoneF.setFocusLostBehavior(JFormattedTextField.COMMIT);


    }

    String getActualText()
    {
        try {
            phoneF.commitEdit();
        }
        catch (Exception ex) {
            return null;
        }
        return phoneF.getValue().toString();
    }


    @Override
    public void keyTyped(KeyEvent e) {
        String phoneMask = "####-###-####";


        if (getActualText() != null) {
            if (getActualText().length() == phoneMask.length()){
                phoneM.setVisible(false);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
