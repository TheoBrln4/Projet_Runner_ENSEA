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

public class Hero extends AnimatedThing{

    private final double km = 1;
    private final double fm = 1.2;
    private double v_x,v_y;
    private double a_x,a_y;
    private double f_x,f_y;
    public double life=3;

    public double invincibility = 2.5;
    public boolean isInvicible;

    public Hero(double x, double y) {
        super(x, y, 0.1, 5, 10, 75, 100, "heros.png");
    }

    public void setForce(double fx, double fy){
        f_x = fx;
        f_y = fy;
    }


    public void lostLife(){
        if(life != 0) {
            life -= 1;
            System.out.println("Vous avez été touché, il vous reste : " +life);
        }
        else{
            System.out.println("Vous avez perdu");
        }
    }

    public void speedAug(double aug){
        v_x += aug;
    }

    public void forceAug(double aug){
        f_x += aug;
        if(v_x<1){
            v_x = -1;
        }
    }

    public void jump(){
        if(y >= 150+sizey){
            f_y += 105;
        }
    }

    @Override
    public void UpdateAttitude(){
        if(v_y>=0.1){
            at = attitude.Jumping_Down;
        }
        else if(v_y<-0.1){
            at = attitude.Jumping_Up;
        }
        else{
            at = attitude.Running;
        }
    }

    public void speed(double vx){
        v_x = vx;
    }

    @Override
    public void update(double t) {
        super.update(t);
        UpdateAttitude();

        a_y = 0.22 - f_y/15;
        v_y += a_y;
        y += v_y;

        if(y>150+sizey){
            if(v_y>0){
                v_y=0;
            }
            y = 150 + sizey;
        }
        a_x = f_x/20;
        v_x += a_x;
        x += v_x;


        setForce(0,0);

    }
}
