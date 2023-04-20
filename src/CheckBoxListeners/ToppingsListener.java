package CheckBoxListeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import view.PizzaOrderGUI;
import model.OrderTableModel;

public class ToppingsListener implements ItemListener {
    private PizzaOrderGUI view;
    private OrderTableModel model;
    public ToppingsListener(PizzaOrderGUI view, OrderTableModel model){
        this.view = view;
        this.model = model;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            view.getToppingsMSG().setVisible(false);
        }
    }
}
