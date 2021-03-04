package lesson2;

abstract class Employee {
    protected String name;
    protected String surname;
    protected String ID;
    protected double salary;

    public Employee(String name, String surname, String ID) {
        this.name = name;
        this.surname = surname;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public abstract double getCalculatedSalary(int days, int hours, float rate);

    public void displaySalary(){
        System.out.println("Salary of " + this.name + ", " + this.surname + " is $" + this.salary);
    }
}
