package ss.week3.math;

public class Exponent implements Function {
	private int power;

	public Exponent (int power) {
		this.power = power;
	}

	public static void main (String[] args) {
		Function myExponent = new Exponent(8);

		System.out.println(myExponent.toString());
	}

	@Override
	public double apply(double x) {
		return Math.pow(x, this.power);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(power, new Exponent(power - 1));
	}

	@Override
	public String toString() {
		return "x^" + this.power;
	}
}
