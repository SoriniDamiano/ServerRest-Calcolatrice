package serverrest;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.google.gson.Gson;
import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class PostUserHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Legge il JSON inviato nel corpo della richiesta
        Scanner s = new Scanner(exchange.getRequestBody()).useDelimiter("\\A");
        String body = s.hasNext() ? s.next() : "";

        Gson gson = new Gson();
        // Converte il JSON in una Mappa (senza bisogno di una classe User.java)
        Map<String, Object> nuovoUtente = gson.fromJson(body, Map.class);

        // Salva l'utente nel MockDataService
        MockDataService.addUtente(nuovoUtente);

        // Risposta di conferma
        String risposta = "{\"status\":\"success\"}";
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(201, risposta.length());
        exchange.getResponseBody().write(risposta.getBytes());
        exchange.getResponseBody().close();
    }
}