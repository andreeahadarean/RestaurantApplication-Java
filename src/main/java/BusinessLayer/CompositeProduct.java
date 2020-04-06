package BusinessLayer;

import java.util.*;

public class CompositeProduct extends MenuItem {

	ArrayList<MenuItem> items = new ArrayList<MenuItem>();

	public CompositeProduct(String name) {
		super(name, 0); 
	}

	public CompositeProduct(String name, ArrayList<MenuItem> items) {
		this.name = name;
		this.items = items;
	}

	public int computePrice() {
		int pos = 0;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).equals(this)) {
				pos = i;
				break;
			}
		}
		int nextPos = pos + 1;
		while (items.get(nextPos) instanceof BaseProduct) {
			price += items.get(nextPos).computePrice();
			nextPos++;
			if (nextPos > items.size() || nextPos == items.size())
				break;
		}
		return price;
	}

	public String toString() {
		return "-- Composite Dish: " + name + " --price: " + price + " --";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeProduct other = (CompositeProduct) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

}
