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
            int radius = (int) mainBodyList.get(i).getRadius();
            int x = (int) mainBodyList.get(i).getX();
            int y = (int) mainBodyList.get(i).getY();
            g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        }

        for (int i = 0; i < secondaryBodyList.size(); i++) {
            g.setColor(secondaryBodyList.get(i).getColor());
            int radius = (int) secondaryBodyList.get(i).getRadius();
            int x = (int) secondaryBodyList.get(i).getX();
            int y = (int) secondaryBodyList.get(i).getY();
            g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
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

        private void calculation() {
            calculation: for (int i = 0; i < secondaryBodyList.size(); i++) {
                double x = secondaryBodyList.get(i).getX();
                double y = secondaryBodyList.get(i).getY();
                double xvector = secondaryBodyList.get(i).getVelocity() * Math.cos(secondaryBodyList.get(i).getAngle() / 180 * Math.PI);
                double yvector = secondaryBodyList.get(i).getVelocity() * Math.sin(-secondaryBodyList.get(i).getAngle() / 180 * Math.PI);
                for (int a = 0; a < mainBodyList.size(); a++) {
                    double distanceX = (mainBodyList.get(a).getX() - secondaryBodyList.get(i).getX());
                    double distanceY = (mainBodyList.get(a).getY() - secondaryBodyList.get(i).getY());
                    double planetPull = 500 / ((distanceX * distanceX) + (distanceY * distanceY));

                    xvector = xvector + distanceX * planetPull;
                    yvector = yvector + distanceY * planetPull;

                    //check for collision
                    if (Math.sqrt((distanceX * distanceX) + (distanceY * distanceY)) <= (secondaryBodyList.get(i).getRadius() + mainBodyList.get(a).getRadius())) {
                        secondaryBodyList.remove(i);
                        break calculation;
                    }

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