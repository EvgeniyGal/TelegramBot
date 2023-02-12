package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.bank.monobank.MonoBank;
import edu.goit.telegrambot.bank.nbu_bank.NBUBank;
import edu.goit.telegrambot.bank.privatbank.PrivatBank;

public enum Banks {

    MONOBANK(MonoBank.getInstance()),
    PRIVATBANK(PrivatBank.getInstance()),
    NBUBANK(NBUBank.getInstance());

    Banks(Bank Bank) {

    }

}
