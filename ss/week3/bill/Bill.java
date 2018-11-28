package ss.week3.bill;

import ss.week3.math.Printer;

import java.util.ArrayList;
import java.util.List;

public class Bill {
	interface Item {

	}

	// ----- members ------
	private Printer printer;
	private List<Bill.Item> items;

	// ----- methods ------
	public Bill(Printer printer) {
		this.printer = printer;
		this.items = new ArrayList<>();
	}


}
