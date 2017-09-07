package com.ice.ids;

import java.util.*;

public class Anagrams {

    public static List<List<String>> findAnagrams(List<String> words) {
        Map<String, List<String>> sortedStringToAnagramsMap = new HashMap<>();
        for (String s : words) {

            // First sort the string, then use it as a key, and then append
            // the original string as another value in the hashmap.
            char[] wordChars = s.toCharArray();
            Arrays.sort(wordChars);
            String sortedStr = new String(wordChars);
            if (!sortedStringToAnagramsMap.containsKey(sortedStr)) {
                sortedStringToAnagramsMap.put(sortedStr, new ArrayList<String>());
            }
            sortedStringToAnagramsMap.get(sortedStr).add(s);
        }

        List<List<String>> anagramGroups = new ArrayList<>();
        for (Map.Entry<String, List<String>> p :
                sortedStringToAnagramsMap.entrySet()) {
            if (p.getValue().size() >= 2) { // Found anagrams.
                anagramGroups.add(p.getValue());
            }
        }
        return anagramGroups;
    }

    public static void main(String[] args) {
        ArrayList<String> listOfWords = new ArrayList<String>();
        listOfWords.add("apt");
        listOfWords.add("cat");
        listOfWords.add("mat");
        listOfWords.add("tap");
        listOfWords.add("act");
        listOfWords.add("sat");
        listOfWords.add("pat");
        List<List<String>> anagrams = findAnagrams(listOfWords);
        anagrams.stream().forEach(x -> System.out.println(x.toString()));
    }
}
