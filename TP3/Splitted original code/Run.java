import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Run {
    private JFrame frame;
    private JTable table;
    private PersonneTableModel tableModel;

    public Run() {
        frame = new JFrame("Gestion de Personnes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        tableModel = new PersonneTableModel();
        table = new JTable(tableModel);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);

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

}
