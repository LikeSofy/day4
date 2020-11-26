package com.sofy.array.service;

import com.sofy.array.entity.CustomIntegerArray;
import com.sofy.array.entity.CustomIntegerJaggedArray;

import java.util.Arrays;

public class CustomIntegerJaggedArrayService {
    public CustomIntegerJaggedArray CopyCustomIntegerArray(CustomIntegerJaggedArray arrayForCopy) {
        CustomIntegerJaggedArray jaggedArray = new CustomIntegerJaggedArray();
        for (int i = 0; i < arrayForCopy.getLength(); i++) {
            int[] copyArr = Arrays.copyOf(arrayForCopy.getArrays()[i].getValues(), arrayForCopy.getArrays()[i].getValues().length);
            jaggedArray.add(new CustomIntegerArray(copyArr));
        }

        return jaggedArray;
    }

    public void swap(CustomIntegerJaggedArray array, int index1, int index2) {
        CustomIntegerArray buffer = array.getArrays()[index1];
        array.getArrays()[index1] = array.getArrays()[index2];
        array.getArrays()[index2] = buffer;
    }
}
