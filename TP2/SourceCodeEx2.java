import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JTextField fact = new JTextField();
        JLabel label = new JLabel();
        JButton calc = new JButton("Fact");
        fact.setText("0");

        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fct = 1;
                if(Integer.parseInt(fact.getText())<17) {
                    for (int i = 2; i <= Integer.parseInt(fact.getText()); i++) {
                        fct = fct * i;
                    }
                    label.setText("");
                    fact.setText(Integer.toString(fct));
                }
                else{
                    label.setText("Result might exceed capacity");
                }

            }
        });

        frame.setSize(400,400);
        frame.setLayout(null);
        frame.add(fact);
        frame.add(calc);
        frame.add(label);
        fact.setBounds(10,10,100,30);
        calc.setBounds(10,50,100,30);
        label.setBounds(10,100,300,30);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        }

    }
