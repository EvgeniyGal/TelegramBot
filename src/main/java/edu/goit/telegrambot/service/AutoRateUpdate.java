package edu.goit.telegrambot.service;

import edu.goit.telegrambot.AppLauncher;
import edu.goit.telegrambot.bank.Banks;
import edu.goit.telegrambot.cbuser.CBUser;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AutoRateUpdate{
    public static void startAutoUpdate() {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        service.scheduleWithFixedDelay(new Task(), 10, 10, TimeUnit.MINUTES);
    }
    private static class Task implements Runnable {
        public void run() {
            autoUpdate();
        }
        private void autoUpdate() {
            for (Map.Entry<Long, CBUser> entry : AppLauncher.cbUsers.entrySet()) {
                for (Banks bank : entry.getValue().getBanks()) {
                    bank.getBank().updateRate();
                }
            }
        }
    }
}
