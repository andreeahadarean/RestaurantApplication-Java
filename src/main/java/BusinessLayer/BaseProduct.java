package BusinessLayer;

public class BaseProduct extends MenuItem {

	public BaseProduct(String name, int price) {
		super(name, price);
	}

	public int computePrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return "-- Base Dish: " + name + " --price: " + price + " --";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseProduct other = (BaseProduct) obj;
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
