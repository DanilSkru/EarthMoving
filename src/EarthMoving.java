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
        MovingWay(space.getIconWidth()/2, space.getIconHeight()/2, earth.getIconWidth(), earth.getIconHeight());
    }
    void MovingWay(int x0, int y0, int w_earth, int h_earth) {
        int R = 250;
        int pause_sleep = 50;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {

                        for (double deg=0; deg<360; deg+=1) {
                            label_earth.setLocation((int) (x0+R*Math.cos(Math.toRadians(deg)))-w_earth/2, (int) (y0+R*Math.sin(Math.toRadians(deg)))-h_earth/2);
                            Thread.sleep(pause_sleep);
                        }


                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}