package edu.goit.telegrambot.service;

import edu.goit.telegrambot.Main;
import edu.goit.telegrambot.cbuser.CBUser;
import edu.goit.telegrambot.currencubot.CurrencyBot;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AutoSender {

    public static void startAutoSender() {

        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        scheduledExecutorService.scheduleWithFixedDelay(new SendTask(), 0,1, TimeUnit.HOURS);

    }

    private static class SendTask implements Runnable {

        public void run() {

            Date currentDate = new Date();
            Calendar currentTime = Calendar.getInstance();
            currentTime.setTime(currentDate);
            int currentHour = currentTime.get(Calendar.HOUR);

            if (currentHour >= 9 && currentHour <= 18) {
                sendMessage(currentHour);
            }

        }

        private void sendMessage(int currentHour) {
            for (Map.Entry<Long, CBUser> entry : Main.cbUsers.entrySet()) {
                if (entry.getValue().getSendTime() == currentHour) {
                    CurrencyBot.getResponseHandler().replyToGetInfo(entry.getValue().getMessage(),
                            entry.getValue().getChatID());
                }
            }
        }
    }

}
