package net.taken.bernard.common;

/**
 * Created by Jeremy on 25/02/2017.
 */
public enum Mode {

    SLEEPMODE("Zzzzz..."),
    ONLINE("Hi ! Can I do something for you ?");

    private String message;

    Mode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
