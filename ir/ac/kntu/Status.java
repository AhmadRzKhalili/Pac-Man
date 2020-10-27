package ir.ac.kntu;

import javafx.scene.*;
import javafx.scene.text.*;

public class Status extends Thread{
    private Group root;
    private boolean lost = false;
    private Text gameStatus = new Text();

    public Status(Group root) {
        setRoot(root);
        gameStatus.setX(450);
        gameStatus.setY(450);
        gameStatus.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,50));
    }

    public void setRoot(Group root) {
        this.root = root;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public void run() {
        if(lost == true)
            printGameOver();
        else
            printWin();
        try {
            Thread.sleep(1000);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void printGameOver() {
        gameStatus.setText("Game over!");
        root.getChildren().add(gameStatus);
    }

    public void printWin() {
        gameStatus.setText("You win!");
        root.getChildren().add(gameStatus);
    }
}