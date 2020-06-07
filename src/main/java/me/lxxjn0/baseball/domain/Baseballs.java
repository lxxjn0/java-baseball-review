package me.lxxjn0.baseball.domain;

import java.util.HashSet;
import java.util.List;

public class Baseballs {

    private static final int BASEBALLS_SIZE = 3;

    private final List<Baseball> baseballs;

    public Baseballs(final List<Baseball> baseballs) {
        validate(baseballs);
        this.baseballs = baseballs;
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

}
