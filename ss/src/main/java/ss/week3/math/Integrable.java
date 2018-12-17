package ss.week3.math;

public interface Integrable extends Function {
	Integrable integral();

	@Override
	Integrable derivative();
}
