package com.codecool.krk;

import com.codecool.krk.controller.TimerController;
import com.codecool.krk.controller.TimerControllerImpl;
import com.codecool.krk.model.TimerFactory;
import com.codecool.krk.model.TimerFactoryImpl;
import com.codecool.krk.service.TimerService;
import com.codecool.krk.service.TimerServiceImpl;
import com.codecool.krk.view.TimerView;
import com.codecool.krk.view.TimerViewImpl;


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
        TimerView timerView = new TimerViewImpl();
        TimerService timerService = new TimerServiceImpl(timerView);
        TimerFactory timerFactory = new TimerFactoryImpl(timerService);
        TimerController timerController = new TimerControllerImpl(timerFactory, timerView, timerService);

        App app = new App(timerController);

        return app;
    }

}
