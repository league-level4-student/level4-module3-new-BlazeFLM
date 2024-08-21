package _01_Spies_On_A_Train;

import java.util.ArrayList;
import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {

    	Node<TrainCar> n = train.getHead();
    	//The pattern is, it will keep going to a person, then eventually bouncing back and forth between two. The last person found between those two is the spy.
    	//EX Froy - Cate - Kelly - Froy - Kelly - Froy (infinite), here, the spy will be Kelly
    	
    	ArrayList<String> spokenTo = new ArrayList<String>();
    	while(n != null) {
    		String question = n.getValue().questionPassenger();
    		System.out.println(question);
    		
    		if (question.contains("My name is")) {
    	        int startIndex = question.indexOf("My name is") + 11; 
    	        int endIndex = question.indexOf('.', startIndex);
    	        if (endIndex != -1) {
    	            String name = question.substring(startIndex, endIndex).trim();
    	            spokenTo.add(name);
    	        }
    	    }
    		
    		n = n.getNext();
    	}
    	
    	
    	
        return "";
    }

}
