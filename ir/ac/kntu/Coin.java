package ir.ac.kntu;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Coin extends Obj {

    private double r;

    private Circle coin = new Circle();

    public Coin(double x, double y, double r) {
        super(x, y);
        setR(r);

        Circle coin = new Circle(x, y, r, Color.YELLOW);
        setCoin(coin);

    }

    public void setR(double r) {
        this.r = r;
    }

    public void setCoin(Circle coin) {
        this.coin = coin;
    }

    public double getR() {
        return r;
    }

    public Circle getCoin() {
        return coin;
    }
}