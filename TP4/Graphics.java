import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;

public class Graphics extends MyTableModel {
    protected JFrame frame;
    protected JList<String> list;
    protected JTree tree;
    protected JButton AddNode = new JButton("Add Node");
    protected JButton AddTask = new JButton("Add Task");

    protected JButton EndTask = new JButton("End Task");

    protected JButton ModTask = new JButton("Modify");

    protected DefaultListModel<String> listmodel = new DefaultListModel<>();
    protected DefaultListModel<String> listmodelP = new DefaultListModel<>();
    protected DefaultListModel<String> listmodelT = new DefaultListModel<>();

    protected JTable table;
    protected MyTableModel tableModel = new MyTableModel();
    protected JPanel panel = new JPanel();
    protected JComboBox<String> comboBox;
    protected ArrayList<String> nodesname = new ArrayList<>();
    protected DefaultMutableTreeNode personel = new DefaultMutableTreeNode("Personel");
    protected DefaultMutableTreeNode travail = new DefaultMutableTreeNode("Travail");
    protected DefaultMutableTreeNode root = new DefaultMutableTreeNode("Desktop");
    public Graphics()
    {
        this.frame = new JFrame("Gestion de tache");
        this.frame.setSize(600,400);

        nodesname.add("Personel");
        nodesname.add("Travail");

        comboBox = new JComboBox<>(nodesname.toArray(new String[0]));

        //tree
        this.tree = new JTree(root);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(true);

        //frame
        this.frame.add(tree, BorderLayout.WEST);
        tree.setBackground(Color.gray);

        this.list = new JList<String>(listmodel);
        //list.setBackground(Color.cyan);

        //this.frame.add(list,BorderLayout.CENTER);
        frame.add(panel,BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane(list);
        this.frame.add(scrollPane, BorderLayout.CENTER);

        this.table=new JTable(tableModel);
        JScrollPane scrollPane2 = new JScrollPane(table);
        frame.add(scrollPane2, BorderLayout.EAST);
        //table.setBackground(Color.cyan);

        root.add(personel);
        root.add(travail);

        panel.setLayout(new FlowLayout());
        panel.add(comboBox);
        panel.add(AddNode);
        panel.add(AddTask);
        panel.add(EndTask);
        panel.add(ModTask);
        panel.setBackground(Color.white);
        AddTask.setVisible(false);
        EndTask.setVisible(false);
        ModTask.setVisible(false);
        frame.setVisible(true);
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
