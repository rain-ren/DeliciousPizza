package RadioButtonsListeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import view.PizzaOrderGUI;
import model.OrderTableModel;

public class ThicknessListener implements ItemListener {
    private PizzaOrderGUI view;
    private OrderTableModel model;
    public ThicknessListener(PizzaOrderGUI view, OrderTableModel model){
        this.view = view;
        this.model = model;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            view.getThicknessMSG().setVisible(false);
        }
    }
}
