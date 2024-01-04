package framecomponents.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GeneralPanel extends JPanel implements ActionListener {

    JButton PauseButton = new JButton("Pause");
    JButton LoadButton = new JButton("Load");
    JButton SaveButton = new JButton("Save");
    JButton ResetButton = new JButton("Reset");
    JCheckBox TraceCheckBox = new JCheckBox("Show trace");
    JSlider TraceSlider = new JSlider();
    JSlider SpeedSlider = new JSlider();
    JLabel SpeedLabel = new JLabel("Simulation Speed");

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    GeneralPanel() {
        initialize();
        setUpComponents();
    }

    private void initialize() {
        this.setLayout(layout);
        this.setBackground(Color.gray);

        // add components
        gbc.insets = new Insets(3, 3, 3, 3);
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
        gbc.gridy = 2;
        this.add(SpeedLabel, gbc);
        gbc.gridy = 3;
        this.add(SpeedSlider, gbc);
        /*
        gbc.gridy = 2;
        this.add(TraceCheckBox, gbc);
        gbc.gridy = 3;
        this.add(TraceSlider, gbc);
        */
    }

    private void setUpComponents() {
        // Buttons
        PauseButton.addActionListener(this);
        LoadButton.addActionListener(this);
        SaveButton.addActionListener(this);
        ResetButton.addActionListener(this);

        /*
        // Checkbox
        TraceCheckBox.setBackground(getBackground());

        // Slider
        Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
        labelTable.put(0, new JLabel("0") );
        labelTable.put(10, new JLabel("10") );
        labelTable.put(20, new JLabel("20") );
        labelTable.put(30, new JLabel("30") );
        labelTable.put(40, new JLabel("40") );
        labelTable.put(50, new JLabel("Ꝏ") );
        TraceSlider.setLabelTable(labelTable);

        TraceSlider.setMinimum(0);
        TraceSlider.setMaximum(50);
		TraceSlider.setMajorTickSpacing(10);
		TraceSlider.setMinorTickSpacing(2);
		TraceSlider.setPaintTicks(true);
		TraceSlider.setPaintLabels(true);
        TraceSlider.setBackground(getBackground());
        */

        Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
        labelTable.put(0, new JLabel("0.25") );
        labelTable.put(1, new JLabel("1") );
        labelTable.put(2, new JLabel("4") );
        labelTable.put(3, new JLabel("16") );
        labelTable.put(4, new JLabel("64") );
        SpeedSlider.setLabelTable(labelTable);

        SpeedSlider.setMinimum(0);
        SpeedSlider.setMaximum(4);
		SpeedSlider.setMajorTickSpacing(1);
		SpeedSlider.setPaintTicks(true);
		SpeedSlider.setPaintLabels(true);
        SpeedSlider.setBackground(getBackground());
        SpeedSlider.setSnapToTicks(true);
        SpeedSlider.setValue(1);
        SpeedSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                int value = SpeedSlider.getValue();
                double result = Math.pow(4, value - 1);
                Simulation.refreshDeltaT(result);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == PauseButton) {
            if (Simulation.pause) {
                Simulation.pause = false;
                PauseButton.setText("Pause");
            }
            else {
                Simulation.pause = true;
                PauseButton.setText("Resume");
            }
        }
        if (e.getSource() == LoadButton) {
            
        }
        if (e.getSource() == SaveButton) {
            
        }
        if (e.getSource() == ResetButton) {
            Simulation.ObjectBodyList.clear();
        }
    }
}
