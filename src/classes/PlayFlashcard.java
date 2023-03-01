package classes;

import java.io.IOException;
import java.util.Random;

import interfaces.FlashcardApp;

public class PlayFlashcard implements FlashcardApp {
    static Console console = new Console();

    @Override
    public void startApp() throws IOException {
        console.say("Shuffle? [y/n]");
        String option = console.readLine().trim().toLowerCase();
        boolean confirmShuffle = option.equals("y") ? true : false;

        this.play(confirmShuffle);
    }

    private void play(Boolean shuffle) throws IOException {
        Flashcard[] flashcards = Database.flashcards;

        Random generator = new Random();
        Integer correct = 0;

        for (int i = 0; i < flashcards.length; i++) {
            String sequenceString = Integer.toString(i + 1);
            String questionString = "";
            String answerString = "";
            if (shuffle) {
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
