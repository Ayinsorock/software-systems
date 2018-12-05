package ss.week4;

import ss.week3.math.Constant;
import ss.week3.math.Exponent;
import ss.week3.math.Integrable;
import ss.week3.math.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class Polynomial implements ss.week3.math.Integrable {
	List<Double> coefficients;
	public static final double C = 1.0;

	public Polynomial (List<Double> coefficients) {
		this.coefficients = coefficients;
	}

	@Override
	public double apply(double x) {
		double result = 0;

		for(int i = 0; i < this.coefficients.size(); i++) {
			result += (new Product(new Constant(this.coefficients.get(i)), new Exponent(i))).apply(x);
		}

		return result;
	}

	@Override
	public Integrable derivative() {
		List<Double> newCoefficients = new ArrayList<>();

		for (int i = 1; i < this.coefficients.size(); i++) {
			newCoefficients.add(this.coefficients.get(i) * i);
		}

		return new Polynomial(newCoefficients);
	}

	@Override
	public Integrable integral() {
		List<Double> newCoefficients = new ArrayList<>();

		newCoefficients.add(Polynomial.C);
		for (int i = 0; i < this.coefficients.size(); i++) {
			newCoefficients.add(this.coefficients.get(i) / (i + 1));
		}

		return new Polynomial(newCoefficients);
	}
}
