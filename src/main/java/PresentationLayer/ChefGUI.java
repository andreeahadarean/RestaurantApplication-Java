package PresentationLayer;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class ChefGUI extends JFrame implements Observer {

	public JTextField update;

	public ChefGUI() {
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		p.setBackground(new Color(253, 216, 141));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		ImageIcon header = new ImageIcon("chef.png");
		update = new JTextField(20);
		update.setFont(f);
		update.setEditable(false);
		JLabel h = new JLabel(header);
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(h, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(update, gbc);
		p.add(h);
		p.add(update);
		this.setContentPane(p);
		this.setSize(1000, 500);
		this.setTitle("Chef GUI");
		this.setLocation(0, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void update(Observable arg0, Object o) {
		update.setText("The chef is cooking for " + o);
	}

}
