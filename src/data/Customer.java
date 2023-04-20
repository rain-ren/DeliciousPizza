package data;

public class Customer {

    private String name, phone, address, pizzaSize, pizzaThickness;
    private String[] pizzaToppings;

    public Customer(String namePassed, String phonePassed, String addressPassed, String pizzaSizePassed, String pizzaThicknessPassed, String[] pizzaToppingsPassed){
        this.name = namePassed;
        this.phone = phonePassed;
        this.address = addressPassed;
        this.pizzaSize = pizzaSizePassed;
        this.pizzaToppings = pizzaToppingsPassed;
        this.pizzaThickness = pizzaThicknessPassed;

    }

    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public String getAddress(){
        return address;
    }
    public String getPizzaSize(){
        return pizzaSize;
    }
    public String getPizzaThickness(){
        return pizzaThickness;
    }
    public String getPizzaToppings(){
        String stringPizzaToppings = "";
        for(int counter = 0; counter < 3; counter++){
            if (pizzaToppings[counter] != null){
                stringPizzaToppings += pizzaToppings[counter] + " ";
            }
        }
        return stringPizzaToppings;
    }
    public String[] getPizzaToppings1(){
        return pizzaToppings;
    }

}
