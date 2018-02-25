package com.codecool.krk.service;

import com.codecool.krk.model.Timer;

public interface TimerService {
    void checkTimer(String[] userInput);

    Timer findTimer(String timerName);

    void validateArgumentsNumber(String[] userInput, String message);

    boolean interruptAllTimers();

    boolean interruptTimer(String[] userInput);
}
