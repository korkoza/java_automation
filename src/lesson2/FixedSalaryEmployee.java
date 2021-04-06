package lesson2;

public class FixedSalaryEmployee extends Employee{
    private final double fixedValue = 3321.1;

    public FixedSalaryEmployee(String name, String surname, String ID) {
        super(name, surname, ID);
    }

    @Override
    public double getCalculatedSalary(int days, int hours, double rate) {
        return salary = fixedValue;
    }
}

