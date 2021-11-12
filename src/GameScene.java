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

public class GameScene extends Scene {

    Camera camera;
    staticThing right;
    staticThing left;
    int numberOfLives;
    Hero joueur;
    int rep = 1;

    private final int desertSizeX=800;
    private final int desertSizeY=400;

    public GameScene(Pane parent, double v, double v1, boolean b, Camera cam, Hero joueur) {
        super(parent, v, v1, b);
        this.camera = cam;
        this.numberOfLives = 3;

        this.left = new staticThing("desert.png", 0, 0);
        left.getim().setViewport(new Rectangle2D(0,0,800,400));
        parent.getChildren().add(left.getim());

        this.right = new staticThing("desert.png", 800, 0);
        right.getim().setViewport(new Rectangle2D(0,0,800,400));
        parent.getChildren().add(right.getim());

        ImageView[] vies = new ImageView[numberOfLives];
        for(int i = 0;i<numberOfLives;i++){
            vies[i] = new ImageView("heart.png");
            vies[i].setX(48*i);
            vies[i].setY(0);
            vies[i].setViewport(new Rectangle2D(0,0,48,48));
            parent.getChildren().add(vies[i]);
        }

        this.joueur = joueur;
        this.joueur.speed(1);
        parent.getChildren().add(this.joueur.getim());

        this.setOnMouseClicked( (event)-> joueur.jump());
        this.setOnKeyPressed(keyEvent -> {
            if(keyEvent.equals("SPACE")){
                joueur.jump();
            }
            if(keyEvent.equals("D")){
                joueur.forceAug(100);
            }
            if(keyEvent.equals("Q")){
                joueur.forceAug(-100);
            }
        });
    }

    public void update(double t){
        right.getim().setY(-camera.gety());
        left.getim().setY(-camera.gety());

        if(camera.getx()>desertSizeX*rep){
            rep += 1;
        }
        if((rep%2) == 1){
            left.getim().setX(desertSizeX*(rep-1) - camera.getx());
            right.getim().setX(desertSizeX*(rep) - camera.getx());
        }
        else{
            right.getim().setX(desertSizeX * (rep-1) - camera.getx());
            left.getim().setX(desertSizeX * rep - camera.getx());
        }
        joueur.getim().setX(joueur.getx()-camera.getx());
        joueur.getim().setY(joueur.gety()-camera.gety());
    }
}