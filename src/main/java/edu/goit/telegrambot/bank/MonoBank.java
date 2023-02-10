package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.service.Bank;

public class MonoBank extends Bank {

    private static final MonoBank monoBank = new MonoBank();

    private MonoBank(){}

    public static Bank getInstance(){
        return monoBank;
    }

}
