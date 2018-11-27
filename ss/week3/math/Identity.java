package ss.week3.math;

public class Identity implements Integrable {
	public static void main (String[] args) {
		Identity myFunction = new Identity();

		System.out.println(myFunction.toString());
	}

	@Override
	public double apply(double x) {
		return x;
	}

	@Override
	public Integrable derivative() {
		return new Constant(1);
	}

	@Override
	public Integrable integral() {
		return new Product(new Constant(0.5), new Exponent(2));
	}

	@Override
	public String toString() {
		return "x";
	}
}
