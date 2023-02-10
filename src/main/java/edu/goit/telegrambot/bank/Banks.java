package edu.goit.telegrambot.bank;

public enum Banks {

    MONOBANK(MonoBank.getInstance()),
    PRIVATBANK(PrivatBank.getInstance()),
    NBUBANK(NBUBank.getInstance());

    Banks(Bank Bank) {

    }

}
