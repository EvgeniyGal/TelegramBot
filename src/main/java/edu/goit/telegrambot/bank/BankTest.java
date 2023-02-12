package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.bank.privatbank.PrivatBank;
import edu.goit.telegrambot.currency.CurrencyType;

public class BankTest {
    public static void main(String[] args) {
        PrivatBank.getInstance().getCurrencyRate(CurrencyType.USD, 3);
    }
}