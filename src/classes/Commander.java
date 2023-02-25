package classes;

import java.util.Scanner;

public class Commander {
    private String state;

    public Commander(String state) {
        this.state = state;
    }
    
    public Commander() {
        this.state = "idle";
    }

    public void sayHello() {
        System.out.println("\n** Тавтай морил! **\n");
    }
    
    public void startApp() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        String option;

        while (flag) {
            /* СОНГОЛТ */
            if (this.state.equals("idle")) {
                System.out.println("Та юу хийх вэ?");
                System.out.println("[1] Тоглох");
                System.out.println("[2] Өөрчлөлт оруулах");
                System.out.println("[3] Сурах");
                System.out.println("[4] < Гарах");

                option = scanner.nextLine();
                if (option.equals("1")) {
                    this.state = "play";
                } else if (option.equals("2")) {
                    this.state = "edit";
                } else if (option.equals("3")) {
                    this.state = "learn";
                } else {
                    flag = false;
                }
            /* ТОГЛОХ */
            } else if (this.state.equals("play")) {
                PlayFlashcard flashcard = new PlayFlashcard();
                System.out.println("Асуултуудыг самансаргүй байдлаар холих?");
                System.out.println("[y/n]");
                option = scanner.nextLine();
                // boolean confirmShuffle = option.equals("y") ? true : false;
                flashcard.startApp();
                this.state = "idle";
            /* ЗАСАХ */
            } else if (this.state.equals("edit")) {
                EditFlashcard flashcard = new EditFlashcard();
                System.out.println("Засах үйлдэл:");
                System.out.println("[1] + Нэмэх");
                System.out.println("[2] Засах");
                System.out.println("[3] Устгах");
                System.out.println("[4] < Буцах");

                option = scanner.nextLine();
                if (option.equals("1")) {
                    flashcard.addFlashcard();
                } else if (option.equals("2")) {
                    flashcard.editFlashcard();
                } else if (option.equals("3")) {
                    flashcard.deleteFlashcard();
                } else {
                    this.state = "idle";
                }
            /* СУРАХ */
            } else if (this.state.equals("learn")) {
                LearnFlashcard flashcard = new LearnFlashcard();
                flashcard.startApp();
                this.state = "idle";
            }
        }
    }
}
