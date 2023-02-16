package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.currency.Currency;
import edu.goit.telegrambot.currency.CurrencyType;


import java.util.List;

public abstract class Bank {

    String name;
    List<Currency> currencies;

    abstract void updateRate();

    public String getCurrencyRate(CurrencyType curType, byte tolerance) {

//        TODO
//        Розробити метод
        return "Тут будуть курси в форматі: " + curType + " купівля _______ продаж _______ з точністю " + tolerance;
    }

    public String getName() {
        return name;
    }
}
