# Java Collections – List ADT Overview

## Collections Hierarchy

```
java.util.Collection (Interface)
             |
   -----------------------------
   |                                     |
List (Interface)                     Set (Interface)
   |                                     |
-----------                         ---------------
|           |         |             |     |      |
ArrayList LinkedList Vector        HashSet LinkedHashSet TreeSet

Queue (Interface)
   |
PriorityQueue, ArrayDeque
-------------------------------------------
        java.util.Map (Interface)
                    |
           -----------------------
           |                     |
         HashMap        TreeMap / LinkedHashMap

## 1. Collection Interface

The root interface in the collection hierarchy for List, Set, and Queue.


## 2. List Interface (Ordered, Allows Duplicates)

| Class      | Features                                 |
|------------|------------------------------------------|
| ArrayList  | Fast random access, resizable array      |
| LinkedList | Doubly-linked, fast insert/delete        |
| Vector     | Thread-safe (synchronized), legacy       |
| Stack      | LIFO stack (extends Vector)              |

### Example: ArrayList Usage

ArrayList<String> arrayList = new ArrayList<>();
arrayList.add("Apple");
arrayList.add("Banana");
arrayList.add(1, "Grape");        // Insert at index
arrayList.set(2, "Orange");       // Replace
arrayList.remove("Banana");       // Remove by value
arrayList.remove(0);              // Remove by index
arrayList.add("Mango");
System.out.println("ArrayList: " + arrayList);
System.out.println("Contains Mango? " + arrayList.contains("Mango"));
System.out.println("Index of Mango: " + arrayList.indexOf("Mango"));
System.out.println("Size: " + arrayList.size());
arrayList.clear();                // Remove all
System.out.println("After clear(): " + arrayList);


### Example: LinkedList Usage

LinkedList<Integer> ll = new LinkedList<>();
ll.add(10); ll.addFirst(5); ll.addLast(20);
System.out.println("LinkedList: " + ll);
ll.removeFirst(); ll.removeLast();
System.out.println("After removing ends: " + ll);
ll.add(15); ll.add(25); ll.add(2, 18);
System.out.println("LinkedList after add: " + ll);
System.out.println("First: " + ll.getFirst() + ", Last: " + ll.getLast());


### Example: Vector Usage

Vector<String> vector = new Vector<>();
vector.add("A"); vector.add("B");
vector.addElement("C");              // Legacy method
vector.remove(1);
System.out.println("Vector: " + vector);
System.out.println("Element at 0: " + vector.elementAt(0)); // legacy method
vector.set(0, "Z");
System.out.println("Modified Vector: " + vector);
System.out.println("Capacity: " + vector.capacity());

### Example: Stack Usage

Stack<Integer> stack = new Stack<>();
stack.push(100); stack.push(200);
System.out.println("Top: " + stack.peek());
stack.pop();
System.out.println("After pop: " + stack);
System.out.println("Is Empty? " + stack.isEmpty());
System.out.println("Search(100): " + stack.search(100)); // 1-based index

### Common List Methods

- addAll, retainAll, removeAll
- Collections.reverse(list), Collections.sort(list),
- Collections.rotate(list,2)//right rotate
- Collections.rotate(list,-2)//left rotate
- Collections.swap(list,ind1,ind2)
- Collections.shuffle(list)
- Collections.fill(list,val)
- Collections.frequency
int freq = Collections.frequency(list, "A");

- Collections.max, Collections.min
Collections.max(list);
Collections.min(list);

- Collections.unmodifiableList
List<String> original = new ArrayList<>(Arrays.asList("One", "Two"));
List<String> unmodifiable = Collections.unmodifiableList(original);

Collections.rotate(list, -2);
Collections.rotate(list, 3);
Collections.reverse(list);
Collections.swap(list, 0, 2);
Collections.shuffle(list);
Collections.fill(list, "X");


#### List <-> Array Conversion

// List to Array
List<String> list = Arrays.asList("x", "y", "z");
String[] arr = list.toArray(new String[0]);
System.out.println(Arrays.toString(arr));

// Array to List
int[] arr = {1, 2, 3};
List<Integer> list = new ArrayList<>();
for (int num : arr) list.add(num);
```


## 3. Set Interface (No Duplicates)

| Class         | Features                                  |
|---------------|-------------------------------------------|
| HashSet       | No duplicates, no order                   |
| LinkedHashSet | Maintains insertion order                 |
| TreeSet       | Sorted, no duplicates (uses Red-Black Tree)|

- Set is part of Java Collections Framework.
- Does not allow duplicate elements.
- Elements are unordered (unless LinkedHashSet or TreeSet).
- Belongs to java.util package.

### Set Operations

Set<Integer> set1 = new HashSet<>();
Set<String> set2 = new LinkedHashSet<>();
Set<Double> set3 = new TreeSet<>();

Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3));
Set<Integer> b = new HashSet<>(Arrays.asList(3, 4, 5));

