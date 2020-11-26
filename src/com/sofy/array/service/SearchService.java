package com.sofy.array.service;

import com.sofy.array.entity.CustomIntegerArray;

public class SearchService {
    public int binarySearch(CustomIntegerArray array, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array.getValue(mid) < key) {
                low = mid + 1;
            } else if (array.getValue(mid) > key) {
                high = mid - 1;
            } else if (array.getValue(mid) == key) {
                index = mid;
                break;
            }
        }

        return index;
    }

    public int findMinElement(CustomIntegerArray array) {
        int minElement = 0;
        for (int i = 1; i < array.getLength(); i++) {
            if (array.getValue(i) < array.getValue(minElement)) {
                minElement = i;
            }
        }

        return minElement;
    }

    public int findMaxElement(CustomIntegerArray array) {
        int maxElement = 0;
        for (int i = 1; i < array.getLength(); i++) {
            if (array.getValue(i) > array.getValue(maxElement)) {
                maxElement = i;
            }
        }

        return maxElement;
    }

    public CustomIntegerArray findAllSimpleElement(CustomIntegerArray array) {
        NumberService numberService = new NumberService();
        CustomIntegerArray arraySimple = new CustomIntegerArray();
        for (int i = 0; i < array.getLength(); i++) {
            if (numberService.isSimple(array.getValues()[i])) {
                arraySimple.add(array.getValue(i));
            }
        }

        return arraySimple;
    }

    public CustomIntegerArray findAllFibonacciElement(CustomIntegerArray array) {
        NumberService numberService = new NumberService();
        CustomIntegerArray arrayFibonacci = new CustomIntegerArray();
        for (int i = 0; i < array.getLength(); i++) {
            if (numberService.isFibonacci(array.getValues()[i])) {
                arrayFibonacci.add(array.getValue(i));
            }
        }

        return arrayFibonacci;
    }

    public CustomIntegerArray findAllNoDuplicateNumbersInElement(CustomIntegerArray array) {
        NumberService numberService = new NumberService();
        CustomIntegerArray arrayNoDuplicateNumbers = new CustomIntegerArray();
        for (int i = 0; i < array.getLength(); i++) {
            if (numberService.isNoDuplicateNumbers(array.getValues()[i])) {
                arrayNoDuplicateNumbers.add(array.getValue(i));
            }
        }

        return arrayNoDuplicateNumbers;
    }
}
