package _01_Spies_On_A_Train;

import java.util.ArrayList;
import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

	/*
	 * A spy has made off with important intel from your intelligence agency! You
	 * know the spy is somewhere on this train(LinkedList). Your job is to find the
	 * suspect that matches the description given to you by the list of clues(the
	 * array).
	 * 
	 * Walk through the train, questioning each of the passengers about what they
	 * have seen and return the name of the most likely suspect.
	 * 
	 * The results are randomly generated each time so you should have a general
	 * case solution that carefully compares the clues to each passenger's
	 * testimony. Remember to use String methods to break up the passengers'
	 * statements.
	 */
	String findIntel(LinkedList<TrainCar> train, String[] clues) {

		Node<TrainCar> n = train.getHead();
		for (String s : clues) {
			System.out.println(s);
		}

		HashMap<String, Integer> suspicionCount = new HashMap<String, Integer>();
		while (n != null) {
			String question = n.getValue().questionPassenger();
			System.out.println(question);

			if (question.contains("I saw")) {
				int startIndex = question.indexOf("I saw") + 6;
				int endIndex = question.indexOf(' ', startIndex);
				String clue = question.substring(endIndex + 1);

				if (endIndex != -1) {
					String name = question.substring(startIndex, endIndex).trim();

					for (String s : clues) {
						if (clue.contains(s)) {
							if (suspicionCount.containsKey(name)) {
								suspicionCount.put(name, suspicionCount.get(name) + 1);
								if (suspicionCount.get(name) == 3) {
									System.out.println(name);
									return name;
								}
							} else {
								suspicionCount.put(name, 1);
							}

						}

					}
				}

			}

			n = n.getNext();

		}

		return "";
	}

}
