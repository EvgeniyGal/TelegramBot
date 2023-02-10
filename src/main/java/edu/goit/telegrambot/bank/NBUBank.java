package edu.goit.telegrambot.bank;

public class NBUBank extends Bank {

    private static final NBUBank nbuBank = new NBUBank();

    private NBUBank(){}

    public static Bank getInstance(){
        return nbuBank;
    }

}
