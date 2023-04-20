package ButtonListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.PizzaOrderGUI;
import model.OrderTableModel;
import fieldActions.ClearForm;

public class DeleteBTListener extends Component implements ActionListener {

    private OrderTableModel model;
    private PizzaOrderGUI view;
    private ClearForm clearForm;
    private JTable table;
    private JTextField nameField, phoneField, addressField;
    private ButtonGroup pizzaS, pizzaT;
    private JCheckBox[] pizzaTop;

    public DeleteBTListener(PizzaOrderGUI view, OrderTableModel model){
        this.view = view;
        this.model = model;
        this.table = view.getTable();
        this.nameField = view.getNameField();
        this.phoneField = view.getPhoneNumField();
        this.addressField = view.getAddressField();
        this.pizzaS = view.getSizes();
        this.pizzaT = view.getThickness();
        this.pizzaTop = view.getToppingsBox();
        clearForm = new ClearForm(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRows[] = table.getSelectedRows();
        int numberOfSelectedRows = selectedRows.length;

        if(numberOfSelectedRows > 0){
            int deleteEntryChoice = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete "+ numberOfSelectedRows + " entry/entries?" , "Confirm Delete Action" ,JOptionPane.OK_CANCEL_OPTION);
            if(deleteEntryChoice == 0){
                model.removeCustomer(table);
                clearForm.clear();
                view.getDeleteBT().setVisible(false);
                JOptionPane.showMessageDialog(this, numberOfSelectedRows + " Entry/Entries Deleted" , "DELETE SUCCESS" ,JOptionPane.INFORMATION_MESSAGE);
            }else if (deleteEntryChoice == 2){
                view.getDeleteBT().setVisible(false);
                JOptionPane.showMessageDialog(this,  "Delete Action Cancelled" , "CANCELLED" ,JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
