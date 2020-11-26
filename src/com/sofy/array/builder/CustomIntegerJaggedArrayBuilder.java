package com.sofy.array.builder;

import com.sofy.array.entity.CustomIntegerJaggedArray;
import com.sofy.array.entity.CustomIntegerArray;

public class CustomIntegerJaggedArrayBuilder {
    public CustomIntegerJaggedArray fillRandomArr() {
        int rows = (int) (Math.random() * 10) + 5;
        CustomIntegerArray[] array = new CustomIntegerArray[rows];

        for (int i = 0; i < rows; i++) {
            int columns = (int) (Math.random() * 10) + 5;
            int[] array_in = new int[columns];
            for (int j = 0; j < columns; j++) {
                array_in[j] = (int) (Math.random() * 2000 - 1000);
            }
            array[i] = new CustomIntegerArray(array_in);
        }

        return new CustomIntegerJaggedArray(array);
    }
}
