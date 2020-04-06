package PresentationLayer;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import BusinessLayer.MenuItem;

public class AdministratorGUIDelete extends JFrame {
	public Vector<MenuItem> menuItems = new Vector<MenuItem>();
	public JComboBox<MenuItem> menu;
	public JButton delete;
	public JTextField output;

	public AdministratorGUIDelete(ArrayList<MenuItem> menuItems) {
		this.menuItems.addAll(menuItems);
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		p.setBackground(new Color(253, 216, 141));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		menu = new JComboBox<MenuItem>(this.menuItems);
		menu.setFont(f);
		delete = new JButton("Delete");
		delete.setFont(f);
		delete.setBackground(Color.WHITE);
		JLabel h = new JLabel("-- Delete a menu item --");
		h.setFont(f);
		output = new JTextField(30);
		output.setFont(f);
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(h, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(menu, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(delete, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(output, gbc);

		p.add(h);
		p.add(menu);
		p.add(delete);
		p.add(output);

		this.setContentPane(p);
		this.setSize(720, 1000);
		this.setTitle("Delete a menu item");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void addButtonListener(ActionListener a) {
		delete.addActionListener(a);
	}
}
