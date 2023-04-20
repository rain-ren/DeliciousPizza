package FieldListeners;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.PizzaOrderGUI;
import model.OrderTableModel;

public class addressListener implements KeyListener {
    private PizzaOrderGUI view;
    private OrderTableModel model;
    private JLabel addressM;
    public addressListener(PizzaOrderGUI view, OrderTableModel model){
        this.view = view;
        this.model = model;
        addressM = view.getAddressMSG();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        addressM.setVisible(false);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
