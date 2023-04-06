import javax.swing.*;

public class EarthMoving {
    public EarthMoving() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        GUIearthMoving app = new GUIearthMoving();
        app.setVisible(true);
    }
    public static void main(String[] arg) {
        new EarthMoving();
    }
}
class GUIearthMoving extends JFrame{
    JLabel label_sun = new JLabel();
    JLabel label_earth = new JLabel();
    public GUIearthMoving() {
        super("MovingEarth");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon space = new ImageIcon("space.jpg");
        setContentPane(new JLabel(space));
        pack();
        ImageIcon sun = new ImageIcon("sun.png");
        ImageIcon earth = new ImageIcon("earth.png");
        label_earth.setBounds(100, 100, earth.getIconWidth(), earth.getIconHeight());
        label_sun.setBounds(space.getIconWidth()/2-sun.getIconWidth()/2, space.getIconHeight()/2-sun.getIconHeight()/2, sun.getIconWidth(), sun.getIconHeight());
        label_earth.setIcon(earth);
        label_sun.setIcon(sun);
        add(label_earth);
        add(label_sun);
        setVisible(true);
        new MovingWay("EarthWay", label_earth, 250, 50, space.getIconWidth()/2, space.getIconHeight()/2, earth.getIconWidth(), earth.getIconHeight()).start();
    }
}
class MovingWay extends Thread {
    JLabel label;
    int R;
    int pause_sleep;
    int x0;
    int y0;
    int w;
    int h;
    MovingWay(String name, JLabel label, int R, int pause_sleep, int x0, int y0, int w, int h) {
        super(name);
        this.label = label;
        this.R = R;
        this.pause_sleep = pause_sleep;
        this.x0 = x0;
        this.y0 = y0;
        this.w = w;
        this.h = h;
    }
    public void run() {
        try {
            while(true) {
                for (double deg=0; deg<360; deg+=1) {
                    label.setLocation((int) (x0+R*Math.cos(Math.toRadians(deg)))-w/2,
                                        (int) (y0+R*Math.sin(Math.toRadians(deg)))-h/2);
                    Thread.sleep(pause_sleep);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}