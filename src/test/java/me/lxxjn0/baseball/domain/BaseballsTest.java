package me.lxxjn0.baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballsTest {

    @DisplayName("Baseballs() - List<Baseball>을 입력받아 객체 생성")
    @Test
    void Baseballs_ListOfBaseBall_GenerateInstance() {
        final List<Baseball> baseballs = Arrays.asList(new Baseball(1), new Baseball(2), new Baseball(3));

        assertThat(new Baseballs(baseballs)).isInstanceOf(Baseballs.class);
    }

    @DisplayName("validateSize() - 유효하지 않은 크기의 List<Baseball>이 들어올 경우 IllegalArgumentException 발생")
    @Test
    void validateSize_InvalidSize_IllegalArgumentExceptionThrown() {
        final List<Baseball> baseballs = Arrays.asList(new Baseball(1), new Baseball(2));

        assertThatThrownBy(() -> new Baseballs(baseballs))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자의 개수가 유효하지 않습니다.");
    }

    @DisplayName("validateDuplication() - 중복이 존재하는 List<Baseball>이 들어올 경우 IllegalArgumentException 발생")
    @Test
    void validateDuplication_DuplicatedBalls_IllegalArgumentExceptionThrown() {
        final List<Baseball> baseballs = Arrays.asList(new Baseball(1), new Baseball(2), new Baseball(2));

        assertThatThrownBy(() -> new Baseballs(baseballs))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("중복된 숫자가 존재합니다.");
    }

    @DisplayName("of() - List<Integer>를 입력받아 해당하는 숫자들로 이루어진 Baseballs를 반환")
    @Test
    void of_ListOfNumbers_GenerateInstance() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3);

        final List<Baseball> expected = Arrays.asList(new Baseball(1), new Baseball(2), new Baseball(3));
        assertThat(Baseballs.of(numbers)).extracting("baseballs")
                                         .asList()
                                         .containsExactlyElementsOf(expected);
    }

    @DisplayName("of() - ellipsis int 배열을 입력받아 해당하는 숫자들로 이루어진 Baseballs를 반환")
    @Test
    void of_EllipsisOfNumbers_GenerateInstance() {
        final List<Baseball> expected = Arrays.asList(new Baseball(1), new Baseball(2), new Baseball(3));
        assertThat(Baseballs.of(1, 2, 3)).extracting("baseballs")
                                         .asList()
                                         .containsExactlyElementsOf(expected);
    }

    @DisplayName("countStrikes() - 입력받은 Baseballs와 비교하여 스트라이크의 개수를 반환")
    @Test
    void countStrikes_Baseballs_ReturnStrikeCountResult() {
        final Baseballs generatedBaseballs = Baseballs.of(1, 2, 3);
        final Baseballs baseballs = Baseballs.of(1, 4, 3);

        assertThat(baseballs.countStrikes(generatedBaseballs)).isEqualTo(2);
    }

    @DisplayName("countBalls() - 입력받은 Baseballs와 비교하여 볼의 개수를 반환")
    @Test
    void countBalls_Baseballs_ReturnBallCountResult() {
        final Baseballs generatedBaseballs = Baseballs.of(1, 2, 3);
        final Baseballs baseballs = Baseballs.of(3, 4, 2);

        assertThat(baseballs.countBalls(generatedBaseballs)).isEqualTo(2);
    }

}
