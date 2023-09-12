package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        CreateEmployee people = new CreateEmployee();
        people.addRandomEmployees(15);
        people.print();
        people.sortEmployee();
        people.print();

       /*
        List<Employee> employees = Worker.getEmployees(15);
        for (Employee employee: employees) {
            System.out.println(employee);
        }

        Collections.sort(people, new EmployeeNameComparator());
        System.out.println();

        for (Employee employee: people) {
            System.out.println(employee);
        }

        */
    }

}
