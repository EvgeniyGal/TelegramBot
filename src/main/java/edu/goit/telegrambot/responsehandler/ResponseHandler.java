package edu.goit.telegrambot.responsehandler;

import java.util.Map;

import edu.goit.telegrambot.constants.Constants;
import edu.goit.telegrambot.constants.State;
import edu.goit.telegrambot.keyboardfactory.KeyboardFactory;
import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.sender.MessageSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
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

    public void replyToButtons(long chatId, String buttonName) {
        switch (buttonName) {
            case Constants.GET_INFO_CB:
                replyToGetInfo(chatId);
                break;
            case Constants.SETUP_USER_CB:
                replyToSetupUser(chatId);
                break;
        }
    }

    private void replyToGetInfo(long chatId) {
        System.out.println("fromerepy" + chatId + "Getinfo");
    }

    private void replyToSetupUser(long chatId) {
        System.out.println("fromerepy" + chatId + "SetupUser");

    }


}
