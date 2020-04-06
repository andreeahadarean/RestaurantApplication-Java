package DataLayer;

import java.io.*;
import java.util.ArrayList;

import BusinessLayer.*;

public class RestaurantSerializator {

	@SuppressWarnings("unchecked")
	public ArrayList<MenuItem> readMenuItems() {
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
		File f = new File("menuItems.ser");
		try {
			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			items = (ArrayList<MenuItem>) oi.readObject();
			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("Fisierul nu exista!");
		} catch (IOException e) {
			System.out.println("Nu se poate citi!");
		} catch (ClassNotFoundException e) {
			System.out.println("Clasa nu exista!");
		}

		/*for (MenuItem item : items) {
			System.out.println(item.toString());
		}*/
		return items;
	}

	public void writeMenuItems(ArrayList<MenuItem> items) {
		File f = new File("menuItems.ser");
		try {
			FileOutputStream fo = new FileOutputStream(f);
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			oo.writeObject(items);
			oo.close();
			fo.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fisierul nu exista!");
		} catch (IOException e) {
			System.out.println("Nu se poate scrie!");
		}
	}
}
