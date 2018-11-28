package ss.week3.bill;

public class StringPrinter implements Printer {
	private String string;

	@Override
	public void printLine(String text, double price) {
		this.string += this.format(text, price) + "\n";
	}

	public String getResult() {
		return this.string;
	}
}
