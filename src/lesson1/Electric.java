package lesson1;

import lesson1.Auto;


public class Electric extends Auto {
    public Electric(String make, String model, int year, String engine){
        super(make, model, year, engine);
    }

    @Override
    public void drive() {
        System.out.println("It can drive on electricity only");
    }
}
