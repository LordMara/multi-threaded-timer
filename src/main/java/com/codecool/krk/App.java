package com.codecool.krk;

import com.codecool.krk.controller.TimerController;
import com.codecool.krk.model.TimerFactory;
import com.codecool.krk.service.TimerService;
import com.codecool.krk.view.TimerView;


public class App {
    private TimerController timerController;

    public App(TimerController timerController) {
        this.timerController = timerController;
    }

    public static void main(String[] args) {
        App app = setup();
        app.start();
    }

    private void start() {
        this.timerController.chooseOption();
    }

    private static App setup() {
        TimerView timerView = new TimerView();
        TimerService timerService = new TimerService(timerView);
        TimerFactory timerFactory = new TimerFactory(timerService);
        TimerController timerController = new TimerController(timerFactory, timerView, timerService);

        App app = new App(timerController);

        return app;
    }

}
