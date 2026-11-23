package lab8;

/** FIFO queue and related operations built on a custom linked list. */
public class Queue extends LinkedList {
    public Queue() {
        super("Queue");
    }

    public void enqueue(int x) {
        insertAtBack(x);
    }

    public int dequeue() {
        return removeFromFront();
    }

    public int peek() {
        if (isEmpty()) return -1;
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
        int n = QueueSize();
        if (n == 0 || k < 0) return;
        k = k % n;
        for (int i = 0; i < k; i++) {
            enqueue(dequeue());
        }
    }

    public int maximum() {
        if (isEmpty()) return -1;
        int max = first.data;
        Node current = first.nextNode;
        while (current != null) {
            if (current.data > max) max = current.data;
            current = current.nextNode;
        }
        return max;
    }

    // Returns a new queue with even numbers first. The original stays unchanged.
    Queue evenbeforeodd() {
        Queue answer = new Queue();
        Node current = first;
        while (current != null) {
            if (current.data % 2 == 0) answer.enqueue(current.data);
            current = current.nextNode;
        }
        current = first;
        while (current != null) {
            if (current.data % 2 != 0) answer.enqueue(current.data);
            current = current.nextNode;
        }
        return answer;
    }

    // Removes every kth element from this queue and returns the removed elements.
    Queue removeEveryKth(int k) {
        Queue removed = new Queue();
        if (k <= 0) return removed;
        int n = QueueSize();
        for (int i = 1; i <= n; i++) {
            int value = dequeue();
            if (i % k == 0) removed.enqueue(value);
            else enqueue(value);
        }
        return removed;
    }

    // Returns unique values in their first-occurrence order.
    Queue removeDuplicates() {
        Queue answer = new Queue();
        Node current = first;
        while (current != null) {
            boolean found = false;
            Node previous = answer.first;
            while (previous != null) {
                if (previous.data == current.data) {
                    found = true;
                    break;
                }
                previous = previous.nextNode;
            }
            if (!found) answer.enqueue(current.data);
            current = current.nextNode;
        }
        return answer;
    }

    // Alternates the values of two queues without emptying either queue.
    Queue mergeAlternate(Queue two) {
        Queue result = new Queue();
        Node a = first;
        Node b = two.first;
        while (a != null || b != null) {
            if (a != null) {
                result.enqueue(a.data);
                a = a.nextNode;
            }
            if (b != null) {
                result.enqueue(b.data);
                b = b.nextNode;
            }
        }
        return result;
    }
}
