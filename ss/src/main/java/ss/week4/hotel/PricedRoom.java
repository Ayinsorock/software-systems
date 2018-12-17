package ss.week4.hotel;

public class PricedRoom extends ss.week2.hotel.Room implements ss.week3.bill.Bill.Item {
	private double price;
	private PricedSafe safe;

	public PricedRoom (int number, double roomPrice, double safePrice) {
		super(number);

		this.safe = new PricedSafe(safePrice);
		this.price = roomPrice;
	}

	@Override
	public double amount () {
		return this.price;
	}

	@Override
	public String toString () {
		return "The price of the room is: " + this.amount() + this.safe.amount();
	}
}
