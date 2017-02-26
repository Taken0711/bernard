package net.taken.bernard.common;

/**
 * Created by Jeremy on 25/02/2017.
 */
public abstract class Controller {

    protected Model model;
    protected ConsoleView view;

    public Controller(Model model) {
        this.model = model;
    }

    public void displayView() {
        view.display();
    }

    protected abstract void waitAnswer();

}
