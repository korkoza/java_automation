package lesson2;

public class EmployeeFixed extends Employee{
    Float fixedValue;

    public EmployeeFixed(String name, String surname, String ID, float fixedValue) {
        super(name, surname, ID);
        this.fixedValue = fixedValue;
    }

    @Override
    public float averageSalary() {
        return fixedValue;
    }
}

