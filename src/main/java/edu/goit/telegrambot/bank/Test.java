package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.currency.CurrencyType;

public class Test {
    public static void main(String[] args) {
        Bank bank = MonoBank.getInstance();
        System.out.println(bank.getCurrencyRate(CurrencyType.EUR, (byte) 2));
        System.out.println(bank.getCurrencyRate(CurrencyType.USD, (byte) 4));
    }
}
