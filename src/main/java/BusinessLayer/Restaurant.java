package BusinessLayer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DataLayer.*;

public class Restaurant extends Observable implements RestaurantProcessing {

	public HashMap<Order, ArrayList<MenuItem>> restaurantTable = new HashMap<Order, ArrayList<MenuItem>>();
	public ArrayList<MenuItem> menu = new ArrayList<MenuItem>();

	public void addMenuItems(ArrayList<MenuItem> a) {
		RestaurantSerializator r = new RestaurantSerializator();
		r.writeMenuItems(a);
		menu = r.readMenuItems();
		for (MenuItem item : menu) {
			if (item instanceof CompositeProduct) {
				((CompositeProduct) item).items.addAll(menu);
			}
		}
		for (MenuItem item : menu) {
			if (item instanceof CompositeProduct)
				item.computePrice();
		}
	}

	public void createNewMenuItem(String name, int price, ArrayList<MenuItem> baseProducts) {
		MenuItem m;
		if (price != 0) {
			m = new BaseProduct(name, price);
			assert m != null : "Noul produs este nul!"; 
			for (MenuItem item : menu) {
				if (item.equals(m)) {
					System.out.println("Produsul exista deja in meniu!");
					return;
				}
			}
			menu.add(m);
		} else {
			m = new CompositeProduct(name);
			assert m != null : "Noul produs este nul!"; 
			for (MenuItem item : menu) {
				if (item.equals(m)) {
					System.out.println("Produsul exista deja in meniu!");
					return;
				}
			}
				menu.add(m);
				menu.addAll(baseProducts);
				((CompositeProduct) m).items.addAll(menu);
				m.computePrice();
			}
		RestaurantSerializator r = new RestaurantSerializator();
		r.writeMenuItems(menu);
	}

	public void deleteMenuItem(MenuItem item) {
		boolean found = true;
		int pos = 0; 
		for (int i = 0; i < menu.size(); i++) {
			if (!item.equals(menu.get(i))) {
				found = false;
			} else {
				found = true;
				pos = i; 
				break;
			}
		}
		if (found == true) {
			menu.remove(item);
			if(item instanceof BaseProduct) {
				CompositeProduct p; 
				while(pos >= 0) {
					if(menu.get(pos - 1) instanceof CompositeProduct) {
						p = (CompositeProduct) menu.get(pos - 1);
						p.items.addAll(menu); 
						p.price = p.price - item.price;; 
						break; 
					}
					pos--; 
				}
			}
			RestaurantSerializator r = new RestaurantSerializator();
			r.writeMenuItems(menu);
		} else {
			System.out.println("Produsul nu exista in meniu!");
			return;
		}
	}

	public void editMenuItem(MenuItem item, int newPrice) {
		boolean found = true;
		int pos = 0; 
		for (int i = 0; i < menu.size(); i++) {
			if (!item.equals(menu.get(i))) {
				found = false;
			} else {
				found = true;
				pos = i; 
				break;
			}
		}
		if (found == true) {
			MenuItem m;
			if (item instanceof BaseProduct) {
				m = new BaseProduct(item.name, newPrice);
			}
			else {
				m = new CompositeProduct(item.name);
				m.price = newPrice; 
			}
			menu.add(pos, m);
			menu.remove(pos+1); 
			if(item instanceof BaseProduct)
				modifyPrice(m, item, pos); 
			RestaurantSerializator r = new RestaurantSerializator();
			r.writeMenuItems(menu);
		} else {
			System.out.println("Produsul nu exista in meniu!");
			return;
		}
	}
	
	public void modifyPrice(MenuItem newItem, MenuItem item, int pos) {
		CompositeProduct p; 
		while(pos >= 0) {
			if(menu.get(pos) instanceof CompositeProduct) {
				p = (CompositeProduct) menu.get(pos);
				p.items.addAll(menu); 
				p.price = p.price - item.price + newItem.price; 
				break; 
			}
			pos--; 
		}
	}

	public void createNewOrder(int orderID, String date, int table, ArrayList<MenuItem> food) {
		assert table >= 0 : "Precondition: table < 0";
		assert table <= 20 : "Precondtion: table > 20";
		Order o = new Order(orderID, date, table); 
		restaurantTable.put(o, food);
		setChanged();
		notifyObservers(o);
	}

	private boolean checkPrice(int totalPrice) {
		if (totalPrice >= 0)
			return true;
		return false;
	}

	public int computePrice(Order o) {
		int totalPrice = 0;
		ArrayList<MenuItem> food = restaurantTable.get(o);
		for (MenuItem item : food) {
			totalPrice += item.price;
		}
		assert checkPrice(totalPrice);
		return totalPrice;
	}

	public void generateBill(Order o) {
		if (o == null)
			return;
		int totalPrice = computePrice(o);
		ArrayList<MenuItem> food = restaurantTable.get(o);
		FileWriter writer;
		try {
			writer = new FileWriter("bill" + o.orderID + ".txt");
			writer.write("Order ID: " + o.orderID);
			writer.write(System.lineSeparator());
			writer.write("Date: " + o.date);
			writer.write(System.lineSeparator());
			writer.write("Table NO: " + o.table);
			writer.write(System.lineSeparator());
			for (MenuItem item : food) {
				writer.write(item.toString());
				writer.write(System.lineSeparator());
			}
			writer.write("Total price: " + totalPrice);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void displayMenu() {
		for (MenuItem item : menu) {
			System.out.println(item.toString());
		}
	}

	public void displayTable() {
		System.out.println("Comenzile curente: " + restaurantTable);
	}

	public TableModel generateMenuItemsTable() {
		DefaultTableModel tableModel = new DefaultTableModel(new Object[] { "Menu Items" }, 0);
		for (MenuItem i : menu) {
			tableModel.addRow(new Object[] { i });
		}
		return tableModel;
	}

	public TableModel generateOrdersTable() {
		DefaultTableModel tableModel = new DefaultTableModel(new Object[] { "Order" }, 0);
		for (Order o : restaurantTable.keySet()) {
			tableModel.addRow(new Object[] { o });
		}
		return tableModel;
	}
}
