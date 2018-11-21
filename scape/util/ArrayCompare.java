package scape.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayCompare {
	private List<String> left;
	private List<String> right;

	public ArrayCompare (List<String> left, List<String> right) {
		this.left = left;
		this.right = right;
	}

	public List<String> intersection () {
		List<String> result = new ArrayList<>();

		for (String entry: this.left) {
			if(right.contains(entry)) {
				result.add(entry);
			}
		}

		return result;
	}
}