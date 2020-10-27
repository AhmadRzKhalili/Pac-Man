package ir.ac.kntu;

import java.io.*;
import java.lang.Thread;
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

class T extends Thread {

    private int x;
    private int y;
    public T(int x, int y){
        this.x=x;
        this.y = y;
    }
    public void start() {
        while(true) {
            for(int i = 0; i < 2; i++)
                System.out.print('*');
            System.out.println('P');
            x++;
            try {
                Thread.sleep(y);
                for(int j = 1; j < 5; j++) {
                    //str = br.readLine();
                    System.out.println(x);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}

class PacMan extends Thread {

    private Circle c;
    private int x = 100;
    private int y = 100;
    private Group r;

    public PacMan(Group root) {
        Circle circle = new Circle(x,y,50);
        c = circle;
        r = root;
    }

    public void mov() {
        x += 50;
        c.setCenterX(x);
        r.getChildren().add(c);
    }

    public void start() {
        while (true) {
            mov();
            try {
                Thread.sleep(2000);
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }

}

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Group root = new Group();
        Scene scene = new Scene(root, 1200, 825, Color.BLUE);     //a=75: 16a*12a
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pac-Man");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        PacMan p = new PacMan(root);
        p.start();
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
       /* File file = new File("map.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;

        T tt = new T(5,2000);
        T t = new T(14, 5000);
        t.start();
        synchronized (tt.start());
        System.out.println("str");*/

        /*for(int i = 1; i < 5; i++) {
            str = br.readLine();
            System.out.println(str);
        }*/
    }
}
