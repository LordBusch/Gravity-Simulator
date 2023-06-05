package framecomponents;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class Frame extends JFrame {
    public Frame() {
        standardView();
        this.setTitle("Gravity Simulator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.setVisible(true);
        this.add(splitpane);
    }

    JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

    void standardView() {
        splitpane.setLeftComponent(new SideBar());
        splitpane.setRightComponent(new SpaceView());
    }
}
