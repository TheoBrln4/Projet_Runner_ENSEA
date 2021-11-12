import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Group;

import javax.swing.*;

import static javafx.application.Application.launch;

public class staticThing {
    static double x;
    static double y;
    ImageView im;

    public staticThing(String filename, double x, double y){
        this.x = x;
        this.y = y;
        this.im = new ImageView(new Image(filename));
        this.im.setX(x);
        this.im.setY(y);
    }

    public ImageView getim(){
        return im;
    }
}
