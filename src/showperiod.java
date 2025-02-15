
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class showperiod  {
	public  showperiod(JFrame fm) {
		fm.setVisible(false);
		JFrame f=new JFrame("Date enter");
		JPanel pan=new JPanel();
		f.add(pan);
		pan.setLayout(null);

		JLabel start=new JLabel("Start: ");
		JLabel end=new JLabel("End: ");
		
		
		JComboBox<Integer> sdate=new JComboBox<Integer>();
		JComboBox<String> smonth=new JComboBox<String>();
		JComboBox<Integer> syear=new JComboBox<Integer>();
		JComboBox<Integer> edate=new JComboBox<Integer>();
		JComboBox<String> emonth=new JComboBox<String>();
		JComboBox<Integer> eyear=new JComboBox<Integer>();
		
		
		String ymonths[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};		
		
		for(int i=1;i<=31;i++) {
			sdate.addItem(i);
			edate.addItem(i);

		}
		for(int i=0;i<ymonths.length;i++) {
			smonth.addItem(ymonths[i]);
			emonth.addItem(ymonths[i]);
		}
		
		for(int i=2023;i<=2024;i++) {
			syear.addItem(i);
			eyear.addItem(i);
		}
		
		JButton b1=new JButton("Submit");
		JButton b2=new JButton("Clear");
		JButton b3=new JButton("Back");
		
		
		
		pan.add(b1);
		pan.add(b2);
		pan.add(b3);
		
		pan.add(sdate);
		pan.add(smonth);
		pan.add(syear);
		
		pan.add(edate);
		pan.add(emonth);
		pan.add(eyear);
		
		f.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String stdate="",endate="";
				
				if((int)syear.getSelectedItem()<= (int)eyear.getSelectedItem()) {
					if(smonth.getSelectedIndex()<=emonth.getSelectedIndex()) {
						if((int)sdate.getSelectedItem()<=(int)edate.getSelectedItem()) {
							stdate=Integer.toString((int)sdate.getSelectedItem())+"/"+(smonth.getSelectedIndex()+1)+"/"+Integer.toString((int)syear.getSelectedItem());
							endate=Integer.toString((int)edate.getSelectedItem())+"/"+(emonth.getSelectedIndex()+1)+"/"+Integer.toString((int)eyear.getSelectedItem());
							try {
								
								new showbills(f,stdate,endate,fm);
								
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							f.setVisible(false);
						}else {
							JFrame fz=new JFrame();
				        	JOptionPane.showMessageDialog(fz,"Date not Valid.","Bill calculator",JOptionPane.ERROR_MESSAGE);
						}
						
					}else {
						JFrame fz=new JFrame();
			        	JOptionPane.showMessageDialog(fz,"Date not Valid.","Bill calculator",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JFrame fz=new JFrame();
		        	JOptionPane.showMessageDialog(fz,"Date not Valid.","Bill calculator",JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sdate.setSelectedIndex(0);
				smonth.setSelectedIndex(0);
				syear.setSelectedIndex(0);
				edate.setSelectedIndex(0);
				emonth.setSelectedIndex(0);
				eyear.setSelectedIndex(0);
			}
		});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				fm.setVisible(true);
			}
		});
		pan.add(start);
		pan.add(end);
		start.setBounds(140, 70, 60, 20);
		end.setBounds(140, 100, 60, 20);
		sdate.setBounds(200,70, 60, 20);
		smonth.setBounds(280,70, 70, 20);
		syear.setBounds(370,70, 80, 20);
		f.setBounds(450, 200, 700, 400);
		b1.setBounds(200, 190, 120, 30);
		b2.setBounds(330, 190, 120, 30);
		b3.setBounds(200 ,240, 250, 40);
		edate.setBounds(200,100, 60, 20);
		emonth.setBounds(280,100, 70, 20);
		eyear.setBounds(370,100, 80, 20);
		
	}
	
}

