public class Camera {
    private int x;
    private int y;
    private double ax;
    private double ay;
    private double vx;
    private double vy;
    private final double km = 1;
    private final double fm = 1.2;

    public Camera(int x, int y){
        this.x = x;
        this.y = y;

    }

    public int getx(){
        return x;
    }

    public int gety(){
        return y;
    }

    public String ToString(){
        return getx()+ "," +gety();
    }

    public void update(double t, Hero joueur){

        double x_joueur=joueur.getx();
        double y_joueur=joueur.gety();

        ax=km*(x_joueur-100-x)-fm*vx;
        vx+=ax;
        x+=vx;
// ok
        ay=km*(y_joueur-250-y)-fm*vy;

        vy+=ay;
        y+=vy;
    }
}
