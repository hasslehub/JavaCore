package ru.geekbrains.lesson3;

import java.util.*;

public class CreateEmployee implements Iterable<Employee>{
    //region fields
    private List<Employee> employees;
    private Scanner scanner;
    private Random random;
    //endregion

    public CreateEmployee() {
        this.employees = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }



    /**
     * Генерируем рандомных служащих
     * @param count кол-во служащих
     */
    public void addRandomEmployees(int count){
        for (int i = 0; i < count; i++) {
            if (random.nextBoolean())
                employees.add(Worker.getInstance());
            else
                employees.add(Freelancer.getInstance());
        }
    }

    /**
     * Печать списока служащих
     */
    public void print() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println();
    }


    /**
     * Отсортировка
     */
    public void sortEmployee() {
        System.out.print("Выберите тип сортировки:\n" +
                "1 - по зарплате\n" +
                "2 - по ФИО сотрудника\n" +
                "3 - по должности\n " +
                "Ваш выбор: ");
        int choice = enter();
        while (choice > 3 || choice < 1){
            System.out.println("Некорректный ввод");
            choice = enter();
        }
        System.out.println(choice);
        switch (choice){
            case 1:
                employees.sort(new EmployeeSalaryComparator());
                break;
            case 2:
                employees.sort(new EmployeeNameComparator());
                break;
            case 3:
                employees.sort(new EmployeeIdComparator());
                break;
        }
    }


    /**
     * Ввод с клавиатуры
     * @return номер сортировки
     */
    private int enter(){
        int num;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Ошибка ввода");
                scanner.nextLine();
            }
        }
        return num;
    }


    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < employees.size();
            }

            @Override
            public Employee next() {
                return employees.get(index++);
            }
        };
    }
}
