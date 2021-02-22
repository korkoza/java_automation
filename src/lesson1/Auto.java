package lesson1;

public class Auto {
    protected String make;
    protected String model;
    protected int year;
    protected String engine;

    public Auto(String make, String model, int year, String engine) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getEngine() {
        return engine;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void drive(){
        System.out.println("It can drive using fossil fuel");
    }

    public void displayInfo(){
        System.out.println("This is " + this.make + ", " + this.model + " that has been produced in " + this.year + ". Engine type - " + this.engine);
    }

}