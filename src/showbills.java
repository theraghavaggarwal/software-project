
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.io.File;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class showbills extends bmain {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;

    public showbills(JFrame f,String sdate,String edate,JFrame fm) throws Exception {
        JFrame fdisp=new JFrame("Bills Report");
        JPanel pdisp=new JPanel();
        pdisp.setLayout(null);
        fm.setVisible(false);
        
        JButton b=new JButton("Close");
        b.setBounds(0, 460, 500, 30);
        
        JButton bck=new JButton("Back");
        bck.setBounds(0, 420, 500, 30);
        JButton sve=new JButton("Save");
        sve.setBounds(0, 380, 500, 30);
        
        pdisp.add(sve);
        // Create a table model
        tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
 
        // Create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 500, 380);
        // Load CSV data into the table model
        loadCSVData(document,sdate,edate,table);
        b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fdisp.setVisible(false);
				fm.setVisible(true);
			}
		});

        sve.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BufferedImage image = new BufferedImage(scrollPane.getWidth(), scrollPane.getHeight(), BufferedImage.TYPE_INT_ARGB);
		        Graphics g = image.getGraphics();
		        scrollPane.paint(g);
		        g.dispose();

		        // Choose a file to save the image
		        FileSystemView view = FileSystemView.getFileSystemView();
		        File file = view.getHomeDirectory();
		        String desktopPath = file.getPath()+"\\Bills\\report.png";
		        
		            try {
		                ImageIO.write(image, "png", new File(desktopPath)); // Save as PNG format
		                JOptionPane.showMessageDialog(null, "Report saved as image successfully!");
		            } catch (IOException ex) {
		                ex.printStackTrace();
		                       }
		        
				
			}});
        bck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(true);
				fdisp.setVisible(false);
				
			}
		});
        pdisp.add(b);
        pdisp.add(scrollPane);
        pdisp.add(bck);
        fdisp.add(pdisp);
        fdisp.setBounds(500, 200,520,530);
        fdisp.setVisible(true);
        
        
    }
   
    private void loadCSVData(String filePath,String sdate,String edate,JTable table) throws Exception {
        // Use OpenCSV to read CSV file
        try (BufferedReader reader = new BufferedReader(new FileReader(document))) {
            String line;
            // Read the header
                String[] headers = {"Date","Bill Number","Client Name","Description","Amount","Bill Status"};
                // Set the headers in the table model
                tableModel.setColumnIdentifiers(headers);

            // Read the data lines
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                data[0]="     "+data[0];
                data[1]="  "+data[1];
                data[2]=data[2]+"  ";
                data[3]=data[3]+"  ";
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dateToCheck = sdf.parse(data[0]);
                Date startDate = sdf.parse(sdate);
                Date endDate = sdf.parse(edate);

                
                if( dateToCheck.compareTo(startDate) >= 0 && dateToCheck.compareTo(endDate) <= 0) {
                	tableModel.addRow(data);
                	DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                	rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
                	table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
                	table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
                }
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
                table.setRowSorter(sorter);

                List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
                sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
                sorter.setSortKeys(sortKeys);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

        
    
}
