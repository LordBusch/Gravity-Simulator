package framecomponents;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import framecomponents.panels.SideBar;
import framecomponents.panels.Simulation;

public class Frame extends JFrame {
    public Frame() {
        initialize();
    }

    public void initialize() {
        JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        splitpane.setLeftComponent(new SideBar());
        splitpane.setRightComponent(new Simulation());
        
        this.setTitle("Gravity Simulator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.setVisible(true);
        this.add(splitpane);
    }
}
