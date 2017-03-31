package com.xyzcorp;

import java.util.Optional;
import java.util.function.BiPredicate;

public class CalcStats {

	private int[] array;

	public CalcStats(int[] array) {
        if (array == null) throw new NullPointerException("array cannot be null");
		this.array = array;
	}

	private Optional<Integer> process(BiPredicate<Integer,Integer> biPredicate) {
		int length = array.length;
		if (length == 0) return Optional.empty();
		int winner = array[0];
		for (int i = 1; i < length; i++) {
			if (biPredicate.test(winner, array[i])) {
			   winner = array[i];
			}
		}
		return Optional.of(winner);
	}

	public Optional<Integer> getMaximum() {
		return process((winner, next) -> winner < next);
	}


	public Optional<Integer> getMinimum() {
		return process((winner, next) -> winner > next);
	}
}



