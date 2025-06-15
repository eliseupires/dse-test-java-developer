package com.anagram.generator;

import java.util.ArrayList;
import java.util.List;

public class AnagramGenerator {
    //validating input

    public static void validateInput(char[] input) {
        if (input == null || input.length == 0)
            throw new IllegalArgumentException("Input must be non-empty.");

        if (!new String(input).matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("Input must contain only alphabetic characters.");

    }

    public static List<String> generateAnagrams(char[] input) {
        List<String> result = new ArrayList<>();

        generate(input, 0, result);

        return result;
    }

    //recursive method to swap letter in order to create anagrams and return the generated anagrams quantity
    private static void generate(char[] chars, int index, List<String> result) {
        //checking ifa new anagram is completed
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        //swapping letters until complete all anagrams with a letter in one fixed  position
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            generate(chars, index + 1, result);
            swap(chars, index, i);
        }
    }

    //swapping letters order
    private static void swap(char[] arr, int i, int j) {
        if (i != j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        char [] input = {'a','b','c','d','e','f'};

        long start = System.nanoTime();
        validateInput(input);
        List<String> result = generateAnagrams(input);
        result.forEach(System.out::println);
        long end = System.nanoTime();

        System.out.printf("Generated %d anagrams in %.3f ms%n", result.size(), (end - start) / 1e6);
    }
}
