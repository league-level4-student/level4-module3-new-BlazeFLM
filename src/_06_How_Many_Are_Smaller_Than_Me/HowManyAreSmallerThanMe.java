package _06_How_Many_Are_Smaller_Than_Me;

import java.util.ArrayList;
import java.util.Collections;

import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

    /*
     * Given an AVLTree filled with the random numbers from 1 to 20, and a
     * single number within the AVL Tree, figure out how many numbers in the
     * AVLTree are smaller than the provided number and return the result.
     * 
     * You may want to create a helper method to search through the AVLTree and
     * count iteratively or recursively.
     */

	ArrayList<Integer> list = new ArrayList<Integer>();
	
    public int howManyAreSmallerThanMe(AVLTree<Integer> avlTree, int me) {
    	
    	AVLNode<Integer> node = avlTree.getRoot();
    	treeToList(node);
    	Collections.sort(list);
    	System.out.println(list);
    	int count = 0;
    	for(Integer i : list) {
    		if(i < me) {
    			count++;
    		}
    	}
        return count;

    }
    
    public void treeToList(AVLNode<Integer> i){
    	
    	if(i == null) return;
    	treeToList(i.getLeft());
    	System.out.println(i.getValue());
    	if(!list.contains(i.getValue())) {
    		list.add(i.getValue());
    	}
    	treeToList(i.getRight());
    	
    }

}
