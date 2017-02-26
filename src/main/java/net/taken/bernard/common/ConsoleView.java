package net.taken.bernard.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created by Jeremy on 25/02/2017.
 */
public class ConsoleView extends View {

    private static final Logger logger = LogManager.getLogger(ConsoleView.class);
    private Writer wrt;


    public ConsoleView(Controller controller) {
        super(controller);
        wrt = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    @Override
    public void display() {
        display("JarvisOS [build 0.1a]\n(c) 2017 Taken Inc. All rights reserved.");
    }

    @Override
    public void speak(SpeakEvent event) {
        logger.info("Talk action received: " + event.getSays());
        display(event.getSays());
        controller.waitAnswer();
    }

    public void display(String str) {
        try {
            wrt.write(str);
            wrt.write("\n> ");
            wrt.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
