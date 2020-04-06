package PresentationLayer;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

import BusinessLayer.*;

public class WaiterGUIPrice extends JFrame {
	public Vector<Order> orders = new Vector<Order>();
	public JComboBox o;
	public JButton price;
	public JTextField output;

	public WaiterGUIPrice(ArrayList<Order> orders) {
		this.orders.addAll(orders);
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		p.setBackground(new Color(253, 216, 141));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		o = new JComboBox(this.orders);
		o.setFont(f);
		price = new JButton("Compute price");
		price.setFont(f);
		price.setBackground(Color.WHITE);
		output = new JTextField(30);
		output.setFont(f);
		JLabel h = new JLabel("-- Compute price for an order --");
		h.setFont(f);
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(h, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(o, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(price, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(output, gbc);
		p.add(h);
		p.add(o);
		p.add(price);
		p.add(output);

		this.setContentPane(p);
		this.setSize(720, 1000);
		this.setTitle("Create a menu item");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void addButtonListener(ActionListener a) {
		price.addActionListener(a);
	}
}
