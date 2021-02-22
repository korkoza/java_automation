package lesson1;

import lesson1.Auto;

public class Hybrid extends Auto {
    public Hybrid(String make, String model, int year, String engine) {
        super(make, model, year, engine);
    }

    @Override
    public void drive() {
        System.out.println("It can drive on both electricity and gas");
    }
}