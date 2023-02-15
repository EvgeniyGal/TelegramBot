package edu.goit.telegrambot.BankCurrencyRateService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CurrencyRateService currencyRateService = new PrivatBankCurrencyRateService();
        System.out.println("currencyRateService.getCurrencyRate() = " + currencyRateService.getCurrencyRateDto());
        CurrencyRateService currencyRateService1 = new MonobankCurrencyRateService();
        System.out.println("currencyRateService1.getCurrencyRate() = " + currencyRateService1.getCurrencyRateDto());
        CurrencyRateService currencyRateService2 = new NbuCurrencyRateService();
        System.out.println("currencyRateService2.getCurrencyRate() = " + currencyRateService2.getCurrencyRateDto());

    }
}
