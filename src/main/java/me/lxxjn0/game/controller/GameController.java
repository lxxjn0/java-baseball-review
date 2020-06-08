package me.lxxjn0.game.controller;

import me.lxxjn0.game.domain.BaseballGame;
import me.lxxjn0.game.domain.NumberGenerator;
import me.lxxjn0.game.domain.RandomNumberGenerator;

public class GameController {

	public GameController() {
	}

	public void play() {
		final BaseballGame game = generateBaseballGame();
	}

	private BaseballGame generateBaseballGame() {
		final NumberGenerator numberGenerator = new RandomNumberGenerator();
		final BaseballGame game = new BaseballGame(numberGenerator);

		game.generateTargetNumbers();
		return game;
	}

}
