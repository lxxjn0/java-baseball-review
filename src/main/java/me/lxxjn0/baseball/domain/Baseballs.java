package me.lxxjn0.baseball.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Baseballs {

    private static final int BASEBALLS_SIZE = 3;

    private final List<Baseball> baseballs;

    public Baseballs(final List<Baseball> baseballs) {
        validate(baseballs);
        this.baseballs = baseballs;
    }

    public static Baseballs of(final List<Integer> numbers) {
        return new Baseballs(
            numbers.stream()
                   .map(Baseball::new)
                   .collect(toList()));
    }

    public static Baseballs of(final int... numbers) {
        return new Baseballs(
            Arrays.stream(numbers)
                  .mapToObj(Baseball::new)
                  .collect(toList()));
    }

    private void validate(final List<Baseball> baseballs) {
        validateSize(baseballs);
        validateDuplication(baseballs);
    }

    private void validateSize(final List<Baseball> baseballs) {
        if (baseballs.size() != BASEBALLS_SIZE) {
            throw new IllegalArgumentException("숫자의 개수가 유효하지 않습니다.");
        }
    }

    private void validateDuplication(final List<Baseball> baseballs) {
        final HashSet<Baseball> distinctBaseballs = new HashSet<>(baseballs);

        if (baseballs.size() != distinctBaseballs.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public boolean isNothing(final Baseballs comparison) {
        return comparison.baseballs.stream()
                                   .noneMatch(this.baseballs::contains);
    }

    public int countStrikes(final Baseballs comparison) {
        return (int)IntStream.range(0, BASEBALLS_SIZE)
                             .filter(index -> this.baseballs.get(index).equals(comparison.baseballs.get(index)))
                             .count();
    }

    public int countBalls(final Baseballs comparison) {
        final int strikeCounts = countStrikes(comparison);
        final int ballCounts = (int)comparison.baseballs.stream()
                                                        .filter(this.baseballs::contains)
                                                        .count();
        return ballCounts - strikeCounts;
    }

}
