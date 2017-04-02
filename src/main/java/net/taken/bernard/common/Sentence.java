package net.taken.bernard.common;

import java.util.*;

/**
 * Created by jerem on 01/04/2017.
 */
public class Sentence {

    private final String sentence;
    private final List<String> wordList;
    private final Map<String, Optional<WordType>> stringWordTypeMap;
    private final Map<WordType, String> wordTypeStringMap;

    public Sentence(String sentence) {
        this.sentence = sentence;
        wordList = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        stringWordTypeMap = new LinkedHashMap<>();
        wordTypeStringMap = new LinkedHashMap<>();
        wordList.forEach(word -> stringWordTypeMap.put(word, Optional.empty()));
    }

    public String getSentence() {
        return sentence;
    }

    public List<String> getWordList() {
        return new ArrayList<>(wordList);
    }

    public Optional<WordType> getWordType(String word) {
        return stringWordTypeMap.get(word);
    }

    public String getWord(WordType wordType) {
        return wordTypeStringMap.get(wordType);
    }

    public void setWordType(String word, WordType wordType) {
        if (stringWordTypeMap.replace(word, Optional.of(wordType)) == null)
            throw new IllegalArgumentException("No such word");
        wordTypeStringMap.put(wordType, word);
    }

    public void joinWords (String... words) {
        joinWords(Arrays.asList(words));
    }

    public void joinWords (List<String> words) {
        // Test if all in the sentence
        if (!wordList.containsAll(words) || !stringWordTypeMap.keySet().containsAll(words))
            throw new IllegalArgumentException("Words aren't all in sentence");
        // Test if they are consecutive
        int indexOfFirstWord = wordList.indexOf(words.get(0));
        List<String> testIfConsecutive = wordList.subList(indexOfFirstWord, indexOfFirstWord+words.size());
        if (!words.equals(testIfConsecutive))
            throw new IllegalArgumentException("Words aren't consecutive");
        // Joining
        wordList.removeAll(words);
        words.forEach(stringWordTypeMap::remove);
        String joinedWord = String.join(" ", words);
        wordList.add(indexOfFirstWord, joinedWord);
        stringWordTypeMap.put(joinedWord, Optional.empty());
    }

}
