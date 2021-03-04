package lesson2;

public class ShowInfo {
    public static void main(String [] args){
        FixedSalaryEmployee JhonDoe = new FixedSalaryEmployee("Jhon", "Doe", "1");
        JhonDoe.getCalculatedSalary(20,8, 33);
        JhonDoe.displaySalary();
        RatedSalaryEmployee JaneDoe = new RatedSalaryEmployee("Jane", "Doe", "2");
        JaneDoe.getCalculatedSalary(20, 8, 25);
        JaneDoe.displaySalary();
    }

}
