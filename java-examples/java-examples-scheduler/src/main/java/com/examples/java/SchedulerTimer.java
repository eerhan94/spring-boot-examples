package com.examples.java;

import java.util.Date;
import java.util.TimerTask;

public class SchedulerTimerExample extends TimerTask {
    private String taskName;

    public SchedulerTimerExample(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + taskName + " executed " + new Date());
    }
    
}