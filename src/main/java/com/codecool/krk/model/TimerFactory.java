package com.codecool.krk.model;

public interface TimerFactory {
    void createTimer(String[] userInput, TimerType timerType) throws IllegalArgumentException;
}
