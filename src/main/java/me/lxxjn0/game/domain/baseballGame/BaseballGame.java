package me.lxxjn0.game.domain.baseballGame;

import me.lxxjn0.game.domain.baseball.Baseballs;
import me.lxxjn0.game.domain.numberGenerator.NumberGenerator;

public class BaseballGame {

	private final NumberGenerator targetNumberGenerator;
	private Baseballs target;
	private Baseballs guess;

	public BaseballGame(final NumberGenerator targetNumberGenerator) {
		this.targetNumberGenerator = targetNumberGenerator;
	}

	public void generateTargetNumbers() {
		target = Baseballs.of(targetNumberGenerator.generate());
	}

	public void generateGuessNumbers(final String guessNumbers) {
		guess = Baseballs.of(guessNumbers);
	}

	public GameResult getGameResult() {
		return GameResult.of(target, guess);
	}

}
