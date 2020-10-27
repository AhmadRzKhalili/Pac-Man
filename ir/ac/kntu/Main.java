package ir.ac.kntu;

import java.io.FileReader;
import java.io.BufferedReader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.application.Platform;

/**
 * @author Ahmad Reza Khalili
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Group root = new Group();
        Scene scene = new Scene(root, 1200, 925, Color.BLUE);

        Controller controller = new Controller();
        Status status = new Status(root);
        Thread t = new Thread(status);

        controller.readMap(root);

        Text score = new Text();
        score.setX(1025);
        score.setY(900);
        score.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,35));

        Text life = new Text();
        life.setX(75);
        life.setY(900);
        life.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,35));

        root.getChildren().add(score);
        root.getChildren().add(life);

        controller.printMap();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Pac-Man");
        primaryStage.getIcons().add(new Image("logo.png"));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                controller.moveRightPacMan();
                score.setText(controller.printScore());
                life.setText(controller.printLife());
                root.getChildren().add(score);
                root.getChildren().add(life);
            }
            if (e.getCode() == KeyCode.LEFT) {
                controller.moveLeftPacMan();
                score.setText(controller.printScore());
                life.setText(controller.printLife());
                root.getChildren().add(score);
                root.getChildren().add(life);
            }
            if (e.getCode() == KeyCode.UP) {
                controller.moveUpPacMan();
                score.setText(controller.printScore());
                life.setText(controller.printLife());
                root.getChildren().add(score);
                root.getChildren().add(life);
            }
            if (e.getCode() == KeyCode.DOWN) {
                controller.moveDownPacMan();
                score.setText(controller.printScore());
                life.setText(controller.printLife());
                root.getChildren().add(score);
                root.getChildren().add(life);
            }
            if(controller.getLife() == 0) {
                status.setLost(true);
//                t.run();
                Thread.sleep(3000);
                Platform.exit();
            }
            if(controller.getScore() == 151) {
                t.run();
                Platform.exit();
            }
        });

    }

    public static void main(String[] args) throws Exception{
//        launch(args);
        
    }
}