package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.JSONArray;
import org.json.JSONObject;

public class Database {
    static LocalConsole console = new LocalConsole();
    static Flashcard[] flashcards;

    public void initDatabase() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("db.txt"));
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

        Database.flashcards = result;
        reader.close();
    }

    public void updateDatabase(Flashcard[] Flashcard) throws IOException {
        JSONArray json = new JSONArray(Flashcard);
        FileWriter myWriter = new FileWriter("db.txt");
        String jsonString = json.toString();
        myWriter.write(jsonString);
        myWriter.close();
        console.say("** Success **");
        this.initDatabase();
    }
}
