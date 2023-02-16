package edu.goit.telegrambot.service;

import edu.goit.telegrambot.bank.Bank;
import edu.goit.telegrambot.bank.Banks;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class AutoRateUpdate{
    AutoRateUpdate(Bank bank){
        for (int i = 0; ;i++) {
            try {
                MINUTES.sleep(5);
                update();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void update(){
        for (Banks value : Banks.values()) {
            value.name();
        }
    }
}