// Union
Set<Integer> union = new HashSet<>(a);
union.addAll(b);  // [1, 2, 3, 4, 5]

// Intersection
Set<Integer> intersection = new HashSet<>(a);
intersection.retainAll(b);  // [3]

// Difference
Set<Integer> diff = new HashSet<>(a);
diff.removeAll(b);  // [1, 2]
```

| Method              | Description                                 |
|---------------------|---------------------------------------------|
| add(E e)            | Adds an element if not already present      |
| addAll(Collection)  | Adds all elements from another collection   |
| remove(Object o)    | Removes the element                         |
| contains(Object o)  | Checks if element exists                    |
| isEmpty()           | Checks if set is empty                      |
| size()              | Returns number of elements                  |
| clear()             | Removes all elements                        |
| iterator()          | Returns an iterator                         |

---

## 4. Iterator

- Iterator is an interface in java.util.
- Used to traverse collections (List, Set, etc.).

| Method      | Description                                   |
|-------------|-----------------------------------------------|
| hasNext()   | Checks if there is another element            |
| next()      | Returns the next element                      |
| remove()    | Removes the last element returned by next()   |

```java
List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));
Iterator<Integer> itr = list.iterator();

while (itr.hasNext()) {
    if (itr.next() == 30) {
        itr.remove(); // safe removal during iteration
    }
}

// Enhanced for loop
for (Integer item : list) {
    System.out.println(item);
}
```

## 5. Queue Interface (FIFO)

| Class         | Features                                  |
|---------------|-------------------------------------------|
| PriorityQueue | Elements sorted by natural/comparator order|
| ArrayDeque    | Double-ended queue, no capacity limit     |

- Queue is a linear data structure that follows FIFO.
- Available in java.util under the Queue<E> interface.

| Method      | Description                                 |
|-------------|---------------------------------------------|
| add(e)      | Inserts element, throws error if full       |
| offer(e)    | Inserts element, returns false if full      |
| poll()      | Removes and returns head, or null           |
| remove()    | Removes and returns head, or error          |
| peek()      | Returns head without removing (or null)     |
| element()   | Same as peek(), but throws error if empty   |

### Example: Queue with LinkedList

Queue<String> queue = new LinkedList<>();
queue.offer("A");
queue.offer("B");
queue.offer("C");

System.out.println("Head: " + queue.peek());  // A
System.out.println("Removed: " + queue.poll()); // A
System.out.println("Queue: " + queue);          // [B, C]
```

### Example: PriorityQueue

PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(50);
pq.offer(10);
pq.offer(30);

