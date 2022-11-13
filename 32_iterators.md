---------------------
Iterators
---------------------

- The `Iterator` interface supports ***iterating*** over the elements of a list
	- Or looping through the elements of a list
- Some Java classes that store elements, do not have a way to access the elements without removing them
- For example, the `PriorityQueue` class has the `poll()` method to get the current lowest element of the `PriorityQueue`, but no way to access the other elements 
	- We can use the `iterator()` method of the `PriorityQueue` to return an `Iterator` able to access the elements of the `PriorityQueue` without removing them

- The `Iterator` interface has the following two methods, `hasNext()` and `next()`, to loop over the elements of the `Iterator`

## Example

- We have a `PriorityQueue<Integer> priQueue` containing a collection of `Integers`
- We want to print out the elements of `priQueue` without removing them, using the `poll()` method
- We get an `Iterator` for `priQueue` and then print out the elements
	- **Note:** The order is not the same as the order we get using `poll()`

### Sample code

- Put 10 pseudo random number in `[0, 9]` into `priQueue` and then output via an `Iterator`, `toArray`, and `poll()`

``` java
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Iterator;

class SampleIterator
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		PriorityQueue<Integer> priQueue = new PriorityQueue<>();

		for(int i = 0; i < 10; ++i)
		{
			priQueue.add(Integer.valueOf(rand.nextInt(10)));
		}

		System.out.println("priQueue via iterator");
		Iterator iter = priQueue.iterator();

		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		System.out.println();

		System.out.println("priQueue via array");
		Integer[] integerArray = priQueue.toArray(new Integer[0]);
		for(int i = 0; i < integerArray.length; ++i)
		{
			System.out.println(integerArray[i]);
		}
		System.out.println();

		System.out.println("priQueue via poll");
		while(priQueue.size() > 0)
		{
			System.out.println(priQueue.poll());
		}
	}
}
```

### Sample code output

- **Note:** `Iterator` order of output is different from `poll()` output order

```
priQueue via iterator
0
4
2
6
5
9
5
8
7
8

priQueue via array
0
4
2
6
5
9
5
8
7
8

priQueue via poll
0
2
4
5
5
6
7
8
8
9
```
