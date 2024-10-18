package QC;

import java.util.LinkedList;
import java.util.Queue;
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

	void printLevelOrder() {
		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int nodeCount = queue.size();

			while (nodeCount > 0) {
				Node node = queue.poll();
				System.out.print(node.key + " ");

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
				nodeCount--;
			}
			System.out.println();
		}
	}
}

public class QC {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();

		System.out.print("Enter the number of integers to insert: ");
		int n = scanner.nextInt();

		System.out.println("Enter " + n + " integers:");
		for (int i = 0; i < n; i++) {
			int value = scanner.nextInt();
			bst.insert(value);
		}

		System.out.println("Level order traversal of the binary search tree:");
		bst.printLevelOrder();

		scanner.close();
	}
}
