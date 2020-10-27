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

public class PacMan extends Creature {

    private Circle pacMan = new Circle();

    public PacMan(Image img, double x, double y, double r){
        super(img);
        Circle pacMan = new Circle(x, y, r);
        setPacMan(pacMan);
    }

    public void setPacMan(Circle pacMan) {
        ImagePattern imgPattern = new ImagePattern(getImg());
        getPacMan().setFill(imgPattern);
        this.pacMan = pacMan;
    }

    public Circle getPacMan() {
        return pacMan;
    }

}