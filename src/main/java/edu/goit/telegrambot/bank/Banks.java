package edu.goit.telegrambot.bank;

public enum Banks {

    MONOBANK(MonoBank.getInstance()),
    PRIVATBANK(PrivatBank.getInstance()),
    NBUBANK(NBUBank.getInstance());

    private final Bank bank;

    Banks(Bank bank) {
        this.bank = bank;
    }

}
