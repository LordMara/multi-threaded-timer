package com.codecool.krk.model;

import com.codecool.krk.service.TimerService;

public class TimerFactoryImpl implements TimerFactory {
    private TimerService timerService;

    public TimerFactoryImpl(TimerService timerService) {
        this.timerService = timerService;
    }

    @Override
    public void createTimer(String[] userInput, TimerType timerType) throws IllegalArgumentException {
        switch (timerType) {
            case BASIC:
                createTimer(userInput);
                break;
            default:
                throw  new IllegalArgumentException("No such timer type");
        }
    }

    private void createTimer(String[] userInput) {
        String timerName = userInput[1];
        Timer existingTimer = this.timerService.findTimer(timerName);

        if (existingTimer != null) {
            restartTimer(existingTimer, timerName);
        } else {
            createNewTimer(timerName);
        }
    }

    private void restartTimer(Timer existingTimer, String timerName) {
        if (!existingTimer.isNotInterrupted()) {
            Timer newTimer = new BasicTimer(timerName, existingTimer.getSeconds());

            int timerIndex = Timer.getTimers().indexOf(existingTimer);
            Timer.getTimers().set(timerIndex, newTimer);

            newTimer.start();
        }
    }

    private void createNewTimer(String timerName) {
        Timer newTimer = new BasicTimer(timerName);
        Timer.getTimers().add(newTimer);
        newTimer.start();
    }
}
