package ppvis_lab_1;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SimpleWindow extends JFrame {
    JTextField textField;
    JButton button;
    JComboBox comboBox;

    JButton button21;
    JButton button22;
    JTextField textField2;

    JTextField textField3;
    JButton button3;
    JRadioButton radioButton31;
    JRadioButton radioButton32;
    JRadioButton radioButton33;

    JTextField textField4;
    JButton button4;
    JCheckBox checkBox41;
    JCheckBox checkBox42;
    JCheckBox checkBox43;

    JTextField textField5;
    JButton button51;
    JButton button52;
    JButton button53;
    JTable table5;
    Object[] headers = { "Column1", "Column2"};
    Object[][] data = {
            { "", "" },
            { "", "" },
            { "", "" },
            { "", "" },
            { "", "" }
    };

    eHandler handler = new eHandler();
    ArrayList<String> list = new ArrayList<String>();

    public SimpleWindow(String name) {
        super(name);

        Box box = Box.createHorizontalBox();
        Box box1 = Box.createVerticalBox();
        Box box2 = Box.createVerticalBox();
        Box box3 = Box.createVerticalBox();
        Box box4 = Box.createVerticalBox();
        Box box5 = Box.createVerticalBox();

        box1.setBorder(new TitledBorder("1"));
        box2.setBorder(new TitledBorder("2"));
        box3.setBorder(new TitledBorder("3"));
        box4.setBorder(new TitledBorder("4"));
        box5.setBorder(new TitledBorder("5"));

        textField = new JTextField(10);
        button = new JButton("Send");
        comboBox = new JComboBox();
        comboBox.setSize(10, 20);

        textField2 = new JTextField(10);
        button21 = new JButton("Rename");
        button22 = new JButton("Button");
        Box box21 = Box.createHorizontalBox();

        textField3 = new JTextField(10);
        button3 = new JButton("Set");
        radioButton31 = new JRadioButton("Флаг 1");
        radioButton32 = new JRadioButton("Флаг 2");
        radioButton33 = new JRadioButton("Флаг 3");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton31);
        buttonGroup.add(radioButton32);
        buttonGroup.add(radioButton33);

        textField4 = new JTextField(10);
        button4 = new JButton("Set");
        checkBox41 = new JCheckBox("Флаг 1");
        checkBox42 = new JCheckBox("Флаг 2");
        checkBox43 = new JCheckBox("Флаг 3");

        textField5 = new JTextField(10);
        button51 = new JButton("Button1");
        button52 = new JButton("Button2");
        button53 = new JButton("Button3");
        Box box51 = Box.createHorizontalBox();
        table5= new JTable(data, headers);
        JScrollPane scrollPane = new JScrollPane(table5);

        box.add(box1);
        box.add(box2);
        box.add(box3);
        box.add(box4);
        box.add(box5);

        box1.add(comboBox);
        box1.add(textField);
        box1.add(button);

        box2.add(textField2);
        box21.add(button21);
        box21.add(button22);
        box2.add(box21);

        box3.add(textField3);
        box3.add(button3);
        box3.add(radioButton31);
        box3.add(radioButton32);
        box3.add(radioButton33);

        box4.add(textField4);
        box4.add(button4);
        box4.add(checkBox41);
        box4.add(checkBox42);
        box4.add(checkBox43);

        box5.add(textField5);
        box51.add(button51);
        box51.add(button52);
        box51.add(button53);
        box5.add(box51);
        box5.add(scrollPane);

        setContentPane(box);
        button.addActionListener(handler);
        button21.addActionListener(handler);
        button22.addActionListener(handler);
        button3.addActionListener(handler);
        button4.addActionListener(handler);
        button51.addActionListener(handler);
        button52.addActionListener(handler);
        button53.addActionListener(handler);
    }

    public class eHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == button) {
                    for (int i=0; i<list.size(); i++) {
                        if (list.get(i).equals(textField.getText())) {
                            JOptionPane.showMessageDialog(null, "Объект уже существует");
                            textField.setText("");
                            return;
                        }
                    }
                    list.add(textField.getText());
                    comboBox.addItem(textField.getText());
                    list.add(textField.getText());
                    textField.setText("");
                }
                if (e.getSource()==button21) {
                    button22.setText(textField2.getText());
                    textField2.setText("");
                }
                if (e.getSource()==button22) {
                    String textButton1 = button21.getText();
                    button21.setText(button22.getText());
                    button22.setText(textButton1);
                }
                if (e.getSource()==button3 && !textField3.getText().equals("")) {
                    if (textField3.getText().equals(radioButton31.getText())) {
                        radioButton31.setSelected(true);
                        return;
                    }
                    if (textField3.getText().equals(radioButton32.getText())) {
                        radioButton32.setSelected(true);
                        return;
                    }
                    if (textField3.getText().equals(radioButton33.getText())) {
                        radioButton33.setSelected(true);
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Ошибка");
                }
                if (e.getSource()==button4) {
                    if (textField4.getText().equals(checkBox41.getText())) {
                        checkBox41.setSelected(true);
                        return;
                    }
                    if (textField4.getText().equals(checkBox42.getText())) {
                        checkBox42.setSelected(true);
                        return;
                    }
                    if (textField4.getText().equals(checkBox43.getText())) {
                        checkBox43.setSelected(true);
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Ошибка");
                }
                if (e.getSource()==button51) {
                    Integer rowCount = table5.getRowCount();
                    for (int i=0; i<rowCount; i++) {
                        table5.setValueAt(textField5.getText(), i, 0);
                    }
                }
                if (e.getSource()==button52) {
                    int rowIndex = table5.getSelectedRow();
                    String strValue = table5.getValueAt(rowIndex, 0).toString();
                    table5.setValueAt(strValue, rowIndex, 1);
                    table5.setValueAt("", rowIndex, 0);
                }
                if (e.getSource()==button53) {
                    int rowIndex = table5.getSelectedRow();
                    String strValue = table5.getValueAt(rowIndex, 1).toString();
                    table5.setValueAt(strValue, rowIndex, 0);
                    table5.setValueAt("", rowIndex, 1);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }
}
