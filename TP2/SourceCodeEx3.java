import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Calendar;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JTextField fact = new JTextField();
        JLabel label = new JLabel("Annee de naissance");
        JLabel label2 = new JLabel();
        JButton calc = new JButton("Normal");
        JButton calcInv = new JButton("Inverse");

        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar cal = Calendar.getInstance();
                int annee = cal.get(Calendar.YEAR);
                int resultat = annee - Integer.parseInt(fact.getText());
                label2.setText("Vous avez actuellement " + Integer.toString(resultat)+" ans");
            }
        });
        calcInv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar cal = Calendar.getInstance();
                int annee = cal.get(Calendar.YEAR);
                int resultat = Integer.parseInt(fact.getText()) - annee;
                label2.setText("Vous avez actuellement " + Integer.toString(resultat)+" ans");
            }
        });

        frame.setSize(400,400);
        frame.setLayout(null);
        frame.add(fact);
        frame.add(calc);
        frame.add(label);
        frame.add(label2);
        frame.add(calcInv);
        fact.setBounds(210,10,100,30);
        calc.setBounds(10,50,100,30);
        calcInv.setBounds(110,50,100,30);
        label.setBounds(10,10,300,30);
        label2.setBounds(10,150,300,30);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        }

    }
