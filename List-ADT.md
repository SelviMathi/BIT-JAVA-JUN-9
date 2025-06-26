# Java Collections – List ADT Overview

## Collections Hierarchy

```
java.util.Collection (Interface)
             |
   -----------------------------
   |                           |
List (Interface)           Set (Interface)
   |                           |
-----------               ---------------
|   |   |                 |     |      |
ArrayList LinkedList Vector  HashSet LinkedHashSet TreeSet

Queue (Interface)
   |
PriorityQueue, ArrayDeque
-------------------------------------------
```

```
        java.util.Map (Interface)
                    |
           -----------------------
           |                     |
         HashMap        TreeMap / LinkedHashMap
```

---

## 1. Collection Interface

The root interface in the collection hierarchy for List, Set, and Queue.

---

## 2. List Interface (Ordered, Allows Duplicates)

| Class      | Features                                 |
|------------|------------------------------------------|
| ArrayList  | Fast random access, resizable array      |
| LinkedList | Doubly-linked, fast insert/delete        |
| Vector     | Thread-safe (synchronized), legacy       |
| Stack      | LIFO stack (extends Vector)              |

### Example: ArrayList Usage

```java
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
```

### Example: LinkedList Usage

```java
LinkedList<Integer> ll = new LinkedList<>();
ll.add(10); ll.addFirst(5); ll.addLast(20);
System.out.println("LinkedList: " + ll);
ll.removeFirst(); ll.removeLast();
System.out.println("After removing ends: " + ll);
ll.add(15); ll.add(25); ll.add(2, 18);
System.out.println("LinkedList after add: " + ll);
System.out.println("First: " + ll.getFirst() + ", Last: " + ll.getLast());
```

### Example: Vector Usage

```java
Vector<String> vector = new Vector<>();
vector.add("A"); vector.add("B");
vector.addElement("C");              // Legacy method
vector.remove(1);
System.out.println("Vector: " + vector);
System.out.println("Element at 0: " + vector.elementAt(0)); // legacy method
vector.set(0, "Z");
System.out.println("Modified Vector: " + vector);
System.out.println("Capacity: " + vector.capacity());
```

### Example: Stack Usage

```java
Stack<Integer> stack = new Stack<>();
stack.push(100); stack.push(200);
System.out.println("Top: " + stack.peek());
stack.pop();
System.out.println("After pop: " + stack);
System.out.println("Is Empty? " + stack.isEmpty());
System.out.println("Search(100): " + stack.search(100)); // 1-based index
```

---

### Common List Methods

- addAll, retainAll, removeAll
- Collections.reverse, Collections.sort, Collections.rotate
- Collections.swap, Collections.shuffle, Collections.fill
- Collections.frequency, Collections.max, Collections.min
- Collections.unmodifiableList

```java
Collections.rotate(list, -2);
Collections.rotate(list, 3);
Collections.reverse(list);
Collections.swap(list, 0, 2);
Collections.shuffle(list);
Collections.fill(list, "X");
int freq = Collections.frequency(list, "A");
Collections.max(list);
Collections.min(list);
List<String> original = new ArrayList<>(Arrays.asList("One", "Two"));
List<String> unmodifiable = Collections.unmodifiableList(original);
```

#### List <-> Array Conversion

```java
// List to Array
List<String> list = Arrays.asList("x", "y", "z");
String[] arr = list.toArray(new String[0]);
System.out.println(Arrays.toString(arr));

// Array to List
int[] arr = {1, 2, 3};
List<Integer> list = new ArrayList<>();
for (int num : arr) list.add(num);
```

---

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

```java
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

---

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

```java
Queue<String> queue = new LinkedList<>();
queue.offer("A");
queue.offer("B");
queue.offer("C");

System.out.println("Head: " + queue.peek());  // A
System.out.println("Removed: " + queue.poll()); // A
System.out.println("Queue: " + queue);          // [B, C]
```

### Example: PriorityQueue

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(50);
pq.offer(10);
pq.offer(30);

while (!pq.isEmpty()) {
    System.out.println(pq.poll());  // 10, 30, 50
}
```

### Example: ArrayDeque

```java
Deque<String> dq = new ArrayDeque<>();
dq.offer("Java");
dq.offerFirst("C++");  // Insert at front
dq.offerLast("Python");

System.out.println(dq);           // [C++, Java, Python]
System.out.println(dq.pollLast()); // Python
```

---

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
| isEmpty()                 | Checks if map is empty                       |
| size()                    | Returns number of entries                    |
| clear()                   | Removes all entries                          |
| getOrDefault(K, V)        | Returns value if key exists, else default    |
| keySet()                  | Returns a Set of all keys                    |
| values()                  | Returns a Collection of all values           |
| entrySet()                | Returns Set of key-value pairs (Map.Entry)   |
| compute(K, BiFunction)    | Modifies value based on key and current value|

#### Example

```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "Apple");
map.put(2, "Banana");

System.out.println(map.getOrDefault(2, "Unknown")); // "Banana"

for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println("Key: " + entry.getKey());
    System.out.println("Value: " + entry.getValue());
}

map.compute(1, (k, v) -> v + " Pie"); // Apple → Apple Pie
```

---

## 7. Array Operations: Manual vs Built-in

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

---

## 8. Example Programs

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
```

---

### Other Topics (To Fill)

2. Inserting in a sorted Array and checking if an Array is sorted  
3. Merging two sorted arrays  
4. Finding duplicate elements in an Integer array  
5. Finding missing elements in Arrays - Different Methods  

---

**Tips:**
- Prefer ArrayList for frequent reads and random access.
- Use LinkedList for frequent insertions/removals at ends.
- Avoid Vector unless thread-safety is needed (legacy, synchronized).
- Stack is LIFO, internally uses Vector.

---