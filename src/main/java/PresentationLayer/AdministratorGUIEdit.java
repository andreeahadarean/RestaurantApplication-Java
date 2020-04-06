package PresentationLayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import BusinessLayer.*;

public class AdministratorGUIEdit extends JFrame {

	public Vector<MenuItem> menuItems = new Vector<MenuItem>();
	public JComboBox menu;
	public JTextField newPrice;
	public JButton edit;
	public JTextField output;

	public AdministratorGUIEdit(ArrayList<MenuItem> menuItems) {
		this.menuItems.addAll(menuItems);
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		p.setBackground(new Color(253, 216, 141));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		menu = new JComboBox(this.menuItems);
		menu.setFont(f);
		newPrice = new JTextField(20);
		newPrice.setFont(f);
		edit = new JButton("Edit");
		edit.setFont(f);
		edit.setBackground(Color.WHITE);
		JLabel h = new JLabel("-- Edit a menu item --");
		h.setFont(f);
		JLabel l1 = new JLabel("New price: ");
		l1.setFont(f);
		output = new JTextField(30);
		output.setFont(f);
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(h, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(menu, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(l1, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(newPrice, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(edit, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(output, gbc);

		p.add(h);
		p.add(menu);
		p.add(l1);
		p.add(newPrice);
		p.add(edit);
		p.add(output);

		this.setContentPane(p);
		this.setSize(720, 1000);
		this.setTitle("Create a menu item");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void addButtonListener(ActionListener a) {
		edit.addActionListener(a);
	}

}
