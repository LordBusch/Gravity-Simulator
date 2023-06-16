package framecomponents;

import java.awt.Color;
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

    public static List<MainBody> mainBodyList = new ArrayList<MainBody>();
    public static List<SecondaryBody> secondaryBodyList = new ArrayList<SecondaryBody>();

    Thread t1 = new Thread(new Runnable() {
        public void run() {
            draw();
        }

        public void draw() {
            System.out.println("TEST");
        }

        public void calculation() {

        }
    });
}
