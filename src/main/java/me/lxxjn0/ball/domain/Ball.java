package me.lxxjn0.ball.domain;

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

}
