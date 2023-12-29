package framecomponents.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import bodies.ObjectBody;

public class Simulation extends JPanel  implements MouseMotionListener, MouseListener, MouseWheelListener {
    public Simulation() {
        initialize();
    }

    private void initialize() {
        this.setBackground(Color.black);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addMouseWheelListener(this);
        simulationThread.start();
    }

    private double zoomFactor = 1.0;
    // offset dependent on the center
    private double offsetX = 0;
    private double offsetY = 0;

    public void paint(Graphics g) {
        super.paint(g);

        int centerX = (int) ((getWidth() / 2 + offsetX) * zoomFactor);
        int centerY = (int) ((getHeight() / 2 + offsetY) * zoomFactor);

        g.drawLine(0, centerY, getWidth(), centerY);
        g.drawLine(centerX, 0, centerX, getHeight());

        for (int i = 0; i < ObjectBodyList.size(); i++) {
            g.setColor(ObjectBodyList.get(i).getColor());
            int radius = (int) ObjectBodyList.get(i).getRadius();
            int scaledRadius = (int) (radius * zoomFactor);
            int x = (int) (ObjectBodyList.get(i).getX() * zoomFactor);
            int y = (int) (ObjectBodyList.get(i).getY() * zoomFactor);
            g.fillOval((x + centerX) - scaledRadius, (y + centerY) - scaledRadius, scaledRadius * 2, scaledRadius * 2);
        }
    }

    public static List<ObjectBody> ObjectBodyList = new ArrayList<ObjectBody>();
    public static boolean pause = false;
    // timestep in seconds
    public static double deltaT = 10000;

    public Thread simulationThread = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (pause == false) {
                    calculation();
                    repaint();
                }
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                }
            }
        }

        public void calculatePosition(double[] positionObject1, double[] positionObject2, double[] velocityObject1, double[] velocityObject2, double massObject1, double massObject2, int index1, int index2) {
            // gravitational constant
            double gravitationalConstant = 6.67e-11;

            // position differences
            double dx = positionObject2[0] - positionObject1[0];
            double dy = positionObject2[1] - positionObject1[1];

            // distance
            double distance = Math.sqrt(dx * dx + dy * dy);

            // gravitational force
            double gravitationalForce = (gravitationalConstant * massObject1 * massObject2) / (distance * distance);

            // gravitational force components
            double fx = gravitationalForce * (dx / distance);
            double fy = gravitationalForce * (dy / distance);

            // acceleration 
            double ax1 = fx / massObject1;
            double ay1 = fy / massObject1;
            //double ax2 = -fx / massObject2;
            //double ay2 = -fy / massObject2;

            // new velocities
            double vx1_new = velocityObject1[0] + ax1 * deltaT;
            double vy1_new = velocityObject1[1] + ay1 * deltaT;
            //double vx2_new = velocityObject2[0] + ax2 * deltaT;
            //double vy2_new = velocityObject2[1] + ay2 * deltaT;
            ObjectBodyList.get(index1).setVelocityX(vx1_new);
            ObjectBodyList.get(index1).setVelocityY(vy1_new);

            // new positions
            double x1_new = positionObject1[0] + vx1_new * deltaT;
            double y1_new = positionObject1[1] + vy1_new * deltaT;
            //double x2_new = positionObject2[0] + vx2_new * deltaT;
            //double y2_new = positionObject2[1] + vy2_new * deltaT;
            ObjectBodyList.get(index1).setX(x1_new);
            ObjectBodyList.get(index1).setY(y1_new);
            
            System.out.println(x1_new + " / " + y1_new);
        }

        private void calculation() {
            if (ObjectBodyList.size() == 1) {
                calculatePosition(
                    new double[]{ObjectBodyList.get(0).getX(), ObjectBodyList.get(0).getY()}, // position of object 1 (x, y)
                    new double[]{0, 0}, // position of object 2 (x, y)
                    new double[]{ObjectBodyList.get(0).getVelocityX(), ObjectBodyList.get(0).getVelocityY()}, // velocity of object 1 (vx, vy)
                    new double[]{0, 0}, // velocity of object 2 (vx, vy)
                    (double) ObjectBodyList.get(0).getMass(), // mass of object 1
                    (double) 0, // mass of object 2
                    0,
                    0
                );
            }
            else {
                for (int i = 0; i < ObjectBodyList.size(); i++) {
                    for (int a = 0; a < ObjectBodyList.size(); a++) {
                        if (a != i) {
                            calculatePosition(
                                new double[]{ObjectBodyList.get(i).getX(), ObjectBodyList.get(i).getY()}, // position of object 1 (x, y)
                                new double[]{ObjectBodyList.get(a).getX(), ObjectBodyList.get(a).getY()}, // position of object 2 (x, y)
                                new double[]{ObjectBodyList.get(i).getVelocityX(), ObjectBodyList.get(i).getVelocityY()}, // velocity of object 1 (vx, vy)
                                new double[]{ObjectBodyList.get(a).getVelocityX(), ObjectBodyList.get(a).getVelocityY()}, // velocity of object 2 (vx, vy)
                                (double) ObjectBodyList.get(i).getMass(), // mass of object 1
                                (double) ObjectBodyList.get(a).getMass(), // mass of object 2
                                i,
                                a
                            );
                        }
                    }
                }
            }
        }
    });

    // position of the mouse
    private int initialX;
    private int initialY;

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        initialX = e.getX();
        initialY = e.getY();
    }

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {
        int dx = e.getX() - initialX;
        int dy = e.getY() - initialY;

        offsetX += dx / zoomFactor;
        offsetY += dy / zoomFactor;

        repaint();

        initialX = e.getX();
        initialY = e.getY();
    }

    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        if (notches < 0) {
            // Zoom in
            zoomFactor *= 1.1;
        } else {
            // Zoom out
            zoomFactor /= 1.1;
        }
        repaint();
    }
}