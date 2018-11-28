package ss.week3.math;

public class LinearProduct extends Product {
	public LinearProduct(Function func1, Function func2) {
		super(func1, func2);
	}

	@Override
	public Integrable derivative() {
		return new LinearProduct(this.func1, this.func2.derivative());
	}
}
