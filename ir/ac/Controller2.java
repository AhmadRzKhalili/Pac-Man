package ir.ac.kntu;

import javafx.scene.Group;
import javafx.geometry.*;
import java.util.ArrayList;

public class Controller {

    private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

    public void generateObstacles(Group root) {
        Obstacle obstacle1 = new Obstacle(75, 75, 75, 300);
        obstacles.add(obstacle1);
        Obstacle obstacle2 = new Obstacle(75, 450, 75, 300);
        obstacles.add(obstacle2);
        Obstacle obstacle3 = new Obstacle(225, 75, 300, 75);
        obstacles.add(obstacle3);
        Obstacle obstacle4 = new Obstacle(225, 225, 75, 375);
        obstacles.add(obstacle4);
        Obstacle obstacle5 = new Obstacle(375, 225, 450, 75);
        obstacles.add(obstacle5);
        Obstacle obstacle6 = new Obstacle(375, 375, 75, 225);
        obstacles.add(obstacle6);
        Obstacle obstacle7 = new Obstacle(225, 675, 750, 75);
        obstacles.add(obstacle7);
        Obstacle obstacle8 = new Obstacle(750, 375, 75, 225);
        obstacles.add(obstacle8);
        Obstacle obstacle9 = new Obstacle(900, 225, 75, 375);
        obstacles.add(obstacle9);
        Obstacle obstacle10 = new Obstacle(1050, 75, 75, 300);
        obstacles.add(obstacle10);
        Obstacle obstacle11 = new Obstacle(1050, 450, 75, 300);
        obstacles.add(obstacle11);
        Obstacle obstacle12 = new Obstacle(675, 75, 300, 75);
        obstacles.add(obstacle12);

        root.getChildren().add(obstacle1.getObstacle());
        root.getChildren().add(obstacle2.getObstacle());
        root.getChildren().add(obstacle3.getObstacle());
        root.getChildren().add(obstacle4.getObstacle());
        root.getChildren().add(obstacle5.getObstacle());
        root.getChildren().add(obstacle6.getObstacle());
        root.getChildren().add(obstacle7.getObstacle());
        root.getChildren().add(obstacle8.getObstacle());
        root.getChildren().add(obstacle9.getObstacle());
        root.getChildren().add(obstacle10.getObstacle());
        root.getChildren().add(obstacle11.getObstacle());
        root.getChildren().add(obstacle12.getObstacle());
    }

    public void generateCoins(Group root) {

        boolean collision = false;

        for(double x = 37.5; x < 1200 ; x += 75) {
            for(double y = 37.5; y < 825 ; y += 75) {
                Coin coin = new Coin(x, y, 10);

                for(int i = 0; i < obstacles.size(); i++) {
                    if(coin.getCoin().getBoundsInParent().intersects(obstacles.get(i).getObstacle().getBoundsInParent())) {
                        collision = true;
                        break;
                    }
                }

                if(!collision)
                    root.getChildren().add(coin.getCoin());
                else
                    collision = false;
            }
        }
    }

}