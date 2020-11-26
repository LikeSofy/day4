package com.sofy.array.entity;

import java.util.Arrays;

public class CustomIntegerArray {
    private int[] values;

    public CustomIntegerArray(int[] arr) {
        this.values = arr;
    }

    public CustomIntegerArray() {
        this.values = new int[0];
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public void add(int value) {
        int[] updatedArray = Arrays.copyOf(this.values, this.values.length + 1);
        updatedArray[this.values.length] = value;

        this.values = updatedArray;
    }

    public int getValue(int index) {
        return this.values[index];
    }

    public void setValue(int index, int value) {
        this.values[index] = value;
    }

    public int getLength() {
        return this.values.length;
    }

    public boolean equals(CustomIntegerArray o) {
        if (this == o) return true;
        if (o == null) return false;
        CustomIntegerArray that = (CustomIntegerArray) o;

        return Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomIntegerArray{");
        sb.append("array=").append(Arrays.toString(values));
        sb.append('}');
        return sb.toString();
    }
}
