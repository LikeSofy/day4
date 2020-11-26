package com.sofy.array.service;

import com.sofy.array.entity.CustomIntegerJaggedArray;
import com.sofy.array.entity.CustomIntegerArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SortCustomIntegerJaggedArrayService {
    static Logger logger = LogManager.getLogger();

    private void sort(CustomIntegerJaggedArray array, SortingConditions condition) {
        logger.info("Start sorting array: {}", array);
        CustomIntegerJaggedArrayService service = new CustomIntegerJaggedArrayService();
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.getLength() - 1; i++) {
                if (condition.isEqual(array.getArray(i), array.getArray(i + 1))) {
                    service.swap(array, i, i + 1);
                    sorted = false;
                }
            }
        }
        logger.info("End sorting array: {}", array);
    }

    public void sortBySumsElements(CustomIntegerJaggedArray array) {
        logger.info("Sorting by sum");
        sort(array, SortingConditionsHelper::sum1MoreSum2);
    }

    public void reverseSortBySumsElements(CustomIntegerJaggedArray arr) {
        logger.info("Reverse sorting by sum");
        sort(arr, SortingConditionsHelper::sum1LessSum2);
    }

    public void sortByMaxElement(CustomIntegerJaggedArray array) {
        logger.info("Sorting by max element");
        sort(array, SortingConditionsHelper::maxNum1MoreMaxNum2);
    }

    public void reverseSortByMaxElement(CustomIntegerJaggedArray array) {
        logger.info("Reverse sorting by max element");
        sort(array, SortingConditionsHelper::maxNum1LessMaxNum2);
    }

    public void sortByMinElement(CustomIntegerJaggedArray array) {
        logger.info("Sorting by min element");
        sort(array, SortingConditionsHelper::minNum1MoreMinNum2);
    }

    public void reverseSortByMinElement(CustomIntegerJaggedArray array) {
        logger.info("Reverse sorting by min element");
        sort(array, SortingConditionsHelper::minNum1LessMinNum2);
    }
}

interface SortingConditions {
    boolean isEqual(CustomIntegerArray array1, CustomIntegerArray array2);
}

interface MaxMinElementCondition {
    boolean isEqual(int num1, int num2);
}

class SortingConditionsHelper {
    private SortingConditionsHelper() {
    }

    static boolean sum1MoreSum2(CustomIntegerArray array1, CustomIntegerArray array2) {
        return getSumSeries(array1) < getSumSeries(array2);
    }

    static boolean sum1LessSum2(CustomIntegerArray array1, CustomIntegerArray array2) {
        return getSumSeries(array1) > getSumSeries(array2);
    }

    static boolean maxNum1MoreMaxNum2(CustomIntegerArray array1, CustomIntegerArray array2) {
        return getMaxMinElement(array1, SortingConditionsHelper::num1MoreNum2) < getMaxMinElement(array2, SortingConditionsHelper::num1MoreNum2);
    }

    static boolean maxNum1LessMaxNum2(CustomIntegerArray array1, CustomIntegerArray array2) {
        return getMaxMinElement(array1, SortingConditionsHelper::num1MoreNum2) > getMaxMinElement(array2, SortingConditionsHelper::num1MoreNum2);
    }

    static boolean minNum1MoreMinNum2(CustomIntegerArray array1, CustomIntegerArray array2) {
        return getMaxMinElement(array1, SortingConditionsHelper::num1LessNum2) < getMaxMinElement(array2, SortingConditionsHelper::num1LessNum2);
    }

    static boolean minNum1LessMinNum2(CustomIntegerArray array1, CustomIntegerArray array2) {
        return getMaxMinElement(array1, SortingConditionsHelper::num1LessNum2) > getMaxMinElement(array2, SortingConditionsHelper::num1LessNum2);
    }

    static boolean num1MoreNum2(int num1, int num2) {
        return num1 > num2;
    }

    static boolean num1LessNum2(int num1, int num2) {
        return num1 < num2;
    }

    static int getSumSeries(CustomIntegerArray array) {
        int sum = 0;
        for (int j = 0; j < array.getLength(); j++) {
            sum += array.getValue(j);
        }

        return sum;
    }

    static int getMaxMinElement(CustomIntegerArray array, MaxMinElementCondition condition) {
        int searchElement = array.getValue(0);
        for (int i = 1; i < array.getLength(); i++) {
            if (condition.isEqual(array.getValue(i), searchElement)) {
                searchElement = array.getValue(i);
            }
        }

        return searchElement;
    }
}
