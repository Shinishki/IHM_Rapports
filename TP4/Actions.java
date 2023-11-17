import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Actions extends Graphics{
    private ArrayList<DefaultListModel<String>> listinfo = new ArrayList<>();
    private ArrayList<ArrayList<MyTableModel>> _info = new ArrayList<>();
    private ArrayList<MyTableModel> _info2 = new ArrayList<>();
    private ArrayList<MyTableModel> _info3 = new ArrayList<>();
    private static int index;


    public Actions()
    {
        listinfo.add(listmodelP);
        listinfo.add(listmodelT);
        _info.add(_info2);
        _info.add(_info3);
        this.AddTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                addtask();
            }
        });
        this.AddNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                addnode();
            }
        });
        this.EndTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                if(list.getSelectedIndex()!=-1)
                {
                    endtask(index);
                }
            }
        });
        this.ModTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list.getSelectedIndex()!=-1)
                {
                    modtask(index);
                }
            }
        });
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                if(node!=null)
                {
                index = root.getIndex(node);
                }
                if(index!=-1)
                {
                AddTask.setVisible(true);
                EndTask.setVisible(true);
                ModTask.setVisible(true);
                list.setModel(listinfo.get(index));
                }
                else
                {
                    AddTask.setVisible(false);
                    EndTask.setVisible(false);
                    ModTask.setVisible(false);
                }
            }
        });
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                table.setModel(tableModel);
                int index2 = list.getSelectedIndex();
                if(index2!=-1)
                {
                    table.setModel(_info.get(index).get(index2));
                }
            }
        });
        this.comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tree.setSelectionPath(tree.getPathForRow(comboBox.getSelectedIndex()+1));
            }
        });


    }
    private void addtask()
    {
        String name = JOptionPane.showInputDialog(this.frame, "Name:");
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
        int index4 = root.getIndex(node);
        if(this.listinfo.get(index4).indexOf(name)== -1)
        {
            String Description = JOptionPane.showInputDialog(this.frame, "Description:");
            String Etat = JOptionPane.showInputDialog(this.frame, "Etat:");
            String DateLimite = JOptionPane.showInputDialog(this.frame, "Date Limite:");
            info.add(new String[] {Description,Etat,DateLimite});
            this.listinfo.get(index4).addElement(name);
            this.listmodel.addElement(name);
            MyTableModel tablemodel1 = new MyTableModel();
            _info.get(index4).add(tablemodel1);
            tablemodel1.addRow(new String[]{Description,Etat,DateLimite});
        }
        else
        {
            JOptionPane.showMessageDialog(this.frame,"Task already there");
        }
    }
    private void endtask(int position)
    {
        int x = list.getSelectedIndex();
        listinfo.get(position).remove(x);
        _info.get(position).remove(x);

    }
    private void modtask(int position)
    {
        String Description = JOptionPane.showInputDialog(this.frame, "Description:");
        String Etat = JOptionPane.showInputDialog(this.frame, "Etat:");
        String DateLimite = JOptionPane.showInputDialog(this.frame, "Date Limite:");
        int x = list.getSelectedIndex();
        _info.get(position).get(x).setValueAt(0,new String[]{Description,Etat,DateLimite});

    }

    private void addnode()
    {
        String name = JOptionPane.showInputDialog(this.frame, "Name:");
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(name);
        root.add(node);
        DefaultTreeModel mytreemodel = new DefaultTreeModel(root);
        tree.setModel(mytreemodel);
        DefaultListModel<String> listmodel = new DefaultListModel<>();
        listinfo.add(listmodel);
        ArrayList<MyTableModel> _info2 = new ArrayList<>();
        _info.add(_info2);
        nodesname.add(name);
        comboBox.setModel(new DefaultComboBoxModel<String>(nodesname.toArray(new String[0])));
    }
    private void testindex()
    {
        System.out.print(root.getIndex(travail));
    }

}

