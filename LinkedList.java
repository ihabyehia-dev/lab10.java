package lab8;

public class LinkedList {
    public Node first;
    public String name;

    public LinkedList() {
        this("list");
    }

    public LinkedList(String listName) {
        name = listName;
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertAtFront(int x) {
        first = new Node(x, first);
    }

    public void insertAtBack(int x) {
        if (isEmpty()) {
            first = new Node(x);
        } else {
            Node current = first;
            while (current.nextNode != null)
                current = current.nextNode;
            current.nextNode = new Node(x);
        }
    }

    public int removeFromFront() {
        if (isEmpty())
            return -1;
        int removed = first.data;
        first = first.nextNode;
        return removed;
    }

    public int removeFromBack() {
        if (isEmpty())
            return -1;
        int removed;
        if (first.nextNode == null) {
            removed = first.data;
            first = null;
            return removed;
        }
        Node current = first;
        while (current.nextNode.nextNode != null)
            current = current.nextNode;
        removed = current.nextNode.data;
        current.nextNode = null;
        return removed;
    }

    // displays the elements from the first node to the last one
    public void display() {
        Node current = first;
        while (current != null) {
            current.display();
            current = current.nextNode;
        }
        System.out.println();
    }

    // Splits the list into a stack and a queue; the original list is unchanged.
    //   result[0]: the stack  -> elements at even positions (2nd, 4th, ...), pushed with insertAtFront,
    //                            so the top of the stack is the last element pushed
    //   result[1]: the queue  -> elements at odd positions (1st, 3rd, ...), enqueued with insertAtBack,
    //                            so they keep their original order
    public LinkedList[] split() {
        LinkedList stack = new LinkedList("Stack");
        LinkedList queue = new LinkedList("Queue");
        Node current = first;
        int position = 1;
        while (current != null) {
            if (position % 2 == 1)
                queue.insertAtBack(current.data);
            else
                stack.insertAtFront(current.data);
            current = current.nextNode;
            position++;
        }
        return new LinkedList[] { stack, queue };
    }
}

