package BusinessLayer;

public class Order {

	public int orderID;
	public String date;
	public int table;

	public Order() {

	}

	public Order(int orderID, String date, int table) {
		this.orderID = orderID;
		this.date = date;
		this.table = table;
	}

	@Override
	public String toString() {
		return "order: " + orderID + " table: " + table + " date: " + date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + orderID;
		result = prime * result + table;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (orderID != other.orderID)
			return false;
		if (table != other.table)
			return false;
		return true;
	}

}
