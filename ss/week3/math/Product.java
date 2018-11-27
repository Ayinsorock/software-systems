package ss.week3.math;

public class Product implements Integrable {
	private Function func1;
	private Function func2;

	public Product (Function func1, Function func2) {
		this.func1 = func1;
		this.func2 = func2;
	}

	public static void main (String[] args) {
		Function func1 = new Constant(9);
		Function func2 = new Identity();
		Function myProduct = new Product(func1, func2);

		System.out.println(myProduct.toString());
	}

	@Override
	public double apply(double x) {
		return this.func1.apply(x) * this.func2.apply(x);
	}

	@Override
	public Integrable derivative() {
		Integrable left = new Product(this.func1, this.func2.derivative());
		Integrable right = new Product(this.func1.derivative(), this.func2);

		return new Sum(left, right);
	}

	@Override
	public Integrable integral() {
		return null;
	}

	@Override
	public String toString() {
		return this.func1.toString() + " * " + this.func2.derivative().toString() + " + " + this.func1.derivative().toString() + " * " + this.func2.toString();
	}
}
