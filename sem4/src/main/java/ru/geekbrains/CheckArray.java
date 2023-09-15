package ru.geekbrains;

import ru.geekbrains.exceptions.MyArrayDataException;
import ru.geekbrains.exceptions.MyArraySizeException;

public class CheckArray {
    private static final int sizeX = 4;
    private static final int sizeY = 4;

    public static int sum(String[][] array) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;
        //System.out.println("array.length [" + array.length + "]" + "[" + array[0].length + "]");
        if (array.length!= sizeY) {
            throw new MyArraySizeException(array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != sizeX)
                throw new MyArraySizeException(i, array[i].length);
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(j, i);
                }
            }
        }

        return sum;
    }

}
