package src;

import src.controller.Personcontroller;
import src.view.PersonView;

public class App {

    public static void main(String[] args) {
        PersonView view = new PersonView();
        new Personcontroller(view);
        view.setVisible(true);
    }
}
