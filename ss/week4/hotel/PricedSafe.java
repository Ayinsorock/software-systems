package ss.week4.hotel;

public class PricedSafe extends ss.week2.hotel.Safe implements ss.week3.bill.Bill.Item {
	private double price;

	public PricedSafe (double price) {
		super();

		this.price = price;
	}

	@Override
	public double amount() {
		return this.price;
	}

	@Override
	public String toString () {
		return "PricedSafe";
	}
}
