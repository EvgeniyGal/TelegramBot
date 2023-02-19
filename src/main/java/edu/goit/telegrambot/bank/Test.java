package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.currency.CurrencyType;

public class Test {
    public static void main(String[] args) {
        Bank bank = MonoBank.getInstance();
        System.out.println(bank.getCurrencyRate(CurrencyType.EUR, (byte) 2));
        System.out.println(bank.getCurrencyRate(CurrencyType.USD, (byte) 4));

        Bank bank1= NBUBank.getInstance();
        System.out.println(bank1.getCurrencyRate(CurrencyType.EUR, (byte) 2));
        System.out.println(bank1.getCurrencyRate(CurrencyType.USD, (byte) 4));

    }
}
