package lesson1;

import lesson1.Auto;
import lesson1.Electric;
import lesson1.Hybrid;

public class AbotherClass {
    public static void main(String[] args){
        Auto car1 = new Auto("VAZ", "Niva", 1987, "Diesel");
        car1.displayInfo();
        car1.drive();

        Hybrid car2 = new Hybrid("Toyota", "Prius", 2018, "Electricity, Gas");
        car2.displayInfo();
        car2.drive();

        Electric car3 = new Electric("Tesla", "Model S", 2020, "Electric");
        car3.displayInfo();
        car3.drive();
    }
}