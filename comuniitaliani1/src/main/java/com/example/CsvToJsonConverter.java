import com.opencsv.CSVReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        String csvFile = "listacomuni.csv";  // Nome del file CSV di input
        String jsonFile = "output.json"; // Nome del file JSON di output

        try (CSVReader csvReader = new CSVReader(new FileReader(csvfile));
             FileWriter fileWriter = new FileWriter(jsonFile)) {

            String[] headers = csvReader.readNext(); // Legge la prima riga per ottenere gli header
            JSONArray jsonArray = new JSONArray();

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], nextLine[i]);
                }
                jsonArray.put(jsonObject);
            }

            // Scrive l'array JSON nel file di output
            fileWriter.write(jsonArray.toString(4)); // Indenta il JSON con 4 spazi

            System.out.println("Conversione completata! File JSON scritto in: " + jsonFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}