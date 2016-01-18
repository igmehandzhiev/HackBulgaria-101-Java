package binarySearchTree;

public class Main {

	public static void main(String[] args) {
		BinaryTree btree = new BinaryTree();
		btree.insert(5);
		btree.insert(2);
		btree.insert(18);
		btree.insert(-4);
		btree.insert(3);
		
		btree.remove(2);
		
		//System.out.println(btree.search(-4));
		//btree.print();

	}

}
