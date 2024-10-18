package QB;

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

	void display(Node node) {
		if (node != null) {
			display(node.left);
			System.out.print(node.key + " ");
			display(node.right);
		}
	}

	void display() {
		display(root);
		System.out.println();
	}

	void delete(int key) {
		root = deleteRec(root, key);
	}

	Node deleteRec(Node root, int key) {
		if (root == null) {
			System.out.println("Key not found!");
			return root;
		}
		if (key < root.key)
			root.left = deleteRec(root.left, key);
		else if (key > root.key)
			root.right = deleteRec(root.right, key);
		else {

			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.key = minValue(root.right);

			root.right = deleteRec(root.right, root.key);
		}
		return root;
	}

	int minValue(Node node) {
		int minValue = node.key;
		while (node.left != null) {
			minValue = node.left.key;
			node = node.left;
		}
		return minValue;
	}
}

public class QB {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		int choice, key;

		do {
			System.out.println("\nBinary Search Tree Menu:");
			System.out.println("1. Insert a key");
			System.out.println("2. Display the tree");
			System.out.println("3. Delete a key");
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
				System.out.println("Tree (In-Order):");
				bst.display();
				break;
			case 3:
				System.out.print("Enter key to delete: ");
				key = scanner.nextInt();
				bst.delete(key);
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
