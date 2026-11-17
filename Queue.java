package lab8;

public class Queue extends LinkedList {

	public Queue() {
		super("Queue");
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("The Queue is empty!");
		}

		Node current = first;

		while (current != null) {
			current.display();
			current = current.nextNode;
		}
	}

	public void enqueue(int x) {
		insertAtBack(x);
	}

	public int dequeue() {
		return removeFromFront();
	}

	public int peek() {
		if (first == null) {
			return -1;
		}
		return first.data;
	}

	public int QueueSize() {
		int count = 0;

		Node current = first;

		while (current != null) {
			count++;
			current = current.nextNode;
		}

		return count;
	}

	void rotate(int k) {

		Queue tmp = new Queue();

		if (first == null) {
			System.out.println("X");
		}
		if (k > QueueSize()) {
			System.out.println("X");
		}
		int count = 0;
		while (!isEmpty() && count < k) {
			tmp.enqueue(dequeue());
			count++;
		}

		while (!tmp.isEmpty()) {
			enqueue(tmp.dequeue());
		}

		while (!isEmpty()) {
			int x = dequeue();
			System.out.print(x + " ");
			tmp.enqueue(x);
		}
		while (!tmp.isEmpty()) {
			int x = tmp.dequeue();
			System.out.print(x + " ");
			enqueue(x);
		}
	}

	public int maximum() {

		Queue temp = new Queue();

		int max = first.data;
		while (!isEmpty()) {
			int x = dequeue();

			if (x > max) {
				max = x;
			}
			temp.enqueue(x);
		}
		while (!temp.isEmpty()) {
			enqueue(temp.dequeue());
		}
		return max;
	}

	Queue evenbeforeodd() {
		Queue evenbodd = new Queue();

		for (int i = 0; i < QueueSize(); i++) {
			int x = dequeue();
			if (x % 2 == 0) {
				evenbodd.enqueue(x);
				enqueue(x);
			}
			for (int j = 0; j < QueueSize(); i++) {
				int z = dequeue();
				evenbodd.enqueue(z);
				enqueue(z);
			}
		}
		return evenbodd;
	}

	Queue removeEveryKth(int k) {
		Queue temp1 = new Queue();
		Queue temp2 = new Queue();

		for (int i = 0; i < QueueSize(); i++) {
			int x = dequeue();
			if (i%k!=0) {
				temp2.enqueue(x);
			}
			temp1.enqueue(x);
		}
		
		while(!temp1.isEmpty()) {
			enqueue(temp1.dequeue());
		}
		
		return temp2;
	}

	Queue removeDuplicates() {
		Queue temp = new Queue();

		for (int i = 0; i < QueueSize(); i++) {
			int x = dequeue();

			for (int j = 0; j < QueueSize(); j++) {
				int z = dequeue();
				if (x != z) {
					enqueue(z);
				}
			}
			temp.enqueue(x);
		}
		return temp;
	}

	Queue mergeAlternate(Queue two) {
		Queue merge = new Queue();
		Queue temp1 = new Queue();
		Queue temp2 = new Queue();

		while (!isEmpty()) {
			int x = dequeue();

			while (!two.isEmpty()) {
				int z = dequeue();
				if (x == z) {
					merge.enqueue(z);
				}
				temp2.enqueue(z);
			}
			temp1.enqueue(x);
		}
		while (!temp1.isEmpty()) {
			enqueue(temp1.dequeue());
		}
		while (!temp2.isEmpty()) {
			two.enqueue(temp2.dequeue());
		}

		return merge;
	}

}
