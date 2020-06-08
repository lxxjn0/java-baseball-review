package me.lxxjn0.game.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

	@DisplayName("BaseballGame() - 타겟 숫자를 생성하는 전략을 입력받아 객체 생성")
	@Test
	void BaseballGame_NumberGenerator_GenerateInstance() {
		final NumberGenerator numberGenerator = new RandomNumberGenerator();

		assertThat(new BaseballGame(numberGenerator)).isInstanceOf(BaseballGame.class);
	}

	@DisplayName("generateTargetNumbers() - 타겟 숫자를 생성하여 target 필드 초기화")
	@Test
	void generateTargetNumbers_Nothing_InitializeTarget() {
		final NumberGenerator numberGenerator = new RandomNumberGenerator();
		final BaseballGame game = new BaseballGame(numberGenerator);
		game.generateTargetNumbers();

		assertThat(game).extracting("target").isNotNull();
	}

	@DisplayName("generateGuessNumbers() - 사용자로부터 입력받은 숫자를 생성하여 guess 필드 초기화")
	@Test
	void generateGuessNumbers_Nothing_InitializeGuess() {
		final NumberGenerator numberGenerator = new RandomNumberGenerator();
		final BaseballGame game = new BaseballGame(numberGenerator);
		game.generateGuessNumbers("123");

		assertThat(game).extracting("guess").isNotNull();
	}

}
