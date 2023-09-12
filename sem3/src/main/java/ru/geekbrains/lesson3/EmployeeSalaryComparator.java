package ru.geekbrains.lesson3;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        //System.out.println("ЗП сортировка");
        return Double.compare(o1.calculateSalary(), o2.calculateSalary());
    }
}
