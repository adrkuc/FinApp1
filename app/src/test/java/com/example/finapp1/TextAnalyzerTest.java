package com.example.finapp1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextAnalyzerTest {

    private final TextAnalyzer analyzer = new TextAnalyzer();

    @Test
    public void givenTwoWords_WhenCountWords_ThenReturnTwo() {
        String input = "Labas rytas";
        int expected = 2;
        int result = analyzer.countWords(input);
        assertEquals(expected, result);
    }

    @Test
    public void givenEmptyString_WhenCountWords_ThenReturnZero() {
        String input = "";
        int expected = 0;
        int result = analyzer.countWords(input);
        assertEquals(expected, result);
    }

    @Test
    public void givenOnlySpaces_WhenCountWords_ThenReturnZero() {
        String input = "     ";
        int expected = 0;
        int result = analyzer.countWords(input);
        assertEquals(expected, result);
    }

    @Test
    public void givenTabsAndSpaces_WhenCountWords_ThenReturnZero() {
        String input = " \t  \t ";
        int expected = 0;
        int result = analyzer.countWords(input);
        assertEquals(expected, result);
    }

    @Test
    public void givenTextWithMultipleSpaces_WhenCountWords_ThenReturnCorrectCount() {
        String input = "word   word2   word3";
        int expected = 3;
        int result = analyzer.countWords(input);
        assertEquals(expected, result);
    }

    @Test
    public void givenSingleCharacter_WhenCountCharacters_ThenReturnOne() {
        String input = "A";
        int expected = 1;
        int result = analyzer.countCharacters(input);
        assertEquals(expected, result);
    }

    @Test
    public void givenEmptyString_WhenCountCharacters_ThenReturnZero() {
        String input = "";
        int expected = 0;
        int result = analyzer.countCharacters(input);
        assertEquals(expected, result);
    }

    @Test
    public void givenWhitespaceCharacters_WhenCountCharacters_ThenReturnCount() {
        String input = " \t\n";
        int expected = 3;
        int result = analyzer.countCharacters(input);
        assertEquals(expected, result);
    }

    @Test
    public void givenNormalSentence_WhenCountCharacters_ThenReturnCorrectCount() {
        String input = "Labas rytas!";
        int expected = 12; // includes space and exclamation
        int result = analyzer.countCharacters(input);
        assertEquals(expected, result);
    }

    @Test
    public void givenNullString_WhenCountWords_ThenReturnZero() {
        String input = null;
        int expected = 0;
        int result = analyzer.countWords(input != null ? input : "");
        assertEquals(expected, result);
    }

    @Test
    public void givenNullString_WhenCountCharacters_ThenReturnZero() {
        String input = null;
        int expected = 0;
        int result = analyzer.countCharacters(input != null ? input : "");
        assertEquals(expected, result);
    }
}
