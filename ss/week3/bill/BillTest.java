package ss.week3.bill;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BillTest {
	public class Item implements Bill.Item {
		private double amount;

		public Item(double amount) {
			this.amount = amount;
		}

		@Override
		public double amount() {
			return this.amount;
		}
	}

	private static final double DELTA  = 1e-15;
	private Bill bill;

	@Before
	public void setUp() {
		StringPrinter myPrinter = new StringPrinter();

		this.bill = new Bill(myPrinter);
	}

	@Test
	public void addBillItems() {
		this.bill.addItem(new Item(3.00));
		this.bill.addItem(new Item(4.00));

		assertEquals(this.bill.getSum(), 7.00, DELTA);
	}

	@Test
	public void closeBill() {
		this.bill.addItem(new Item(3.00));
		this.bill.addItem(new Item(4.00));
		this.bill.close();

		assertTrue(this.bill.printer().getResult().contains("7,00"));
	}
}
