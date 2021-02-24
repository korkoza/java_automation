package lesson2;

public class ShowInfo {
    public static void main(String [] args){
        EmployeeFixed emp1 = new EmployeeFixed("Jhon", "Doe", "1", 3123.8f);
        emp1.displaySalary();
        EmployeeRate emp2 = new EmployeeRate("Jane", "Doe", "2", 25.6f);
        emp2.displaySalary();
    }

}
