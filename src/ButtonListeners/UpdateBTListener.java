package ButtonListeners;

import fieldActions.ClearForm;
import model.OrderTableModel;
import view.PizzaOrderGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Validations.*;

public class UpdateBTListener extends Component implements ActionListener {
    private PizzaOrderGUI view;
    private OrderTableModel model;
    private ClearForm clearForm;
    private JTable tableP;
    private JTextField nameF, phoneF, addressF;
    private JButton save, update;
    private ButtonGroup sizeP, thicknessP;
    private JCheckBox[] toppingsBox;
    private int selectedRow;
    private ValidateButtons validateButtons;
    private ValidateForm validateForm;
    public UpdateBTListener(PizzaOrderGUI Gui, OrderTableModel model){
        this.view = Gui;
        this.model= model;
        this.tableP = view.getTable();
        this.nameF = view.getNameField();
        this.phoneF = view.getPhoneNumField();
        this.addressF = view.getAddressField();
        this.save = view.getSaveBT();
        this.update = view.getUpdateBT();
        this.sizeP = view.getSizes();
        this.thicknessP = view.getThickness();
        this.toppingsBox = view.getToppingsBox();
        clearForm = new ClearForm(view);
        validateForm = new ValidateForm(view,model);
        validateButtons = new ValidateButtons(view,model);

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
        selectedRow = tableP.getSelectedRow();
        boolean fValidation = validateForm.fValidation();
        boolean bValidation = validateButtons.bValidation();
        System.out.println(fValidation);
        System.out.println(bValidation);

        if(fValidation==false  && bValidation == false){
            model.updateCustomer(selectedRow, nameF.getText(), phoneF.getText(),addressF.getText(), sizeP.getSelection().getActionCommand(),thicknessP.getSelection().getActionCommand(), getActiveCheck(toppingsBox));
            clearForm.clear();
            save.setVisible(true);
            update.setVisible(false);
            view.getDeleteBT().setVisible(false);
            JOptionPane.showMessageDialog(this, "Entry Update Success", "UPDATE SUCCESS" ,JOptionPane.INFORMATION_MESSAGE);

        }
        /*
        *  if (selectedRow < 0){
                clearForm.clear();
                save.setVisible(true);
                update.setVisible(false);
                view.getDeleteBT().setVisible(false);
                JOptionPane.showMessageDialog(this, "No entry to update", "INVALID ACTION" ,JOptionPane.ERROR_MESSAGE);*/
    }
}
