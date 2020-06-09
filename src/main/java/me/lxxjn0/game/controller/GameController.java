package me.lxxjn0.game.controller;

import static me.lxxjn0.game.view.InputView.*;
import static me.lxxjn0.game.view.OutputView.*;

import me.lxxjn0.game.domain.baseballGame.BaseballGame;
import me.lxxjn0.game.domain.baseballGame.GameResult;

public class GameController {

	private final BaseballGame game;

	public GameController(final BaseballGame game) {
		this.game = game;
	}

	private void play() {
		GameResult gameResult;
		game.generateTargetNumbers();

		do {
			game.generateGuessNumbers(receiveGuessNumbers());
			gameResult = game.getGameResult();
			printGameResult(gameResult.log());
		} while (gameResult.isFail());
	}

}
