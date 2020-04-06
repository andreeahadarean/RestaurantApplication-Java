package PresentationLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class WaiterGUITable extends JFrame {

	JTable table;

	public WaiterGUITable(TableModel model) {
		table = new JTable(model);
		JPanel p = new JPanel();
		p.setBackground(new Color(253, 216, 141));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		JLabel h = new JLabel("-- ORDERS --");
		h.setFont(f);
		h.setAlignmentX(CENTER_ALIGNMENT);
		h.setAlignmentY(TOP_ALIGNMENT);
		table.setFont(f);
		table.setForeground(new Color(98, 89, 102));
		table.setRowHeight(30);
		table.setEnabled(false);
		changeColumnWidth();
		table.setPreferredScrollableViewportSize(new Dimension(600, 500));
		table.setFillsViewportHeight(true);
		final JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setAlignmentX(CENTER_ALIGNMENT);
		scrollPane.setAlignmentY(BOTTOM_ALIGNMENT);
		p.add(h);
		p.add(scrollPane);
		this.setContentPane(p);
		this.setSize(720, 1000);
		this.setTitle("Make-Up Store");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void changeColumnWidth() {
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		for (int i = 1; i <= table.getColumnCount() - 1; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(80);
		}
	}
}
