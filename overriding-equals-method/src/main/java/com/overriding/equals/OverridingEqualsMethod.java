package com.overriding.equals;

import java.util.ArrayList;
import java.util.List;

public class OverridingEqualsMethod {

    public static List<String> generateAnagrams(char[] input) {
        if (input == null || input.length == 0)
            throw new IllegalArgumentException("Input must be non-empty.");

        if (!new String(input).matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("Input must contain only alphabetic characters.");

        List<String> result = new ArrayList<>();

        generate(input, 0, result);

        return result;
    }

    private static void generate(char[] chars, int index, List<String> result) {
        //save original order
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            generate(chars, index + 1, result);
            swap(chars, index, i);
        }
    }

    //
    private static void swap(char[] arr, int i, int j) {
        if (i != j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        char [] input = {'a','b','c'};

        long start = System.nanoTime();
        List<String> result = generateAnagrams(input);
        result.forEach(System.out::println);
        long end = System.nanoTime();

        System.out.printf("Generated %d anagrams in %.3f ms%n", result.size(), (end - start) / 1e6);
    }
}
