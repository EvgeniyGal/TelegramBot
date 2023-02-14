package banks;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.List;

public interface Requestable {
    static final Gson GSON = new Gson();
    static final HttpClient CLIENT = HttpClient.newHttpClient();
    static final String MB_URI = "https://api.monobank.ua/bank/currency";
    static final String NBU_URI = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    static final String PB_URI = "https://api.privatbank.ua/p24api/pubinfo?exchange";
    List<?> requestRate() throws IOException, InterruptedException;
}
