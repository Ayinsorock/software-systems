package ss.week3.math;

public class LinearProduct implements Function {
	private double n;
	private Function func;

	public LinearProduct(double n, Function func) {
		this.n = n;
		this.func = func;
	}

	@Override
	public double apply(double x) {
		return n * func.apply(x);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(this.n, this.func.derivative());
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
