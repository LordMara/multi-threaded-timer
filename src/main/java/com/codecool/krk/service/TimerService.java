package com.codecool.krk.service;

import com.codecool.krk.model.Timer;
import com.codecool.krk.view.TimerView;

public class TimerService {
    private TimerView timerView;

    public TimerService(TimerView timerView) {
        this.timerView = timerView;
    }

    public void checkTimer(String[] userInput) {
        if (userInput.length == 1) {
            this.timerView.displayTimers(Timer.getTimers());
        } else if (userInput.length == 2){
            String timerName = userInput[1];
            Timer timer = findTimer(timerName);

            if (timer != null) {
                this.timerView.displayTimer(timer);
            }
        }
    }

    public Timer findTimer(String timerName) {
        Timer searchedTimer = null;

        for (Timer timer: Timer.getTimers()) {
            if (timer.getName().equals(timerName)) {
                searchedTimer = timer;
                break;
            }
        }

        return searchedTimer;
    }

    public void validateArgumentsNumber(String[] userInput, String message) {
        if (userInput.length < 2) {
            throw new IllegalArgumentException(message);
        }
    }

    public boolean interruptAllTimers() {
        for (Timer timer: Timer.getTimers()) {
            timer.interrupt();
        }
        return true;
    }

    public boolean interruptTimer(String[] userInput) {
        boolean status = false;

        String timerName = userInput[1];
        Timer timer = findTimer(timerName);

        if (timer != null && timer.isNotInterrupted()) {
            timer.interrupt();
            status = true;
        }

        return status;
    }
}
