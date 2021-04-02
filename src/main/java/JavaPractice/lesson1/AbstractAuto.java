package JavaPractice.lesson1;

public abstract class AbstractAuto implements IAuto {
    protected String make;
    protected String model;
    protected int year;
    protected String engine;

    public AbstractAuto(String make, String model, int year, String engine) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public void displayInfo() {
        System.out.println("This is " + this.make + ", " + this.model + " that has been produced in " + this.year + ". Engine type - " + this.engine);
    }
}
