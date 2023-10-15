import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

        public class Main {
            public static void main(String[] args) {
                JFrame frame = new JFrame();
                JPanel panel = new JPanel();
                ;


                // cree un botton
                JButton btn = new JButton("Add");
                JButton Reset = new JButton("Reset");
                btn.setBounds(30,0, 30,30);
                Reset.setBounds(90,0, 30,30);

                btn.addActionListener(new ActionListener() {
                    int i = 1;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton btn1 = new JButton("btn "+i);
                        panel.add(btn1);

                        i++;
                        btn1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                panel.remove(btn1);
                                panel.revalidate();
                                panel.repaint();
                            }
                        });
                        panel.revalidate();
                        panel.repaint();
                    }
                });
                Reset.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        panel.removeAll();
                        panel.add(btn);
                        panel.add(Reset);
                        panel.revalidate();
                        panel.repaint();
                    }
                });

                panel.setLayout(new FlowLayout());
                frame.setSize(350,350);
                frame.setLayout(new BorderLayout());
                panel.add(btn);
                panel.add(Reset);


                panel.setBackground(new Color(128,0,200));
                frame.add(panel, BorderLayout.CENTER);

                frame.setVisible(true);
            }
        }

