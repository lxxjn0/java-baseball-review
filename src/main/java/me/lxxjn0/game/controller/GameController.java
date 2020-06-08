package me.lxxjn0.game.controller;

import static me.lxxjn0.game.view.InputView.*;

import me.lxxjn0.game.domain.baseballGame.BaseballGame;

public class GameController {

	private final BaseballGame game;

	public GameController(final BaseballGame game) {
		this.game = game;
	}

	public void play() {
		game.generateTargetNumbers();
		game.generateGuessNumbers(receiveGuessNumbers());
	}

}
