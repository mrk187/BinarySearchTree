package alda.tree;

import java.util.SortedSet;
import java.util.TreeSet;

public class MyOwnTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		SortedSet<Integer> oracle = new TreeSet<Integer>();
		
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		
		oracle.add(1);
		oracle.add(2);
		oracle.add(3);
		oracle.add(4);
		
		System.out.println(tree.remove(4));
		System.out.println(tree);
		

		BinarySearchTree<String> tree2 = new BinarySearchTree<String>();
		tree2.add("A");
		tree2.add("B");
		tree2.add("C");
		
		tree2.remove("B");
		
		System.out.print(tree2);
			
	}

}
