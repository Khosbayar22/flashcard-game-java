package interfaces;

import java.util.ArrayList;
import java.util.List;

public interface FlashcardApp {
    List<FlashcardData> cards = new ArrayList<>();

    void initDatabase();
    void startApp();
}
