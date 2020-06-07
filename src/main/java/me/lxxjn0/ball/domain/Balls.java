package me.lxxjn0.ball.domain;

import java.util.HashSet;
import java.util.List;

public class Balls {

    private static final int BALLS_SIZE = 3;

    private final List<Ball> balls;

    public Balls(final List<Ball> balls) {
        validate(balls);
        this.balls = balls;
    }

    private void validate(final List<Ball> balls) {
        validateSize(balls);
        validateDuplication(balls);
    }

    private void validateSize(final List<Ball> balls) {
        if (balls.size() != BALLS_SIZE) {
            throw new IllegalArgumentException("숫자의 개수가 유효하지 않습니다.");
        }
    }

    private void validateDuplication(final List<Ball> balls) {
        final HashSet<Ball> distinctBalls = new HashSet<>(balls);

        if (balls.size() != distinctBalls.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

}
