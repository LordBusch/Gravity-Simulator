package framecomponents;
import java.awt.*;
import javax.swing.*;

public class SideBar extends JPanel {
    SideBar() {
        this.setPreferredSize(new Dimension(250, 1080));
        this.setLayout(new GridLayout(2, 1));
        this.add(new GeneralPanel());
        this.add(new BodyCreationPanel());
    }
}
