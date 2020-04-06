package PresentationLayer;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

import BusinessLayer.MenuItem;

public class WaiterGUIOrder extends JFrame {

	public JTextField id;
	public JTextField date;
	public JTextField table;
	public JButton order;
	public JCheckBox[] menu = new JCheckBox[20];
	public ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

	public WaiterGUIOrder(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		p.setBackground(new Color(253, 216, 141));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		id = new JTextField(20);
		id.setFont(f);
		date = new JTextField(20);
		date.setFont(f);
		table = new JTextField(20);
		table.setFont(f);
		order = new JButton("Order");
		order.setFont(f);
		order.setBackground(Color.WHITE);
		JLabel h = new JLabel("-- Create an order --");
		h.setFont(f);
		JLabel l1 = new JLabel("Order ID ");
		l1.setFont(f);
		JLabel l2 = new JLabel("Date: ");
		l2.setFont(f);
		JLabel l3 = new JLabel("Table Number: ");
		l3.setFont(f);
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(h, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l1, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(id, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l2, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(date, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l3, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(table, gbc);
		initializeCheckBox(p, gbc, gbag);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(order, gbc);
		p.add(h);
		p.add(l1);
		p.add(id);
		p.add(l2);
		p.add(date);
		p.add(l3);
		p.add(table);
		addCheckBox(p);
		p.add(order);
		this.setContentPane(p);
		this.setSize(720, 1000);
		this.setTitle("Order");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}

	public void initializeCheckBox(JPanel p, GridBagConstraints gbc, GridBagLayout gbag) {
		for (int i = 0; i < menuItems.size(); i++) {
			JCheckBox aux = new JCheckBox(menuItems.get(i).toString());
			menu[i] = aux;
			menu[i].setBackground(new Color(253, 216, 141));
			gbag.setConstraints(menu[i], gbc);
			gbc.gridwidth = GridBagConstraints.REMAINDER;
		}
	}

	public void addCheckBox(JPanel p) {
		for (int i = 0; i < menuItems.size(); i++) {
			p.add(menu[i]);
		}
	}

	public void addButtonListener(ActionListener a) {
		order.addActionListener(a);
	}

	public void addCheckBoxListener(ActionListener a) {
		for (int i = 0; i < menu.length; i++) {
			menu[i].addActionListener(a);
		}
	}

}
