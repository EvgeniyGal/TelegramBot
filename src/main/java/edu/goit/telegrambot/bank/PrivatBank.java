package edu.goit.telegrambot.bank;

public class PrivatBank extends Bank {
    private static final PrivatBank privatBank = new PrivatBank();

    private PrivatBank(){}

    public static Bank getInstance(){
        return privatBank;
    }


}
