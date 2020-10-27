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
import java.lang.Thread;

/**
 * @author Ahmad Reza Khalili
 */

public class Controller {

    private char[][] map = new char[13][18];
    private PacMan pacMan;
    private Group root;
    private int score = 0;
    private int life = 3;

    public void readMap(Group root) throws Exception {
        FileReader fr = new FileReader("map.txt");
        BufferedReader br = new BufferedReader(fr);
        this.root = root;
        int i = 0;

        String line;

        while ((line = br.readLine()) != null) {
            for (int j = 0; j < 18; j++) {
                map[i][j] = line.charAt(j);
            }
            i++;
        }
    }

    public void printMap() {
        root.getChildren().clear();
        addWall(root);
        addCoin(root);
        addGhost(root);
        addPacMan(root);
    }

    public void addWall(Group root) {
        for(int i = 0; i < 13; i++) {
            for(int j = 0; j < 18; j++) {
                if(i > 0 && j > 0){
                    if(map[i][j] == '#') {
                        Wall wall = new Wall((j - 1) * 75, (i - 1) * 75);
                        root.getChildren().add(wall.getWall());
                    }
                }
            }
        }
    }

    public void addCoin(Group root) {
        double r;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 18; j++) {
                if(i > 0 && j > 0){
                    if(map[i][j] != '#' && map[i][j] != 'P') {
                        if(map[i][j] == 'O') {
                            r = 25;
                            Coin coin = new Coin((j - 0.5) * 75, (i - 0.5) * 75, r);
                            root.getChildren().add(coin.getCoin());
                            continue;
                        }
                        else
                            if(map[i][j] == '*') {
                                r = 10;
                                Coin coin = new Coin((j - 0.5) * 75, (i - 0.5) * 75, r);
                                root.getChildren().add(coin.getCoin());
                                continue;
                            }
                    }
                }
            }
        }
    }

    public void addGhost(Group root) {
        int id = 1;
        String imgName;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 18; j++)
                if (map[i][j] == 'G') {
                    imgName = "ghost" + id + ".png";
                    Image img = new Image(imgName);
                    Ghost ghost = new Ghost(img, (j - 1.05) * 75 + 10, (i - 1.05) * 75, 75, 75);
                    ImagePattern imgPattern = new ImagePattern(ghost.getImg());
                    ghost.getGhost().setFill(imgPattern);
                    root.getChildren().add(ghost.getGhost());
                    id++;
                }
        }
    }

    /*@Override
    public void run() {
        movePacMan(root);
    }*/

    public void addPacMan(Group root) {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 18; j++)
                if (map[i][j] == 'P') {
                    Image img = new Image("pacman.png");
                    PacMan pacMan = new PacMan(img, (j - 1) * 75 + 35, (i - 1) * 75 + 35, 30);
                    ImagePattern imgPattern = new ImagePattern(pacMan.getImg());
                    pacMan.getPacMan().setFill(imgPattern);
                    this.pacMan = pacMan;
                    root.getChildren().add(pacMan.getPacMan());
                }
        }
    }

    public void moveRightPacMan() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 18; j++)
                if (map[i][j] == 'P') {
                    if(map[i][j + 1] == '|' || map[i][j + 1] == '#')
                        return;
                    if(map[i][j + 1] == '*' || map[i][j + 1] == 'O') {
                        if(map[i][j + 1] == '*')
                            score++;
                        else
                            score += 10;
                        map[i][j] = '0';
                        map[i][j + 1] = 'P';
                        printMap();
                        return;
                    }
                    if(map[i][j + 1] == '0') {
                        map[i][j] = '0';
                        map[i][j + 1] = 'P';
                        printMap();
                        return;
                    }
                    if(map[i][j + 1] == 'G') {
                        map[1][2] = 'P';
                        map[i][j] = '0';
                        life--;
                        printMap();
                        return;
                    }
                }
        }
    }

   public void moveLeftPacMan() {
       for (int i = 0; i < 13; i++) {
           for (int j = 0; j < 18; j++)
               if (map[i][j] == 'P') {
                   if(map[i][j - 1] == '|' || map[i][j - 1] == '#')
                       return;
                   if(map[i][j - 1] == '*' || map[i][j - 1] == 'O') {
                       if(map[i][j - 1] == '*')
                           score++;
                       else
                           score += 10;
                       map[i][j] = '0';
                       map[i][j - 1] = 'P';
                       printMap();
                       return;
                   }
                   if(map[i][j - 1] == '0') {
                       map[i][j] = '0';
                       map[i][j - 1] = 'P';
                       printMap();
                       return;
                   }
                   if(map[i][j - 1] == 'G') {
                       map[1][2] = 'P';
                       map[i][j] = '0';
                       life--;
                       printMap();
                       return;
                   }
               }
       }
    }

    public void moveUpPacMan() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 18; j++)
                if (map[i][j] == 'P') {
                    if(map[i - 1][j] == '-' || map[i - 1][j] == '#')
                        return;
                    if(map[i - 1][j] == '*' || map[i - 1][j] == 'O') {
                        if(map[i - 1][j] == '*')
                            score++;
                        else
                            score += 10;
                        map[i][j] = '0';
                        map[i - 1][j] = 'P';
                        printMap();
                        return;
                    }
                    if(map[i - 1][j] == '0') {
                        map[i][j] = '0';
                        map[i - 1][j] = 'P';
                        printMap();
                        return;
                    }
                    if(map[i - 1][j] == 'G') {
                        map[1][2] = 'P';
                        map[i][j] = '0';
                        life--;
                        printMap();
                        return;
                    }
                }
        }
    }

    public void moveDownPacMan() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 18; j++)
                if (map[i][j] == 'P') {
                    if(map[i + 1][j] == '-' || map[i + 1][j] == '#')
                        return;
                    if(map[i + 1][j] == '*' || map[i + 1][j] == 'O') {
                        if(map[i + 1][j] == '*')
                            score++;
                        else
                            score += 10;
                        map[i][j] = '0';
                        map[i + 1][j] = 'P';
                        printMap();
                        return;
                    }
                    if(map[i + 1][j] == '0') {
                        map[i][j] = '0';
                        map[i + 1][j] = 'P';
                        printMap();
                        return;
                    }
                    if(map[i + 1][j] == 'G') {
                        map[1][2] = 'P';
                        map[i][j] = '0';
                        life--;
                        printMap();
                        return;
                    }
                }
        }
    }

    public int getScore() {
        return score;
    }

    public String printScore() {
        return "Score: " + getScore();
    }

    public int getLife() {
        return life;
    }

    public String printLife() {
        return "Lives: " + getLife();
    }
}