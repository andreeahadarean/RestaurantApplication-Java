package PresentationLayer;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WaiterGUI extends JFrame {

	public JButton order;
	public JButton price;
	public JButton bill;
	public JButton view;

	public WaiterGUI() {
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		p.setBackground(new Color(253, 216, 141));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		ImageIcon header = new ImageIcon("waiter.png");
		order = new JButton("Create an order");
		order.setFont(f);
		order.setBackground(Color.WHITE);
		price = new JButton("Compute price");
		price.setFont(f);
		price.setBackground(Color.WHITE);
		bill = new JButton("Generate bill");
		bill.setFont(f);
		bill.setBackground(Color.WHITE);
		view = new JButton("View the orders");
		view.setFont(f);
		view.setBackground(Color.WHITE);
		JLabel h = new JLabel(header);
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(h, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(order, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(price, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(bill, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(view, gbc);
		p.add(h);
		p.add(order);
		p.add(price);
		p.add(bill);
		p.add(view); 
		this.setContentPane(p);
		this.setSize(1000, 500);
		this.setTitle("Waiter GUI");
		this.setLocation(970, 1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addButton1Listener(ActionListener a) {
		order.addActionListener(a);
	}

	public void addButton2Listener(ActionListener a) {
		price.addActionListener(a);
	}

	public void addButton3Listener(ActionListener a) {
		bill.addActionListener(a);
	}
	
	public void addButton4Listener(ActionListener a) {
		view.addActionListener(a);
	}
}
