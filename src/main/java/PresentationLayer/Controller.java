package PresentationLayer;

import java.awt.event.*;
import java.util.*;
import BusinessLayer.*;

public class Controller {

	AdministratorGUI a = new AdministratorGUI();
	AdministratorGUICreate a1 = new AdministratorGUICreate();
	WaiterGUI w = new WaiterGUI();
	ChefGUI c = new ChefGUI();
	Restaurant r = new Restaurant();

	public Controller() {
		initializeMenu();
		r.addObserver(c);
		a.setVisible(true);
		a.addButton1Listener(new AdminListener());
		a.addButton2Listener(new AdminListener());
		a.addButton3Listener(new AdminListener());
		a.addButton4Listener(new AdminListener());
		a1.addButtonListener(new AdminListener());
		w.setVisible(true);
		w.addButton1Listener(new WaiterListener());
		w.addButton2Listener(new WaiterListener());
		w.addButton3Listener(new WaiterListener());
		w.addButton4Listener(new WaiterListener());
		c.setVisible(true);
	}

	public void initializeMenu() {
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		menu.add(new CompositeProduct("Gratar piept pui"));
		menu.add(new BaseProduct("Piept pui", 10));
		menu.add(new BaseProduct("Condimente", 2));
		menu.add(new CompositeProduct("Paste carbonara"));
		menu.add(new BaseProduct("Paste", 8));
		menu.add(new BaseProduct("Ou", 4));
		menu.add(new BaseProduct("Smantana", 6));
		menu.add(new CompositeProduct("Pilaf cu legume"));
		menu.add(new BaseProduct("Orez", 4));
		menu.add(new BaseProduct("Ciuperci", 4));
		menu.add(new BaseProduct("Ardei", 2));
		menu.add(new BaseProduct("Morcovi", 2));
		menu.add(new CompositeProduct("Cartofi prajiti"));
		menu.add(new BaseProduct("Cartofi", 4));
		menu.add(new BaseProduct("Ulei", 5));
		r.addMenuItems(menu);
	}

	class AdminListener implements ActionListener {

		public void createNewItem() {
			BaseProduct b1 = new BaseProduct(a1.baseName1.getText(), Integer.parseInt(a1.basePrice1.getText()));
			BaseProduct b2 = new BaseProduct(a1.baseName2.getText(), Integer.parseInt(a1.basePrice2.getText()));
			BaseProduct b3 = new BaseProduct(a1.baseName3.getText(), Integer.parseInt(a1.basePrice3.getText()));
			ArrayList<MenuItem> base = new ArrayList<MenuItem>();
			base.add(b1);
			base.add(b2);
			base.add(b3);
			r.createNewMenuItem(a1.name.getText(), 0, base);
			int totalPrice = b1.price + b2.price + b3.price;
			a1.price.setText("" + totalPrice);
			System.out.println("----------------------------------");
			r.displayMenu();
		}

		public void actionPerformed(ActionEvent action) {
			if (action.getSource() == a.add)
				a1.setVisible(true);
			if (action.getSource() == a1.add)
				createNewItem();
			if (action.getSource() == a.edit) {
				AdministratorGUIEdit a2 = new AdministratorGUIEdit(r.menu);
				a2.setVisible(true);
				a2.addButtonListener(new Aux1AdminListener(a2));
			}
			if (action.getSource() == a.delete) {
				AdministratorGUIDelete a3 = new AdministratorGUIDelete(r.menu);
				a3.addButtonListener(new Aux2AdminListener(a3));
				a3.setVisible(true);
			}
			if (action.getSource() == a.view) {
				AdministratorGUITable a4 = new AdministratorGUITable(r.generateMenuItemsTable());
				a4.setVisible(true);
			}
		}
	}

	class Aux1AdminListener implements ActionListener {

		AdministratorGUIEdit a2;

		public Aux1AdminListener(AdministratorGUIEdit a2) {
			this.a2 = a2;
		}

