package DS_ASSIGNMENT;

import java.util.Scanner;

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

class BinarySearchTree {
	Node root;

	void insert(int key) {
		root = insertRec(root, key);
	}

	Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);
		return root;
	}

	void preorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.key + " ");
		preorder(node.left);
		preorder(node.right);
	}

	void postorder(Node node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.key + " ");
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}
}

public class QA {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		int choice, key;

		do {
			System.out.println("\nBinary Search Tree Menu:");
			System.out.println("1. Insert a key");
			System.out.println("2. Preorder Traversal");
			System.out.println("3. Postorder Traversal");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter key to insert: ");
				key = scanner.nextInt();
				bst.insert(key);
				break;
			case 2:
				System.out.println("Preorder Traversal:");
				bst.preorder();
				break;
			case 3:
				System.out.println("Postorder Traversal:");
				bst.postorder();
				break;
			case 4:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 4);

		scanner.close();
	}
}
