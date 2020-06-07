package me.lxxjn0.ball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {

    @DisplayName("Balls() - List<Ball>을 입력받아 객체 생성")
    @Test
    void Balls_ListOfBall_GenerateInstance() {
        final List<Ball> balls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3));

        assertThat(new Balls(balls)).isInstanceOf(Balls.class);
    }

    @DisplayName("validateSize() - 유효하지 않은 크기의 List<Ball>이 들어올 경우 IllegalArgumentException 발생")
    @Test
    void validateSize_InvalidSize_IllegalArgumentExceptionThrown() {
        final List<Ball> balls = Arrays.asList(new Ball(1), new Ball(2));

        assertThatThrownBy(() -> new Balls(balls))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자의 개수가 유효하지 않습니다.");
    }

    @DisplayName("validateDuplication() - 중복이 존재하는 List<Ball>이 들어올 경우 IllegalArgumentException 발생")
    @Test
    void validateDuplication_DuplicatedBalls_IllegalArgumentExceptionThrown() {
        final List<Ball> balls = Arrays.asList(new Ball(1), new Ball(2), new Ball(2));

        assertThatThrownBy(() -> new Balls(balls))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("중복된 숫자가 존재합니다.");
    }

}
