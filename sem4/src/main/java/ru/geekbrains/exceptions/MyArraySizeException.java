package ru.geekbrains.exceptions;

public class MyArraySizeException extends Exception{
    private static final int sizeRow = 4;
    private static final int sizeColumn = 4;
    private static final String sizeMessage = "Размер массива должен быть " + sizeRow + "x" + sizeColumn + " !\n";


    public MyArraySizeException(String message) {
        super(message + sizeMessage);
    }

    public MyArraySizeException(int column) {
        super(sizeMessage + "Количество строк в массиве: " + column + " !\n");
    }

    public MyArraySizeException(int column, int row) {
        super(sizeMessage + "Количество элементов в " + column + " строке массива: " + row + "!\n");
    }

}
