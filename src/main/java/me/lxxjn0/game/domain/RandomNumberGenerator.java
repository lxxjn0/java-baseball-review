package me.lxxjn0.game.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

	private static final int EXCLUSIVE_UPPER_BOUND = Baseball.UPPER_BOUND + 1;

	@Override
	public List<Integer> generate() {
		return new Random().ints(Baseball.LOWER_BOUND, EXCLUSIVE_UPPER_BOUND)
		                   .distinct()
		                   .limit(Baseballs.VALID_SIZE)
		                   .boxed()
		                   .collect(toList());
	}

}
