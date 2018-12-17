package ss.week3.math;

public class Exponent implements Function {
	private int power;

	public Exponent (int power) {
		this.power = power;
	}

	public static void main (String[] args) {
		Print.print(new Exponent(3));
	}

	@Override
	public double apply(double x) {
		return Math.pow(x, this.power);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(new Constant(power), new Exponent(power - 1));
	}

	@Override
	public String toString() {
		return "x^" + this.power;
	}
}
