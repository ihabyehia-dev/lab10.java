# Java Lab 10 - Linked List Queue

A Java Data Structures lab implementing a queue using a custom linked list rather than the built-in Java Queue interface.

## Concepts
- Linked nodes and maintaining a front/back
- FIFO operations `enqueue`, `dequeue` and `peek`
- Counting queue elements and displaying contents
- Queue exercises such as rotation, maximum, and separating even/odd numbers

## Files
- `Node.java` - node data and link
- `LinkedList.java` - underlying linked list
- `Queue.java` - queue built on the linked list
- `main.java` - practice program

## Run
Use package `lab8` in Eclipse, import the four files and run `main.java`.

## Notes
This is course practice. The queue's rotation, maximum, kth-item removal, duplicate filtering, even/odd ordering and alternating merge logic were corrected and tested locally. `removeEveryKth(k)` changes the original queue and returns the removed items; the other filtering methods return a new queue. Do not confuse this with `java.util.Queue`.
