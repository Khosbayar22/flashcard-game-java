package interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface FlashcardApp {
    List<FlashcardData> cards = new ArrayList<>();

    Object initDatabase() throws IOException;

    void startApp() throws IOException;
}
