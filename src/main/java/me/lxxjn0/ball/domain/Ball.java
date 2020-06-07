package me.lxxjn0.ball.domain;

import java.util.Objects;

public class Ball {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 9;

    private final int number;

    public Ball(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Ball that = (Ball)object;
        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number);
    }

}
