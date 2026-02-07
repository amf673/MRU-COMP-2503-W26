public class Tut4Solution {
	private Node<String> head;
	private Node<String> tail;

	public void addHead(String data) {
		Node<String> n = new Node<> (data);
		addHead(n);
	}
	
	public void addTail(String data) {
		Node<String> n = new Node<> (data);
		addTail(n);
	}
	
	public void addInOrder(String data) {
		Node<String> n = new Node<> (data);
		addInOrder(n);
	}
	
	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}
	
	/*
	 * addHead
	 * assumes n is not null
	 */
	private void addHead(Node<String> n) {
		n.setNext(null);
		if (isEmpty()) {
			head = n;
			tail = n;
		} else {
			n.setNext(head);
			head = n;
		}
	}

	/*
	 * addTail
	 * assumes n is not null
	 */
	private void addTail(Node<String> n) {
		n.setNext(null);
		if (isEmpty()) { // list is empty
			addHead(n);
		} else {
			tail.setNext(n);
			tail = n;
		}
	}

	private void addInOrder(Node<String> n) {
		if (isEmpty()) {
			addHead(n);
		} else {
			if (n.getData().compareTo(head.getData()) <= 0) // less than first item, insert here.
				addHead(n);
			else {
				Node<String> currentNode = head;
				while (currentNode.getNext() != null && n.getData().compareTo(currentNode.getNext().getData()) > 0) {
					currentNode = currentNode.getNext();
				}
				if (currentNode.getNext() == null) { // did not find a place
					addTail(n);
				} else {
					n.setNext(currentNode.getNext());
					currentNode.setNext(n);
				}
			}
		}
	}

	private void printList() {
		System.out.println();
		Node<String> currentNode = head;
		while (currentNode != null) {
			// Visit the node. In this case, print it out.
			System.out.println(currentNode.toString());
			currentNode = currentNode.getNext();
		}
	}

	private void emptyList() {
		head = null;
		tail = null;
	}

	private Node<String> find(String key) {
		Node<String> currentNode = head;
		while (currentNode != null) {
			// Visit the node. In this case,
			// if the data in the currentNode is equal to the key,
			// return the reference to the node.
			if (currentNode.getData().equals(key))
				return currentNode;
			// else, move to the next node
			else
				currentNode = currentNode.getNext();
		}
		// Return null if it didn't find the node.
		return null;
	}

	private Node<String> delete(String key) {
		Node<String> currentNode = head;
		Node<String> previousNode = head;
		while (currentNode != null) {
			// Visit the node. In this case,
			// if the data in the currentNode is equal to the key,
			// remove the current node from the list by updating the reference
			// of the previous node to point to the node after the currentNode.
			if (currentNode.getData().equals(key)) {
				if (head == tail) {
					head = null;
					tail = null;
					return currentNode;
				}

				if (currentNode == head)
					head = currentNode.getNext();
				else {
					previousNode.setNext(currentNode.getNext());
				}
				if (currentNode == tail) {
					tail = previousNode;
				}

				return currentNode;
			}
			// else, move to the next node
			else {
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
		}
		// Return null if it didn't find the node.
		return null;
	}

	public void run() {

		Node<String> a = new Node<String>("Athabasca");
		Node<String> b = new Node<String>("Andromeda");
		Node<String> c = new Node<String>("Hector");
		Node<String> d = new Node<String>("Victoria");

		/*
		 * addHead (a); addTail (b); addHead (c); printList(); addTail (d); printList();
		 * emptyList();
		 */

		addInOrder(a);
		printList();
		addInOrder(b);
		printList();
		addInOrder(c);
		addInOrder(d);
		printList();

		delete("Victoria");
		printList();

		System.out.println("Tail is now " + tail.toString());
	}

	public static void main(String[] args) {
		Tut4Solution tut = new Tut4Solution();
		tut.run();
	}
}
