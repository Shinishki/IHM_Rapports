import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class PersonneTableModel extends AbstractTableModel {
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
