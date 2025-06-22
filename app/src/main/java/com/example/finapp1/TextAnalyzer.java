package com.example.finapp1;

public class TextAnalyzer {

    public int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public int countCharacters(String text) {
        return text.length();
    }
}
