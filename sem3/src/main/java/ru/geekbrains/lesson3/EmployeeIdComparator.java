package ru.geekbrains.lesson3;

import java.util.Comparator;

public class EmployeeIdComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        //System.out.println("id сортировка");
        return Integer.compare(o1.getPosID(), o2.getPosID());
    }
}
