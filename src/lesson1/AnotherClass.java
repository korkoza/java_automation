package lesson1;

public class AnotherClass {
    public static void main(String[] args){
        Hybrid toyotaPrius = new Hybrid("Toyota", "Prius", 2018, "Electricity, Gas");
        toyotaPrius.displayInfo();
        toyotaPrius.drive();

        Electric teslaModelS = new Electric("Tesla", "Model S", 2020, "Electric");
        teslaModelS.displayInfo();
        teslaModelS.drive();
    }
}