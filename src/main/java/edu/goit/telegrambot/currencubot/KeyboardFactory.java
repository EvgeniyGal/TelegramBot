package edu.goit.telegrambot.currencubot;

import edu.goit.telegrambot.bank.Banks;
import edu.goit.telegrambot.cbuser.CBUser;
import edu.goit.telegrambot.constants.Constants;
import edu.goit.telegrambot.currency.CurrencyType;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyboardFactory {

    public static ReplyKeyboard withInfoSetupButtons() {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        InlineKeyboardButton getInfo = new InlineKeyboardButton();
        getInfo.setText(Constants.GET_INFO_T);
        getInfo.setCallbackData(Constants.GET_INFO_CB);
        InlineKeyboardButton setupUser = new InlineKeyboardButton();
        setupUser.setText(Constants.SETUP_USER_T);
        setupUser.setCallbackData(Constants.SETUP_USER_CB);
        rowInline.add(getInfo);
        rowInline.add(setupUser);
        rowsInline.add(rowInline);
        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }

    public static ReplyKeyboard setupMenu() {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineFirst = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineSecond = new ArrayList<>();
        InlineKeyboardButton setTolerance = new InlineKeyboardButton();
        setTolerance.setText(Constants.SET_TOLERANCE_T);
        setTolerance.setCallbackData(Constants.SET_TOLERANCE_CB);
        InlineKeyboardButton setBank = new InlineKeyboardButton();
        setBank.setText(Constants.SET_BANK_T);
        setBank.setCallbackData(Constants.SET_BANK_CB);
        InlineKeyboardButton setCurrency = new InlineKeyboardButton();
        setCurrency.setText(Constants.SET_CURRENCY_T);
        setCurrency.setCallbackData(Constants.SET_CURRENCY_CB);
        InlineKeyboardButton setTime = new InlineKeyboardButton();
        setTime.setText(Constants.SET_TIME_T);
        setTime.setCallbackData(Constants.SET_TIME_CB);
        rowInlineFirst.add(setTolerance);
        rowInlineFirst.add(setBank);
        rowInlineSecond.add(setCurrency);
        rowInlineSecond.add(setTime);
        rowsInline.add(rowInlineFirst);
        rowsInline.add(rowInlineSecond);
        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }

    public static ReplyKeyboard setupTolerance(CBUser cbUser) {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineFirst = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineSecond = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineThird = new ArrayList<>();
        InlineKeyboardButton setTwo = new InlineKeyboardButton();
        setTwo.setText(cbUser.getTolerance() == 2 ? Constants.CHECK_SIGN + "2" : "2");
        setTwo.setCallbackData(Constants.SET_TWO_CB);
        InlineKeyboardButton setThree = new InlineKeyboardButton();
        setThree.setText(cbUser.getTolerance() == 3 ? Constants.CHECK_SIGN + "3" : "3");
        setThree.setCallbackData(Constants.SET_THREE_CB);
        InlineKeyboardButton setFour = new InlineKeyboardButton();
        setFour.setText(cbUser.getTolerance() == 4 ? Constants.CHECK_SIGN + "4" : "4");
        setFour.setCallbackData(Constants.SET_FOUR_CB);
        rowInlineFirst.add(setTwo);
        rowInlineSecond.add(setThree);
        rowInlineThird.add(setFour);
        rowsInline.add(rowInlineFirst);
        rowsInline.add(rowInlineSecond);
        rowsInline.add(rowInlineThird);
        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }

    public static ReplyKeyboard setupBank(CBUser cbUser) {

//        TO DO

        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineFirst = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineSecond = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineThird = new ArrayList<>();
        InlineKeyboardButton setMono = new InlineKeyboardButton();
        setMono.setText(cbUser.getBanks().contains(Banks.MONOBANK) ? Constants.CHECK_SIGN + "Монобанк" : "Монобанк");
        setMono.setCallbackData(Constants.SET_BANK_MONO_CB);
        InlineKeyboardButton setPrivat = new InlineKeyboardButton();
        setPrivat.setText(cbUser.getBanks().contains(Banks.PRIVATBANK) ? Constants.CHECK_SIGN + "Приватбанк" : "Приватбанк");
        setPrivat.setCallbackData(Constants.SET_BANK_PRIVAT_CB);
        InlineKeyboardButton setNBU = new InlineKeyboardButton();
        setNBU.setText(cbUser.getBanks().contains(Banks.NBUBANK) ? Constants.CHECK_SIGN + "НБУ" : "НБУ");
        setNBU.setCallbackData(Constants.SET_BANK_NBU_CB);
        rowInlineFirst.add(setMono);
        rowInlineSecond.add(setPrivat);
        rowInlineThird.add(setNBU);
        rowsInline.add(rowInlineFirst);
        rowsInline.add(rowInlineSecond);
        rowsInline.add(rowInlineThird);
        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }

    public static ReplyKeyboard setupCurrency(CBUser cbUser) {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        InlineKeyboardButton setUSD = new InlineKeyboardButton();
        setUSD.setText(cbUser.getCurType().contains(CurrencyType.USD) ? Constants.CHECK_SIGN + "USD" : "USD");
        setUSD.setCallbackData(Constants.SET_CURRENCY_USD_CB);
        InlineKeyboardButton setEUR = new InlineKeyboardButton();
        setEUR.setText(cbUser.getCurType().contains(CurrencyType.EUR) ? Constants.CHECK_SIGN + "EUR" : "EUR");
        setEUR.setCallbackData(Constants.SET_CURRENCY_EUR_CB);
        rowInline.add(setUSD);
        rowInline.add(setEUR);
        rowsInline.add(rowInline);
        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }

    public static ReplyKeyboard setupTime(CBUser cbUser) {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineFirst = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineSecond = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineThird = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineFourth = new ArrayList<>();
        InlineKeyboardButton set9 = new InlineKeyboardButton();
        set9.setText(cbUser.getSendTime() == 9 ? Constants.CHECK_SIGN + "9" : "9");
        set9.setCallbackData(Constants.SET_TIME_9_CB);
        InlineKeyboardButton set10 = new InlineKeyboardButton();
        set10.setText(cbUser.getSendTime() == 10 ? Constants.CHECK_SIGN + "10" : "10");
        set10.setCallbackData(Constants.SET_TIME_10_CB);
        InlineKeyboardButton set11 = new InlineKeyboardButton();
        set11.setText(cbUser.getSendTime() == 11 ? Constants.CHECK_SIGN + "11" : "11");
        set11.setCallbackData(Constants.SET_TIME_11_CB);
        InlineKeyboardButton set12 = new InlineKeyboardButton();
        set12.setText(cbUser.getSendTime() == 12 ? Constants.CHECK_SIGN + "12" : "12");
        set12.setCallbackData(Constants.SET_TIME_12_CB);
        InlineKeyboardButton set13 = new InlineKeyboardButton();
        set13.setText(cbUser.getSendTime() == 13 ? Constants.CHECK_SIGN + "13" : "13");
        set13.setCallbackData(Constants.SET_TIME_13_CB);
        InlineKeyboardButton set14 = new InlineKeyboardButton();
        set14.setText(cbUser.getSendTime() == 14 ? Constants.CHECK_SIGN + "14" : "14");
        set14.setCallbackData(Constants.SET_TIME_14_CB);
        InlineKeyboardButton set15 = new InlineKeyboardButton();
        set15.setText(cbUser.getSendTime() == 15 ? Constants.CHECK_SIGN + "15" : "15");
        set15.setCallbackData(Constants.SET_TIME_15_CB);
        InlineKeyboardButton set16 = new InlineKeyboardButton();
        set16.setText(cbUser.getSendTime() == 16 ? Constants.CHECK_SIGN + "16" : "16");
        set16.setCallbackData(Constants.SET_TIME_16_CB);
        InlineKeyboardButton set17 = new InlineKeyboardButton();
        set17.setText(cbUser.getSendTime() == 17 ? Constants.CHECK_SIGN + "17" : "17");
        set17.setCallbackData(Constants.SET_TIME_17_CB);
        InlineKeyboardButton set18 = new InlineKeyboardButton();
        set18.setText(cbUser.getSendTime() == 18 ? Constants.CHECK_SIGN + "18" : "18");
        set18.setCallbackData(Constants.SET_TIME_18_CB);
        InlineKeyboardButton setStop = new InlineKeyboardButton();
        setStop.setText(cbUser.getSendTime() == -1 ? Constants.CHECK_SIGN + "Відключити сповіщення" : "Відключити сповіщення");
        setStop.setCallbackData(Constants.SET_TIME_STOP_CB);

        rowInlineFirst.add(set9);
        rowInlineFirst.add(set10);
        rowInlineFirst.add(set11);

        rowInlineSecond.add(set12);
        rowInlineSecond.add(set13);
        rowInlineSecond.add(set14);

        rowInlineThird.add(set15);
        rowInlineThird.add(set16);
        rowInlineThird.add(set17);

        rowInlineFourth.add(set18);
        rowInlineFourth.add(setStop);

        rowsInline.add(rowInlineFirst);
        rowsInline.add(rowInlineSecond);
        rowsInline.add(rowInlineThird);
        rowsInline.add(rowInlineFourth);

        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }

}
