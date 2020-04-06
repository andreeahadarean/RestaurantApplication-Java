package PresentationLayer;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdministratorGUICreate extends JFrame {

	public JTextField name;
	public JTextField price;
	public JTextField baseName1;
	public JTextField basePrice1;
	public JTextField baseName2;
	public JTextField basePrice2;
	public JTextField baseName3;
	public JTextField basePrice3;
	public JButton add;

	public AdministratorGUICreate() {
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		p.setBackground(new Color(253, 216, 141));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		name = new JTextField(20);
		name.setFont(f);
		price = new JTextField(20);
		price.setFont(f);
		price.setEditable(false);
		baseName1 = new JTextField(20);
		baseName1.setFont(f);
		basePrice1 = new JTextField(10);
		basePrice1.setFont(f);
		baseName2 = new JTextField(20);
		baseName2.setFont(f);
		basePrice2 = new JTextField(10);
		basePrice2.setFont(f);
		baseName3 = new JTextField(20);
		baseName3.setFont(f);
		basePrice3 = new JTextField(10);
		basePrice3.setFont(f);
		JLabel h = new JLabel("-- Add a new menu item --");
		h.setFont(f);
		JLabel l1 = new JLabel("-- Composite product --");
		l1.setFont(f);
		JLabel l2 = new JLabel("-- Name -- ");
		l2.setFont(f);
		JLabel l3 = new JLabel("-- Price -- ");
		l3.setFont(f);
		JLabel l4 = new JLabel("-- Base products --");
		l4.setFont(f);
		JLabel l5 = new JLabel("Base product name: ");
		l5.setFont(f);
		JLabel l6 = new JLabel("Price: ");
		l6.setFont(f);
		JLabel l7 = new JLabel("Base product name: ");
		l7.setFont(f);
		JLabel l8 = new JLabel("Price: ");
		l8.setFont(f);
		JLabel l9 = new JLabel("Base product name: ");
		l9.setFont(f);
		JLabel l10 = new JLabel("Price: ");
		l10.setFont(f);
		add = new JButton("Add");
		add.setFont(f);
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(h, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l2, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(name, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l3, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(price, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l5, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(baseName1, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l6, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(basePrice1, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l7, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(baseName2, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l8, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(basePrice2, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l9, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(baseName3, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l10, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(basePrice3, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(add, gbc);
		p.add(h);
		p.add(l2);
		p.add(name);
		p.add(l3);
		p.add(price);
		p.add(l5);
		p.add(baseName1);
		p.add(l6);
		p.add(basePrice1);
		p.add(l7);
		p.add(baseName2);
		p.add(l8);
		p.add(basePrice2);
		p.add(l9);
		p.add(baseName3);
		p.add(l10);
		p.add(basePrice3);
		p.add(add);
		this.setContentPane(p);
		this.setSize(720, 1000);
		this.setTitle("Create a menu item");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void addButtonListener(ActionListener a) {
		add.addActionListener(a);
	}
}