package ss.week3.math;

public class Sum implements Integrable {
	private Integrable func1;
	private Integrable func2;

	public Sum (Integrable func1, Integrable func2) {
		this.func1 = func1;
		this.func2 = func2;
	}

	public static void main (String[] args) {
		Constant myFunc1 = new Constant(2.0);
		Identity myFunc2 = new Identity();

		Sum mySum = new Sum(myFunc1, myFunc2);

		System.out.println(mySum.toString());
	}

	@Override
	public double apply(double x) {
		return this.func1.apply(x) + this.func2.apply(x);
	}

	@Override
	public Integrable derivative() {
		return new Sum(this.func1.derivative(), this.func2.derivative());
	}

	@Override
	public Integrable integral () {
		return null;
	}

	@Override
	public String toString() {
		return this.func1.toString() + "+" + this.func2.toString();
	}
}
