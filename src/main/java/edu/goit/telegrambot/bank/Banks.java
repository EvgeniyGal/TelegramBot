package edu.goit.telegrambot.bank;

public enum Banks {

    MONOBANK(MonoBank.getInstance()),
    PRIVATBANK(PrivatBank.getInstance()),
    NBUBANK(NBUBank.getInstance());

    private Bank bank;

    Banks(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }
}
