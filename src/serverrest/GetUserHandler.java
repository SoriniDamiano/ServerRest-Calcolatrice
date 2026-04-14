package serverrest;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.google.gson.Gson;
import java.io.IOException;

public class GetUserHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Gson gson = new Gson();
        // Prende i dati dal Service e li converte in JSON
        String json = gson.toJson(MockDataService.getUtenti());

        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, json.getBytes().length);
        exchange.getResponseBody().write(json.getBytes());
        exchange.getResponseBody().close();
    }
}