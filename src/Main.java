import fieldActions.ClearForm;
import com.formdev.flatlaf.FlatDarculaLaf;
import model.OrderTableModel;
import view.PizzaOrderGUI;

public class Main {
    public static void main(String[] args){
        FlatDarculaLaf.install();
        PizzaOrderGUI view = new PizzaOrderGUI();
        OrderTableModel model = new OrderTableModel();
        ClearForm clear = new ClearForm(view);
        Controller controller = new Controller(view,model,clear);

    }
}