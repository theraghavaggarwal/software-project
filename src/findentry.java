import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class findentry extends bmain {
	public static int rown=0;
    public findentry(JFrame f,String billno) throws Exception {
        String csvFilePath = document; // Replace with the actual path to your CSV file
        String valueToFind =billno; // Replace with the value you want to find in the specified column

        try {
        	rown=0;
            String foundEntry = findCSVEntry(csvFilePath, valueToFind);
            System.out.println(foundEntry);
            if (foundEntry != null) {
                new updatecsv(foundEntry,rown);
                
            } else {
                JFrame er = null;
	        	JOptionPane.showMessageDialog(er,"No Bill Found","Bill calculator",JOptionPane.ERROR_MESSAGE);

            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    private static String findCSVEntry(String csvFilePath, String valueToFind) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {

            
            int columnIndex = 1;

            // Find the index of the specified column
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                rown++;
                System.out.println("line: "+ values[columnIndex]);
                
                if (columnIndex < values.length && values[columnIndex].trim().equals(valueToFind)) {
                    return line;
                }
            }
            br.close();
        }

        return null; // Entry not found
    }
}
