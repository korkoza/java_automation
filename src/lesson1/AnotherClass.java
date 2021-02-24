package lesson1;

import lesson1.Electric;
import lesson1.Hybrid;

public class AnotherClass {
    public static void main(String[] args){
        Hybrid car1 = new Hybrid("Toyota", "Prius", 2018, "Electricity, Gas");
        car1.displayInfo();
        car1.drive();

        Electric car2 = new Electric("Tesla", "Model S", 2020, "Electric");
        car2.displayInfo();
        car2.drive();
    }
}