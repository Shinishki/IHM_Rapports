import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {
    protected ArrayList<String[]> info = new ArrayList<>();
    protected String[] columnNames = {"Description", "Etat", "Date Limite"};

    public MyTableModel() {
        // info.add(columnNames);
    }

    @Override
    public int getRowCount() {
        return info.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return info.get(rowIndex)[columnIndex];
    }

    public void setValueAt(int rowIndex,String[] s){info.set(rowIndex,s);fireTableRowsUpdated(info.size() - 1, info.size() - 1);}

    public void addRow(String[] rowData) {
        info.add(rowData);
        fireTableRowsInserted(info.size() - 1, info.size() - 1);
    }
    public void removeRow(int rowIndex) {
        info.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
