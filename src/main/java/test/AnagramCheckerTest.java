package test;

import org.example.AnagramChecker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramCheckerTest {

    @Test
    void testAreAnagrams_PositiveCase() {
        assertTrue(AnagramChecker.areAnagrams("listen", "silent"));
    }

    @Test
    void testAreAnagrams_NegativeCase() {
        assertFalse(AnagramChecker.areAnagrams("hello", "world"));
    }

    @Test
    void testAreAnagrams_SameString() {
        assertTrue(AnagramChecker.areAnagrams("hello", "hello"));
    }

    @Test
    void testAreAnagrams_EmptyStrings() {
        assertTrue(AnagramChecker.areAnagrams("", ""));
    }

    @Test
    void testAreAnagrams_WithSpaces() {
        assertTrue(AnagramChecker.areAnagrams("funeral", "real fun"));
    }

    @Test
    void testIsValidInput_ValidInput() {
        assertTrue(AnagramChecker.isValidInput("validInput"));
    }

    @Test
    void testIsValidInput_ContainsSpace() {
        assertFalse(AnagramChecker.isValidInput("contains space"));
    }

    @Test
    void testIsValidInput_ContainsNumber() {
        assertFalse(AnagramChecker.isValidInput("contains123number"));
    }

    @Test
    void testIsValidInput_EmptyString() {
        assertTrue(AnagramChecker.isValidInput(""));
    }

    @Test
    void testWriteToFile() {
        // This is a placeholder test for the writeToFile method, and it doesn't perform assertions.
        AnagramChecker.writeToFile("user", "word1", "word2", true);
    }
}
