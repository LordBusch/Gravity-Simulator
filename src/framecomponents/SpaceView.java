package framecomponents;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import bodies.MainBody;
import bodies.SecondaryBody;

public class SpaceView extends JPanel {
    SpaceView() {
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
            }
        }

        public void calculation() {
            for (int i = 0; i < mainBodyList.size(); i++) {

            }

            for (int i = 0; i < secondaryBodyList.size(); i++) {

            }
        }
    });
}
