package BusinessLayer;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {

	private static final long serialVersionUID = 1L;
	public String name;
	public int price;
	
	public MenuItem() {
		
	}
	public MenuItem(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public abstract int computePrice();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
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
