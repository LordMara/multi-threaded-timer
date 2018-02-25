package com.codecool.krk.view;

import com.codecool.krk.model.Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class TimerView {
    private BufferedReader bufferedReader;

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String[] getUserInput() throws IOException{
        String[] userInput = this.bufferedReader.readLine().split("\\s+",2);
        return userInput;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayTimer(Timer timer) {
        System.out.println(timer);
    }

    public void displayTimers(List<Timer> timers) {
        for (Timer timer: timers) {
            System.out.println(timer);
        }
    }
}
