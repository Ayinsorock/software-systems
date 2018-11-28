package ss.week3.bill;

public interface Printer {
	public default String format(String text, double price) {
		return String.format("%-15s%8.2f", text, price);
	};
	void printLine(String text, double price);
}
