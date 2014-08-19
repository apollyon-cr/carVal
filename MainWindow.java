
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.*;

public class MainWindow  {
	
	Car [] c;
	int idx = 0;
	
	JFrame jf;
	JPanel jp;
	JPanel results;
	
	JLabel [] jl;
	
	JButton save;
	JButton clear;
	JButton to_file;
	
	JTextField type;
	JTextField price;
	JTextField kms;
	JTextField year;
	JCheckBox leather;
	JTextField color;
	JTextField location;
	
	File file = new File("c:\\Users\\CR\\Desktop\\cars.txt");
	PrintWriter pr = new PrintWriter(new FileWriter(file));
	StringBuilder sb = new StringBuilder();
	
	public MainWindow() throws IOException {
		
		
		
		c = new Car [100];
		jl = new JLabel [100];
		
		jf = new JFrame();
		
		
		jp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jp.setMinimumSize(new Dimension(480, 600));
		jp.setPreferredSize(new Dimension(480, 600));
		
		results = new JPanel(new FlowLayout(FlowLayout.CENTER));
		results.setMinimumSize(new Dimension(250, 500));
		results.setPreferredSize(new Dimension(250, 500));
		
		
		JLabel lTemp = new JLabel("Type");
		type = new JTextField(10);
		jp.add(lTemp);
		jp.add(type);
		
		lTemp = new JLabel("Price");
		price = new JTextField(10);
		jp.add(lTemp);
		jp.add(price);
		
		lTemp = new JLabel("Kms");
		kms = new JTextField(10);
		jp.add(lTemp);
		jp.add(kms);
		
		lTemp = new JLabel("Year");
		year = new JTextField( 10);
		jp.add(lTemp);
		jp.add(year);
		
		
		lTemp = new JLabel("Color");
		color = new JTextField(10);
		jp.add(lTemp);
		jp.add(color);
		
		lTemp = new JLabel("Location");
		location = new JTextField(10);
		jp.add(lTemp);
		jp.add(location);
		
		leather = new JCheckBox("Leather");
		jp.add(leather);
		
		
		save = new JButton("Save Vehicle");
		save.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				c[idx] = new Car(	type.getText(),
									Integer.parseInt(price.getText()),
									Integer.parseInt(kms.getText()),
									Integer.parseInt(year.getText()),
									leather.isSelected(),
									color.getText(),
									location.getText()
								);		
				
				results.removeAll();
				for(int i = 0; i < c.length; i++) {
					
					if (c[i] != null) {
						jl[i] = new JLabel(c[i].toString());
						results.add(jl[i]);
						results.updateUI();
					}
				}
				
				idx++;
				price.setText("");
				kms.setText("");
				year.setText("");
				color.setText("");
				location.setText("");
			}
		});
		
		clear = new JButton("Clear array");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				Arrays.fill(c,  null);
				results.removeAll();
				results.updateUI();
			}
		});
		
		to_file = new JButton("Save to file");
		to_file.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				
				try {
				
				String element;
				
				
				for (int i = 0; i < c.length; i++) {
				 element = c[i].toString();	
				 sb.append(element);
				 sb.append(",");
				 
				}
				System.out.print(sb.toString());
				pr.println(sb.toString());
				pr.close();
				}
				catch(Exception e){}
				
			}
			
		});
		

		jp.add(save);
		jp.add(to_file);
		jp.add(clear);
		jp.add(results);
		
		
		jf.add(jp);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			new MainWindow();
		}
		
		catch (Exception e){}
	}

}
