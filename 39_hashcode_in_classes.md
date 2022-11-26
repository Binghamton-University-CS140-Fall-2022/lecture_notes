-------------------------
HashCodes for classes
-------------------------

- If we override the `equals()` method or need to use a `HashSet`, `Hashtable`, or use the class as the ***key*** of a `HashMap` we need to override the `hashCode()` method.


### Overridding the `equals()` method and `hashCode()` method

- When we override the `equals()` method for a class, we also need to override the `hashCode()` method
- From the Java documentation for `Object.equals()`
	- API Note:
	- "It is generally necessary to override the `hashCode` method whenever this method is overridden, so as to maintain the general contract for the `hashCode` method, which states that ***equal objects must have equal hash codes***."


### Details on the hashCode method

- From the Java documentation for `Object.hashCode()`
	- The general contract of `hashCode` is:
	- Whenever it is invoked on the same object more than once during an execution of a Java application, the `hashCode` method must consistently return the same integer, provided no information used in `equals` comparisons on the object is modified. This integer need not remain consistent from one execution of an application to another execution of the same application.
	- If two objects are equal according to the `equals` method, then calling the `hashCode` method on each of the two objects must produce the same integer result.
	- It is not required that if two objects are unequal according to the `equals` method, then calling the `hashCode` method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.

### Examples of how we could implement it for classes we've defined throughout the semester

| Class | Reasonable hashCode() implementation |
| ----- | ------------------------------------ |
| Node  | If we override the equals() method, we need to implement hashCode(). We can simply return the key value. |
| WeightedVertex | Return the vertex value |
| WeightedEdge | Return a function of the from and to vertices. Seems like the sum of the from and to vertices would be sufficient. |

**Note:** The WeightedEdge implementation would be sufficient according to the last note, but it is possible two unequal WeightedEdges could have an equal hashCode. This could lead to decreased performance for hash tables, but would not break them.

Another return value could be something like: fromVertex + 10 * toVertex, which, while less intuitive, would lead to less collisions for hashCodes involving our weightedEdges, which could make the performance of hash tables better. 

Even this is not perfect though. Consider the following two edges:

(100,2)
(20,10) 

Both would map to 120 here, so we see this doesn't work as a hashCode implementation in general.
