package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.attribute.Auxiliary;
import net.taken.bernard.common.Sentence;
import net.taken.bernard.common.WordType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static net.taken.bernard.common.WordType.INTERROGATIVE_WORD;
import static org.junit.Assert.*;

/**
 * Created by user on 04/04/2017.
 */
public class AuxiliaryAnalyserTest {

    private static AuxiliaryAnalyser analyser;
    private Sentence withInterrogativeWord;
    private Sentence withoutInterrogativeWord;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        analyser = new AuxiliaryAnalyser();
    }

    @Before
    public void setUp() throws Exception {
        withInterrogativeWord = new Sentence("What is your name ?");
        withInterrogativeWord.setWordType("What", INTERROGATIVE_WORD);
        withoutInterrogativeWord = new Sentence("Are you happy ?");
    }

    @Test
    public void identifyAuxiliaryWhenThereIsInterrogativeWord() throws Exception {
        assertEquals(Auxiliary.Present.BE, analyser.getAuxiliary(withInterrogativeWord));
    }

    @Test
    public void identifyAuxiliaryWhenThereIsNoInterrogativeWord() throws Exception {
        assertEquals(Auxiliary.Present.BE, analyser.getAuxiliary(withoutInterrogativeWord));
    }

}