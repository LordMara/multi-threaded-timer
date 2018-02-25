package com.codecool.krk.model;

import java.util.LinkedList;
import java.util.List;

public abstract class Timer extends Thread{
    protected static List<Timer> timers = new LinkedList<>();

    protected int seconds;
    // declared due to default implemented flag isInterrupted do not work correctly
    protected boolean notInterrupted;

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
    public abstract void run();

    @Override
    public String toString() {
        return String.format("Name: %s, ThreadId: %d, Seconds: %d",
                this.getName(), this.getId(), this.getSeconds());
    }
}
