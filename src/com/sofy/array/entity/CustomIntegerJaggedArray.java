package com.sofy.array.entity;

import java.util.Arrays;

public class CustomIntegerJaggedArray {
    private CustomIntegerArray[] arrays;

    public CustomIntegerJaggedArray(CustomIntegerArray[] arr) {
        this.arrays = arr;
    }

    public CustomIntegerJaggedArray() {
        this.arrays = new CustomIntegerArray[0];
    }

    public CustomIntegerArray[] getArrays() {
        return arrays;
    }

    public void setArrays(CustomIntegerArray[] arrays) {
        this.arrays = arrays;
    }

    public CustomIntegerArray getArray(int index) {
        return this.arrays[index];
    }

    public void setArray(int index, CustomIntegerArray array) {
        this.arrays[index] = array;
    }

    public void add(CustomIntegerArray array) {
        CustomIntegerArray[] updatedArray = Arrays.copyOf(this.arrays, this.arrays.length + 1);
        updatedArray[this.arrays.length] = array;

        this.arrays = updatedArray;
    }

    public int getLength() {
        return this.arrays.length;
    }

    public boolean equals(CustomIntegerJaggedArray o) {
        if (this == o) return true;
        if (o == null) return false;
        CustomIntegerJaggedArray that = (CustomIntegerJaggedArray) o;
        return Arrays.equals(arrays, that.arrays);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arrays);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomInteger2DArray{");
        sb.append("array=").append(Arrays.toString(arrays));
        sb.append('}');
        return sb.toString();
    }
}
