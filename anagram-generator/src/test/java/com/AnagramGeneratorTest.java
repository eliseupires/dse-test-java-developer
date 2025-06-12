package com;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramGeneratorTest {

    @Test
    void testThreeLetters() {
        char[] input = {'a','b','c'};
        List<String> result = AnagramGenerator.generateAnagrams(input);
        assertEquals(6, result.size());
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("cba"));
    }

    @Test
    void testSingleLetter() {
        char[] input = {'p'};
        List<String> result = AnagramGenerator.generateAnagrams(input);
        assertEquals(1, result.size());
        assertEquals("p", result.get(0));
    }

    @Test
    void testEmptyInput() {
        char[] input = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AnagramGenerator.generateAnagrams(input);
        });
        assertEquals("Input must be non-empty.", exception.getMessage());
    }

    @Test
    void testNonAlphabeticInput() {
        char[] input = {'p','0','r','t'};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AnagramGenerator.generateAnagrams(input);
        });
        assertEquals("Input must contain only alphabetic characters.", exception.getMessage());
    }
}
