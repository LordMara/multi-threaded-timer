package com.codecool.krk.view;

import com.codecool.krk.controller.MenuOption;
import com.codecool.krk.model.Timer;

import java.io.IOException;
import java.util.List;

public interface TimerView {
    String[] getUserInput() throws IOException;

    void displayMessage(String message);

    void displayTimer(Timer timer);

    void displayTimers(List<Timer> timers);

    MenuOption getUserChoice(String[] userInput);
}
