package classes;

import java.io.IOException;

import interfaces.FlashcardApp;

public class LearnFlashcard extends ConnectDatabase implements FlashcardApp {

    @Override
    public void startApp() throws IOException {
        console.say("\nLearn (Question | Answer) ----------------");
        Flashcard[] flashcards = this.initDatabase();
        for (int i = 0; i < flashcards.length; i++) {
            String questionString = flashcards[i].getQuestion();
            String answeString = flashcards[i].getAnswer();
            console.say("%s: %s | %s", Integer.toString(i + 1), questionString, answeString);
        }
    }

}
