package ss.week3.math;

public class Constant implements Integrable {
	private double c;

	public static void main (String[] args) {
		Constant myFunction = new Constant(2.0);

		System.out.println(myFunction.toString());
		System.out.println("f' = " + myFunction.derivative().toString());
	}

	public Constant (double c) {
		this.c = c;
	}

	@Override
	public double apply(double x) {
		return c;
	}

	@Override
	public Constant derivative() {
		return new Constant(0);
	}

	@Override
	public String toString() {
		return Double.toString(c);
	}

	@Override
	public Integrable integral() {
		return new Product(new Constant(this.c), new Identity());
	}
}
