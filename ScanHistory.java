package observatory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Guarda en memoria el historial de escaneos ejecutados desde la interfaz.
 */
public class ScanHistory {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final List<String> entries = new ArrayList<>();

    public void record(String station, String analyzer, String region) {
        String timestamp = LocalDateTime.now().format(FORMAT);
        entries.add("[" + timestamp + "] " + station + " + " + analyzer + " -> " + region);
    }

    public List<String> getEntries() {
        return Collections.unmodifiableList(entries);
    }

    public int size() {
        return entries.size();
    }

    public String getFormattedHistory() {
        if (entries.isEmpty()) {
            return "No scans have been executed yet.";
        }
        StringBuilder sb = new StringBuilder("=== Scan History ===\n");
        for (int i = 0; i < entries.size(); i++) {
            sb.append(i + 1).append(". ").append(entries.get(i)).append("\n");
        }
        return sb.toString();
    }
}
