package ss.week4;

import java.util.ArrayList;
import java.util.List;


/**
 * Does dingen.
 */
public final class Util {
	/**
	 * Private constructor.
	 */
	private Util() { }

	/**
	 * hallo.
	 * @param l1 doei.
	 * @param l2 hoi.
	 * @param <Element> nee.
	 * @return Result.
	 */
	public static <Element> List<Element> zip(
			final List<Element> l1, final List<Element> l2
	) {
		ArrayList<Element> result = new ArrayList<>();
		for (int i = 0; i < l1.size(); i++) {
			result.add(l1.get(i));
			result.add(l2.get(i));
		}
		return result;
	}


	/**
	 * signum function.
	 *
	 * @param i
	 *            the function argument
	 * @return -1, 0 or 1 if the argument is negative, 0 or positive
	 */
	public static int signum(final int i) {
		if (i < 0) {
			return -1;
		} else if (i > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
