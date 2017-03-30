package com.xyzcorp;

import java.util.Optional;

public class CalcStats {

	private int[] array;

	public CalcStats(int[] array) {
        if (array == null) throw new NullPointerException("array cannot be null");
		this.array = array;
	}

	public Optional<Integer> getMaximum() {
		if (array.length == 0) return Optional.empty();
		if (array.length == 1) return Optional.of(array[0]);
		return array[0] > array[1] ? Optional.of(array[0]) : Optional.of(array[1]);
	}
}
