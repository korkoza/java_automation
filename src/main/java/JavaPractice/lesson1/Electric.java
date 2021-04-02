package JavaPractice.lesson1;

public class Electric extends AbstractAuto {
    public Electric(String make, String model, int year, String engine){
        super(make, model, year, engine);
    }

    @Override
    public void drive() {
        System.out.println("It can drive on electricity only");
    }
}
