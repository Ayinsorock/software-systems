package ss.week3.math;

public class LinearProduct extends Product {
	Constant func1;

	public LinearProduct(Constant func1, Function func2) {
		super(func1, func2);

		this.func1 = func1;
	}

	@Override
	public Integrable derivative() {
		return new LinearProduct(this.func1, this.func2.derivative());
	}
}
