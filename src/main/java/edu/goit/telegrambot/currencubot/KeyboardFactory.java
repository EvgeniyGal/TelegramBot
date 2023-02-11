package edu.goit.telegrambot.currencubot;

import edu.goit.telegrambot.constants.Constants;
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

    public static ReplyKeyboard setupTolerance() {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineFirst = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineSecond = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineThird = new ArrayList<>();
        InlineKeyboardButton setTwo = new InlineKeyboardButton();
        setTwo.setText("2");
        setTwo.setCallbackData(Constants.SET_TWO_CB);
        InlineKeyboardButton setThree = new InlineKeyboardButton();
        setThree.setText("3");
        setThree.setCallbackData(Constants.SET_THREE_CB);
        InlineKeyboardButton setFour = new InlineKeyboardButton();
        setFour.setText("4");
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

    public static ReplyKeyboard setupBank() {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineFirst = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineSecond = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineThird = new ArrayList<>();
        InlineKeyboardButton setMono = new InlineKeyboardButton();
        setMono.setText("Mono");
        setMono.setCallbackData(Constants.SET_BANK_MONO_CB);
        InlineKeyboardButton setPrivat = new InlineKeyboardButton();
        setPrivat.setText("Privat");
        setPrivat.setCallbackData(Constants.SET_BANK_PRIVAT_CB);
        InlineKeyboardButton setNBU = new InlineKeyboardButton();
        setNBU.setText("NBU");
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

    public static ReplyKeyboard setupCurrency() {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        InlineKeyboardButton setUSD = new InlineKeyboardButton();
        setUSD.setText("USD");
        setUSD.setCallbackData(Constants.SET_CURRENCY_USD_CB);
        InlineKeyboardButton setEUR = new InlineKeyboardButton();
        setEUR.setText("EUR");
        setEUR.setCallbackData(Constants.SET_CURRENCY_EUR_CB);
        rowInline.add(setUSD);
        rowInline.add(setEUR);
        rowsInline.add(rowInline);
        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }

    public static ReplyKeyboard setupTime() {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineFirst = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineSecond = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineThird = new ArrayList<>();
        List<InlineKeyboardButton> rowInlineFourth = new ArrayList<>();
        InlineKeyboardButton set9 = new InlineKeyboardButton();
        set9.setText("9");
        set9.setCallbackData(Constants.SET_BANK_MONO_CB);
        InlineKeyboardButton set10 = new InlineKeyboardButton();
        set10.setText("10");
        set10.setCallbackData(Constants.SET_BANK_PRIVAT_CB);
        InlineKeyboardButton set11 = new InlineKeyboardButton();
        set11.setText("11");
        set11.setCallbackData(Constants.SET_BANK_NBU_CB);
        InlineKeyboardButton set12 = new InlineKeyboardButton();
        set12.setText("10");
        set12.setCallbackData(Constants.SET_BANK_NBU_CB);
        InlineKeyboardButton set13 = new InlineKeyboardButton();
        set13.setText("10");
        set13.setCallbackData(Constants.SET_BANK_NBU_CB);
        InlineKeyboardButton set14 = new InlineKeyboardButton();
        set14.setText("10");
        set14.setCallbackData(Constants.SET_BANK_NBU_CB);
        InlineKeyboardButton set15 = new InlineKeyboardButton();
        set15.setText("10");
        set15.setCallbackData(Constants.SET_BANK_NBU_CB);
        InlineKeyboardButton set16 = new InlineKeyboardButton();
        set16.setText("10");
        set16.setCallbackData(Constants.SET_BANK_NBU_CB);
        InlineKeyboardButton set17 = new InlineKeyboardButton();
        set17.setText("10");
        set17.setCallbackData(Constants.SET_BANK_NBU_CB);
        InlineKeyboardButton set18 = new InlineKeyboardButton();
        set18.setText("10");
        set18.setCallbackData(Constants.SET_BANK_NBU_CB);




        rowInlineFirst.add(set9);
        rowInlineSecond.add(set10);
        rowInlineThird.add(set11);
        rowsInline.add(rowInlineFirst);
        rowsInline.add(rowInlineSecond);
        rowsInline.add(rowInlineThird);
        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }


}
