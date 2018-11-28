package ss.week3.bill;

import ss.week3.math.Print;

public class SysoutPrinter implements Printer {
	@Override
	public void printLine(String text, double price) {
		System.out.println(this.format(text, price));
	}
}
