package ir.ac.kntu;

/*
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.*;
//import javafx.stage.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.Group;
import javafx.scene.shape.*;*/

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
import javafx.util.Duration;

/**
 * @author Ahmad Reza Khalili
 */

public class Main extends Application {

    //SceneSetter/Controller->generate obstacle

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root, 1200, 825, Color.BLUE);     //a=75: 16a*12a
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pac-Man");
        primaryStage.getIcons().add(new Image("logo.png"));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);

        Controller controller = new Controller();

        controller.generateObstacles(root);
        controller.generateCoins(root);

        /*String imagePath = "red_ghost.png";
        Image image =  new Image(imagePath);
        ImagePattern iP = new ImagePattern(image);
        Rectangle rect = new Rectangle();
        double x = 800;
        double v = 50;
        rect.setX(75);
        rect.setY(610);
        rect.setWidth(50);
        rect.setHeight(50);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(3000));

        //Setting the node for the transition
        translateTransition.setNode(rect);

        //Setting the value of the transition along the x axis.
        translateTransition.setByX(700);

        //Setting the cycle count for the transition
        translateTransition.setCycleCount(-1);

        //Setting auto reverse value to false
        translateTransition.setAutoReverse(true);

        //Playing the animation


        rect.setFill(iP);

        root.getChildren().add(rect);
        root.getChildren().add(new ImageView(image));

        //root.getChildren().add(rect2);

        translateTransition.play();*/
        Image img = new Image("red_ghost.png");
        Ghost ghost = new Ghost(img, 155, 605, 60, 60);
        ImagePattern imgPattern = new ImagePattern(ghost.getImg());
        ghost.getGhost().setFill(imgPattern);
        ghost.movingVertically(835, 3000);
        root.getChildren().add(ghost.getGhost());

        Image img2 = new Image("green_ghost.png");
        Ghost ghost2 = new Ghost(img2, 1140, 10, 60, 60);
        ImagePattern imgPattern2 = new ImagePattern(ghost2.getImg());
        ghost2.getGhost().setFill(imgPattern2);
        ghost2.movingHorizontally(765, 2748.5);
        root.getChildren().add(ghost2.getGhost());
        primaryStage.show();

        /*try {
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }

    public static void main(String[] args) {
        launch(args);
    }
}
