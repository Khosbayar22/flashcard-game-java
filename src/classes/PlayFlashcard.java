package classes;

import java.io.IOException;
import java.util.Random;

import interfaces.FlashcardApp;

public class PlayFlashcard extends ConnectDatabase implements FlashcardApp {
    private Boolean shuffle = false;

    public PlayFlashcard(Boolean shuffle) {
        this.shuffle = shuffle;
    }

    @Override
    public void startApp() throws IOException {
        Flashcard[] flashcards = this.initDatabase();

        Random generator = new Random();
        Integer correct = 0;

        for (int i = 0; i < flashcards.length; i++) {
            String sequenceString = Integer.toString(i + 1);
            String questionString = "";
            String answerString = "";
            if (this.shuffle) {
                Integer randIndex = generator.nextInt(flashcards.length - i);
                answerString = flashcards[randIndex].getAnswer();
                questionString = flashcards[randIndex].getQuestion();
            } else {
                questionString = flashcards[i].getQuestion();
                answerString = flashcards[i].getAnswer();
            }

            console.say("Cart #" + sequenceString + "----------------");
            console.say(questionString);

            String question = console.readLine();
            if (question.toLowerCase().equals(answerString)) {
                console.say("** Correct! **\n");
                correct += 1;
            } else {
                console.say("__ Wrong! The right answer is %s __", answerString);
            }
        }
        console.say("Total: %s / %s ----------------", flashcards.length, correct);
    }
}
