package ss.week3.math;

/** Prints a function, its derivative and integral, and a couple of applications. */
public class Print {
	public static void print(Function f) {
		System.out.println("f = "+f);
		System.out.println("f' = " + f.derivative());
		if (f instanceof Integrable) {
			System.out.println("F = " + ((Integrable) f).integral());
		}
		System.out.println("f(1) = "+f.apply(1));
		System.out.println("f(2) = "+f.apply(2));
	}
}
