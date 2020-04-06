package PresentationLayer;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdministratorGUI extends JFrame {

	public JButton add;
	public JButton edit;
	public JButton delete;
	public JButton view;

	public AdministratorGUI() {
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		p.setBackground(new Color(253, 216, 141));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		ImageIcon header = new ImageIcon("administrator.png");
		add = new JButton("Add a menu item");
		add.setFont(f);
		add.setBackground(Color.WHITE);
		edit = new JButton("Edit a menu item");
		edit.setFont(f);
		edit.setBackground(Color.WHITE);
		delete = new JButton("Delete a menu item");
		delete.setFont(f);
		delete.setBackground(Color.WHITE);
		view = new JButton("View the menu");
		view.setFont(f);
		view.setBackground(Color.WHITE);
		JLabel h = new JLabel(header);
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(h, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(add, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(edit, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(delete, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(view, gbc);
		p.add(h);
		p.add(add);
		p.add(edit);
		p.add(delete);
		p.add(view);
		this.setContentPane(p);
		this.setSize(1000, 500);
		this.setTitle("Administrator GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(0, 1);
	}

	public void addButton1Listener(ActionListener a) {
		add.addActionListener(a);
	}

	public void addButton2Listener(ActionListener a) {
		edit.addActionListener(a);
	}

	public void addButton3Listener(ActionListener a) {
		delete.addActionListener(a);
	}
	
	public void addButton4Listener(ActionListener a) {
		view.addActionListener(a);
	}

}
