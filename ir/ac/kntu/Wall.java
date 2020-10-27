package ir.ac.kntu;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Wall extends Obj {

    private Rectangle wall = new Rectangle();

    public Wall(double x, double y) {
        super(x, y);
        Rectangle wall = new Rectangle(x, y, 75, 75);
        wall.setFill(Color.LIGHTGREEN);
        setWall(wall);
    }

    public void setWall(Rectangle wall) {
        this.wall = wall;
    }

    public Rectangle getWall() {
        return wall;
    }
}