package FieldListeners;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.PizzaOrderGUI;
import model.OrderTableModel;

public class nameListener implements KeyListener {
    private PizzaOrderGUI view;
    private OrderTableModel model;
    private JLabel nameM;
    public nameListener(PizzaOrderGUI view, OrderTableModel model){
        this.view = view;
        this.model = model;
        nameM = view.getNameMSG();

    }

    @Override
    public void keyTyped(KeyEvent e) {

        nameM.setVisible(false);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
