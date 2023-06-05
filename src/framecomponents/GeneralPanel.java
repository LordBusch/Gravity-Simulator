package framecomponents;
import java.awt.*;
import javax.swing.*;

public class GeneralPanel extends JPanel {
    JButton PauseButton = new JButton("Pause");
    JButton LoadButton = new JButton("Load");
    JButton SaveButton = new JButton("Save");
    JButton ResetButton = new JButton("Reset");

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    GeneralPanel() {
        this.setLayout(layout);
        this.setBackground(Color.gray);
        
        //add components
        gbc.insets = new Insets(3,3,3,3);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(ResetButton, gbc);
        gbc.gridx = 1;
        this.add(LoadButton, gbc);
        gbc.gridx = 2;
        this.add(SaveButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        this.add(PauseButton, gbc);
    }
}
