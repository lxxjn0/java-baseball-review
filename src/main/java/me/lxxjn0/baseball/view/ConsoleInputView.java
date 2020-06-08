package me.lxxjn0.baseball.view;

import java.util.Scanner;

public class ConsoleInputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	public ConsoleInputView() {
	}

	public String receiveGuessNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		return SCANNER.nextLine();
	}

}
