package com.codecool.krk.model;

import java.util.LinkedList;
import java.util.List;

public class Timer extends Thread {
    private static List<Timer> timers = new LinkedList<>();

    private int seconds;
    // declared due to default implemented flag isInterrupted do not work correctly
    private boolean notInterrupted;

    public Timer(String name) {
        super(name);

        this.seconds = 0;
        this.notInterrupted = true;
    }

    public Timer(String name, int seconds) {
        super(name);
        this.seconds = seconds;

        this.notInterrupted = true;
    }

    public static List<Timer> getTimers() {
        return timers;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isNotInterrupted() {
        return notInterrupted;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.seconds++;
                this.sleep(1000);
            } catch (InterruptedException e) {
                this.interrupt();
                this.notInterrupted = false;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s, ThreadId: %d, Seconds: %d",
                this.getName(), this.getId(), this.getSeconds());
    }
}
