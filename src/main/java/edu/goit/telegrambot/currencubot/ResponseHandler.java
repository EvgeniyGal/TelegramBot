package edu.goit.telegrambot.currencubot;

import java.util.Map;

import edu.goit.telegrambot.constants.Constants;
import edu.goit.telegrambot.constants.State;
import edu.goit.telegrambot.currencubot.KeyboardFactory;
import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.sender.MessageSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class ResponseHandler {

    private final MessageSender sender;
    private final Map<Long, State> chatStates;

    public ResponseHandler(MessageSender sender, DBContext db) {
        this.sender = sender;
        chatStates = db.getMap(Constants.CHAT_STATES);
    }

    public void replyToStart(long chatId) {
        try {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(Constants.START_REPLY);
            sendMessage.setChatId(chatId);
            sendMessage.setReplyMarkup(KeyboardFactory.withInfoSetupButtons());
            sender.execute(sendMessage);
            chatStates.put(chatId, State.AWAITING_SENDINFO_OR_SETUP);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void replyToButtons(User user, long chatId, String buttonName) {
        switch (buttonName) {

            case Constants.GET_INFO_CB:
                replyToGetInfo(user, chatId);
                break;
            case Constants.SETUP_USER_CB:
                replyToSetupUser(user, chatId);
                break;
        }
    }

    private void replyToGetInfo(User user, long chatId) {

        try {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText("\uD83D\uDD25" + user.getFirstName() + ", Скоро тут будуть курси валют \uD83D\uDD25");
            sendMessage.setChatId(chatId);
            sender.execute(sendMessage);
            chatStates.put(chatId, State.AWAITING_INFO);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    private void replyToSetupUser(User user, long chatId) {
        try {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText("\uD83D\uDD25" + user.getFirstName() + ", Скоро тут буде меню по налаштуванню бота \uD83D\uDD25" +
                    "\n chat ID" + chatId);
            sendMessage.setChatId(chatId);
            sender.execute(sendMessage);
            chatStates.put(chatId, State.AWAITING_FO_SETUPCOMMAND);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


}
