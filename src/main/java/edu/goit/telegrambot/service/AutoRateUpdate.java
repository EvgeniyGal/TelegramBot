package edu.goit.telegrambot.service;

import edu.goit.telegrambot.bank.Banks;

public class AutoRateUpdate{
    public static void update(){
        for (int i = 0; ; i++){
            try {
                Thread.sleep(600000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (Banks value : Banks.values()) {
                value.name();
            }
        }
    }
}
