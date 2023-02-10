package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.service.Bank;

public class NBUBank extends Bank {

    private static final NBUBank nbuBank = new NBUBank();

    private NBUBank(){}

    public static Bank getInstance(){
        return nbuBank;
    }

}
