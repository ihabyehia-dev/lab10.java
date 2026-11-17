package lab8;

public class Node {
    public int data;
    public Node nextNode;

    public Node(int d) {
        data = d;
        nextNode = null;
    }

    public Node(int d, Node node) {
        data = d;
        nextNode = node;
    }

    public void display() {
        System.out.print(data + " ");
    }
}

