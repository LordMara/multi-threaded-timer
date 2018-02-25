package com.codecool.krk.model;

public class BasicTimer extends Timer {
    public BasicTimer(String name) {
        super(name);
    }

    public BasicTimer(String name, int seconds) {
        super(name, seconds);
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

}
