package net.taken.bernard.common;

import java.util.*;

/**
 * Created by jerem on 01/04/2017.
 */
public class Sentence {

    private final String sentenceString;
    private final List<String> wordList;
    private final Map<String, Optional<WordType>> stringWordTypeMap;
    private final Map<WordType, String> wordTypeStringMap;

    public Sentence(String sentenceString) {
        this.sentenceString = sentenceString;
        wordList = new ArrayList<>();
        Arrays.stream(sentenceString.split(" ")).filter(word -> !word.isEmpty()).forEach(wordList::add);
        stringWordTypeMap = new LinkedHashMap<>();
        wordTypeStringMap = new LinkedHashMap<>();
        wordList.forEach(word -> stringWordTypeMap.put(word, Optional.empty()));
    }

    public String getSentenceString() {
        return sentenceString;
    }

    public List<String> getWordList() {
        return new ArrayList<>(wordList);
    }

    public Optional<WordType> getWordType(String word) {
        return stringWordTypeMap.get(word);
    }

    public String getWord(IWordType wordType) {
        return wordTypeStringMap.get(wordType);
    }

    public void setWordType(String word, WordType wordType) {
        if (!stringWordTypeMap.containsKey(word))
            throw new IllegalArgumentException("No such word");
        stringWordTypeMap.replace(word, Optional.of(wordType));
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
