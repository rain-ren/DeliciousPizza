import ButtonListeners.DeleteBTListener;
import ButtonListeners.SaveBTListener;
import ButtonListeners.UpdateBTListener;
import CheckBoxListeners.ToppingsListener;
import fieldActions.ClearForm;
import FieldListeners.addressListener;
import FieldListeners.nameListener;
import FieldListeners.phoneListener;
import RadioButtonsListeners.SizesListener;
import RadioButtonsListeners.ThicknessListener;
import TableListener.TableListener;
import model.OrderTableModel;
import view.PizzaOrderGUI;

public class Controller {
    private PizzaOrderGUI view;
    private OrderTableModel model;
    private ClearForm clear;
    public Controller(PizzaOrderGUI view, OrderTableModel model, ClearForm clear){
        this.view = view;
        this.model = model;
        this.clear = clear;

        //===Table===
        view.getTable().setModel(model);
        TableListener tableListener = new TableListener(view, model);
        view.getTable().addMouseListener(tableListener);

        //===Save Button===
        SaveBTListener saveListener = new SaveBTListener(view,model,clear);
        view.getSaveBT().addActionListener(saveListener);

        //===Update Button===
        UpdateBTListener updateListener = new UpdateBTListener(view,model);
        view.getUpdateBT().addActionListener(updateListener);

        //===Delete Button===
        DeleteBTListener deleteListener = new DeleteBTListener(view, model);
        view.getDeleteBT().addActionListener(deleteListener);

        //===Key Listener===
        nameListener nameListener = new nameListener(view,model);
        view.getNameField().addKeyListener(nameListener);

        phoneListener phoneListener = new phoneListener(view,model);
        view.getPhoneNumField().addKeyListener(phoneListener);

        addressListener addressListener = new addressListener(view,model);
        view.getAddressField().addKeyListener(addressListener);

        //===Radio Button Listener
        SizesListener sizesListener = new SizesListener(view,model);
        for (int counter = 0; counter < view.getSizesRButton().length; counter ++){
            view.getSizesRButton()[counter].addItemListener(sizesListener);
        }

        ThicknessListener thicknessListener = new ThicknessListener(view,model);
        for (int counter = 0; counter < view.getThicknessRButton().length; counter ++){
            view.getThicknessRButton()[counter].addItemListener(thicknessListener);
        }
        ToppingsListener toppingsListener = new ToppingsListener(view,model);
        for (int counter = 0; counter < view.getToppingsBox().length; counter ++){
            view.getToppingsBox()[counter].addItemListener(toppingsListener);
        }
    }
}
