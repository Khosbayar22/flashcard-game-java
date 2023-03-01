package classes;

import java.io.IOException;
// import java.util.ArrayList;

import interfaces.FlashcardApp;

public class Commander implements FlashcardApp {
    private String state;
    final private static Console console = new Console();

    // Database db = new Database("filepath");
    // App = new App(db.connection);

    public Commander(String state) {
        this.state = state;
    }

    public Commander() {
        this.state = "idle";
    }

    public void sayHello() {
        console.say("\n** Welcome! **\n");
    }

    public void startApp() throws IOException {
        // Event listener
        Database database = new Database();
        database.initDatabase();

        // ArrayList<FlashcardApp> applications = new ArrayList<>();

        // applications.add(new EditFlashcard());
        // applications.add(new LearnFlashcard());
        // applications.add(new PlayFlashcard());

        boolean flag = true;

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
                PlayFlashcard flashcard = new PlayFlashcard();
                flashcard.startApp();

                this.state = "idle";
            } else if (this.state.equals("manage")) {
                /* ЗАСАХ */
                EditFlashcard flashcard = new EditFlashcard();
                flashcard.startApp();

                this.state = "idle";
            } else if (this.state.equals("learn")) {
                /* СУРАХ */
                LearnFlashcard flashcard = new LearnFlashcard();
                flashcard.startApp();

                this.state = "idle";
            }
        }
        console.say("** Good bye! **");
    }
}
