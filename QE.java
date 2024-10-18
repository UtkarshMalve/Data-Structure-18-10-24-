package QE;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class SinglyLinkedList {
	Node head;

	public void insert(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void displayAlternateNodes() {
		Node current = head;
		boolean alternate = true;

		while (current != null) {
			if (alternate) {
				System.out.print(current.data + " ");
			}
			alternate = !alternate;
			current = current.next;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();

		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);

		System.out.println("Alternate nodes in the linked list:");
		list.displayAlternateNodes();
	}
}
