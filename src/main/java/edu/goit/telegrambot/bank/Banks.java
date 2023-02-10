package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.service.Bank;

public enum Banks {

    MONOBANK(MonoBank.getInstance()),
    PRIVATBANK(PrivatBank.getInstance()),
    NBUBANK(NBUBank.getInstance());

    Banks(Bank Bank) {

    }

}
