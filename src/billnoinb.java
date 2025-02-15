
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class billnoinb{
	public billnoinb(JFrame fm){
		fm.setVisible(false);
		JFrame f=new JFrame("Bill Update");
		JPanel pan=new JPanel();
		
		f.add(pan);
		pan.setLayout(null);
		JLabel frm=new JLabel("Bill No: ");
		pan.add(frm);
		
		JTextField billno=new JTextField();
		billno.setBounds(310,100 , 120, 20);
		pan.add(billno);
		
		
		JButton b1=new JButton("Submit");
		JButton b2=new JButton("Clear");
		JButton b3=new JButton("Back");
		
		
		pan.add(b1);
		pan.add(b2);
		pan.add(b3);
		
		f.setBounds(450, 200, 700, 400);
		frm.setBounds(200, 100, 60, 20);
		b1.setBounds(200, 190, 120, 30);
		b2.setBounds(330, 190, 120, 30);
		b3.setBounds(200 ,240, 250, 40);
		f.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					try {
						new findbentry(f,billno.getText());
						fm.setVisible(false);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						f.setVisible(true);
					}
				fm.setVisible(false);
				
				
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				billno.setText("");
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
		
		
		
	}
}
