package classes;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConnectDatabase {
    static Console console = new Console();

    public Flashcard[] initDatabase() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("db.json"));
        StringBuilder jsonBuilder = new StringBuilder();
        String line = reader.readLine();

        while (line != null) {
            jsonBuilder.append(line);
            line = reader.readLine();
        }

        JSONArray jsonArray = new JSONArray(jsonBuilder.toString());
        Integer jsonLength = jsonArray.length();

        Flashcard[] result = new Flashcard[jsonLength];

        for (int i = 0; i < jsonLength; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            result[i] = new Flashcard(jsonObject.getString("answer"), jsonObject.getString("question"));
        }

        reader.close();
        return result;
    }

    public void updateDatabase(Flashcard[] Flashcard) throws IOException {
        console.say("** Success **");
        // FileOutputStream fileOut = new FileOutputStream(
        // "C:\\Users\\Khosbayar\\Documents\\must\\buteelt\\lab_2b\\flashcard-game-java\\db.json");
        // ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        // objectOut.writeObject(Flashcard);
    }
}
