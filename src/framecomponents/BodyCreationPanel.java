package framecomponents;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class BodyCreationPanel extends JPanel implements ActionListener {
    
    String[] options = {"Planet", "Asteroid"};
    JComboBox comboBox = new JComboBox(options);
    JButton ChooseButton = new JButton("Choose");
    JButton CreateButton = new JButton("Create");

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    BodyCreationPanel() {
        initialize();
        setUpButtons();
    }

    private void initialize() {
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
        this.add(ChooseButton, gbc);
        gbc.gridy = 5;
        this.add(new JTextField(), gbc);
        gbc.gridy = 6;
        this.add(new JTextField(), gbc);

        //bottom
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        this.add(CreateButton, gbc);
    }

    private void setUpButtons() {
        ChooseButton.addActionListener(this);
        CreateButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ChooseButton) {
            
        }
        if (e.getSource() == CreateButton) {
            
        }
    }
}
