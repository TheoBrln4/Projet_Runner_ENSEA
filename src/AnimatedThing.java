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


abstract public class AnimatedThing {
    protected double x;
    protected double y;
    private ImageView im;
    enum attitude{Jumping_Up, Jumping_Down, Running, Dead}
    attitude at;

    protected Rectangle2D hitbox;

    int index;
    double duration;
    int indexMax;
    int offset;
    int sizex;
    int sizey;

    public boolean isInvicible=false;

    public AnimatedThing(double x, double y, double duration, int indexMax, int offset, int sizex, int sizey, String filename){
        this.x = x;
        this.y = y;
        this.duration = duration;
        this.indexMax = indexMax;
        this.offset = offset;
        this.sizex = sizex;
        this.sizey = sizey;

        this.im = new ImageView(new Image(filename));
        this.im.setViewport(new Rectangle2D(0, 0, sizex, sizey));
        this.im.setX(x);
        this.im.setY(y);
        this.hitbox = new Rectangle2D(x,y,sizex,sizey);
    }

    public double getx(){
        return x;
    }

    public double gety(){
        return y;
    }

    public Rectangle2D getRecta(){
        return hitbox;
    }

    public void update(double t){
        this.indexMax = 5;
        this.index = (int) ((t%(duration*indexMax))/this.duration);
        this.hitbox= new Rectangle2D(this.getx(), this.gety(), this.sizex, this.sizey);

        if(this.at == attitude.Running) {
            this.im.setViewport(new Rectangle2D(index * (sizex + offset), 0, sizey * 0.75 + offset, 100));
        }
        else if(this.at == attitude.Jumping_Up){
            this.im.setViewport(new Rectangle2D(offset, 160, sizex+offset, sizey));
        }
        else if(this.at == attitude.Jumping_Down){
            this.im.setViewport(new Rectangle2D(95, 160, sizex + offset, sizey));
        }

        if (isInvicible && index%2==0){
            this.im.setViewport(new Rectangle2D(300,100,sizex+offset,sizey));
        }
    }

    public ImageView getim(){
        return im;
    }

    public abstract void UpdateAttitude();

    public boolean touch(Rectangle2D recti){
        return hitbox.intersects(recti);
    }
}
