package _04_Morse_Code;

import java.util.Scanner;

import _03_Intro_to_Binary_Trees.BinaryTree;
import _03_Intro_to_Binary_Trees.Node;

public class MorseDecoder {

	BinaryTree<MorseCode> mcTree = new BinaryTree<MorseCode>();

	public static void main(String[] args) {

		MorseDecoder md = new MorseDecoder();
		md.initialize();
		md.decode();

	}

	public void initialize() {

		mcTree.insert(new MorseCode(" ", ""));
		mcTree.insert(new MorseCode("e", "."));
		mcTree.insert(new MorseCode("t", "-"));

		mcTree.insert(new MorseCode("i", ".."));
		mcTree.insert(new MorseCode("a", ".-"));
		mcTree.insert(new MorseCode("n", "-."));
		mcTree.insert(new MorseCode("m", "--"));

		mcTree.insert(new MorseCode("s", "..."));
		mcTree.insert(new MorseCode("u", "..-"));
		mcTree.insert(new MorseCode("r", ".-."));
		mcTree.insert(new MorseCode("w", ".--"));
		mcTree.insert(new MorseCode("d", "-.."));
		mcTree.insert(new MorseCode("k", "-.-"));
		mcTree.insert(new MorseCode("g", "--."));
		mcTree.insert(new MorseCode("o", "---"));

		mcTree.insert(new MorseCode("h", "...."));
		mcTree.insert(new MorseCode("v", "...-"));
		mcTree.insert(new MorseCode("f", "..-."));
		mcTree.insert(new MorseCode("l", ".-.."));
		mcTree.insert(new MorseCode("p", ".--."));
		mcTree.insert(new MorseCode("j", ".---"));
		mcTree.insert(new MorseCode("b", "-..."));
		mcTree.insert(new MorseCode("x", "-..-"));
		mcTree.insert(new MorseCode("c", "-.-."));
		mcTree.insert(new MorseCode("y", "-.--"));
		mcTree.insert(new MorseCode("z", "--.."));
		mcTree.insert(new MorseCode("q", "--.-"));

		mcTree.printVertical();

	}

	/*
	 * 1.) See if you can decode the following message using the binary tree and
	 * print it to the console:
	 * 
	 * -.-- --- ..- .- .-. . .- -- .- --.. .. -. --.
	 * 
	 * 2.) Then use the binary tree and the scanner class to create a morse code
	 * translator. The user should be able to type multiple letters in morse code on
	 * a single line and have it repeated back to them, decoded into the english
	 * alphabet.
	 * 
	 */
	void decode() {
		String morseCode = "-.-- --- ..- .- .-. . .- -- .- --.. .. -. --.";
		System.out.println("you are amazing");
		// ___________________________________________________________________
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Morse code and it will be decoded");
		String input = sc.nextLine();

		StringBuilder msg = new StringBuilder();
		String[] letters = input.split(" ");
		for (String s : letters) {
			Node<MorseCode> currentNode = mcTree.getRoot();

			for (char c : s.toCharArray()) {
				if (c == '.') {
					currentNode = currentNode.getLeft();
				} else if (c == '-') {
					currentNode = currentNode.getRight();
				}
			}

			if (currentNode != null && currentNode.getValue() != null) {
				msg.append(currentNode.getValue().getDecoded());
			}
		}

		String finalMsg = msg.toString();
		System.out.println(finalMsg);
		sc.close();
	}

}
