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



}
