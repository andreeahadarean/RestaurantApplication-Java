package BusinessLayer;

import java.util.ArrayList;

public interface RestaurantProcessing {
	/*
	 ** @pre - check if the menu item exists already
	 */
	public void createNewMenuItem(String name, int price, ArrayList<MenuItem> baseProducts);
	/*
	 ** @post - check if the new menu item in not null
	 */

	/*
	 ** @pre - check is the menu item to be deleted exists
	 */
	public void deleteMenuItem(MenuItem m);

	/*
	 ** @pre - check is the menu item to be edited exists
	 */
	public void editMenuItem(MenuItem item, int newPrice);

	/*
	 ** @pre - check if table is grater than 0 and smaller than 100
	 */
	public void createNewOrder(int orderID, String date, int table, ArrayList<MenuItem> food);

	public int computePrice(Order o);

	/*
	 ** @post - check if the totalPrice is grater than 0
	 */
	/*
	 ** @pre - check if the the order exists
	 */
	public void generateBill(Order o);
}