while (!pq.isEmpty()) {
    System.out.println(pq.poll());  // 10, 30, 50
}
```

### Example: ArrayDeque

Deque<String> dq = new ArrayDeque<>();
dq.offer("Java");
dq.offerFirst("C++");  // Insert at front
dq.offerLast("Python");

System.out.println(dq);           // [C++, Java, Python]
System.out.println(dq.pollLast()); // Python


## 6. Map Interface (Key-Value Pairs)

| Class        | Features                                 |
|--------------|------------------------------------------|
| HashMap      | Fast, no order                           |
| LinkedHashMap| Maintains insertion order                |
| TreeMap      | Sorted by keys                           |
| Hashtable    | Legacy, thread-safe                      |

- A Map is a key-value pair collection.
- Each key must be unique, values can be duplicated.

| Method                    | Description                                  |
|---------------------------|----------------------------------------------|
| put(K key, V value)       | Adds a key-value pair                        |
| get(K key)                | Retrieves value by key                       |
| remove(K key)             | Removes entry by key                         |
| containsKey(K key)        | Checks if key exists                         |
| containsValue(V value)    | Checks if value exists                       |
| putIfAbsent(K, V)         | Adds if key is not already present           |
| replace(K key, V value)   | Updates value if key exists                  |
|replace(K key, V oldVal, V newVal)
| isEmpty()                 | Checks if map is empty                       |
| size()                    | Returns number of entries                    |
| clear()                   | Removes all entries                          |
| getOrDefault(K, V)        | Returns value if key exists, else default    |
| keySet()                  | Returns a Set of all keys                    |
| values()                  | Returns a Collection of all values           |
| entrySet()                | Returns Set of key-value pairs (Map.Entry)   |
| compute(K, BiFunction)    | Modifies value based on key and current value|

#### Example

Map<Integer, String> map = new HashMap<>();
map.put(1, "Apple");
map.put(2, "Banana");

System.out.println(map.getOrDefault(2, "Unknown")); // "Banana"
System.out.println(map.containsKey(2) ? map.get(2) : "Apple");

map.compute(1, (k, v) -> v + " Pie");
map.compute(5, (k, v) -> (v == null ? "New Pie" : v + " Pie"));

map.put(1, "Apple");
map.computeIfAbsent(2, k -> "Banana");  // Key 2 not present → adds it
map.computeIfAbsent(1, k -> "Orange");  // Key 1 present → no change
map.computeIfAbsent(3, k -> k % 2 == 0 ? "Even" : "Odd");


map.put(1, "Apple");
map.computeIfPresent(1, (k, v) -> v.toUpperCase()); // Only if key 1 is present
map.computeIfPresent(3, (k, v) -> "Mango"); // Key 3 not present → ignored


| Method               | If key is **absent** | If key is **present** |
| -------------------- | -------------------- | --------------------- |
| `compute()`          | `v = null`, runs     | `v = value`, runs     |
| `computeIfAbsent()`  | runs with `v = null` | **does not run**      |
| `computeIfPresent()` | **does not run**     | runs with `v = value` |


FOR Iteration
for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println("Key: " + entry.getKey());
    System.out.println("Value: " + entry.getValue());
}
for (Integer key : map.keySet()) {
    System.out.println("Key: " + key);
}

for (String value : map.values()) {
    System.out.println("Value: " + value);
}


ITERATOR Iteration

  Using entrySet() with Iterator – for both key and value
---- 
 Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

    Using keySet() with Iterator – for keys only
    -------

    Iterator<Integer> it = map.keySet().iterator();
    while (it.hasNext()) {
    Integer key = it.next();
    System.out.println("Key: " + key);
}

Using values() with Iterator – for values only
-----
Iterator<String> it = map.values().iterator();
while (it.hasNext()) {
    String value = it.next();
    System.out.println("Value: " + value);
}

map.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));

 Array Operations: Manual vs Built-in
---
| Array Operation | Manual Implementation      | Built-in Method                 |
|-----------------|---------------------------|---------------------------------|
| Append          | arr[size++] = value;       | ArrayList.add(value);           |
| Insert          | Shift elements, insert     | ArrayList.add(index, value);    |
| Delete          | Shift elements left        | ArrayList.remove(index);        |
| Get             | arr[index]                 | ArrayList.get(index);           |
| Update          | arr[index] = value;        | ArrayList.set(index, value);    |
| Search          | Loop through array         | ArrayList.indexOf(value);       |
| Shift Left      | Loop and shift             | System.arraycopy()              |
| Shift Right     | Loop and shift             | Collections.rotate(arr, -1);    |
| Rotate Left     | Loop and swap              | Collections.rotate(arr, -1);    |
| Rotate Right    | Loop and swap              | Collections.rotate(arr, 1);     |


**Tips:**
- Prefer ArrayList for frequent reads and random access.
- Use LinkedList for frequent insertions/removals at ends.
- Avoid Vector unless thread-safety is needed (legacy, synchronized).
- Stack is LIFO, internally uses Vector.

---
PROBLEMS
------
### 1. Segregating Positive and Negative Numbers

**Using ArrayList:**

```java
public static void segregateArray(int[] arr) {
    List<Integer> positive = new ArrayList<>();
    List<Integer> negative = new ArrayList<>();

    for (int num : arr) {
        if (num >= 0)
            positive.add(num);
        else
            negative.add(num);
    }

    // Merge both lists back to array
    int i = 0;
    for (int num : negative) arr[i++] = num;
    for (int num : positive) arr[i++] = num;
}

public static void main(String[] args) {
    int[] arr = {12, -7, 5, -3, 9, -6, 8, -2};
    segregateArray(arr);
    System.out.println("Segregated Array: " + Arrays.toString(arr));
}
```

**Using Pointers:**

```java
public static void segregate(int[] arr) {
    int left = 0, right = arr.length - 1;

    while (left < right) {
        if (arr[left] < 0) left++;
        else if (arr[right] > 0) right--;
        else {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

2.Merging two sorted arrays

3. Finding duplicate elements in an Integer array  

4.Create an empty `HashSet` of integers.

5.Add Duplicate Element to HashSet and Observe Behavior

Add two elements in hashset 30 and 50 If the hashset accepts the valueS, print 
30 = "true", 50 = "false" that means set already consist 10,20,30

6.Convert a HashSet to an ArrayList.

4.Given an array nums of integers, return how many of them contain an even number of digits.

5.Given an array of integers, return the element with the highest frequency.
Input: [1, 3, 2, 3, 4, 3, 5]
Output: 3

6.Given a string s, return the first non-repeating character. If none, return '_'.
Input: "aabbcdde"
Output: 'c'

7.You are given a list of non-negative integers where each integer represents the amount of money stored in a house. The houses are arranged in a line, and you are a robber who cannot rob two adjacent houses due to security systems.

Write a Java program to determine the maximum amount of money you can rob tonight without alerting the police.
5
2 7 9 3 1

output
12

8.Given a list of strings, group all anagrams together.
Input: ["eat","tea","tan","ate","nat","bat"]
Output: [["eat","tea","ate"],["tan","nat"],["bat"]]

. Inserting in a sorted Array and checking if an Array is sorted  
3. Finding missing elements in Arrays 
  


