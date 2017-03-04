package net.taken.bernard.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jeremy on 25/02/2017.
 */
public class ConsoleController extends Controller {

    private static final Logger logger = LogManager.getLogger(ConsoleController.class);
    private BufferedReader rdr;

    public ConsoleController (Model model) {
        super(model);
        rdr = new BufferedReader(new InputStreamReader(System.in));
        view = new ConsoleView(this);
        addListenerToModel();
    }

    private void addListenerToModel() {
        model.addSpeakEventListener(view);
    }

    @Override
    public void displayView() {
        super.displayView();
        waitAnswer();
    }

    @Override
    protected void waitAnswer() {
        try {
            String ans = rdr.readLine();
            model.analyseSentence(ans);
        } catch (IOException e) {
            logger.error(e);
        }
    }


}
