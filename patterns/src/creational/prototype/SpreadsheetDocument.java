package creational.prototype;
import java.util.*;

public class SpreadsheetDocument extends AbstractDocument {
    private List<String> sheets;
    private int rowCount;
    private int columnCount;

    public SpreadsheetDocument() {
        super("Spread Sheet Document");
        this.sheets=new ArrayList<>();
        this.sheets.add("Sheets1");
        this.rowCount=100;
        this.columnCount=26;
    }

    public SpreadsheetDocument(String content, String metadata, List<String> sheets, int rowCount, int columnCount) {
        super("SpreadSheetDocument");
        this.content=content;
        this.metadata=metadata;
        this.sheets=new ArrayList<>(sheets);
        this.rowCount=rowCount;
        this.columnCount=columnCount;
    }

    // cópia para proteger encapsulamento
    public List<String> getSheets() {
        return new ArrayList<>(sheets);
    }

    public void setSheets(List<String> sheets) {
        this.sheets=new ArrayList<>(sheets);
    }

    public void addSheet(String sheetName) {
        sheets.add(sheetName);
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }
    
    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }
    
    @Override
    public Document clone() {
        return new SpreadsheetDocument(this.content, this.metadata, 
                                      new ArrayList<>(this.sheets), // Deep copy
                                      this.rowCount, this.columnCount);
    }

    @Override
    public String toString() {
        return "SpreadsheetDocument{" +
                "type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", metadata='" + metadata + '\'' +
                ", sheets=" + sheets +
                ", rowCount=" + rowCount +
                ", columnCount=" + columnCount +
                '}';
        }
}
