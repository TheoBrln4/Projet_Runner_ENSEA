public class Foe extends AnimatedThing {

    private final double km = 1;
    private final double fm = 1.2;
    private double v_x,v_y;
    private double a_x,a_y;
    private double f_x,f_y;

    public Foe (double x, double y){
        super(x, y, 0.1, 5, 10, 75, 100, "foe.png");
    }

    @Override
    public void UpdateAttitude() {

    }

    @Override
    public void update(double t) {
        super.update(t);

        a_y = 0.25 - f_y/15;
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

    }
}
