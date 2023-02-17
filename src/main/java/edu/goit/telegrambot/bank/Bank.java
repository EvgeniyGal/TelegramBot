package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.constants.Constants;
import edu.goit.telegrambot.currency.Currency;
import edu.goit.telegrambot.currency.CurrencyType;


import java.math.RoundingMode;
import java.util.List;

public abstract class Bank {
    String name;
    List<Currency> currencies;

    abstract public void updateRate();

    public String getCurrencyRate(CurrencyType curType, byte tolerance) {
        StringBuilder builder = new StringBuilder();
        if (curType.equals(CurrencyType.USD)) {
            builder.append(Constants.USA_FLAG).append(curType.name()).append(": ");
        } else {
            builder.append(Constants.EU_FLAG).append(curType.name()).append(": ");
        }
        builder.append(currencies.stream()
                        .filter(item -> item.getType().equals(curType))
                        .map(it -> it.getBuyRate().setScale(tolerance, RoundingMode.HALF_UP))
                        .findFirst().orElseThrow())
                .append(" - ")
                .append(currencies.stream()
                        .filter(item -> item.getType().equals(curType))
                        .map(it -> it.getSellRate().setScale(tolerance, RoundingMode.HALF_UP))
                        .findFirst()
                        .orElseThrow());
        return builder.toString();
    }

    public String getName() {
        return name;
    }
}
