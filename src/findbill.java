import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class findbill extends bmain {
	public DefaultTableModel tableModel;
    int totala;

	public static int rown=0;
    public findbill(JFrame f,String billno,JFrame fm) throws Exception {
        String csvFilePath = document; // Replace with the actual path to your CSV file
        String valueToFind =billno; // Replace with the value you want to find in the specified column

        tableModel = new DefaultTableModel();
		JTable table = new JTable(tableModel);
		String []head= {"Sr. No.","Particulars","Amount"};
		tableModel.setColumnIdentifiers(head);
    	
		
		
    	
        try {
            String foundEntry = findCSVEntry(csvFilePath, valueToFind);
            if (foundEntry != null) {
                new generatebill(f,foundEntry, table,totala);
            } else {
                System.out.println("Entry not found.");
                JFrame fz=null;
	        	JOptionPane.showMessageDialog(fz,"Bill not Found.","Bill calculator",JOptionPane.ERROR_MESSAGE);
	        	fm.setVisible(true);

            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
    public String findCSVEntry(String csvFilePath, String valueToFind) throws IOException {
    	int i=1;

    	String data1 = null;
    	try (BufferedReader reader = new BufferedReader(new FileReader(document))) {
            String line;
            // Read the data lines
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if(Integer.parseInt(data[1])==Integer.parseInt(valueToFind )) {
                	data1=line;
                	String datap[]= {String.valueOf(i),data[3],data[4]};
                	tableModel.addRow(datap);
                	totala+=Integer.parseInt(data[4]);
                	i++;
                	
                }
                            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return data1 ;
}}
