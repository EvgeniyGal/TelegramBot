package edu.goit.telegrambot.service;

import edu.goit.telegrambot.AppLauncher;
import edu.goit.telegrambot.cbuser.CBUser;
import edu.goit.telegrambot.currencubot.CurrencyBot;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AutoSender {

    public static void startAutoSender() {

        Date currentDate = new Date();
        Calendar currentTime = Calendar.getInstance();
        currentTime.setTime(currentDate);

        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        scheduledExecutorService.scheduleWithFixedDelay(new SendTask(),
                60 - currentTime.get(Calendar.MINUTE), 60, TimeUnit.MINUTES);

    }

    private static class SendTask implements Runnable {

        public void run() {
            Date currentDate = new Date();
            Calendar currentTime = Calendar.getInstance();
            currentTime.setTime(currentDate);
            int currentHour = currentTime.get(Calendar.HOUR_OF_DAY);

            if (currentHour >= 9 && currentHour <= 18) {
                sendMessage(currentHour);
            }
        }

        private void sendMessage(int currentHour) {
            for (Map.Entry<Long, CBUser> entry : AppLauncher.cbUsers.entrySet()) {
                if (entry.getValue().getSendTime() == currentHour) {
                    CurrencyBot.getResponseHandler().replyToGetInfo(entry.getValue().getMessage(),
                            entry.getValue().getChatID());
                }
            }
        }
    }

}
