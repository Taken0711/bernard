package net.taken.bernard.analysis.analyser.data;

import net.taken.bernard.analysis.attribute.Effect;
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

import static net.taken.bernard.analysis.attribute.Effect.NEUTRAL;
import static net.taken.bernard.analysis.attribute.Effect.getEffect;

/**
 * Created by jerem on 31/03/2017.
 */
public class EffectData {

    private static final String PATH_TO_EFFECTS = "effects.txt";
    private static final Logger logger = LogManager.getLogger(EffectData.class);

    private Map<String, Effect> effectMap = new HashMap<>();

    public EffectData() {
        try {
            URL url = getClass().getResource(PATH_TO_EFFECTS);
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

    public Effect getWordEffect(String word) {
        return effectMap.getOrDefault(word.toLowerCase(), NEUTRAL);
    }

}
