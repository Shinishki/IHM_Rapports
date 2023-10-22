import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Personne {
    private String nom;
    private String prenom;
    private int age;

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class PersonneTableModel extends AbstractTableModel {
    private List<Personne> personnes = new ArrayList<>();
    private String[] columnNames = {"Nom", "Prénom", "Âge"};

    public void addPersonne(Personne personne) {
        personnes.add(personne);
        fireTableRowsInserted(personnes.size() - 1, personnes.size() - 1);
    }

    public void removePersonne(int rowIndex) {
        personnes.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public Personne getPersonne(int rowIndex) {
        return personnes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return personnes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Personne personne = personnes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return personne.getNom();
            case 1:
                return personne.getPrenom();
            case 2:
                return personne.getAge();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}

public class TableauApp {
    private JFrame frame;
    private JTable table;
    private PersonneTableModel tableModel;

    public TableauApp() {
        frame = new JFrame("Gestion de Personnes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        tableModel = new PersonneTableModel();
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        frame.add(buttonPanel, BorderLayout.SOUTH);

        JButton addButton = new JButton("Ajouter");
        JButton deleteButton = new JButton("Supprimer");
        JButton updateButton = new JButton("Mettre à jour");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterPersonne();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supprimerPersonne();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mettreAJourPersonne();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private void ajouterPersonne() {
        String nom = JOptionPane.showInputDialog(frame, "Nom:");
        String prenom = JOptionPane.showInputDialog(frame, "Prénom:");
        String ageStr = JOptionPane.showInputDialog(frame, "Âge:");
        try {
            int age = Integer.parseInt(ageStr);
            Personne personne = new Personne(nom, prenom, age);
            tableModel.addPersonne(personne);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Âge invalide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void supprimerPersonne() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removePersonne(selectedRow);
        } else {
            JOptionPane.showMessageDialog(frame, "Sélectionnez une personne à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mettreAJourPersonne() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            Personne personne = tableModel.getPersonne(selectedRow);
            String nom = JOptionPane.showInputDialog(frame, "Nom:", personne.getNom());
            String prenom = JOptionPane.showInputDialog(frame, "Prénom:", personne.getPrenom());
            String ageStr = JOptionPane.showInputDialog(frame, "Âge:", personne.getAge());
            try {
                int age = Integer.parseInt(ageStr);
                personne.setNom(nom);
                personne.setPrenom(prenom);
                personne.setAge(age);
                tableModel.fireTableDataChanged();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Âge invalide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Sélectionnez une personne à mettre à jour.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
       new TableauApp();
    }
}
