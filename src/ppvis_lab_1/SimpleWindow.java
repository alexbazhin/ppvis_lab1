package ppvis_lab_1;

import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;


public class SimpleWindow {
    Vector<JCheckBox> checkboxesList = new Vector<JCheckBox>();
    boolean b=false;
    JTextField addToList;
    JButton sendComboBox;
    JComboBox comboBox;

    JButton rename;
    JButton buttonForRename;
    JTextField textForButton;

    JTextField textForFlag;
    JButton setForRadio;
    JRadioButton radioButton31;
    JRadioButton radioButton32;
    JRadioButton radioButton33;

    JTextField countCheck;
    JButton addCheck;
    JButton playStop;


    JTextField textForTable;
    JButton setValueOfTable;
    JButton setValueOfCell2;
    JButton setValueOfCell1;
    JTable table5;
    Object[] headers = {"Column1", "Column2"};
    Object[][] data = {
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""}
    };

    ArrayList<String> list = new ArrayList<String>();

    public SimpleWindow() {
        super();
    }

    public JFrame createFrame(String name) {
        JFrame frame = new JFrame();
        frame.setName(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box box = Box.createHorizontalBox();
        Box box1 = Box.createVerticalBox();
        Box box2 = Box.createVerticalBox();
        Box box3 = Box.createVerticalBox();
        Box box4 = Box.createVerticalBox();
        Box box5 = Box.createVerticalBox();
        Box box21 = Box.createHorizontalBox();
        Box box51 = Box.createHorizontalBox();

        box1.setBorder(new TitledBorder("1"));
        box2.setBorder(new TitledBorder("2"));
        box3.setBorder(new TitledBorder("3"));
        box4.setBorder(new TitledBorder("4"));
        box5.setBorder(new TitledBorder("5"));
        box.add(box1);
        box.add(box2);
        box.add(box3);
        box.add(box4);
        box.add(box5);

        addToList = new JTextField(10);
        sendComboBox = new JButton("Send");
        comboBox = new JComboBox();
        comboBox.setSize(10, 20);

        textForButton = new JTextField(10);
        rename = new JButton("Rename");
        buttonForRename = new JButton("Button");

        textForFlag = new JTextField(10);
        setForRadio = new JButton("Set");
        radioButton31 = new JRadioButton("1");
        radioButton32 = new JRadioButton("2");
        radioButton33 = new JRadioButton("3");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton31);
        buttonGroup.add(radioButton32);
        buttonGroup.add(radioButton33);

        countCheck = new JTextField(10);
        addCheck = new JButton("Add");
        playStop = new JButton("Play/Stop");

        textForTable = new JTextField(10);
        setValueOfTable = new JButton("Button1");
        setValueOfCell2 = new JButton("Button2");
        setValueOfCell1 = new JButton("Button3");

        box1.add(comboBox);
        box1.add(addToList);
        box1.add(sendComboBox);

        box2.add(textForButton);
        box21.add(rename);
        box21.add(buttonForRename);
        box2.add(box21);

        box3.add(textForFlag);
        box3.add(setForRadio);
        box3.add(radioButton31);
        box3.add(radioButton32);
        box3.add(radioButton33);

        box4.add(countCheck);
        box4.add(addCheck);
        box4.add(playStop);

        box5.add(textForTable);
        box51.add(setValueOfTable);
        box51.add(setValueOfCell2);
        box51.add(setValueOfCell1);
        box5.add(box51);
        table5 = new JTable(data, headers);
        JScrollPane scrollPane = new JScrollPane(table5);
        box5.add(scrollPane);
        frame.setContentPane(box);

        sendComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addToList.getText() != null) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).equals(addToList.getText())) {
                            JOptionPane.showMessageDialog(null, "Error");
                            addToList.setText("");
                            return;
                        }
                    }
                    list.add(addToList.getText());
                    comboBox.addItem(addToList.getText());
                    list.add(addToList.getText());
                    addToList.setText("");
                }
            }
        });

        rename.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textForButton.getText() != null) {
                    buttonForRename.setText(textForButton.getText());
                    textForButton.setText("");
                }
            }
        });

        buttonForRename.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String textButton1 = rename.getText();
                    rename.setText(buttonForRename.getText());
                    buttonForRename.setText(textButton1);
            }
        });

        setForRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textForFlag.getText().equals("")) {
                    if (textForFlag.getText().equals(radioButton31.getText())) {
                        radioButton31.setSelected(true);
                        return;
                    }
                    if (textForFlag.getText().equals(radioButton32.getText())) {
                        radioButton32.setSelected(true);
                        return;
                    }
                    if (textForFlag.getText().equals(radioButton33.getText())) {
                        radioButton33.setSelected(true);
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });



        addCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < Integer.parseInt(countCheck.getText()); i++) {
                        checkboxesList.add(new JCheckBox());
                        box4.add(checkboxesList.get(i));
                    }
                }
        });

        ActionListener taskPerformer = new ActionListener() {
            int i = 0;
            public void actionPerformed(ActionEvent evt) {
                if (i < checkboxesList.size()) {
                    checkboxesList.get(i).setSelected(!checkboxesList.get(i).isSelected());
                    i++;
                } else i = 0;
            }
        };

        Timer timer = new Timer(200, taskPerformer);

        playStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!b) {
                    timer.start();
                    b = true;
                }
                else {
                    timer.stop();
                    b = false;
                }
            }
        });

        setValueOfTable.addActionListener(new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == setValueOfTable && textForTable.getText() != null) {
                    Integer rowCount = table5.getRowCount();
                    table5.setValueAt(textForTable.getText(), i, 0);
                    i++;
                }
            }
        });

        setValueOfCell2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == setValueOfCell2) {
                    int rowIndex = table5.getSelectedRow();
                    String strValue = table5.getValueAt(rowIndex, 0).toString();
                    if (table5.getValueAt(rowIndex, 1).toString().equals("")) {
                        table5.setValueAt(strValue, rowIndex, 1);
                        table5.setValueAt("", rowIndex, 0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
            }
        });

        setValueOfCell1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == setValueOfCell1) {
                    int rowIndex = table5.getSelectedRow();
                    String strValue = table5.getValueAt(rowIndex, 1).toString();
                    if (table5.getValueAt(rowIndex, 0).toString().equals("")) {
                        table5.setValueAt(strValue, rowIndex, 0);
                        table5.setValueAt("", rowIndex, 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
            }
        });

        return frame;
    }
}


