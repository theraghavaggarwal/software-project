import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class updatecsv extends bmain {

    public updatecsv(String data,int rown ) throws IOException {
    	String csvFilePath=document;
        
        // Assuming the new data you want to update
        try {
            updateCSV(csvFilePath, rown);
        	JFrame fz=null;
			JOptionPane.showMessageDialog(fz,"Bill Deleted.","Bill calculator",JOptionPane.INFORMATION_MESSAGE);

            
        } catch (IOException e) {
            System.err.println("Error updating CSV file: " + e.getMessage());
        }
    }

    private static void updateCSV(String csvFilePath, int rowToUpdate) throws IOException {
    	FileSystemView view = FileSystemView.getFileSystemView();
    	File file = view.getDefaultDirectory();
    	String dc = file.getPath()+"\\temp.csv";
    	try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(dc))) {

            String line;
            int currentRow = 1;


            // Copy the existing data to the new file, updating the specified row
            while ((line = br.readLine()) != null) {
                if (currentRow != rowToUpdate) {
                    bw.write(line);
                    bw.newLine();
                }
                

                currentRow++;
            }
            br.close();
            bw.close();
        }

        // Replace the original file with the updated file
        replaceOriginalFile(csvFilePath, dc);
    }

    private static void replaceOriginalFile(String originalFilePath, String tempFilePath) throws IOException {
        // Delete the original file
        if (!new java.io.File(originalFilePath).delete()) {
            throw new IOException("Could not delete the original file.");
        }

        // Rename the temporary file to the original file name
        if (!new java.io.File(tempFilePath).renameTo(new java.io.File(originalFilePath))) {
            throw new IOException("Could not rename the temporary file.");
        }
    }
}