		public void actionPerformed(ActionEvent action) {
			if (action.getSource() == a2.edit) {
				int pos = a2.menu.getSelectedIndex();
				MenuItem m = r.menu.get(pos);
				r.editMenuItem(m, Integer.parseInt(a2.newPrice.getText()));
				a2.output.setText("The menu item has been modified!");
				System.out.println("----------------------------------");
				r.displayMenu();
			}
		}
	}

	class Aux2AdminListener implements ActionListener {

		AdministratorGUIDelete a3;

		public Aux2AdminListener(AdministratorGUIDelete a3) {
			this.a3 = a3;
		}

		public void actionPerformed(ActionEvent action) {
			if (action.getSource() == a3.delete) {
				int pos = a3.menu.getSelectedIndex();
				MenuItem m = r.menu.get(pos);
				System.out.println(m.toString());
				r.deleteMenuItem(m);
				a3.output.setText("The menu item has been deleted!");
				System.out.println("----------------------------------");
				r.displayMenu();
			}
		}
	}

	class WaiterListener implements ActionListener {

		public void actionPerformed(ActionEvent action) {
			if (action.getSource() == w.order) {
				WaiterGUIOrder w1 = new WaiterGUIOrder(r.menu);
				w1.setVisible(true);
				w1.addButtonListener(new Aux1WaiterListener(w1));
			}
			if (action.getSource() == w.bill) {
				Collection<Order> o = r.restaurantTable.keySet();
				ArrayList<Order> listOfKeys = new ArrayList<Order>(o);
				WaiterGUIBill w2 = new WaiterGUIBill(listOfKeys);
				w2.addButtonListener(new Aux2WaiterListener(w2, listOfKeys));
				w2.setVisible(true);
			}
			if (action.getSource() == w.price) {
				Collection<Order> o = r.restaurantTable.keySet();
				ArrayList<Order> listOfKeys = new ArrayList<Order>(o);
				WaiterGUIPrice w3 = new WaiterGUIPrice(listOfKeys);
				w3.addButtonListener(new Aux3WaiterListener(w3, listOfKeys));
				w3.setVisible(true);
			}
			if (action.getSource() == w.view) {
				WaiterGUITable w4 = new WaiterGUITable(r.generateOrdersTable());
				w4.setVisible(true);
			}
		}
	}

	class Aux1WaiterListener implements ActionListener {

		WaiterGUIOrder w1;

		public Aux1WaiterListener(WaiterGUIOrder w1) {
			this.w1 = w1;
		}

		public void actionPerformed(ActionEvent action) {
			if (action.getSource() == w1.order) {
				ArrayList<MenuItem> food = new ArrayList<MenuItem>();
				for (int i = 0; i < w1.menuItems.size(); i++) {
					if (w1.menu[i].isSelected() == true) {
						food.add(r.menu.get(i));
					}
				}
				r.createNewOrder(Integer.parseInt(w1.id.getText()), w1.date.getText(),
						Integer.parseInt(w1.table.getText()), food);
				System.out.println("----------------------------------");
				r.displayTable();
			}
		}
	}

	class Aux2WaiterListener implements ActionListener {

		WaiterGUIBill w2;
		ArrayList<Order> orders = new ArrayList<Order>();

		public Aux2WaiterListener(WaiterGUIBill w2, ArrayList<Order> orders) {
			this.w2 = w2;
			this.orders = orders;
		}

		public void actionPerformed(ActionEvent action) {
			if (action.getSource() == w2.price) {
				int pos = w2.o.getSelectedIndex();
				Order o = orders.get(pos);
				r.generateBill(o);
			}
		}
	}

	class Aux3WaiterListener implements ActionListener {

		WaiterGUIPrice w3;
		ArrayList<Order> orders = new ArrayList<Order>();

		public Aux3WaiterListener(WaiterGUIPrice w3, ArrayList<Order> orders) {
			this.w3 = w3;
			this.orders = orders;
		}

		public void actionPerformed(ActionEvent action) {
			if (action.getSource() == w3.price) {
				int pos = w3.o.getSelectedIndex();
				Order o = orders.get(pos);
				int price = r.computePrice(o);
				w3.output.setText("" + price);
			}
		}
	}
}
