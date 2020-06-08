package me.lxxjn0.game.domain;

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

}
