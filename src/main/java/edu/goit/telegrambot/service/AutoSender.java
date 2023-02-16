package edu.goit.telegrambot.service;

import edu.goit.telegrambot.Main;
import edu.goit.telegrambot.cbuser.CBUser;
import edu.goit.telegrambot.currencubot.CurrencyBot;

import java.util.*;

public class AutoSender {

    public static void startAutoSender() {

        System.out.println("Enter to start");

        Timer timer = new Timer();

        Date currentDate = new Date();

        Calendar startTime = Calendar.getInstance();
        startTime.setTime(currentDate);
        startTime.set(Calendar.HOUR_OF_DAY, 0);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.SECOND, 0);
        startTime.set(Calendar.MILLISECOND, 0);

        timer.schedule(new MyTask(), startTime.getTime(), 2 * 1000);

    }

    private static class MyTask extends TimerTask {

        public void run() {

            Date currentDate = new Date();
            Calendar startTime = Calendar.getInstance();
            startTime.setTime(currentDate);
            int currentHour = startTime.get(Calendar.SECOND);

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
