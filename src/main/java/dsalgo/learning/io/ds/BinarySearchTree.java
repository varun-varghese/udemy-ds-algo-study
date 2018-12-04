package dsalgo.learning.io.ds;

public class BinarySearchTree {

	class Node {
		int key;
		String value;
		Node left, right;
		
		public Node(int key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public Node min() {
			if (left == null) {
				return this;
			} else {
				return left.min();
			}
		}
	}
	
	Node root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public String find(int key) {
		Node node = find(root, key);
		return null == node ? null : node.value;
	}
	
	private Node find(Node node, int key) {
		if (null == node || node.key == key) {
			return node;
		} else if (key < node.key) {
			return find(node.left, key);
		} else if(key > node.key) {
			return find(node.right, key);
		}
		return null;
	}
	
	public void insert(int key, String value) {
		root = insertNode(root, key, value);
	}
	
	public Node insertNode(Node node, int key, String value) {
		//Node newNode = new Node(key, value);
		
		if (null == node) {
			node = new Node(key, value);
			return node;
		}
		
		if (key < node.key) {
			node.left = insertNode(node.left, key, value);
		} else if (key > node.key) {
			node.right = insertNode(node.right, key, value);
		}
		
		return node;
	}
	
	public int findMinKey() {
		return findMin(root).key;
	}
	private Node findMin(Node node) {
		return node.min();
	}
	
	public void delete(int key) {
		deleteNode(root, key);
	}
	
	private Node deleteNode(Node node, int key) {
		if (null == node) {
			return null;
		} else if (key < node.key){
			node.left = deleteNode(node.left, key);
		} else if (key > node.key) {
			node.right = deleteNode(node.right, key);
		} else {
			if (null == node.left && null == node.right) {
				node = null;
			} else if (null != node.left && null == node.right) {
				node = node.left;
			} else if (null == node.left && null != node.right) {
				node = node.right;
			} else {
				Node minRight = findMin(node.right);
				
				node.key = minRight.key;
				node.value = minRight.value;
				
				node.right = deleteNode(node.right, node.key);
			}
		}
		
		return node;
	}
	
	public int depth() {
		return depthNode(root);
	}
	
	private int depthNode(Node node) {
		if ( null == node) {
			return 0;
		}
		return 1 + Math.max(depthNode(node.left), depthNode(node.right));
	}
	
	public void printInOrder() {
		printInOderNode(root);
	}
	
	private void printInOderNode(Node node) {
		if(null != node) {
			printPreOrderNode(node.left);
			System.out.println(node.key + " -> " + node.value);
			printPreOrderNode(node.right);
		}
	}
	
	public void printPreOrder() {
		printPreOrderNode(root);
	}

	private void printPreOrderNode(Node node) {
		if(null != node) {
			System.out.println(node.key + " -> " + node.value);
			printPreOrderNode(node.left);
			printPreOrderNode(node.right);
		}
	}
	
	public void printPostOrder() {
		printPostOrderNode(root);
	}

	private void printPostOrderNode(Node node) {
		if(null != node) {
			printPostOrderNode(node.left);
			printPostOrderNode(node.right);
			System.out.println(node.key + " -> " + node.value);
		}
	}
	
	
}
