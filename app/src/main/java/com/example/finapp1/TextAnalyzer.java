package com.example.finapp1;

public class TextAnalyzer {

    public int countWords(String text) {
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public int countCharacters(String text) {
        return text.length();
    }
}
