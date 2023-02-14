package tbot;

import Utils.Data;
import Utils.Settings;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.util.WebhookUtils;

import java.util.ArrayList;
import java.util.List;

// Bottable інтерфейс в якому є статичні поля токену та id
public class TelegramBot extends DefaultAbsSender implements LongPollingBot,Bottable {
    Data data = new Data();
    protected TelegramBotStarter(DefaultBotOptions options, String botToken) {
        super(options, botToken);
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();
            long chatId = message.getFrom().getId();
            if (message.getText().equals("/start")){
                //Це потрібно реалізовувати через методи які прописати в окремому класі
                String text = "Ласкаво просимо. Цей бот допоможе відслідковувати актуальні курси валют";
                Settings defaultSet = new Settings();
                InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

                InlineKeyboardButton button1 = new InlineKeyboardButton();
                button1.setText("info");
                button1.setCallbackData("+");

                InlineKeyboardButton button2 = new InlineKeyboardButton();
                button2.setText("settings");
                button2.setCallbackData("settigsMessage");

                List<InlineKeyboardButton> buttonsRow1 = new ArrayList<>();
                buttonsRow1.add(button1);

                List<InlineKeyboardButton> buttonsRow2 = new ArrayList<>();
                buttonsRow2.add(button2);

                List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
                buttons.add(buttonsRow1);
                buttons.add(buttonsRow2);
                markup.setKeyboard(buttons);
                
                SendMessage smessage = new SendMessage();
                smessage.setChatId(chatId);
                smessage.setText(text);
                smessage.setReplyMarkup(markup);

                execute(smessage);
            } else if(update.hasCallbackQuery()){
                    try {
                        SendMessage sendMessage = new SendMessage();
                        sendMessage.setText(update.getCallbackQuery().getData());
                        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

             }
            // тут інші if за допомогою яких надається відповідь
    }

    @Override
    public void clearWebhook() throws TelegramApiRequestException {
        WebhookUtils.clearWebhook(this);
    }

    @SneakyThrows
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(new DefaultBotOptions(),TOKEN_BOT);
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }
}
