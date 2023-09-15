package ru.geekbrains;

import ru.geekbrains.exceptions.MyArrayDataException;
import ru.geekbrains.exceptions.MyArraySizeException;

import java.util.Random;

public class Main {
    public static final Random random = new Random();

    public static void main(String[] args) {
        String[][] array = createArray();
        fillArray(array);
        printArray(array);
        sum(array);
    }

    public static String[][] createArray(){
        int y = arrayLengthSet();
        String[][] array = new String[y][];
        for (int i = 0; i < y; i++) {
            array[i] = new String[arrayLengthSet()];
        }
        return array;
    }

    public static int arrayLengthSet(){
        if (random.nextInt(5) == 1)
            return random.nextInt(2, 6);
        else
            return 4;
    }

    public static void fillArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (random.nextInt(15) == 1) { // произвольно заполним элемент массива символом "*"
                    array[i][j] = "*";
                }
                else {
                    array[i][j] = String.format("%d", random.nextInt(10));
                }
            }
        }
    }

    public static void printArray(String[][] array) {
        for (String[] strings : array) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static void sum(String[][] array){
        int res = 0;
        while (res == 0) {
            try {
                res = CheckArray.sum(array);
                System.out.println("Сумма элементов массива = " + res);
            } catch (MyArraySizeException e){
                System.out.println(e.getMessage());
                System.out.println("Создаем новый массив");
                array = createArray();
                fillArray(array);
                printArray(array);
            } catch (MyArrayDataException e) {
                System.out.println(e.getMessage());
                System.out.println("Замена элемента [" + e.getRow() + "][" + e.getColumn() + "] в массиве");
                array[e.getColumn()][e.getRow()] = String.format("%d", random.nextInt(10)); // Собственно сама замена
                printArray(array);
            }
        }
    }

}