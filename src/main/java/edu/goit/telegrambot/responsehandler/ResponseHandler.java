package edu.goit.telegrambot.responsehandler;

import java.util.Map;

import edu.goit.telegrambot.constants.Constants;
import edu.goit.telegrambot.constants.State;
import edu.goit.telegrambot.constants.keyboardfactory.KeyboardFactory;
import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.sender.MessageSender;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class ResponseHandler {

    private final MessageSender sender;
    private final Map<Long, State> chatStates;

    public ResponseHandler(MessageSender sender, DBContext db) {
        this.sender = sender;
        chatStates = db.getMap(Constants.CHAT_STATES);
    }

    public void replyToStart(long chatId) {
        try {
            sender.execute(new SendMessage().setText(Constants.START_REPLY)
                    .setChatId(chatId)
                    .setReplyMarkup(KeyboardFactory.withInfoSetupButtons()));
            chatStates.put(chatId, State.AWAITING_SENDINFO_OR_SETUP);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void replyToButtons(long chatId, String buttonId) {
        switch (buttonId) {
            case Constants.GET_INFO_CB:
                replyToGetInfo(chatId);
                break;
            case Constants.SETUP_USER_CB:
                replyToSetupUser(chatId);
                break;
        }
    }

    private void replyToGetInfo(long chatId) {
    }

    private void replyToSetupUser(long chatId) {

    }


}
