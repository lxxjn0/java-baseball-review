package me.lxxjn0.game.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {
	}

	public static String receiveGuessNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		return SCANNER.nextLine();
	}

}
