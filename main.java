package lab8;
import java.util.*;
public class main {

	public static void main(String[] args) {
		Scanner c = new Scanner(System.in);
		Queue q = new Queue();
		
		System.out.println("is the queue empty? "+ q.isEmpty());
		System.out.println("Enter the number of elements to enqueue: ");
		int elem = c.nextInt();
		for(int i = 0;i<elem;i++) {
			System.out.println("Enter element "+(i+1)+": ");
			int z = c.nextInt();
			q.enqueue(z);
		}
		q.display();
		System.out.println("---------------------");
		System.out.println("Front element of the queue: "+q.peek());
		System.out.println("Number of elements inside the queue: "+q.QueueSize());
		System.out.println("Enter the number of elements you want ot remove: ");
		int s = c.nextInt();
		q.removeEveryKth(s);
		q.display();
		System.out.println("Front element of the queue after dequeuing: "+q.peek());
		System.out.println("Is the queue empty? "+q.isEmpty());
		System.out.println("--------------------");
		System.out.println("Enter the number of elements to rotate: ");
		int a = c.nextInt();
		q.rotate(a);
		System.out.println("After Rotating: ");
		System.out.print("Queue elemnts: ");
		q.display();
		System.out.println("--------------------");
	
		
		
	}

}
