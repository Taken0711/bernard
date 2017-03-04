package net.taken.bernard.analysis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static net.taken.bernard.analysis.Effect.*;
import static  net.taken.bernard.analysis.SentenceAnalysis.*;

/**
 * Created by Jeremy on 26/02/2017.
 */
public class EffectAnalyzer extends AbstractAnalyzer {

    private static final Logger logger = LogManager.getLogger(EffectAnalyzer.class);
    
    private Map<String, Effect> effectMap = new HashMap<>();

    EffectAnalyzer() {
        try {
            URL url = getClass().getResource("effects.txt");
            Files.lines(Paths.get(url.toURI())).forEach(line -> {
                String[] lineArr = line.split(" ");
                if (lineArr.length != 2)
                    return;
                Effect effect = getEffect(lineArr[0]);
                Arrays.stream(lineArr[1].split(",")).forEach(word -> effectMap.put(word.toLowerCase().replaceAll("_", " "), effect));
            });
        } catch (URISyntaxException | IOException e) {
            logger.error(e);
        }
        logger.debug(effectMap);
    }

    @Override
    void hookAnalyze(String sentence, SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        int res = 0;
        for (String word : sentence.split(" ")) {
            int changeValue = effectMap.containsKey(word) ? effectMap.get(word).getEffectValue() : 0;
            logger.info(String.format("Analysed word: %s, value found: %s", word, changeValue));
            res += changeValue;
        }
        sentenceAnalysisBuilder.effect(res == 0 ? MEDIUM : (res > 0 ? POSITIVE : NEGATIVE));
    }
}
