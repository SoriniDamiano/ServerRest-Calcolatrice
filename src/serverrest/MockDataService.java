package serverrest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockDataService {
    // La lista è statica così i dati "restano vivi" tra una chiamata e l'altra
    private static List<Map<String, Object>> utenti = new ArrayList<>();

    static {
        // Un utente di esempio già presente all'avvio
        Map<String, Object> u1 = new HashMap<>();
        u1.put("_id", "123");
        u1.put("email", "test@example.com");
        u1.put("active", true);
        utenti.add(u1);
    }

    // Usato dal GetHandler
    public static List<Map<String, Object>> getUtenti() {
        return utenti;
    }

    // Usato dal PostHandler
    public static void addUtente(Map<String, Object> nuovoUtente) {
        utenti.add(nuovoUtente);
    }
}