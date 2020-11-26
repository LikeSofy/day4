package com.sofy.array.main;

import com.sofy.array.entity.CustomIntegerArray;
import com.sofy.array.service.*;
import com.sofy.array.builder.CustomIntegerArrayBuilder;
import com.sofy.array.builder.CustomIntegerJaggedArrayBuilder;
import com.sofy.array.entity.CustomIntegerJaggedArray;
import com.sofy.array.report.CustomArrReport;
import com.sofy.array.service.SortCustomIntegerArrayService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProjectMain {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        CustomIntegerArrayBuilder customIntegerArrayBuilder = new CustomIntegerArrayBuilder();
        CustomIntegerArray customIntegerArray = customIntegerArrayBuilder.fillArr();
        SearchService searchService = new SearchService();
        CustomIntegerArray simpleNumbers = searchService.findAllSimpleElement(customIntegerArray);
        CustomIntegerArray fibonacciNumbers = searchService.findAllFibonacciElement(customIntegerArray);
        CustomIntegerArray noDuplicateNumbersInElements = searchService.findAllNoDuplicateNumbersInElement(customIntegerArray);
        CustomIntegerArrayService customIntegerArrayService = new CustomIntegerArrayService();
        CustomIntegerArray selectionSort = customIntegerArrayService.copyCustomIntegerArray(customIntegerArray);
        CustomIntegerArray bubbleSort = customIntegerArrayService.copyCustomIntegerArray(customIntegerArray);
        CustomIntegerArray insertionSort = customIntegerArrayService.copyCustomIntegerArray(customIntegerArray);
        SortCustomIntegerArrayService sortCustomIntegerArrayService = new SortCustomIntegerArrayService();
        sortCustomIntegerArrayService.selectionSort(selectionSort);
        sortCustomIntegerArrayService.bubbleSort(bubbleSort);
        sortCustomIntegerArrayService.selectionSort(insertionSort);
        CustomArrReport report = new CustomArrReport();
        report.closesCustomArr(customIntegerArray, simpleNumbers, fibonacciNumbers, noDuplicateNumbersInElements, selectionSort, bubbleSort, insertionSort);
        CustomIntegerJaggedArrayBuilder builder = new CustomIntegerJaggedArrayBuilder();
        CustomIntegerJaggedArray array = builder.fillRandomArr();
        CustomIntegerJaggedArrayService service = new CustomIntegerJaggedArrayService();
        CustomIntegerJaggedArray sortBySumsElements = service.CopyCustomIntegerArray(array);
        CustomIntegerJaggedArray reverseSortBySumsElements = service.CopyCustomIntegerArray(array);
        CustomIntegerJaggedArray sortByMaxElement = service.CopyCustomIntegerArray(array);
        CustomIntegerJaggedArray reverseSortByMaxElement = service.CopyCustomIntegerArray(array);
        CustomIntegerJaggedArray sortByMinElement = service.CopyCustomIntegerArray(array);
        CustomIntegerJaggedArray reverseSortByMinElement = service.CopyCustomIntegerArray(array);
        SortCustomIntegerJaggedArrayService sortCustomIntegerJaggedArrayService = new SortCustomIntegerJaggedArrayService();
        sortCustomIntegerJaggedArrayService.sortBySumsElements(sortBySumsElements);
        sortCustomIntegerJaggedArrayService.reverseSortBySumsElements(reverseSortBySumsElements);
        sortCustomIntegerJaggedArrayService.sortByMaxElement(sortByMaxElement);
        sortCustomIntegerJaggedArrayService.reverseSortByMaxElement(reverseSortByMaxElement);
        sortCustomIntegerJaggedArrayService.sortByMinElement(sortByMinElement);
        sortCustomIntegerJaggedArrayService.reverseSortByMinElement(reverseSortByMinElement);
        report.closesCustomJaggedArr(array, sortBySumsElements, reverseSortBySumsElements, sortByMaxElement, reverseSortByMaxElement, sortByMinElement, reverseSortByMinElement);
    }
}
