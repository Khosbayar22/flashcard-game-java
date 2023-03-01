package classes;

import java.io.IOException;

public class Commander {
    private String state;
    final private static Console console = new Console();

    public Commander(String state) {
        this.state = state;
    }

    public Commander() {
        this.state = "idle";
    }

    public void sayHello() {
        console.say("\n** Welcome! **\n");
    }

    public void startApp() {
        boolean flag = true;
        String option;

        while (flag) {
            if (this.state.equals("idle")) {
                /* СОНГОЛТ */
                console.say("Input the action ----------------");
                console.say("Play");
                console.say("Manage");
                console.say("Learn");
                console.say("< Exit");

                String input = console.readLine().trim().toLowerCase();
                switch (input) {
                    case "play":
                        this.state = "play";
                        break;
                    case "manage":
                        this.state = "manage";
                        break;
                    case "learn":
                        this.state = "learn";
                        break;
                    default:
                        flag = false;
                        break;
                }
            } else if (this.state.equals("play")) {
                /* ТОГЛОХ */
                console.say("Shuffle? [y/n]");
                option = console.readLine().trim().toLowerCase();
                boolean confirmShuffle = option.equals("y") ? true : false;

                PlayFlashcard flashcard = new PlayFlashcard(confirmShuffle);
                try {
                    flashcard.startApp();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                this.state = "idle";
            } else if (this.state.equals("manage")) {
                /* ЗАСАХ */
                EditFlashcard flashcard = new EditFlashcard();
                console.say("Input the action ----------------");
                console.say("+ Add");
                console.say("Edit");
                console.say("Delete");
                console.say("< Back");

                String input = console.readLine().trim().toLowerCase();
                try {
                    switch (input) {
                        case "add":
                            flashcard.addFlashcard();
                            break;
                        case "edit":
                            flashcard.editFlashcard();
                            break;
                        case "delete":
                            flashcard.deleteFlashcard();
                            break;
                        default:
                            this.state = "idle";
                            break;
                    }
                } catch (IOException e) {
                    console.say("Hello World");
                    e.printStackTrace();
                }
            } else if (this.state.equals("learn")) {
                /* СУРАХ */
                LearnFlashcard flashcard = new LearnFlashcard();
                try {
                    flashcard.startApp();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.state = "idle";
            }
        }
        console.say("** Good bye! **");
    }
}
