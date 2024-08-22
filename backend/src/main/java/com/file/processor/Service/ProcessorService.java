package com.file.processor.Service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProcessorService {

    public String processText(String content) {
        // Split the content into words
        String[] words = content.split("\\W+");

        // Count the occurrences of each word
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Find the most frequent word
        String mostFrequentWord = Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();

        // Replace the most frequent word with "foo" + word + "bar"
        return content.replaceAll("\\b" + mostFrequentWord + "\\b", "foo" + mostFrequentWord + "bar");
    }
}
