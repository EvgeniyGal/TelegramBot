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



}
