import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.animation.AnimationTimer;
import javax.swing.*;

import static javafx.application.Application.launch;

public class Hello_World extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Runner Game");
        Group root = new Group();
        Pane pane = new Pane(root);
        Camera cam = new Camera(200, 0);
        Hero joueur = new Hero(100, 257);

        GameScene theScene = new GameScene(pane, 800, 400,true, cam, joueur);
        primaryStage.setScene(theScene);
        primaryStage.show();

        /**Image desertSheet = new Image("desert.png");
        ImageView desert = new ImageView(desertSheet);
        desert.setViewport(new Rectangle2D(0, 0, 800, 400));
        desert.setX(cam.getx());
        desert.setY(cam.gety());**/

       /* Image spriteSheet = new Image("heros.png");
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,0,65,100));
        sprite.setX(200);
        sprite.setY(300); */

        //root.getChildren().add(desert);
        //root.getChildren().add(sprite);

        final long startingTime = System.nanoTime();
        AnimationTimer timer = new AnimationTimer()
        {public void handle(long time){
            double t = (time - startingTime)/1000000000.0;
            joueur.update(t);
            cam.update(t, joueur);
            theScene.update(t);

            }
            };timer.start();

    }
   public static void main(String[] args) {
         launch(args);
    }

 }