package lesson2;

public class EmployeeRate extends Employee{
    float rate;

    public EmployeeRate(String name, String surname, String ID, float rate) {
        super(name, surname, ID);
        this.rate = rate;
    }

    @Override
    public float averageSalary() {
        return (float) (20.8 * 8 * rate);
    }
}
