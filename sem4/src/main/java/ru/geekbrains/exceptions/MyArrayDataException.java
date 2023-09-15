package ru.geekbrains.exceptions;

public class MyArrayDataException  extends Exception{
    private final int row;
    private final int column;

    public MyArrayDataException(int row, int column) {
        super("Неправильный формат данных. Ошибка в элементе массива [" + row + "][" + column + "]\n");
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

}
