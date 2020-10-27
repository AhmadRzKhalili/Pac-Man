package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
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


public class Ghost extends Creature{

    private Rectangle ghost = new Rectangle();

    public Ghost(Image img, double x, double y, double width, double height){
        super(img);
        Rectangle ghost = new Rectangle(x, y, width, height);
        setGhost(ghost);
    }

    public void setGhost(Rectangle ghost) {
        ImagePattern imgPattern = new ImagePattern(getImg());
        getGhost().setFill(imgPattern);
        this.ghost = ghost;
    }

    public Rectangle getGhost() {
        return ghost;
    }

}