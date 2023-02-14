package banks;

import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import static banks.Requestable.*;

public class Privatebank implements Requestable{
    public List<PrivatebankData> requestRate() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(PB_URI))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        return GSON.fromJson(response.body(), new TypeToken<List<PrivatebankData>>(){}.getType());
    }
}
