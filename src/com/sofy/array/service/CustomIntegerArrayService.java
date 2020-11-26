package com.sofy.array.service;

import com.sofy.array.entity.CustomIntegerArray;

import java.util.Arrays;

public class CustomIntegerArrayService {
    public CustomIntegerArray copyCustomIntegerArray(CustomIntegerArray array) {
        int[] copyArr = Arrays.copyOf(array.getValues(), array.getLength());
        return new CustomIntegerArray(copyArr);
    }

    public void swap(CustomIntegerArray array, int index1, int index2) {
        int buffer = array.getValue(index1);
        array.setValue(index1, array.getValue(index2));
        array.setValue(index2, buffer);
    }
}
