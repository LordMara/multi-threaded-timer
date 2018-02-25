package com.codecool.krk.view;

import com.codecool.krk.model.Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class TimerViewImpl implements TimerView {
    private BufferedReader bufferedReader;

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public String[] getUserInput() throws IOException{
        String[] userInput = this.bufferedReader.readLine().split("\\s+",2);
        return userInput;
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayTimer(Timer timer) {
        System.out.println(timer);
    }

    @Override
    public void displayTimers(List<Timer> timers) {
        for (Timer timer: timers) {
            System.out.println(timer);
        }
    }
}
