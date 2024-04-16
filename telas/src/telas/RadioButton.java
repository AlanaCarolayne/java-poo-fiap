package aula1004;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioButton extends JFrame {
    private JTextField textField;
    private Font plainFont;
    private Font boldFont;
    private Font italicFont;
    private Font boldItalicFont;

    private JRadioButton plainJRadioButton;
    private JRadioButton boldRadioButton;
    private JRadioButton italicRadioButton;
    private JRadioButton bolsItalicRadioButton;
    private ButtonGroup radioGroup;

    public RadioButton() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        setLayout(new FlowLayout());
        setBackground(Color.blue);

        textField = new JTextField("Watch the font style change", 25);
        add(textField);

        plainJRadioButton = new JRadioButton("Plain", true);
        boldRadioButton = new JRadioButton("Bold", false);
        italicRadioButton = new JRadioButton("Italic", false);
        bolsItalicRadioButton = new JRadioButton("Bold & Italic", false);

        add(plainJRadioButton);
        add(boldRadioButton);
        add(italicRadioButton);
        add(bolsItalicRadioButton);

//        cria relacionamento logico entre os JRadioButtons
        radioGroup = new ButtonGroup();
        radioGroup.add(plainJRadioButton);
        radioGroup.add(boldRadioButton);
        radioGroup.add(italicRadioButton);
        radioGroup.add(bolsItalicRadioButton);

//        cria fonte objetos

        plainFont = new Font("Serif", Font.PLAIN, 14);
        boldFont = new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        textField.setFont(plainFont);

//        eventos
        plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont));
        boldRadioButton.addItemListener(new RadioButtonHandler(boldFont));
        italicRadioButton.addItemListener(new RadioButtonHandler(italicFont));
        bolsItalicRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont));
    }

    private class RadioButtonHandler implements ItemListener {
        private Font font;

        public RadioButtonHandler(Font f) {
            font = f;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            textField.setFont(font);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RadioButton frame = new RadioButton();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
