package com.codecool.krk.model;

import com.codecool.krk.service.TimerService;

public class TimerFactory {
    private TimerService timerService;

    public TimerFactory(TimerService timerService) {
        this.timerService = timerService;
    }

    public void createTimer(String[] userInput) {
        String timerName = userInput[1];
        Timer existingTimer = this.timerService.findTimer(timerName);

        if (existingTimer != null) {
            restartTimer(existingTimer, timerName);
        } else {
            Timer newTimer = new Timer(timerName);
            Timer.getTimers().add(newTimer);
            newTimer.start();
        }
    }

    private void restartTimer(Timer existingTimer, String timerName) {
        if (!existingTimer.isNotInterrupted()) {
            Timer newTimer = new Timer(timerName, existingTimer.getSeconds());

            int timerIndex = Timer.getTimers().indexOf(existingTimer);
            Timer.getTimers().set(timerIndex, newTimer);

            newTimer.start();
        }
    }
}
