package ss.week3.bill;

import java.util.ArrayList;
import java.util.List;

public class Bill {
	public interface Item {
		public double amount();
	}

	// ----- members ------
	private StringPrinter printer;
	private List<Bill.Item> items;

	// ----- methods ------
	public Bill(StringPrinter printer) {
		this.printer = printer;
		this.items = new ArrayList<>();
	}

	public void addItem(Bill.Item item) {
		this.printer.printLine("", item.amount());
		this.items.add(item);
	}

	public StringPrinter printer() {
		return this.printer;
	}

	public double getSum() {
		return this.items.stream().map(Bill.Item::amount).reduce((double) 0, Double::sum);
	}

	public void close() {
		this.printer.printLine("Total", this.getSum());
	}
}
