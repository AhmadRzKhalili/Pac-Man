package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public abstract class Creature {
    private Image img;
    private ImageView imgView = new ImageView();
    private ImagePattern imgPattern;

    public Creature(Image img){
        setImg(img);
        createAppearnce(img);
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Image getImg() {
        return img;
    }

    public ImageView getImgView() {
        return imgView;
    }

    public void createAppearnce(Image img){
        getImgView().setImage(img);
    }

}