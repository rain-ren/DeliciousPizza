package fieldActions;

import view.PizzaOrderGUI;

import javax.swing.*;

public class ClearForm {
    private PizzaOrderGUI view;
    private JTextField nameF, phoneF, addressF;
    private ButtonGroup sizeP, thicknessP;
    private JCheckBox[] toppingsBox;

    public ClearForm(PizzaOrderGUI view){
        this.nameF = view.getNameField();
        this.phoneF = view.getPhoneNumField();
        this.addressF = view.getAddressField();
        this.sizeP = view.getSizes();
        this.thicknessP = view.getThickness();
        this.toppingsBox = view.getToppingsBox();
    }
    public void clear(){
        nameF.setText("");
        phoneF.setText("");
        addressF.setText("");
        sizeP.clearSelection();
        thicknessP.clearSelection();
        for(int i = 0; i < toppingsBox.length; i++){
            toppingsBox[i].setSelected(false);
        }
    }
}
