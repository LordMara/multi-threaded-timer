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
                createBasicTimer(userInput);
                break;
            default:
                throw  new IllegalArgumentException("No such timer type");
        }
    }

    private void createBasicTimer(String[] userInput) {
        String timerName = userInput[1];
        Timer existingTimer = this.timerService.findTimer(timerName);

        if (existingTimer != null) {
            restartBasicTimer(existingTimer, timerName);
        } else {
            createNewBasicTimer(timerName);
        }
    }

    private void restartBasicTimer(Timer existingTimer, String timerName) {
        if (!existingTimer.isNotInterrupted()) {
            Timer newTimer = new BasicTimer(timerName, existingTimer.getSeconds());

            int timerIndex = Timer.getTimers().indexOf(existingTimer);
            Timer.getTimers().set(timerIndex, newTimer);

            newTimer.start();
        }
    }

    private void createNewBasicTimer(String timerName) {
        Timer newTimer = new BasicTimer(timerName);
        Timer.getTimers().add(newTimer);
        newTimer.start();
    }
}
