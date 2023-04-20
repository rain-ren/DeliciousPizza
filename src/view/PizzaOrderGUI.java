package view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;


public class PizzaOrderGUI {
    private JTextField nameField, addressField;
    private JFormattedTextField phoneNumField;
    private JTable table;
    private JButton saveBT, deleteBT, updateBT;
    private JRadioButton[] sizesRButton, thicknessRButton;
    private JCheckBox[] toppingsBox;
    private JLabel nameMSG, phoneMSG, addressMSG, sizesMSG, thicknessMSG, toppingsMSG;

    private ButtonGroup sizes, thickness;
    public MaskFormatter fieldFormat(){
        String phoneMask = "####-###-####";
        try{
            MaskFormatter maskFormatter = new MaskFormatter(phoneMask);
            maskFormatter.setOverwriteMode(true);
            return maskFormatter;
        } catch (Exception e){
            return null;
        }
    }
    public PizzaOrderGUI(){
        JFrame frame = new JFrame("Pizza Order Form");
        Image pizzaIcon = Toolkit.getDefaultToolkit().getImage("D:\\pizzaIcon.png");
        frame.setIconImage(pizzaIcon);
        Container container = frame.getContentPane();
        GridLayout grid = new GridLayout(1,2);
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints cons =new GridBagConstraints();

        container.setLayout(grid);
        JPanel left = new JPanel(new FlowLayout());
        JPanel right = new JPanel(new BorderLayout());
        JPanel fieldPanel = new JPanel(new GridLayout(3,1));
        JPanel namePanel = new JPanel(new GridBagLayout());
        JPanel phonePanel = new JPanel(new GridBagLayout());
        JPanel addressPanel = new JPanel(new GridBagLayout());
        JPanel choicesPanel= new JPanel(new GridLayout(1,3));
        JPanel sizePanel = new JPanel(gridBagLayout);
        JPanel thicknessPanel = new JPanel(gridBagLayout);
        JPanel toppingsPanel = new JPanel(gridBagLayout);
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));


        JLabel nameLabel = new JLabel("Name: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 0;
        namePanel.add(nameLabel,cons);

        nameField = new JTextField(30);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 0;
        namePanel.add(nameField,cons);

        nameMSG = new JLabel("Name is required");
        nameMSG.setForeground(Color.red);
        nameMSG.setVisible(false);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 1;
        namePanel.add(nameMSG,cons);


        JLabel phoneLabel = new JLabel("Phone: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 0;
        phonePanel.add(phoneLabel,cons);

        phoneNumField = new JFormattedTextField(fieldFormat());
        phoneNumField.setColumns(30);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 0;
        phonePanel.add(phoneNumField,cons);

        phoneMSG = new JLabel("Phone is required");
        phoneMSG.setForeground(Color.red);
        phoneMSG.setVisible(false);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 1;
        phonePanel.add(phoneMSG,cons);

        JLabel addressLabel = new JLabel("Address: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 0;
        addressPanel.add(addressLabel,cons);

        addressField = new JTextField(30);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 0;
        addressPanel.add(addressField,cons);

        addressMSG = new JLabel("Address is required");
        addressMSG.setForeground(Color.red);
        addressMSG.setVisible(false);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 1;
        addressPanel.add(addressMSG,cons);

        fieldPanel.add(namePanel);
        fieldPanel.add(phonePanel);
        fieldPanel.add(addressPanel);


        sizes = new ButtonGroup();//creates a button group to limit user selection to one
        String[] sizesC ={"Small","Medium","Large"};//sizesC is size choices
        sizesRButton = new JRadioButton[sizesC.length];
        for(int i = 0; i < sizesC.length; i++){ //Creating multiple JRadioButtons using for-loop
            sizesRButton[i] = new JRadioButton(sizesC[i]);
            String command = "";
            if (i == 0){//assigning different string commands for different radio buttons
                command += "Small";
            }else if (i == 1){
                command += "Medium";
            }else if (i == 2){
                command += "Large";
            }
            sizesRButton[i].setActionCommand(command);
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridx = 0;
            cons.gridy = i;
            sizePanel.add(sizesRButton[i],cons);
            sizes.add(sizesRButton[i]);
        }

        sizesMSG = new JLabel("Choose at least one Size");
        sizesMSG.setForeground(Color.red);
        sizesMSG.setVisible(false);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 3;
        sizePanel.add(sizesMSG,cons);

        thickness = new ButtonGroup();
        String[] thicknessC ={"Thin","Thick"};
        thicknessRButton = new JRadioButton[thicknessC.length];
        for (int i = 0; i < thicknessC.length; i++){
            thicknessRButton[i] = new JRadioButton(thicknessC[i]);
            String command = "";
            if (i == 0){
                command += "Thin";
               // thicknessRButton[i].setSelected(true);
            }else if (i == 1){
                command += "Thick";
            }
            thicknessRButton[i].setActionCommand(command);
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridx = 0;
            cons.gridy = i;
            thicknessPanel.add(thicknessRButton[i],cons);
            thickness.add(thicknessRButton[i]);
        }

        thicknessMSG = new JLabel("Choose at least one Thickness");
        thicknessMSG.setForeground(Color.red);
        thicknessMSG.setVisible(false);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 3;
        thicknessPanel.add(thicknessMSG,cons);

        String[] toppings ={"Pepperoni","Mushrooms","Anchovies"};
        toppingsBox = new JCheckBox[toppings.length];
        for(int i = 0; i < toppingsBox.length; i++){
            toppingsBox[i]=new JCheckBox(toppings[i]);
            String command = "";
            if (i == 0){
                command += " P ";
            }else if (i == 1){
                command += " M ";
            }else if (i == 2){
                command += " A ";
            }
            toppingsBox[i].setActionCommand(command);
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridx = 0;
            cons.gridy = i;
            toppingsPanel.add(toppingsBox[i],cons);
        }

        toppingsMSG = new JLabel("Choose at least one Toppings");
        toppingsMSG.setForeground(Color.red);
        toppingsMSG.setVisible(false);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 3;
        toppingsPanel.add(toppingsMSG,cons);

        right.add(fieldPanel, BorderLayout.PAGE_START);
        choicesPanel.add(sizePanel);
        choicesPanel.add(thicknessPanel);
        choicesPanel.add(toppingsPanel);
        right.add(choicesPanel, BorderLayout.CENTER);
        right.add(buttonsPanel, BorderLayout.PAGE_END);

        sizePanel.setBorder(BorderFactory.createTitledBorder("Size"));
        thicknessPanel.setBorder(BorderFactory.createTitledBorder("Thickness"));
        toppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));

        saveBT = new JButton("Save");
        updateBT = new JButton("Update");
        deleteBT = new JButton("Delete");
        deleteBT.setVisible(false);
        updateBT.setVisible(false);
        buttonsPanel.add(saveBT);
        buttonsPanel.add(updateBT);
        buttonsPanel.add(deleteBT);

        table = new JTable();

        JScrollPane scrollP = new JScrollPane(table);
        var tableDimensions = new Dimension(650,700);
        left.setPreferredSize(tableDimensions);
        scrollP.setPreferredSize(tableDimensions);
        container.add(left);
        container.add(right);
        left.add(scrollP);


        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JTextField getNameField(){
        return nameField;
    }
    public JFormattedTextField getPhoneNumField(){
        return phoneNumField;
    }
    public JTextField getAddressField(){
        return addressField;
    }
    public JButton getSaveBT(){
        return saveBT;
    }

    public JButton getDeleteBT() {
        return deleteBT;
    }

    public JButton getUpdateBT() {
        return updateBT;
    }

    public JRadioButton[] getSizesRButton() {
        return sizesRButton;
    }

    public JRadioButton[] getThicknessRButton() {
        return thicknessRButton;
    }

    public JCheckBox[] getToppingsBox() {
        return toppingsBox;
    }


    public JTable getTable() {
        return table;
    }

    public ButtonGroup getSizes() {
        return sizes;
    }

    public ButtonGroup getThickness() {
        return thickness;
    }

    public JLabel getNameMSG() {
        return nameMSG;
    }

    public JLabel getPhoneMSG() {
        return phoneMSG;
    }

    public JLabel getAddressMSG() {
        return addressMSG;
    }

    public JLabel getSizesMSG() {
        return sizesMSG;
    }

    public JLabel getThicknessMSG() {
        return thicknessMSG;
    }

    public JLabel getToppingsMSG() {
        return toppingsMSG;
    }

}