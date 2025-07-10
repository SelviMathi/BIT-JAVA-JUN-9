# Priority Queue Examples in Java

This document demonstrates how to use `PriorityQueue` in Java with three different examples: Min-Heap, Max-Heap, and a custom object with a comparator.

---

## Example 1: Min-Heap (Default)

A `PriorityQueue` by default is a min-heap in Java. This means the smallest element is always at the head of the queue.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(30);
pq.add(10);
pq.add(20);

System.out.println("Min-Heap output:");
while (!pq.isEmpty()) {
    System.out.print(pq.poll() + " ");
}
// Output: 10 20 30
```

---

## Example 2: Max-Heap using `Collections.reverseOrder()`

To create a max-heap (largest element at the head), use `Collections.reverseOrder()` as the comparator.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
pq.add(30);
pq.add(10);
pq.add(20);

System.out.println("\nMax-Heap output:");
while (!pq.isEmpty()) {
    System.out.print(pq.poll() + " ");
}
// Output: 30 20 10
```

---

## Example 3: Custom PriorityQueue with Comparator

You can define a custom comparator for objects. In this example, we use a `Job` class and sort jobs by priority (lower priority value first).

```java
class Job {
    int id, priority;
    Job(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

class JobComparator implements Comparator<Job> {
    public int compare(Job a, Job b) {
        return a.priority - b.priority; // lower priority first
    }
}

PriorityQueue<Job> pq = new PriorityQueue<>(new JobComparator());
pq.add(new Job(1, 3));
pq.add(new Job(2, 1));
pq.add(new Job(3, 2));

System.out.println("\nCustom PriorityQueue output (Job IDs by priority):");
while (!pq.isEmpty()) {
    System.out.print(pq.poll().id + " ");
}
// Output: 2 3 1
```
Anonymous Comparator
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    List<Integer>l=Arrays.asList(10,2,80,5);
	    
	    Collections.sort(l,(a,b)->b-a);
	    System.out.println(l);


	}
}

---

## Summary

- **Min-Heap:** Default behavior for `PriorityQueue`.
- **Max-Heap:** Use `Collections.reverseOrder()`.
- **Custom Objects:** Implement `Comparator` for custom sorting logic.
