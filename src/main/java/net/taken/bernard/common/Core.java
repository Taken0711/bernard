package net.taken.bernard.common;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Jeremy on 25/02/2017.
 */
public class Core {

    public static final String VERSION = "0.2a";
    private final Calendar firstStart = new GregorianCalendar(2017, 02, 25);

    private static final Logger logger = LogManager.getLogger(Core.class);
    private Model model;
    private Controller controller;



    public Core() {
        logger.info("Initializing system");
        model = new Model();
        controller = new ConsoleController(model);
    }

    public void start() {
        logger.info("Starting system");
        logger.info("System has successfully started");
        controller.displayView();
    }
}
