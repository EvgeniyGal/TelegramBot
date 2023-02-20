package edu.goit.telegrambot.currencubot;

import edu.goit.telegrambot.AppLauncher;
import edu.goit.telegrambot.bank.Banks;
import edu.goit.telegrambot.cbuser.CBUser;
import edu.goit.telegrambot.constants.Constants;
import edu.goit.telegrambot.currency.CurrencyType;
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
        if (AppLauncher.cbUsers.containsKey(user.getId())) {
            AppLauncher.cbUsers.get(user.getId()).setChatID(chatId);
        } else {
            AppLauncher.cbUsers.put(user.getId(), new CBUser(chatId));
        }

        switch (buttonName) {
            case Constants.GET_INFO_CB:
                replyToGetInfo(AppLauncher.cbUsers.get(user.getId()).getMessage(), chatId);
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
                AppLauncher.cbUsers.get(user.getId()).setTolerance((byte) 2);
                replyToSetupTolerance(user, chatId);
                break;
            case Constants.SET_THREE_CB:
                AppLauncher.cbUsers.get(user.getId()).setTolerance((byte) 3);
                replyToSetupTolerance(user, chatId);
                break;
            case Constants.SET_FOUR_CB:
                AppLauncher.cbUsers.get(user.getId()).setTolerance((byte) 4);
                replyToSetupTolerance(user, chatId);
                break;
            case Constants.SET_BANK_MONO_CB:
                List<Banks> banks = AppLauncher.cbUsers.get(user.getId()).getBanks();
                if (banks.contains(Banks.MONOBANK)) {
                    banks.remove(Banks.MONOBANK);
                } else {
                    banks.add(Banks.MONOBANK);
                }
                replyToSetupBank(user, chatId);
                break;
            case Constants.SET_BANK_PRIVAT_CB:
                banks = AppLauncher.cbUsers.get(user.getId()).getBanks();
                if (banks.contains(Banks.PRIVATBANK)) {
                    banks.remove(Banks.PRIVATBANK);
                } else {
                    banks.add(Banks.PRIVATBANK);
                }
                replyToSetupBank(user, chatId);
                break;
            case Constants.SET_BANK_NBU_CB:
                banks = AppLauncher.cbUsers.get(user.getId()).getBanks();
                if (banks.contains(Banks.NBUBANK)) {
                    banks.remove(Banks.NBUBANK);
                } else {
                    banks.add(Banks.NBUBANK);
                }
                replyToSetupBank(user, chatId);
                break;
            case Constants.SET_CURRENCY_USD_CB:
                List<CurrencyType> currencyTypes = AppLauncher.cbUsers.get(user.getId()).getCurType();
                if (currencyTypes.contains(CurrencyType.USD)) {
                    currencyTypes.remove(CurrencyType.USD);
                } else {
                    currencyTypes.add(CurrencyType.USD);
                }
                replyToSetupCurrency(user, chatId);
                break;
            case Constants.SET_CURRENCY_EUR_CB:
                currencyTypes = AppLauncher.cbUsers.get(user.getId()).getCurType();
                if (currencyTypes.contains(CurrencyType.EUR)) {
                    currencyTypes.remove(CurrencyType.EUR);
                } else {
                    currencyTypes.add(CurrencyType.EUR);
                }
                replyToSetupCurrency(user, chatId);
                break;
            case Constants.SET_TIME_9_CB:
                AppLauncher.cbUsers.get(user.getId()).setSendTime((byte) 9);
                replyToSetupTime(user, chatId);
                break;
            case Constants.SET_TIME_10_CB:
                AppLauncher.cbUsers.get(user.getId()).setSendTime((byte) 10);
                replyToSetupTime(user, chatId);
                break;
            case Constants.SET_TIME_11_CB:
                AppLauncher.cbUsers.get(user.getId()).setSendTime((byte) 11);
                replyToSetupTime(user, chatId);
                break;
            case Constants.SET_TIME_12_CB:
                AppLauncher.cbUsers.get(user.getId()).setSendTime((byte) 12);
                replyToSetupTime(user, chatId);
                break;
            case Constants.SET_TIME_13_CB:
                AppLauncher.cbUsers.get(user.getId()).setSendTime((byte) 13);
                replyToSetupTime(user, chatId);
                break;
            case Constants.SET_TIME_14_CB:
                AppLauncher.cbUsers.get(user.getId()).setSendTime((byte) 14);
                replyToSetupTime(user, chatId);
                break;
            case Constants.SET_TIME_15_CB:
                AppLauncher.cbUsers.get(user.getId()).setSendTime((byte) 15);
                replyToSetupTime(user, chatId);
                break;
            case Constants.SET_TIME_16_CB:
                AppLauncher.cbUsers.get(user.getId()).setSendTime((byte) 16);
                replyToSetupTime(user, chatId);
                break;
            case Constants.SET_TIME_17_CB:
                AppLauncher.cbUsers.get(user.getId()).setSendTime((byte) 17);
                replyToSetupTime(user, chatId);
                break;
            case Constants.SET_TIME_18_CB:
                AppLauncher.cbUsers.get(user.getId()).setSendTime((byte) 18);
                replyToSetupTime(user, chatId);
                break;
            case Constants.SET_TIME_STOP_CB:
                AppLauncher.cbUsers.get(user.getId()).setSendTime((byte) -1);
                replyToSetupTime(user, chatId);
                break;
        }
    }

    public void replyToGetInfo(String message, long chatId) {
        try {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(message);
            sendMessage.setReplyMarkup(KeyboardFactory.withInfoSetupButtons());
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
            sendMessage.setReplyMarkup(KeyboardFactory.setupTime(AppLauncher.cbUsers.get(user.getId())));
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
            sendMessage.setReplyMarkup(KeyboardFactory.setupCurrency(AppLauncher.cbUsers.get(user.getId())));
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
            sendMessage.setReplyMarkup(KeyboardFactory.setupTolerance(AppLauncher.cbUsers.get(user.getId())));
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
            sendMessage.setReplyMarkup(KeyboardFactory.setupBank(AppLauncher.cbUsers.get(user.getId())));
            sender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
