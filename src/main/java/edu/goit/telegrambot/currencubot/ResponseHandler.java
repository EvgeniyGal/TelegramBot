package edu.goit.telegrambot.currencubot;

import edu.goit.telegrambot.Main;
import edu.goit.telegrambot.bank.Banks;
import edu.goit.telegrambot.cbuser.CBUser;
import edu.goit.telegrambot.constants.Constants;
import org.telegram.abilitybots.api.sender.MessageSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;


public class ResponseHandler {

    private final MessageSender sender;

    public ResponseHandler(MessageSender sender) {
        this.sender = sender;
    }

    public void replyToStart(long chatId) {
        try {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(Constants.START_REPLY);
            sendMessage.setChatId(chatId);
            sendMessage.setReplyMarkup(KeyboardFactory.withInfoSetupButtons());
            sender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void replyToButtons(User user, long chatId, String buttonName) {
        if (Main.cbUsers.containsKey(user.getId())) {
            Main.cbUsers.get(user.getId()).setChatID(chatId);
        } else {
            Main.cbUsers.put(user.getId(), new CBUser(user.getId(), chatId));
        }

        switch (buttonName) {
            case Constants.GET_INFO_CB:
                replyToGetInfo(user, chatId);
                break;
            case Constants.SETUP_USER_CB:
                replyToSetupUser(chatId);
                break;
            case Constants.SET_BANK_CB:
                replyToSetupBank(user, chatId);
                break;
            case Constants.SET_TOLERANCE_CB:
                replyToSetupTolerance(user, chatId);
                break;
            case Constants.SET_CURRENCY_CB:
                replyToSetupCurrency(user, chatId);
                break;
            case Constants.SET_TIME_CB:
                replyToSetupTime(user, chatId);
                break;
            case Constants.SET_TWO_CB:
                Main.cbUsers.get(user.getId()).setTolerance((byte) 2);
                replyToSetupTolerance(user, chatId);
                break;
            case Constants.SET_THREE_CB:
                Main.cbUsers.get(user.getId()).setTolerance((byte) 3);
                replyToSetupTolerance(user, chatId);
                break;
            case Constants.SET_BANK_MONO_CB:
                List<Banks> banks = Main.cbUsers.get(user.getId()).getBanks();
                if (banks.contains(Banks.MONOBANK)) {
                    banks.remove(Banks.MONOBANK);
                } else {
                    banks.add(Banks.MONOBANK);
                }
                replyToSetupBank(user, chatId);
                break;
            case Constants.SET_BANK_PRIVAT_CB:
                banks = Main.cbUsers.get(user.getId()).getBanks();
                if (banks.contains(Banks.PRIVATBANK)) {
                    banks.remove(Banks.PRIVATBANK);
                } else {
                    banks.add(Banks.PRIVATBANK);
                }
                replyToSetupBank(user, chatId);
                break;
            case Constants.SET_BANK_NBU_CB:
                banks = Main.cbUsers.get(user.getId()).getBanks();
                if (banks.contains(Banks.NBUBANK)) {
                    banks.remove(Banks.NBUBANK);
                } else {
                    banks.add(Banks.NBUBANK);
                }
                replyToSetupBank(user, chatId);
                break;
        }
    }

    public void replyToGetInfo(User user, long chatId) {
        try {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText("\uD83D\uDD25" + user.getFirstName() + ", Скоро тут будуть курси валют \uD83D\uDD25");
            sendMessage.setChatId(chatId);
            sender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void replyToSetupUser(long chatId) {
        try {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(Constants.SETUP_USER_MESSAGE);
            sendMessage.setChatId(chatId);
            sendMessage.setReplyMarkup(KeyboardFactory.setupMenu());
            sender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void replyToSetupTime(User user, Long chatId) {
        try {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(Constants.TIME_SETUP_MESSAGE);
            sendMessage.setChatId(chatId);
            sendMessage.setReplyMarkup(KeyboardFactory.setupTime(Main.cbUsers.get(user.getId())));
            sender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void replyToSetupCurrency(User user, Long chatId) {
        try {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(Constants.CURRENCY_SETUP_MESSAGE);
            sendMessage.setChatId(chatId);
            sendMessage.setReplyMarkup(KeyboardFactory.setupCurrency(Main.cbUsers.get(user.getId())));
            sender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void replyToSetupTolerance(User user, Long chatId) {
        try {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(Constants.TOLERANCE_SETUP_MESSAGE);
            sendMessage.setChatId(chatId);
            sendMessage.setReplyMarkup(KeyboardFactory.setupTolerance(Main.cbUsers.get(user.getId())));
            sender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void replyToSetupBank(User user, Long chatId) {
        try {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(Constants.BANK_SETUP_MESSAGE);
            sendMessage.setChatId(chatId);
            sendMessage.setReplyMarkup(KeyboardFactory.setupBank(Main.cbUsers.get(user.getId())));
            sender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
