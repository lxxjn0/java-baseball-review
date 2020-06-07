package me.lxxjn0.ball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

    @DisplayName("Ball() - 숫자를 입력받아 객체 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void Ball_NumberOfBall_GenerateInstance(final int number) {
        assertThat(new Ball(number)).isInstanceOf(Ball.class);
    }

    @DisplayName("validate() - 유효하지 않은 숫자의 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void validate_InvalidNumber_IllegalArgumentExceptionThrown(final int number) {
        assertThatThrownBy(() -> new Ball(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("유효하지 않은 숫자입니다.");
    }

}
