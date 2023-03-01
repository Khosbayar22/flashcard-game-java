package classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import interfaces.FlashcardApp;

public class EditFlashcard extends ConnectDatabase implements FlashcardApp {
    private static LearnFlashcard learnFlashcard = new LearnFlashcard();

    @Override
    public void startApp() throws IOException {
    }

    public void addFlashcard() throws IOException {
        Flashcard[] flashcards = this.initDatabase();

        console.say("Question: ");
        String answerString = console.readLine();
        console.say("Answer: ");
        String questionString = console.readLine();

        Flashcard newFlashcard = new Flashcard(answerString, questionString);
        for (int i = 0; i < flashcards.length; i++) {
            if (flashcards[i] == null) {
                flashcards[i] = newFlashcard;
                break;
            }
        }
        this.updateDatabase(flashcards);
    }

    public void editFlashcard() throws IOException {
        Flashcard[] flashcards = this.initDatabase();
        console.say("Take card to update");
        Integer index = Integer.parseInt(console.readLine());
        learnFlashcard.startApp();

        console.say("Question: ");
        String answerString = console.readLine();
        console.say("Answer: ");
        String questionString = console.readLine();

        Flashcard newFlashcard = new Flashcard(answerString, questionString);
        flashcards[index] = newFlashcard;
    }

    public void deleteFlashcard() throws IOException {
        Flashcard[] flashcards = this.initDatabase();
        console.say("Take card to delete");
        learnFlashcard.startApp();
        Integer index = Integer.parseInt(console.readLine());
        for (int i = index; i < flashcards.length - 1; i++) {
            flashcards[i] = flashcards[i + 1];
        }
        flashcards[flashcards.length - 1] = null;
        this.updateDatabase(flashcards);
    }

}
