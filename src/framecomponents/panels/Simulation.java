package framecomponents.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import bodies.MainBody;
import bodies.SecondaryBody;

public class Simulation extends JPanel {
    public Simulation() {
        initialize();
    }

    private void initialize() {
        this.setBackground(Color.black);
        t1.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < mainBodyList.size(); i++) {
            g.setColor(mainBodyList.get(i).getColor());
            int radius = mainBodyList.get(i).getRadius();
            int x = mainBodyList.get(i).getX();
            int y = mainBodyList.get(i).getY();
            g.fillOval(x - (radius / 2), y - (radius / 2), radius, radius);
        }

        for (int i = 0; i < secondaryBodyList.size(); i++) {
            g.setColor(secondaryBodyList.get(i).getColor());
            int radius = secondaryBodyList.get(i).getRadius();
            int x = secondaryBodyList.get(i).getX();
            int y = secondaryBodyList.get(i).getY();
            g.fillOval(x - (radius / 2), y - (radius / 2), radius, radius);
        }
    }

    public static List<MainBody> mainBodyList = new ArrayList<MainBody>();
    public static List<SecondaryBody> secondaryBodyList = new ArrayList<SecondaryBody>();

    public Thread t1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                calculation();
                repaint();
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                }
            }
        }

        public void calculation() {
            for (int i = 0; i < secondaryBodyList.size(); i++) {
                double x = secondaryBodyList.get(i).getX();
                double y = secondaryBodyList.get(i).getY();
                double xvector = 5;
                double yvector = 3;
                for (int a = 0; a < mainBodyList.size(); a++) {
                    double distanceX = (mainBodyList.get(a).getX() - secondaryBodyList.get(i).getX());
                    double distanceY = (mainBodyList.get(a).getY() - secondaryBodyList.get(i).getY());
                    double planetPull = 500 / ((distanceX * distanceX) + (distanceY * distanceY));

                    xvector = xvector + distanceX * planetPull;
                    yvector = yvector + distanceY * planetPull;

                    System.out.println("CALLED");
                    System.out.println(xvector);
                    System.out.println(yvector);
                }
                x = x + xvector;
                y = y + yvector;
                System.out.println(x);
                System.out.println(y);
                secondaryBodyList.get(i).setX((int) x);
                secondaryBodyList.get(i).setY((int) y);
                /*
                 * // Calculate new position
                 * xshot = xshot + xvector;
                 * yshot = yshot + yvector;
                 * shot_xpos[count] = (int) xshot;
                 * shot_ypos[count] = (int) yshot;
                 */
            }

        }
    });
}
