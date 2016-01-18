package binarySearchTree;


public class BinaryTree {

	class Node {
		private int mValue;
		private Node mLeft;
		private Node mRight;

		public Node() {
		}
		
		public Node(int value, Node left, Node right) {
			mValue = value;
			mLeft = left;
			mRight = right;
		}

		public int getValue() {
			return mValue;
		}

		public void setValue(int mValue) {
			this.mValue = mValue;
		}

		public Node getLeft() {
			return mLeft;
		}

		public void setLeft(Node mLeft) {
			this.mLeft = mLeft;
		}

		public Node getRight() {
			return mRight;
		}

		public void setRight(Node mRight) {
			this.mRight = mRight;
		}

	}

	Node mRoot;

	public BinaryTree() {
		mRoot = null;
	}

	public BinaryTree(Node root) {
		mRoot = new Node(root.getValue(), root.getLeft(), root.getRight());
	}

	public void insert(int value) {
		mRoot = insertInternal(value, mRoot);

	}

	private Node insertInternal(int value, Node node) {

		if (node == null) {
			node = new Node(value, null, null);
		} else if (value >= node.getValue()) {
			node.mRight = insertInternal(value, node.getRight());
		} else {
			node.mLeft = insertInternal(value, node.getLeft());
		}

		return node;
	}
	
	public boolean search(int value) {
		Node found = searchInternal(value, mRoot);
		return found != null;
	}

	private Node searchInternal(int value, Node root) {
		
		if(root == null) {
			return null;
		}
		
		if(root.mValue == value) {
			return root;
		} else if (value >= root.getValue()) {
			return searchInternal(value, root.getRight());
		} else if (value < root.getValue()) {
			return searchInternal(value, root.getLeft());
		}
		
		return null;
	}
	
	public boolean remove(int value) {
		
		
		
		return removeInternal(value, mRoot);
	}

	private boolean removeInternal(int value, Node root) {
		
		/*Node parent = searchParent(value, root);
		Node target = searchInternal(value, root);
		
		boolean isLeft = false;
		
		if( parent.mLeft.mValue == value ) {
			isLeft = true;
		}
		
		if(isLeaf(target)) {
			if(isLeft) {
				parent.mLeft = null;
			} else {
				parent.mRight = null;
			}
		} else if (hasBothParents(target)) {
			target.mValue = rightMinValue(target.mRight);
			
		}*/
		
		Node parent = searchParent(value, root);
		Node target = searchInternal(value, root);
		
		boolean isLeft = false;
		
		if( parent.mLeft.mValue == value ) {
			isLeft = true;
		}
		
		if(isLeaf(target)) {
			//removeLeaf(value);
		} else if (hasBothParents(target)) {
			target.mValue = rightMinValue(target.mRight);
			
		}
		
		
		
		return false;
	}
	
	/*private void removeLeaf(int value) {
		Node parent = searchParent(value, root);
		boolean isLeft = false;
		
		if( parent.mLeft.mValue == value ) {
			isLeft = true;
		}
		
		if(isLeft) {
			parent.mLeft = null;
		} else {
			parent.mRight = null;
		}
	}*/
	
	private int rightMinValue(Node right) {
		if(right.mLeft != null) {
			return rightMinValue(right.mLeft);
		}
		return right.mValue;
	}

	private boolean hasBothParents(Node target) {
		return (target.mLeft != null) && (target.mRight != null);
	}

	private boolean isLeaf(Node target) {
		return (target.mLeft == null) && (target.mRight == null);
	}

	private Node searchParent(int value, Node root) {
		
		if(root == null) {
			return null;
		}
		
		if(root.mLeft.mValue == value || root.mRight.mValue == value) {
			return root;
		} else if (value >= root.getValue()) {
			return searchParent(value, root.getRight());
		} else if (value < root.getValue()) {
			return searchParent(value, root.getLeft());
		}
		
		return null;
	}
	public void print() {

		traverse(mRoot);
	}
	public void traverse (Node root){ // Each child of a tree is a root of its subtree.
		System.out.println(root.mValue);
		if (root.mLeft != null){
			traverse (root.mLeft);
		}
		if (root.mRight != null){
			traverse (root.mRight);
		}
	}

/*	private void walk(Node node) {
		Node temp = node;
		if (temp != null) {
			System.out.println(temp.mValue);

			walk(temp.getLeft());
			walk(temp.getRight());

		}
	}

	private void walk2(Node node) {
			printKids(node);
			walk2(node.mLeft);
			walk2(node.mRight);
		
	}
	

	
	private void printKids(Node node) {
		if (node != null) {
			if (node.mLeft == null && node.mRight == null) {
				return;
			} else if (node.mLeft == null) {
				System.out.println(node.mRight.mValue);
			} else if (node.mRight == null) {
				System.out.println(node.mLeft.mValue);
			}
		}
		return;
	}*/
}
