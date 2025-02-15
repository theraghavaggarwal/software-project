

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;


public class bmain {
	public FileSystemView view = FileSystemView.getFileSystemView();
	public  File file = view.getDefaultDirectory();
	public String document1 = file.getPath();
	static public String document="";
	public static void main(String[] args) throws Exception {
		new loginpage();
	}
}
class loginpage extends bmain{
	JFrame logwin=new JFrame("Main WIndow");
	public loginpage() throws IOException  {
		for (int i = 0; i < document1.length(); i++) {
			if(document1.charAt(i)!='\\')
			{document+=document1.charAt(i);
			}
			else {
				document+="\\";
			}
		}
		document+="\\Bills.csv";
		File fil=new File(document);
		System.out.println(fil.getAbsolutePath());
		if(!fil.exists()) {
			fil.createNewFile();
		}
		
		
		JPanel logpan=new JPanel();
		logpan.setLayout(null);
		JLabel inname=new JLabel("Created by: Raghav Aggarwal");
		inname.setBounds(500, 320, 200, 30);
		
		JLabel billd=new JLabel("Bill");
		billd.setBounds(220, 90, 200, 30);
		billd.setFont(new Font("Calibri", 1, 22));
		logpan.add(billd);
		
		JLabel funds=new JLabel("Funds");
		funds.setBounds(475, 90, 200, 30);
		funds.setFont(new Font("Calibri", 1, 22));
		logpan.add(funds);
		
		JLabel repd=new JLabel("Report");
		repd.setBounds(470, 180, 200, 30);
		repd.setFont(new Font("Calibri", 1, 22));
		logpan.add(repd);
		
		logpan.add(inname);
		JLabel Wlcm=new JLabel("Welcome to Bill Calculator");
		Wlcm.setBounds(220, 50, 400, 30);
		Wlcm.setFont(new Font("Calibri", 1, 25));
		
		
		JButton addb=new JButton("Add Bill");
		addb.setBounds(130, 120, 205, 40);
		logpan.add(addb);
		JButton b=new JButton("Delete Bill");
		JButton bc=new JButton("Close");
		
		JButton genb=new JButton("Generate Bill");
		genb.setBounds(400, 240, 205, 20);
		logpan.add(genb);
		
		JButton updateb=new JButton("Update Bill");
		updateb.setBounds(130, 220, 205, 40);
		logpan.add(updateb);
		
		
		JButton addfnds=new JButton("Add Funds");
		addfnds.setBounds(400, 120, 205, 20);
		logpan.add(addfnds);
		
		JButton delfnds=new JButton("Delete Funds");
		delfnds.setBounds(400, 150, 205, 20);
		logpan.add(delfnds);
		
			
		genb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new billshow(logwin);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				logwin.setVisible(false);
			}
		});
		
		b.setBounds(130, 170, 205, 40);
		bc.setBounds(130, 270, 475, 30);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new billnoin(logwin);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				logwin.setVisible(false);
			}
		});
		addb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new addbill(logwin);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				logwin.setVisible(false);
				
				
				
			}
		});
		updateb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new billnoinb(logwin);
				
			}
		});
		JButton showf=new JButton("Show Bills");
		
		showf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				logwin.setVisible(false);
				new showperiod(logwin);
				
			}
		});
		showf.setBounds(400, 210, 205, 20);
		
		
		logpan.add(showf);
		logpan.add(bc);
		logpan.add(b);
		//b.setVisible(false);
		logpan.add(Wlcm);
		logwin.add(logpan);
		logwin.setBounds(450, 200, 700, 400);
		logwin.setVisible(true);
	}
}
