
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.management.monitor.Monitor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class updatebill  {
	
	public updatebill(JFrame f,String data,int rown) throws Exception{
		f.setVisible(false);
		String[] datan=data.split(",");
		
		JFrame fa=new JFrame("Update Bill");
		JPanel pan=new JPanel();
		pan.setLayout(null);
		JButton b1=new JButton("Update");
		JButton b2=new JButton("Clear");
		JButton b3=new JButton("Close");
		JButton b4=new JButton("Back");
		b1.setBounds(200, 220, 120, 30);
		b2.setBounds(330, 220, 120, 30);
		b3.setBounds(200 ,270, 250, 40);
		b4.setBounds(10, 10, 120, 30);
		fa.setBounds(450, 200, 700, 400);
		
		JLabel dt=new JLabel("Bill Date: ");
		JLabel billn=new JLabel("Bill No: ");
		JLabel clname=new JLabel("Client Name: ");
		JLabel disc=new JLabel("Work discription: ");
		JLabel amt=new JLabel("Bill Amount: ");
		JLabel status=new JLabel("Bill Status");
		
		JTextField billni=new JTextField(datan[1]);
		JTextField clnamei=new JTextField(datan[2]);
		JTextField disci=new JTextField(datan[3]);
		JTextField amti=new JTextField(datan[4]);
		
		JComboBox statusi=new JComboBox();
		JComboBox<Integer> cdate=new JComboBox<Integer>();
		JComboBox<String> cmonth=new JComboBox<String>();
		JComboBox<Integer> cyear=new JComboBox<Integer>();
		statusi.addItem("Pending");
		statusi.addItem("Paid");
		String ymonths[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};		
		statusi.setSelectedIndex(datan[5]=="Paid"?1:0);

		for(int i=1;i<=31;i++) {
			cdate.addItem(i);
		}
		for(int i=0;i<ymonths.length;i++) {
			cmonth.addItem(ymonths[i]);
		}
		
		for(int i=2023;i<=2024;i++) {
			cyear.addItem(i);
		}
		int mn=0;
		String []dti=datan[0].split("/");
		for(int i=0;i<ymonths.length;i++) {
			if(dti[1]==ymonths[i]) {
				mn=i;
				break;
			}
		}
		cdate.setSelectedIndex(Integer.parseInt(dti[0])-1);
		cmonth.setSelectedIndex(mn);
		cmonth.setSelectedIndex(Integer.parseInt(dti[2])==2023?0:1);

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
		
		pan.add(dt);
		pan.add(b4);
		pan.add(b1);
		pan.add(b2);
		fa.add(pan);
				
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dtin=Integer.toString((int)cdate.getSelectedItem())+"/"+(cmonth.getSelectedIndex()+1)+"/"+Integer.toString((int)cyear.getSelectedItem());

				String ss=(String)(dtin+","+billni.getText()+","+clnamei.getText()+","+disci.getText()+","+amti.getText()+","+statusi.getSelectedItem());
				System.out.println(ss);
				try {
					new updatebcsv(ss,rown);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
