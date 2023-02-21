package edu.goit.telegrambot.service;

import edu.goit.telegrambot.bank.Banks;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AutoRateUpdate {
    public static void startAutoUpdate() {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        service.scheduleWithFixedDelay(new Task(), 10, 10, TimeUnit.MINUTES);
    }

    private static class Task implements Runnable {
        public void run() {
            for (Banks entry : Banks.values()) {
                entry.getBank().updateRate();
            }
        }
    }
}
