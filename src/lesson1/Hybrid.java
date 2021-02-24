package lesson1;

public class Hybrid extends AbstractIAuto {
    public Hybrid(String make, String model, int year, String engine) {
        super(make, model, year, engine);
    }

    @Override
    public void drive() {
        System.out.println("It can drive on both electricity and gas");
    }
}