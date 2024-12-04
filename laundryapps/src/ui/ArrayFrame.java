package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArrayFrame extends JFrame {
    private JTextField dataField;
    private JTextField indexField;
    private JTextArea displayArea;
    private int[] array;

    public ArrayFrame() {
        // Set up the frame
        setTitle("Array Input and Check");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        getContentPane().setLayout(null);

        // Create and add components
        JLabel lblEnterData = new JLabel("Masukkan Data");
        lblEnterData.setBounds(10, 10, 150, 25);
        getContentPane().add(lblEnterData);

        dataField = new JTextField();
        dataField.setBounds(10, 35, 250, 25);
        getContentPane().add(dataField);

        JButton btnSave = new JButton("Simpan");
        btnSave.setBounds(270, 35, 100, 25);
        getContentPane().add(btnSave);

        JLabel lblIndex = new JLabel("Check array ke-");
        lblIndex.setBounds(10, 70, 150, 25);
        getContentPane().add(lblIndex);

        indexField = new JTextField();
        indexField.setBounds(10, 95, 50, 25);
        getContentPane().add(indexField);

        JButton btnCheck = new JButton("Check");
        btnCheck.setBounds(70, 95, 100, 25);
        getContentPane().add(btnCheck);

        displayArea = new JTextArea();
        displayArea.setBounds(10, 130, 450, 120);
        displayArea.setEditable(false);
        getContentPane().add(displayArea);

        // Add action listeners
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = dataField.getText();
                if (!data.isEmpty()) {
                    String[] dataArray = data.split(",");
                    array = new int[dataArray.length];
                    try {
                        for (int i = 0; i < dataArray.length; i++) {
                            array[i] = Integer.parseInt(dataArray[i].trim());
                        }
                        displayArea.setText("Data disimpan: " + data);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Input data harus berupa angka yang dipisahkan dengan koma.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Masukkan data tidak boleh kosong.");
                }
            }
        });

        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String indexText = indexField.getText();
                if (!indexText.isEmpty()) {
                    try {
                        int index = Integer.parseInt(indexText);
                        if (array != null && index >= 0 && index < array.length) {
                            displayArea.setText("Hasil: Indeks ke-" + index + " adalah " + array[index]);
                        } else {
                            displayArea.setText("Index out of bounds.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Indeks harus berupa angka.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Masukkan indeks tidak boleh kosong.");
                }
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArrayFrame frame = new ArrayFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
