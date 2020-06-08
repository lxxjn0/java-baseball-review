package me.lxxjn0.game.domain;

public class BaseballGame {

	private final NumberGenerator targetNumberGenerator;
	private Baseballs target;
	private Baseballs guess;

	public BaseballGame(final NumberGenerator targetNumberGenerator) {
		this.targetNumberGenerator = targetNumberGenerator;
	}

}
