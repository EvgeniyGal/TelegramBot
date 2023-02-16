package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.currency.CurrencyType;

import java.util.Currency;
import java.util.List;

public abstract class Bank {
    //!!! створюєм основні компоненти сінглтона !!!
    // private static "Bank" instance;
    private String name; //в моєму розумінні це імʼя банку
    private List<Currency> currencies;

    /*
    //!!! Конструктор сінглтона !!!
    private static synchronized "Bank"(){
        this.name = "Монобанк";
        updateRate();
    };

    //!!! Потрібно ще додати інстанс !!!
    //Приблизно так бачу сам код інстанс

    public static synchronized "Bank" getInstance() {
        if (instance == null) {
            instance = new "Bank"();
        }
        return instance;
    }*/

    abstract Currency getCurrency(CurrencyType curType, byte tolerance);
    abstract String getName();
    abstract void updateRate();


}
