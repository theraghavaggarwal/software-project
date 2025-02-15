
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class addbill extends bmain  {
	
	public addbill(JFrame f) throws Exception{
		f.setVisible(false);
		
		
		
		JFrame fa=new JFrame("Add Bill");
		JPanel pan=new JPanel();
		pan.setLayout(null);
		
		JButton b1=new JButton("Add");
		JButton b2=new JButton("Clear");
		JButton b3=new JButton("Close");
		JButton b4=new JButton("Back");
		
		b1.setBounds(200, 220, 120, 30);
		b2.setBounds(330, 220, 120, 30);
		b3.setBounds(200 ,270, 250, 40);
		b4.setBounds(10, 10, 120, 30);
		fa.setBounds(450, 200, 700, 400);
		
		JLabel dt=new JLabel("Enter Bill Date: ");
		JLabel billn=new JLabel("Enter Bill No: ");
		JLabel clname=new JLabel("Enter Client Name: ");
		JLabel disc=new JLabel("Enter work discription: ");
		JLabel amt=new JLabel("Enter Bill Amount: ");
		JLabel status=new JLabel("Enter Bill Status");
		
		JTextField billni=new JTextField();
		JTextField clnamei=new JTextField();
		JTextField disci=new JTextField();
		JTextField amti=new JTextField();
		
		JComboBox<String> statusi=new JComboBox<String>();
		JComboBox<Integer> cdate=new JComboBox<Integer>();
		JComboBox<String> cmonth=new JComboBox<String>();
		JComboBox<Integer> cyear=new JComboBox<Integer>();
		
		statusi.addItem("Pending");
		statusi.addItem("Paid");
		String ymonths[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};		
		
		for(int i=1;i<=31;i++) {
			cdate.addItem(i);
		}
		for(int i=0;i<ymonths.length;i++) {
			cmonth.addItem(ymonths[i]);
		}
		
		for(int i=2023;i<=2024;i++) {
			cyear.addItem(i);
		}
		
		
		billn.setBounds(180, 70, 140,20);
		clname.setBounds(180, 100, 140,20);
		disc.setBounds(180, 130, 140,20);
		amt.setBounds(180, 160, 140,20);
		status.setBounds(180, 190, 140,20);
		dt.setBounds(180, 40, 140,20);
		billni.setBounds(330, 70, 140,20);
		clnamei.setBounds(330, 100, 140,20);
		disci.setBounds(330, 130, 140,20);
		amti.setBounds(330, 160, 140,20);
		statusi.setBounds(330, 190, 140,20);
		
		cdate.setBounds(330,40, 60, 20);
		cmonth.setBounds(410,40, 70, 20);
		cyear.setBounds(500,40, 80, 20);
		
		pan.add(dt);
		pan.add(billn);
		pan.add(amt);
		pan.add(clname);
		pan.add(disc);
		pan.add(status);
		
		pan.add(cdate);
		pan.add(cmonth);
		
		pan.add(cyear);
		pan.add(billni);
		pan.add(amti);
		pan.add(clnamei);
		pan.add(disci);
		pan.add(statusi);
		
		pan.add(b4);
		pan.add(b1);
		pan.add(b2);
		fa.add(pan);
				
        b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int correct=1;
				if(billni.getText()=="" || billni.getText().length()!=4) {
					correct=0;
					JFrame fz=new JFrame();
		        	JOptionPane.showMessageDialog(fz,"Bill No not Valid.","Bill calculator",JOptionPane.ERROR_MESSAGE);
				}
				if(clnamei.getText().compareTo("")==0) {
					correct=0;
					JFrame fz=new JFrame();
		        	JOptionPane.showMessageDialog(fz,"Client name not Valid.","Bill calculator",JOptionPane.ERROR_MESSAGE);
				}
				if(disci.getText().compareTo("")==0) {
					correct=0;
					JFrame fz=new JFrame();
		        	JOptionPane.showMessageDialog(fz,"Bill Discription not Valid.","Bill calculator",JOptionPane.ERROR_MESSAGE);
				}
				int sz = amti.getText().length();
			    for (int i = 0; i < sz; i++) {
			      	Character.isDigit(amti.getText().charAt(i));
			        if (!Character.isDigit(amti.getText().charAt(i))) {
			          	correct=0;
						JFrame fz=new JFrame();
				       	JOptionPane.showMessageDialog(fz,"Amount not Valid.","Bill calculator",JOptionPane.ERROR_MESSAGE);
				       	break;
			        }
			    }
							
				
				
				if(correct!=0) {
					File fl=new File(document);
					if (!fl.exists()) {
						try {
							fl.createNewFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					FileWriter fileWritter = null;
					try {
						fileWritter = new FileWriter(fl,true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					BufferedWriter bw = new BufferedWriter(fileWritter);
					String dtin=Integer.toString((int)cdate.getSelectedItem())+"/"+(cmonth.getSelectedIndex()+1)+"/"+Integer.toString((int)cyear.getSelectedItem());

					String ss=(String)(dtin+","+billni.getText()+","+clnamei.getText()+","+disci.getText()+","+amti.getText()+","+statusi.getSelectedItem()+"\n");
				
					try {
						bw.write(ss);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JFrame fz=new JFrame();
		        	JOptionPane.showMessageDialog(fz,"Bill Added.","Bill calculator",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});    
		
		
			
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				billni.setText("");
				clnamei.setText("");
				disci.setText("");
				amti.setText("");
				statusi.setSelectedIndex(0);
				cdate.setSelectedIndex(0);
				cmonth.setSelectedIndex(0);
				cyear.setSelectedIndex(0);
				
				
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(true);
				fa.setVisible(false);
				
			}
		});
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(true);
				fa.setVisible(false);
				
			}
		});
		
		
		pan.add(b3);
		fa.add(pan);
		fa.setVisible(true);
	}

}
