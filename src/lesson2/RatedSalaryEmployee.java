package lesson2;

public class RatedSalaryEmployee extends Employee{


    public RatedSalaryEmployee(String name, String surname, String ID) {
        super(name, surname, ID);
    }

    @Override
    public double getCalculatedSalary(int days, int hours, double rate) {
        return salary = days * hours * rate;
    }
}
