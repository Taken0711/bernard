package net.taken.bernard.common;

import net.taken.bernard.analysis.attribute.InterrogativeWord;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by jerem on 02/04/2017.
 */
public class SentenceTest {

    Sentence sentence;

    @Before
    public void setUp() throws Exception {
        sentence = new Sentence("Hi how are you ?");
    }

    @Test
    public void joinWordsAtTheStart() throws Exception {
        assertTrue(sentence.getWordList().containsAll(Arrays.asList("Hi", "how")));
        assertFalse(sentence.getWordList().contains("Hi how"));
        assertTrue(sentence.getWordType("Hi how") == null);
        sentence.joinWords("Hi", "how");
        assertTrue(sentence.getWordList().contains("Hi how"));
        assertFalse(sentence.getWordList().containsAll(Arrays.asList("Hi", "how")));
        assertTrue(sentence.getWordType("Hi how") != null);
    }

    @Test
    public void joinWordsAtTheMiddle() throws Exception {
        assertTrue(sentence.getWordList().containsAll(Arrays.asList("how", "are")));
        assertFalse(sentence.getWordList().contains("how are"));
        assertTrue(sentence.getWordType("how are") == null);
        sentence.joinWords("how", "are");
        assertTrue(sentence.getWordList().contains("how are"));
        assertFalse(sentence.getWordList().containsAll(Arrays.asList("how", "are")));
        assertTrue(sentence.getWordType("how are") != null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenJoinWordThatAreNotInSentence() throws Exception {
        assertFalse(sentence.getWordList().containsAll(Arrays.asList("Hi", "bro")));
        sentence.joinWords("Hi", "bro");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenJoinWordThatAreNotConsecutive() throws Exception {
        assertTrue(sentence.getWordList().containsAll(Arrays.asList("are", "how")));
        sentence.joinWords("are", "how");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSetWordTypeOfAWordThatIsNotInSentence() throws Exception {
        assertFalse(sentence.getWordList().contains("bro"));
        sentence.setWordType("bro", WordType.INTERROGATIVE_WORD);
    }
}
