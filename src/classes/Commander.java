package classes;

import java.util.ArrayList;
import java.io.IOException;
import interfaces.FlashcardApp;

public class Commander implements FlashcardApp {
    private String state;
    final private static LocalConsole console = new LocalConsole();

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
        Database database = new Database();
        database.initDatabase();

        ArrayList<FlashcardApp> apps = new ArrayList<>();

        apps.add(new PlayFlashcard());
        apps.add(new EditFlashcard());
        apps.add(new LearnFlashcard());

        boolean flag = true;

        while (flag) {

            if (this.state.equals("idle")) {
                /* CHOICES */
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
                    case "exit":
                        flag = false;
                        break;
                    default:
                        console.say("Please, Select the options below");
                        this.state = "idle";
                        break;
                }
            } else if (this.state.equals("play")) {
                /* PLAY */
                apps.get(0).startApp();

                this.state = "idle";
            } else if (this.state.equals("manage")) {
                /* EDIT */
                apps.get(1).startApp();

                this.state = "idle";
            } else if (this.state.equals("learn")) {
                /* LEARN */
                apps.get(2).startApp();

                this.state = "idle";
            }
        }
        console.say("** Good bye! **");
    }
}
