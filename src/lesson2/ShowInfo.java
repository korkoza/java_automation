package lesson2;

import java.util.*;
import java.util.stream.Collectors;

public class ShowInfo{
    public static void main(String[] args){

        // Process FixedSalaryEmployee

        List<FixedSalaryEmployee> fixedSalaryEmployeeList = new ArrayList<>();

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

        fixedSalaryEmployeeList.add(JhonDoe1);
        fixedSalaryEmployeeList.add(JhonDoe2);
        fixedSalaryEmployeeList.add(JhonDoe3);
        fixedSalaryEmployeeList.add(JhonDoe4);
        fixedSalaryEmployeeList.add(JhonDoe5);
        fixedSalaryEmployeeList.add(JhonDoe6);
        fixedSalaryEmployeeList.add(JhonDoe7);
        fixedSalaryEmployeeList.add(JhonDoe8);
        fixedSalaryEmployeeList.add(JhonDoe9);
        fixedSalaryEmployeeList.add(JhonDoe10);

        // Calculate salary
        for(FixedSalaryEmployee i:fixedSalaryEmployeeList){
            i.getCalculatedSalary(0,0,0);
        }

        // Sort the list by Salary and then Surname
        fixedSalaryEmployeeList.sort(Comparator.comparing(FixedSalaryEmployee::getSalary).thenComparing(FixedSalaryEmployee::getSurname));

        // Display sorted list
        System.out.println("Fixed salary employee");
        for(FixedSalaryEmployee i:fixedSalaryEmployeeList){
            System.out.println("name - " + i.name + " " + i.surname + ", ID - " + i.ID + ", salary - " + i.salary);
        }

        // Process RatedSalaryEmployee
        List<RatedSalaryEmployee> ratedSalaryEmployeeList = new ArrayList<>();

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

        ratedSalaryEmployeeList.add(JaneDoe11);
        ratedSalaryEmployeeList.add(JaneDoe12);
        ratedSalaryEmployeeList.add(JaneDoe13);
        ratedSalaryEmployeeList.add(JaneDoe14);
        ratedSalaryEmployeeList.add(JaneDoe15);
        ratedSalaryEmployeeList.add(JaneDoe16);
        ratedSalaryEmployeeList.add(JaneDoe17);
        ratedSalaryEmployeeList.add(JaneDoe18);
        ratedSalaryEmployeeList.add(JaneDoe19);
        ratedSalaryEmployeeList.add(JaneDoe20);

        // Calculate salary
        for(RatedSalaryEmployee i:ratedSalaryEmployeeList){
            i.getCalculatedSalary(21, 8, 30*Math.random());
        }

        // Sort the list by Salary and then Surname
        ratedSalaryEmployeeList.sort(Comparator.comparing(RatedSalaryEmployee::getSalary).thenComparing(RatedSalaryEmployee::getSurname));

        // Display sorted list
        System.out.println("\nRated salary employee");
        for(RatedSalaryEmployee i:ratedSalaryEmployeeList){
            System.out.println("name - " + i.name + " " + i.surname + ", ID - " + i.ID + ", salary - " + String.format("%.2f", i.salary));
        }

        // Display the names of the fist 5 items
        System.out.println("\nNames of the fist 5 items");
        for(int j=0; j<5; j++){
            System.out.println(ratedSalaryEmployeeList.get(j).surname);
        }

        // Display the IDs of the last 3 items
        System.out.println("\nIDs of the last 3 items");
        for(int j=ratedSalaryEmployeeList.size(); j>ratedSalaryEmployeeList.size()-3; j--){
            System.out.println(ratedSalaryEmployeeList.get(j-1).ID);
        }

        // ---------------------------------------------------------------------------------------------------------------
        System.out.println("\nWORKING WITH STREAMS \nTask 1:\n");

        // 1.
        ratedSalaryEmployeeList.stream()
                .forEach(e -> System.out.println("name - " + e.name + " " + e.surname + ", ID - " + e.ID + ", salary - " + String.format("%.2f", e.salary)));

        // 2.
        List <String> ratedSalaryEmployeesNames = ratedSalaryEmployeeList.stream()
                .map(p->p.name)
                .collect(Collectors.toList());

        System.out.println("\nTask 2: \nNew list with names only: " + ratedSalaryEmployeesNames);


        // 3.
        List <String> fixedSalaryEmployeeSurnamesAddedList = fixedSalaryEmployeeList.stream()
                .map(p->p.surname + "_added")
                .collect(Collectors.toList());

        System.out.println("\nTask 3: \nNew list after concatenation: " + fixedSalaryEmployeeSurnamesAddedList);

        // 4.
        List <Double> fixedSalaryEmployeeChangedSalaryList = fixedSalaryEmployeeList.stream()
                .map(p -> p.salary - 500)
                .collect(Collectors.toList());

        System.out.println("\nTask 4:\nList of salaries after subtraction of 500: " + fixedSalaryEmployeeChangedSalaryList);

        // 5.
        System.out.println("\nTask 5:\nFiltered list of random numbers");

        List <Double> randomNumbersList = new ArrayList<>();
        for (int i=0; i<10; i++) {
            randomNumbersList.add(100 * Math.random());
        }

        List <Double> filteredRandomList = randomNumbersList.stream()
                .map(p -> p + 5)
                .filter(p -> p > 20)
                .collect(Collectors.toList());

        filteredRandomList.forEach(p -> System.out.printf("%.2f ", p));

        }
    }
