CurrencyBot

A simple to use app to be up-to-date with currency rates of Ukrainian banks.

How to Run app.

1. Create interface BotConfig in package edu.goit.telegrambot.constants with the data that shows next:

package edu.goit.telegrambot.constants;

public interface BotConfig {

    String BOT_USERNAME = "Yout bot name";

    String BOT_TOKEN = "Your bot tocken";

    int CREATOR_ID = Your bot ID;

}

2. Run the AppLauncher.