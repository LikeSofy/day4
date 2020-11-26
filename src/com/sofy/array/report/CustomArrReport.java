package com.sofy.array.report;

import com.sofy.array.entity.CustomIntegerArray;
import com.sofy.array.entity.CustomIntegerJaggedArray;

import java.util.Formatter;

import static java.lang.System.out;

public class CustomArrReport {
    public void closesCustomArr(CustomIntegerArray array, CustomIntegerArray simpleNumbers, CustomIntegerArray fibonacciNumbers, CustomIntegerArray noDuplicateNumbersInElements, CustomIntegerArray selectionSort, CustomIntegerArray bubbleSort, CustomIntegerArray insertionSort) {
        Formatter f = new Formatter();
        f.format(" .....closes..... :%nИсходный массив: %s", array.toString());
        f.format("%nПростые числа: %s", simpleNumbers.toString());
        f.format("%nЧисла фибоначи: %s", fibonacciNumbers.toString());
        f.format("%nТрехзначные числа, в десятичной записи которых нет одинаковых цифр: %s", noDuplicateNumbersInElements.toString());
        f.format("%nСортировка выборкой: %s", selectionSort.toString());
        f.format("%nСортировка пузырьком: %s", bubbleSort.toString());
        f.format("%nСортировка вставкой: %s", insertionSort.toString());
        out.print(f);
    }

    public void closesCustomJaggedArr(CustomIntegerJaggedArray array, CustomIntegerJaggedArray sortBySumsElements, CustomIntegerJaggedArray reverseSortBySumsElements, CustomIntegerJaggedArray sortByMaxElement, CustomIntegerJaggedArray reverseSortByMaxElement, CustomIntegerJaggedArray sortByMinElement, CustomIntegerJaggedArray reverseSortByMinElement) {
        Formatter f = new Formatter();
        f.format(" .....closes..... :%nИсходный массив: %s", array.toString());
        f.format("%nОтсортированный по сумме: %s", sortBySumsElements.toString());
        f.format("%nОтсортированный по сумме в обратном порядке: %s", reverseSortBySumsElements.toString());
        f.format("%nОтсортированный по максимальному элементу: %s", sortByMaxElement.toString());
        f.format("%nОтсортированный по максимальному элементу в обратном порядке: %s", reverseSortByMaxElement.toString());
        f.format("%nОтсортированный по минимальному элементу: %s", sortByMinElement.toString());
        f.format("%nОтсортированный по минимальному элементу в обратном порядке: %s", reverseSortByMinElement.toString());
        out.print(f);
    }
}
