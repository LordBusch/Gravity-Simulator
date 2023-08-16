package framecomponents.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;

import bodies.MainBody;
import bodies.SecondaryBody;

public class BodyCreationPanel extends JPanel implements ActionListener {

    String[] options = { "Main Body", "Secondary Body" };
    JComboBox comboBox = new JComboBox(options);
    JButton ChooseButton = new JButton("Choose");
    JButton CreateButton = new JButton("Create");
    JColorChooser ColorPicker = new JColorChooser();

    NumberFormat format = NumberFormat.getInstance();
    NumberFormatter formatter = new NumberFormatter(format);

    BodyCreationPanel() {
        setUpFormatter();
        initialize();
        setUpButtons();
    }

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    private void initialize() {
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateVelocityUI();
            }
        });
        Border blackline = BorderFactory.createTitledBorder("Body Creation");
        this.setBorder(blackline);
        this.setBackground(Color.gray);
        this.setLayout(layout);
        this.add(comboBox);

        // add components
        // left side
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3, 3, 3, 50);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(new JLabel("Type:"), gbc);
        gbc.gridy = 1;
        this.add(new JLabel("Mass:"), gbc);
        gbc.gridy = 2;
        this.add(new JLabel("Radius:"), gbc);
        gbc.gridy = 5;
        this.add(new JLabel("Color:"), gbc);
        gbc.gridy = 6;
        this.add(new JLabel("X:"), gbc);
        gbc.gridy = 7;
        this.add(new JLabel("Y:"), gbc);

        // right side
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.gridy = 0;
        gbc.gridx = 1;
        this.add(comboBox, gbc);
        gbc.gridy = 1;
        this.add(MassTF, gbc);
        gbc.gridy = 2;
        this.add(RadiusTF, gbc);
        gbc.gridy = 5;
        this.add(ChooseButton, gbc);
        gbc.gridy = 6;
        this.add(XTF, gbc);
        gbc.gridy = 7;
        this.add(YTF, gbc);

        // bottom
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        this.add(CreateButton, gbc);
    }

    JFormattedTextField MassTF = new JFormattedTextField(formatter);
    JFormattedTextField RadiusTF = new JFormattedTextField(formatter);
    JFormattedTextField VelocityTF = new JFormattedTextField(formatter);
    JFormattedTextField AngleTF = new JFormattedTextField(formatter);
    JFormattedTextField XTF = new JFormattedTextField(formatter);
    JFormattedTextField YTF = new JFormattedTextField(formatter);
    JLabel VelocityLabel = new JLabel("Velocity");
    JLabel AngleLabel = new JLabel("Angle");

    private void updateVelocityUI() {
        if (String.valueOf(comboBox.getSelectedItem()) == options[1]) {
            gbc.gridx = 0;
            gbc.gridy = 3;
            this.add(VelocityLabel, gbc);
            gbc.gridy = 4;
            this.add(AngleLabel, gbc);
            gbc.gridx = 1;
            this.add(AngleTF, gbc);
            gbc.gridy = 3;
            this.add(VelocityTF, gbc);
        } else {
            this.remove(VelocityLabel);
            this.remove(VelocityTF);
            this.remove(AngleLabel);
            this.remove(AngleTF);
        }
        this.repaint();
        this.revalidate();
    }

    private void setUpButtons() {
        ChooseButton.addActionListener(this);
        CreateButton.addActionListener(this);
    }

    private void setUpFormatter() {
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
    }

    private boolean choose = false;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ChooseButton) {
            if (choose) {
                this.remove(ColorPicker);
                choose = false;
            } else {
                gbc.gridx = 2;
                gbc.gridy = 5;
                gbc.gridwidth = 1;
                this.add(ColorPicker, gbc);
                choose = true;
            }
            this.revalidate();
        }
        if (e.getSource() == CreateButton) {
            if (String.valueOf(comboBox.getSelectedItem()) == options[1]) {
                // if no necessary value is emtpy, create new secondaryBody
                try {
                    if (MassTF.getText() != null && RadiusTF.getText() != null && VelocityTF.getText() != null && XTF.getText() != null && YTF.getText() != null) {
                        SecondaryBody body = new SecondaryBody(Integer.valueOf(VelocityTF.getText()), Integer.valueOf(MassTF.getText()),
                                Integer.valueOf(RadiusTF.getText()), Integer.valueOf(AngleTF.getText()), Integer.valueOf(XTF.getText()),
                                Integer.valueOf(YTF.getText()), ColorPicker.getColor());
                        Simulation.secondaryBodyList.add(body);
                    }
                } catch (NumberFormatException e1) {
                    //error message
                    System.out.println("FAILED");
                }
            } else {
                // if no necessary value is emtpy, create new mainBody
                try {
                    if (MassTF.getText() != null && RadiusTF.getText() != null && XTF.getText() != null && YTF.getText() != null) {
                        MainBody body = new MainBody(Integer.valueOf(MassTF.getText()),
                                Integer.valueOf(RadiusTF.getText()), Integer.valueOf(XTF.getText()),
                                Integer.valueOf(YTF.getText()), ColorPicker.getColor());
                        Simulation.mainBodyList.add(body);
                    }
                } catch (NumberFormatException e1) {
                    //error message
                    System.out.println("FAILED");
                }
            }
        }
    }
}
