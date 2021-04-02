package JavaPractice.lesson2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShowInfo{

    public static void main(String[] args){

        // Process FixedSalaryEmployee

        List<FixedSalaryEmployee> FixedSalaryEmployeeList = new ArrayList<>();

        FixedSalaryEmployee JhonDoe1 = new FixedSalaryEmployee("Jhon", "Doe9", "9");
        FixedSalaryEmployee JhonDoe2 = new FixedSalaryEmployee("Jhon", "Doe8", "8");
        FixedSalaryEmployee JhonDoe3 = new FixedSalaryEmployee("Jhon", "Doe1", "1");
        FixedSalaryEmployee JhonDoe4 = new FixedSalaryEmployee("Jhon", "Doe2", "2");
        FixedSalaryEmployee JhonDoe5 = new FixedSalaryEmployee("Jhon", "Doe3", "3");
        FixedSalaryEmployee JhonDoe6 = new FixedSalaryEmployee("Jhon", "Doe4", "4");
        FixedSalaryEmployee JhonDoe7 = new FixedSalaryEmployee("Jhon", "Doe5", "5");
        FixedSalaryEmployee JhonDoe8 = new FixedSalaryEmployee("Jhon", "Doe6", "6");
        FixedSalaryEmployee JhonDoe9 = new FixedSalaryEmployee("Jhon", "Doe7", "7");
        FixedSalaryEmployee JhonDoe10 = new FixedSalaryEmployee("Jhon", "Doe10", "10");

        FixedSalaryEmployeeList.add(JhonDoe1);
        FixedSalaryEmployeeList.add(JhonDoe2);
        FixedSalaryEmployeeList.add(JhonDoe3);
        FixedSalaryEmployeeList.add(JhonDoe4);
        FixedSalaryEmployeeList.add(JhonDoe5);
        FixedSalaryEmployeeList.add(JhonDoe6);
        FixedSalaryEmployeeList.add(JhonDoe7);
        FixedSalaryEmployeeList.add(JhonDoe8);
        FixedSalaryEmployeeList.add(JhonDoe9);
        FixedSalaryEmployeeList.add(JhonDoe10);

        // Calculate salary
        for(FixedSalaryEmployee i:FixedSalaryEmployeeList){
            i.getCalculatedSalary(0,0,0);
        }

        // Sort the list by Salary and then Surname
        FixedSalaryEmployeeList.sort(Comparator.comparing(FixedSalaryEmployee::getSalary).thenComparing(FixedSalaryEmployee::getSurname));

        // Display sorted list
        System.out.println("Fixed salary employee");
        for(FixedSalaryEmployee i:FixedSalaryEmployeeList){
            System.out.println("name - " + i.name + " " + i.surname + ", ID - " + i.ID + ", salary - " + i.salary);
        }

        // Process RatedSalaryEmployee
        List<RatedSalaryEmployee> RatedSalaryEmployeeList = new ArrayList<>();

        RatedSalaryEmployee JaneDoe11 = new RatedSalaryEmployee("Jane", "Doe11", "11");
        RatedSalaryEmployee JaneDoe12 = new RatedSalaryEmployee("Jane", "Doe12", "12");
        RatedSalaryEmployee JaneDoe13 = new RatedSalaryEmployee("Jane", "Doe13", "13");
        RatedSalaryEmployee JaneDoe14 = new RatedSalaryEmployee("Jane", "Doe14", "14");
        RatedSalaryEmployee JaneDoe15 = new RatedSalaryEmployee("Jane", "Doe15", "15");
        RatedSalaryEmployee JaneDoe16 = new RatedSalaryEmployee("Jane", "Doe16", "16");
        RatedSalaryEmployee JaneDoe17 = new RatedSalaryEmployee("Jane", "Doe17", "17");
        RatedSalaryEmployee JaneDoe18 = new RatedSalaryEmployee("Jane", "Doe18", "18");
        RatedSalaryEmployee JaneDoe19 = new RatedSalaryEmployee("Jane", "Doe19", "19");
        RatedSalaryEmployee JaneDoe20 = new RatedSalaryEmployee("Jane", "Doe20", "20");

        RatedSalaryEmployeeList.add(JaneDoe11);
        RatedSalaryEmployeeList.add(JaneDoe12);
        RatedSalaryEmployeeList.add(JaneDoe13);
        RatedSalaryEmployeeList.add(JaneDoe14);
        RatedSalaryEmployeeList.add(JaneDoe15);
        RatedSalaryEmployeeList.add(JaneDoe16);
        RatedSalaryEmployeeList.add(JaneDoe17);
        RatedSalaryEmployeeList.add(JaneDoe18);
        RatedSalaryEmployeeList.add(JaneDoe19);
        RatedSalaryEmployeeList.add(JaneDoe20);

        // Calculate salary
        for(RatedSalaryEmployee i:RatedSalaryEmployeeList){
            i.getCalculatedSalary(21, 8, 30*Math.random());
        }

        // Sort the list by Salary and then Surname
        RatedSalaryEmployeeList.sort(Comparator.comparing(RatedSalaryEmployee::getSalary).thenComparing(RatedSalaryEmployee::getSurname));

        // Display sorted list
        System.out.println("\nRated salary employee");
        for(RatedSalaryEmployee i:RatedSalaryEmployeeList){
            System.out.println("name - " + i.name + " " + i.surname + ", ID - " + i.ID + ", salary - " + String.format("%.2f", i.salary));
        }

        // Display the names of the fist 5 items
        System.out.println("\nNames of the fist 5 items");
        for(int j=0; j<5; j++){
            System.out.println(RatedSalaryEmployeeList.get(j).surname);
        }

        // Display the IDs of the last 3 items
        System.out.println("\nIDs of the last 3 items");
        for(int j=RatedSalaryEmployeeList.size(); j>RatedSalaryEmployeeList.size()-3; j--){
            System.out.println(RatedSalaryEmployeeList.get(j-1).ID);
        }

    }
}
