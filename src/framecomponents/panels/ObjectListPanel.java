package framecomponents.panels;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

import bodies.ObjectBody;

public class ObjectListPanel extends JPanel {

    public static JScrollPane ObjectScrollPane = new JScrollPane();
    static JList<ObjectBody> list = new JList<ObjectBody>();

    ObjectListPanel() {
        setUpComponents();
        initialize();
    }

    private void initialize() {
        Border blackline = BorderFactory.createTitledBorder("Body List");
        this.setBorder(blackline);
        this.setBackground(Color.gray);
        this.setLayout(new GridLayout(1, 1));

        this.add(ObjectScrollPane);
    }

    private void setUpComponents() {
        list.setBackground(Color.gray);
        ObjectScrollPane.setViewportView(list);
    }

    public static void refreshList() {
        DefaultListModel<ObjectBody> listModel = new DefaultListModel<ObjectBody>();
        for (int i = 0; i < Simulation.ObjectBodyList.size(); i++) {
            listModel.addElement(Simulation.ObjectBodyList.get(i));
        }
        list.setModel(listModel);
    }
}
