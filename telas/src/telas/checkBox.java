package aula1004;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class checkBox extends JFrame {
    private JTextField textField;
    private JCheckBox boldJcheckBox;
    private JCheckBox italicJcheckBox;

    public  checkBox(){
        setLayout(new FlowLayout());
        textField = new JTextField("Veja o estilo da fonte mudar");
        textField.setFont(new Font("Serif", Font.PLAIN, 14));
        add(textField);

        boldJcheckBox = new JCheckBox("Negrito");
        italicJcheckBox = new JCheckBox("Italico");

        add(boldJcheckBox);
        add(italicJcheckBox);
        CheckBoxHandler handler = new CheckBoxHandler();
        boldJcheckBox.addItemListener(handler);
        italicJcheckBox.addItemListener(handler);

    }

    private class CheckBoxHandler implements ItemListener{
    private  int valBold = Font.PLAIN;
    private int valItalic = Font.PLAIN;
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == boldJcheckBox){
                valBold = boldJcheckBox.isSelected() ? Font.BOLD: Font.PLAIN;
            }
            if (e.getSource() == italicJcheckBox){
                valItalic = italicJcheckBox.isSelected() ? Font.ITALIC: Font.PLAIN;
            }
            textField.setFont( new Font("Serif", valBold + valItalic,14));
        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                  checkBox frame = new checkBox();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(275, 100);
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
