import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class generatebill extends JFrame {

	public generatebill(JFrame f,String data,JTable table,int totala) {
		JFrame fbill=new JFrame();
		JPanel pdisp=new JPanel();
        pdisp.setLayout(null);
        f.setVisible(false);
        
        JButton b=new JButton("Close");
        b.setBounds(0, 680, 500, 30);

        JButton bck=new JButton("Back");
        bck.setBounds(0, 640, 500, 30);
        JButton sve=new JButton("Save");
        sve.setBounds(0, 600, 500, 30);
        pdisp.add(sve);
        JPanel inp=new JPanel();
        inp.setLayout(null);
        Color clr=new Color(255, 255, 255);
        inp.setBackground(clr);
        
        b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fbill.setVisible(false);
				f.setVisible(true);
			}
		});
       
        bck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(true);
				fbill.setVisible(false);
				
			}
		});
        int i=1;
        String []datan=data.split(",");
		String datap[]= {String.valueOf(i),datan[3],datan[4]};
		JLabel bill=new JLabel("Bill");
		JLabel name=new JLabel("<Name>");
		JLabel ca=new JLabel("<Occupation>");
		JLabel billno=new JLabel("Bill No:");
		JLabel billnoi=new JLabel(datan[1]);
		JLabel to=new JLabel("To: ");
		JLabel toi=new JLabel(datan[2]);
		JLabel date=new JLabel("Date: ");
		JLabel datei=new JLabel(datan[0]);
		JLabel total=new JLabel("Total: ");
		JLabel totali=new JLabel(" Rs. "+totala);
		JLabel sign=new JLabel("Signature");
		JLabel address1=new JLabel("<Addressline 1>",JLabel.RIGHT);
		JLabel address2=new JLabel("<AddressLine 2>",JLabel.RIGHT);
		JLabel address3=new JLabel("<AddressLine 3>",JLabel.RIGHT);
		JLabel acc=new JLabel("Please pay in our account number: <Account No>");
		JLabel IFSC=new JLabel("IFSC Code: <IFSC Code>");
		JLabel Bank=new JLabel("Bank Name: <Bank Name>");
		JLabel Mob=new JLabel("Mobile: <Mobile No>",JLabel.RIGHT);
		JLabel email=new JLabel("Email: <Email> ",JLabel.RIGHT);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.WHITE);
    	DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    	rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
    	DefaultTableCellRenderer CenterRenderer = new DefaultTableCellRenderer();
    	CenterRenderer.setHorizontalAlignment(JLabel.CENTER);
    	table.getColumnModel().getColumn(0).setPreferredWidth(65);
    	table.getColumnModel().getColumn(1).setPreferredWidth(250);
    	table.getColumnModel().getColumn(2).setPreferredWidth(114);
    	table.getColumnModel().getColumn(1).setCellRenderer(CenterRenderer);
    	table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);	
    	table.setRowHeight(30);	
    	table.setFont(new Font("Arial",Font.PLAIN,16));
    	table.setRowSelectionAllowed(false);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.black);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.black);
        tableHeader.setForeground(Color.white);
        Font headerFont = new Font("Verdana", Font.BOLD, 15);
        tableHeader.setFont(headerFont);
    	Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
        attributes.put(TextAttribute.FONT, 0.2);
    	
        
    	inp.setAutoscrolls(true);
    	scrollPane.setBackground(clr);
    	table.setBackground(new Color(255, 255, 255));
    	address1.setBounds(230, 70, 240, 20);
    	address2.setBounds(230, 90, 240, 20);
    	address3.setBounds(230, 110, 240, 20);
		scrollPane.setBounds(10, 260, 470, 180);
		date.setBounds(320, 190, 60, 20);
		datei.setBounds(380, 185, 100, 30);
		bill.setBounds(230, 0, 50, 40);
		billno.setBounds(10, 190, 60, 20);
		billnoi.setBounds(70, 190, 150, 20);
		ca.setBounds(10, 70, 150, 20);
		email.setBounds(230, 130, 240, 20);
		name.setBounds(10, 35, 300, 40);
		to.setBounds(10, 220, 30, 30);
		toi.setBounds(40, 220, 150, 30);
		acc.setBounds(10, 470, 300, 20);
		sign.setBounds(380, 560, 150, 20);
		Bank.setBounds(10, 490, 200, 20);
		IFSC.setBounds(10, 510, 150, 20);
		Mob.setBounds(295, 45, 170, 20);
		total.setBounds(340, 470, 60, 20);
		totali.setBounds(380,470,100,20);
		
    	
		scrollPane.setBounds(10, 260, 490, 180);
		date.setFont(new Font("Arial",0,15));
		datei.setFont(new Font("Arial", 1,20));
		bill.setFont(new Font("Arial", 1,20));
		billno.setFont(new Font("Arial", 0,15));
		billnoi.setFont(new Font("Arial", 1,20));
		ca.setFont(new Font("Arial", 0,14));
		name.setFont(new Font("Arial", 1, 25));
		to.setFont(new Font("Arial", 0,15));
		toi.setFont(new Font("Arial", 1,18));
		acc.setFont(new Font("Arial", 0,12));
		sign.setFont(new Font("Arial", 1,10));
		Bank.setFont(new Font("Arial", 0,12));
		IFSC.setFont(new Font("Arial", 0,12));
		Mob.setFont(new Font("Arial", 0,13));
		address1.setFont(new Font("Arial",0,13));
		address2.setFont(new Font("Arial",0,13));

		address3.setFont(new Font("Arial",0,13));
		email.setFont(new Font("Arial",0,13));

		total.setFont(new Font("Arial", 1,13));
		totali.setFont(new Font("Arial", 3, 18));
    	
		
		 sve.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					BufferedImage image = new BufferedImage(inp.getWidth()+20, inp.getHeight(), BufferedImage.TYPE_INT_ARGB);
			        Graphics g = image.getGraphics();
			        inp.paint(g);
			        g.dispose();

			        // Choose a file to save the image
			     // Choose a file to save the image
			        JFileChooser jfc=new JFileChooser();
			        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("image files (*.png)", "png");
			   
			        jfc.addChoosableFileFilter(imgFilter);
			        jfc.setFileFilter(imgFilter);
			        jfc.showSaveDialog(f);
			  
			        File desktopPath = jfc.getSelectedFile();
			        String path=desktopPath.getAbsolutePath()+".png";
			        System.out.println(path);
			            try {
			                ImageIO.write(image, "png", new File(path)); // Save as PNG format
			                JOptionPane.showMessageDialog(null, "Bill saved as image successfully!");
			            } catch (IOException ex) {
			                ex.printStackTrace();
			                       }
			        
					
				}});
		
		
		
		inp.setBounds(0, 0, 520, 595);
		pdisp.add(inp); 
		inp.add(toi);
		inp.add(totali);
		inp.add(email);
		inp.add(datei);
		inp.add(address1);
		inp.add(address2);
		inp.add(address3);
		inp.add(billnoi);
		inp.add(scrollPane);
		inp.add(date);
		inp.add(bill);
		inp.add(billno);
		inp.add(ca);
		inp.add(name);
		inp.add(to);
		inp.add(total);
		inp.add(acc);
		inp.add(sign);
		inp.add(Bank);
		inp.add(IFSC);
		inp.add(Mob);
        pdisp.add(b);
        pdisp.add(bck);
        
        fbill.add(pdisp);
        fbill.setBounds(500, 50,520,780);
        fbill.setVisible(true);
        
	}

	
}
