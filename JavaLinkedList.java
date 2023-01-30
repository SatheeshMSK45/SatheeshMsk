import java.util.Iterator;
import java.util.Scanner;

class Node {
	int data;
	Node nextNode;

	Node(int data, Node nextNode) {
		this.data = data;
		this.nextNode = null;
	}

}

class LinkedList {
	private Node head;
	static int size = 0;

	// inserting element at the end
	public void insert(int element) {
		Node newNode = new Node(element, null);
		if (head == null) {// if head is empty, insert at head
			head = newNode;
		} else {
			Node currentNode = head;

			while (currentNode.nextNode != null) {
				currentNode = currentNode.nextNode;
			}

			currentNode.nextNode = newNode;
		}
		System.out.println(toString());
	}

	public void insertFirst(int element) {
		Node newNode = new Node(element, null);
		newNode.nextNode = head;
		head = newNode;
		System.out.println(toString());
	}

	public void insert(int element, int index) {
		if (head == null) {
			System.err.println("List is Empty...");
			return;
		}
		Node newNode = new Node(element, null);
		Node temp = head;

		if (index == 0) {
			newNode.nextNode = head;
			head = newNode;
			System.out.println(toString());
			return;
		}
		for (int i = 0; temp != null && i < index - 1; i++)
			temp = temp.nextNode;

		if (temp == null || temp.nextNode == null) {
			System.err.println("Index Out of Bounds " + index + " of length " + getSize());
			return;
		}
		Node nextNode = temp.nextNode;
		temp.nextNode = newNode;
		newNode.nextNode = nextNode;
		System.out.println(toString());
	}

	public int getSize() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.nextNode;
		}
		return count;
	}

	public void delete(int index) {

		if (head == null) {
			System.err.println("List is Empty...");
			return;
		}

		Node temp = head;

		if (index == 0) {
			head = temp.nextNode;
			System.out.println(toString());
			return;
		}

		for (int i = 0; temp != null && i < index - 1; i++)
			temp = temp.nextNode;

		if (temp == null || temp.nextNode == null) {
			System.err.println("Index Out of Bounds " + index + " of length " + getSize());
			return;
		}

		Node nextNode = temp.nextNode.nextNode;

		temp.nextNode = nextNode;
		System.out.println(toString());
		return;
	}

	public void deleteLast(int element) {
		if (head == null) {
			System.err.println("List is Empty...");
			return;
		}

		Node temp = head;
		
		while (temp != null)
			temp = temp.nextNode;
		
		
	}

	public void deleteFirst(int element) {

	}

	public String toString() {
		StringBuffer print = new StringBuffer();
		Node currentNode = head;

		while (currentNode != null) {
			print.append(currentNode.data).append(" ");
			currentNode = currentNode.nextNode;
		}

		return print.toString();
	}

}

public class JavaLinkedList {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LinkedList list = new LinkedList();
		System.out.println("1) Insert \n2) Delete \n3) Size \n4) Exit");
		int choice = 0, element = 0, index = 0;
		char choose = '0';
		while (choice != 4) {
			System.out.print("\nEnter your Choice :- (1/2/3/4) ");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("a) Insert At End \nb) Insert At Position \nc) Insert At First \nx) Go Back");
				choose = '0';
				while (choose != 'x') {
					System.out.print("\nChoose your Option :- (a/b/c/x) ");
					choose = input.next().charAt(0);
					switch (choose) {
					case 'a':
						System.out.print("\nInsertion Value :- ");
						element = input.nextInt();
						list.insert(element);
						break;

					case 'b':
						System.out.print("\nInsertion Value :- ");
						element = input.nextInt();
						System.out.print("\nInsertion Position :- ");
						index = input.nextInt();
						list.insert(element, index);
						break;

					case 'c':
						System.out.print("\nInsertion Value :- ");
						element = input.nextInt();
						list.insertFirst(element);
						break;

					case 'x':
						break;

					default:
						System.err.print("\nChoose the Correct Option... ");
						break;
					}
				}
				break;

			case 2:
				System.out.println("a) Delete At End \nb) Delete At Position \nc) Delete At First \nx) Go Back");
				choose = '0';
				while (choose != 'x') {
					System.out.print("\nChoose your Option :- (a/b/c/x) ");
					choose = input.next().charAt(0);
					switch (choose) {
					case 'a':
						list.deleteLast();
						break;

					case 'b':
						System.out.print("\nDeletion Position :- ");
						index = input.nextInt();
						list.delete(index);
						break;

					case 'c':
						list.deleteFirst();
						break;

					case 'x':
						break;

					default:
						System.out.print("\nChoose the Correct Option... ");
						break;
					}
				}
				break;

			case 3:
				System.out.println("Size of the List is " + list.getSize());
				break;

			case 4:
				System.exit(0);
				break;

			default:
				System.out.print("\nEnter the Correct Choice... ");
				break;
			}
		}
	}
}