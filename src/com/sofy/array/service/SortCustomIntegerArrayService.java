package com.sofy.array.service;

import com.sofy.array.entity.CustomIntegerArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortCustomIntegerArrayService {
    static Logger logger = LogManager.getLogger();

    public void selectionSort(CustomIntegerArray array) {
        logger.info("Start selection sorting array {}", array);
        CustomIntegerArrayService service = new CustomIntegerArrayService();
        for (int left = 0; left < array.getLength(); left++) {
            int minIndex = left;
            for (int i = left; i < array.getLength(); i++) {
                if (array.getValue(i) < array.getValue(minIndex)) {
                    minIndex = i;
                }
            }
            service.swap(array, left, minIndex);
        }
        logger.info("End selection sorting array {}", array);
    }

    public void bubbleSort(CustomIntegerArray array) {
        logger.info("Start bubble sorting array {}", array);
        CustomIntegerArrayService service = new CustomIntegerArrayService();
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.getLength() - 1; i++) {
                if (array.getValue(i) > array.getValue(i + 1)) {
                    service.swap(array, i, i + 1);
                    sorted = false;
                }
            }
        }
        logger.info("End bubble sorting array {}", array);
    }

    public void insertionSort(CustomIntegerArray array) {
        logger.info("Start insertion sorting array {}", array);
        for (int i = 1; i < array.getLength(); i++) {
            int current = array.getValue(i);
            int j = i - 1;
            while (j >= 0 && current < array.getValue(j)) {
                array.setValue(j + 1, array.getValue(j));
                j--;
            }
            array.setValue(j + 1, current);
        }
        logger.info("End insertion sorting array {}", array);
    }
}
