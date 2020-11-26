package com.sofy.array.builder;

import com.sofy.array.entity.CustomIntegerArray;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomIntegerArrayBuilder {
    private final String SELECTMESSAGE = "1. Random\n2. From console\n3. From file: ";
    private final String INPUTLENGTH = "\nLength: ";
    private final String INPUTPATH = "\nPath: ";
    private final String INVALIDINPUT = "\nInvalid input: ";

    static Logger logger = LogManager.getLogger();

    public CustomIntegerArray fillArr() {
        CustomIntegerArray array = new CustomIntegerArray(new int[0]);
        Scanner scanner = new Scanner(System.in);
        boolean k = true;
        while (k) {
            System.out.print(SELECTMESSAGE);
            int sel = scanner.nextInt();
            switch (sel) {
                case 1:
                    k = false;
                    System.out.print(INPUTLENGTH);
                    int length = scanner.nextInt();
                    array = fillArrRandom(length);
                    break;
                case 2:
                    k = false;
                    array = fillArrFromConsole();
                    break;
                case 3:
                    k = false;
                    System.out.print(INPUTPATH);
                    String path = scanner.next();
                    array = fillArrFromFile(path);
                    break;
                default:
                    System.out.print(INVALIDINPUT);
                    break;
            }
        }
        logger.info("Input array: {}", array);
        return array;
    }

    public CustomIntegerArray fillArrFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(INPUTLENGTH);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("input array[%d]: ", i);
            array[i] = scanner.nextInt();
        }

        return new CustomIntegerArray(array);
    }

    public CustomIntegerArray fillArrRandom(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 2000 - 1000);
        }

        return new CustomIntegerArray(array);
    }

    public CustomIntegerArray fillArrFromFile(String path) {
        CustomIntegerArray array = new CustomIntegerArray();
        try {
            Scanner s = new Scanner(new File(path));
            logger.info("Open file: {}", path);
            while (s.hasNext()) {
                int i = s.nextInt();
                array.add(i);
            }
        } catch (FileNotFoundException e) {
            logger.error("Can't open file {} {}", path, e);
        }

        return array;
    }
}
