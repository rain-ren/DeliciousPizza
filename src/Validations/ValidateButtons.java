package Validations;

import javax.swing.*;
import view.PizzaOrderGUI;
import model.OrderTableModel;

public class ValidateButtons {
    private PizzaOrderGUI view;
    private OrderTableModel model;
    private JToggleButton[] sizes, thickness;
    private JCheckBox[] toppings;
    private JLabel sizesMSG, thicknessMSG, toppingsMSG;
    public ValidateButtons(PizzaOrderGUI view, OrderTableModel model){
        this.view = view;
        this.model = model;
        this.sizes = view.getSizesRButton();
        this.thickness = view.getThicknessRButton();
        this.toppings = view.getToppingsBox();
        this.sizesMSG = view.getSizesMSG();
        this.thicknessMSG = view.getThicknessMSG();
        this.toppingsMSG = view.getToppingsMSG();
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
    public String getPizzaToppings(){
        String stringPizzaToppings = "";
        for(int counter = 0; counter < 3; counter++){
            if (getActiveCheck(toppings)[counter] != null){
                stringPizzaToppings += getActiveCheck(toppings)[counter] + " ";
            }
        }
        return stringPizzaToppings;
    }
    public boolean bValidation() {
        boolean validate = false;
        int emptyCounter = 0;
        String activeSize = getActive(sizes);
        String activeThickness = getActive(thickness);
        String activeToppings = getPizzaToppings();
        String[] actives = {activeSize, activeThickness, activeToppings};
        JLabel[] bMSG = {sizesMSG, thicknessMSG, toppingsMSG};

        for (int counter = 0; counter < actives.length; counter++) {
            if(actives[counter].equals("")){
                bMSG[counter].setVisible(true);
                emptyCounter++;
                if (emptyCounter >= 1){
                    validate = true;
                }
            }else {
                bMSG[counter].setVisible(false);
                validate = false;
            }
        }
        emptyCounter = 0;
        return validate;
    }
}
