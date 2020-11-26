package com.sofy.array.service;

import com.sofy.array.builder.CustomIntegerArrayBuilder;
import com.sofy.array.entity.CustomIntegerArray;
import com.sofy.array.entity.CustomIntegerJaggedArray;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomIntegerArrayServiceTest {
    private CustomIntegerArray array = new CustomIntegerArray(new int[]{1, 123, 554, 5, 20, -10, 7, 745, 34});

    private boolean isSorted(CustomIntegerArray arr) {
        boolean result = true;
        for (int i = 1; i < arr.getValues().length; i++) {
            if (arr.getValues()[i] < arr.getValues()[i - 1]) {
                result = false;
                break;
            }
        }

        return result;
    }

    @Test
    public void selectionSortTest() {
        CustomIntegerArrayBuilder builder = new CustomIntegerArrayBuilder();
        CustomIntegerArray arr = builder.fillArrRandom(10);
        SortCustomIntegerArrayService service = new SortCustomIntegerArrayService();
        service.selectionSort(arr);
        assertTrue(isSorted(arr));
    }

    @Test
    public void bubbleSortTest() {
        CustomIntegerArrayBuilder builder = new CustomIntegerArrayBuilder();
        CustomIntegerArray arr = builder.fillArrRandom(10);
        SortCustomIntegerArrayService service = new SortCustomIntegerArrayService();
        service.bubbleSort(arr);
        System.out.print(arr);
        assertTrue(isSorted(arr));
    }

    @Test
    public void insertionSortTest() {
        CustomIntegerArrayBuilder builder = new CustomIntegerArrayBuilder();
        CustomIntegerArray arr = builder.fillArrRandom(10);
        SortCustomIntegerArrayService service = new SortCustomIntegerArrayService();
        service.insertionSort(arr);
        assertTrue(isSorted(arr));
    }

    @Test
    public void binarySearchTest() {
        SortCustomIntegerArrayService sortService = new SortCustomIntegerArrayService();
        SearchService searchService = new SearchService();
        CustomIntegerArrayService customIntegerArrayService = new CustomIntegerArrayService();
        CustomIntegerArray arrSearch = customIntegerArrayService.copyCustomIntegerArray(array);
        sortService.insertionSort(arrSearch);
        int actual = searchService.binarySearch(arrSearch, 5, 0, array.getValues().length);
        int expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    public void findMinElementTest() {
        SearchService searchService = new SearchService();
        int actual = searchService.findMinElement(array);
        int expected = 5;
        assertEquals(actual, expected);
    }

    @Test
    public void findMaxElementTest() {
        SearchService searchService = new SearchService();
        int actual = searchService.findMaxElement(array);
        int expected = 7;
        assertEquals(actual, expected);
    }

    @Test
    public void findAllSimpleElementTest() {
        SearchService searchService = new SearchService();
        CustomIntegerArray actual = searchService.findAllSimpleElement(array);
        CustomIntegerArray expected = new CustomIntegerArray(new int[]{array.getValues()[3], array.getValues()[6]});
        assertTrue(expected.equals(actual));
    }

    @Test
    public void findAllFibonacciElementTest() {
        SearchService searchService = new SearchService();
        CustomIntegerArray actual = searchService.findAllFibonacciElement(array);
        CustomIntegerArray expected = new CustomIntegerArray(new int[]{array.getValues()[0], array.getValues()[3], array.getValues()[8]});
        assertTrue(expected.equals(actual));
    }

    @Test
    public void findAllNoDuplicateNumbersInElementTest() {
        SearchService searchService = new SearchService();
        CustomIntegerArray arr = new CustomIntegerArray(new int[]{1, 123, 554, 5, 20, -10, 7, 745, 34});
        CustomIntegerArray actual = searchService.findAllNoDuplicateNumbersInElement(arr);
        CustomIntegerArray expected = new CustomIntegerArray(new int[]{arr.getValues()[1], arr.getValues()[7]});
        assertTrue(expected.equals(actual));
    }

    private CustomIntegerJaggedArray Array() {
        CustomIntegerArray[] arr = new CustomIntegerArray[3];
        arr[0] = new CustomIntegerArray(new int[]{5, 135, -100, 55, -40}); //55
        arr[1] = new CustomIntegerArray(new int[]{1500, -1000, -550});     //-50
        arr[2] = new CustomIntegerArray(new int[]{-1500, 1000, 580, 25}); //105

        return new CustomIntegerJaggedArray(arr);
    }

    @Test
    public void sortBySumsElementsTest() {
        SortCustomIntegerJaggedArrayService sortCustomIntegerJaggedArrayService = new SortCustomIntegerJaggedArrayService();
        CustomIntegerJaggedArray actual = Array();
        CustomIntegerJaggedArray expected = new CustomIntegerJaggedArray(new CustomIntegerArray[]{actual.getArrays()[2], actual.getArrays()[0], actual.getArrays()[1]});
        sortCustomIntegerJaggedArrayService.sortBySumsElements(actual);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void reverseSortBySumsElementsTest() {
        SortCustomIntegerJaggedArrayService sortCustomIntegerJaggedArrayService = new SortCustomIntegerJaggedArrayService();
        CustomIntegerJaggedArray actual = Array();
        CustomIntegerJaggedArray expected = new CustomIntegerJaggedArray(new CustomIntegerArray[]{actual.getArrays()[1], actual.getArrays()[0], actual.getArrays()[2]});
        sortCustomIntegerJaggedArrayService.reverseSortBySumsElements(actual);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void sortByMaxElementTest() {
        SortCustomIntegerJaggedArrayService sortCustomIntegerJaggedArrayService = new SortCustomIntegerJaggedArrayService();
        CustomIntegerJaggedArray actual = Array();
        CustomIntegerJaggedArray expected = new CustomIntegerJaggedArray(new CustomIntegerArray[]{actual.getArrays()[1], actual.getArrays()[2], actual.getArrays()[0]});
        sortCustomIntegerJaggedArrayService.sortByMaxElement(actual);
        System.out.print(actual);
        assertTrue(expected.equals(actual));

    }

    @Test
    public void reverseSortByMaxElementTest() {
        SortCustomIntegerJaggedArrayService sortCustomIntegerJaggedArrayService = new SortCustomIntegerJaggedArrayService();
        CustomIntegerJaggedArray actual = Array();
        CustomIntegerJaggedArray expected = new CustomIntegerJaggedArray(new CustomIntegerArray[]{actual.getArrays()[0], actual.getArrays()[2], actual.getArrays()[1]});
        sortCustomIntegerJaggedArrayService.reverseSortByMaxElement(actual);
        System.out.print(actual);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void sortByMinElementTest() {
        SortCustomIntegerJaggedArrayService sortCustomIntegerJaggedArrayService = new SortCustomIntegerJaggedArrayService();
        CustomIntegerJaggedArray actual = Array();
        CustomIntegerJaggedArray expected = new CustomIntegerJaggedArray(new CustomIntegerArray[]{actual.getArrays()[0], actual.getArrays()[1], actual.getArrays()[2]});
        sortCustomIntegerJaggedArrayService.sortByMinElement(actual);
        System.out.print(actual);
        assertTrue(expected.equals(actual));

    }

    @Test
    public void reverseSortByMinElementTest() {
        SortCustomIntegerJaggedArrayService sortCustomIntegerJaggedArrayService = new SortCustomIntegerJaggedArrayService();
        CustomIntegerJaggedArray actual = Array();
        CustomIntegerJaggedArray expected = new CustomIntegerJaggedArray(new CustomIntegerArray[]{actual.getArrays()[2], actual.getArrays()[1], actual.getArrays()[0]});
        sortCustomIntegerJaggedArrayService.reverseSortByMinElement(actual);
        System.out.print(actual);
        assertTrue(expected.equals(actual));
    }
}