import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Initialisation
        JFrame frame = new JFrame("Support Service");
        JButton send = new JButton("Send");
        JLabel label1 = new JLabel("Service* : "),label2 = new JLabel("Problem* : "),label4 = new JLabel("Urgent : "),label3 = new JLabel("Type* : "),label5 = new JLabel("Priority  : "),label6 = new JLabel();
        JTextField service = new JTextField();
        JTextArea problem = new JTextArea();
        JCheckBox urgent = new JCheckBox();
        JRadioButton low = new JRadioButton("Low"),medium = new JRadioButton("Medium"),high = new JRadioButton("High");
        ButtonGroup LMH = new ButtonGroup();
        String[] Type={"Delivery Issues","Payment Issues","Quality Issues"};
        JComboBox<String> type = new JComboBox<>(Type);
        JScrollPane scroll = new JScrollPane(problem,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        Font font = new Font("This is a test",Font.PLAIN,12);

        //Actions
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(type.getSelectedItem()==null || service.getText()==null || problem.getText()==null || (urgent.isSelected()& LMH.getSelection()==null)){

                    label6.setForeground(Color.RED);
                    label6.setText("*One or more ' * ' are empty");
                }
                else{
                    frame.dispose();
                    String priority = "none";
                    if (low.isSelected()) {
                        priority = "Low";
                    } else if (medium.isSelected()) {
                        priority = "Medium";
                    } else if (high.isSelected()) {
                        priority = "High";
                    }
                    JOptionPane.showMessageDialog(null, "Service: " + service.getText() + "\nType: " + type.getSelectedItem() + "\nUrgent: " + urgent.isSelected() + "\nPriority: " + priority, "Note saved and sent", JOptionPane.INFORMATION_MESSAGE);
            }
            }
        });
        urgent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(urgent.isSelected()){
                    label5.setText("Priority* : ");
                    low.setEnabled(true);
                    medium.setEnabled(true);
                    high.setEnabled(true);
                }
                else{
                    label5.setText("Priority  : ");
                    low.setEnabled(false);
                    medium.setEnabled(false);
                    high.setEnabled(false);
                }
            }
        });

        //Settings and components
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label1);frame.add(label2);frame.add(label3);
        frame.add(label4);frame.add(label5);frame.add(label6);
        frame.add(urgent);
        frame.add(send);
        frame.add(type);
        frame.add(service);
        frame.add(problem);
        frame.add(scroll);
        frame.add(low);frame.add(medium);frame.add(high);
        LMH.add(low);LMH.add(medium);LMH.add(high);
        //
        frame.setBounds(50,50,500,500);
        label1.setBounds(20,60,100,20);
        service.setBounds(150,60,200,20);

        label2.setBounds(20,120,100,20);
        problem.setBounds(150,110,200,50);

        label3.setBounds(20,180,100,20);
        type.setBounds(150,180,170,20);

        label4.setBounds(20,240,100,20);
        urgent.setBounds(150,230,40,40);

        label5.setBounds(20,300,100,20);
        low.setBounds(150,302,100,20);
        medium.setBounds(250,302,100,20);
        high.setBounds(350,302,100,20);
        low.setEnabled(false);medium.setEnabled(false);high.setEnabled(false);

        send.setBounds(200,350,100,50);
        label6.setBounds(20,25,300,20);
        problem.setLineWrap(true);
        type.setSelectedIndex(-1);
    }
}
