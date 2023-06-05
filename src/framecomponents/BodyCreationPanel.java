package framecomponents;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class BodyCreationPanel extends JPanel {
    String[] options = {"Planet", "Asteroid"};
    JComboBox comboBox = new JComboBox(options);

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    BodyCreationPanel() {
        Border blackline = BorderFactory.createTitledBorder("Body Creation");
        this.setBorder(blackline);
        this.setBackground(Color.gray);
        this.setLayout(layout);
        this.add(comboBox);

        //add components
        //left side
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3,3,3,50);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(new JLabel("Type:"), gbc);
        gbc.gridy = 1;
        this.add(new JLabel("Mass:"), gbc);
        gbc.gridy = 2;
        this.add(new JLabel("Radius:"), gbc);
        gbc.gridy = 3;
        this.add(new JLabel("Verlocity:"), gbc);
        gbc.gridy = 4;
        this.add(new JLabel("Color:"), gbc);
        gbc.gridy = 5;
        this.add(new JLabel("X:"), gbc);
        gbc.gridy = 6;
        this.add(new JLabel("Y:"), gbc);

        //right side
        gbc.insets = new Insets(3,3,3,3);
        gbc.gridy = 0;
        gbc.gridx = 1;
        this.add(comboBox, gbc);
        gbc.gridy = 1;
        this.add(new JTextField(), gbc);
        gbc.gridy = 2;
        this.add(new JTextField(), gbc);
        gbc.gridy = 3;
        this.add(new JTextField(), gbc);
        gbc.gridy = 4;
        this.add(new JButton("Choose"), gbc);
        gbc.gridy = 5;
        this.add(new JTextField(), gbc);
        gbc.gridy = 6;
        this.add(new JTextField(), gbc);

        //bottom
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        this.add(new JButton("Create"), gbc);
    }
}
