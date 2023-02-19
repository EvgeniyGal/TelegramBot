package edu.goit.telegrambot.cbuser;

import edu.goit.telegrambot.bank.Banks;
import edu.goit.telegrambot.constants.Constants;
import edu.goit.telegrambot.currency.CurrencyType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CBUser {
    private long chatID;
    private final List<Banks> banks;
    private byte tolerance;
    private final List<CurrencyType> curType;
    private byte sendTime;

    public CBUser(long chatID) {
        this.chatID = chatID;
        this.banks = new ArrayList<>();
        this.tolerance = 2;
        this.curType = new ArrayList<>();
        this.sendTime = 9;
        banks.add(Banks.MONOBANK);
        curType.add(CurrencyType.USD);
    }

    public void setChatID(long chatID) {
        this.chatID = chatID;
    }

    public void setTolerance(byte tolerance) {
        this.tolerance = tolerance;
    }

    public void setSendTime(byte sendTime) {
        this.sendTime = sendTime;
    }

    public long getChatID() {
        return chatID;
    }

    public List<Banks> getBanks() {
        return banks;
    }

    public byte getTolerance() {
        return tolerance;
    }

    public List<CurrencyType> getCurType() {
        return curType;
    }

    public byte getSendTime() {
        return sendTime;
    }

    public String getMessage() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.UA_FLAG)
                .append(" Доброго дня ")
                .append(Constants.UA_FLAG)
                .append("\n")
                .append("Курс валют на ")
                .append(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyyр.")))
                .append("\n\n");
        for (Banks bank : banks) {
            stringBuilder.append("в ")
                    .append(bank.getBank().getName()).append("\n");
            for (CurrencyType currency : curType) {
                stringBuilder.append(bank.getBank().getCurrencyRate(currency, tolerance)).append("\n");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();

    }
}
