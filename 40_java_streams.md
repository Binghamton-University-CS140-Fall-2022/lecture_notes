--------------------
Java Streams
--------------------

[Take a look at the Java documentation for `Streams`](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)
 
## From the Java documentation

- “A sequence of elements supporting sequential and parallel aggregate operations. ”

## Some of the operations

| Method        | Description      |
| --------------| -----------------|
| `count()`  	| returns a long   |
| `distinct()` 	| returns a Stream |
| `filter()` 	| returns a Stream |
| `limit()` 	| returns a Stream |
| `map()` 		| returns a Stream |
| `skip()` 		| returns a Stream |
| `sorted()`   	| returns a Stream |
| `forEach()`   | returns nothing  |
| `toList()`    | returns a list   |
| `toArray()`   | retrurns an array|


## Example 0

The following example illustrates an aggregate operation using `Stream` and `IntStream`:

``` java
int sum = 	widgets.stream()
			.filter(w -> w.getColor() == RED)
			.mapToInt(w -> w.getWeight())
			.sum();
```

- In this example, `widgets` is a `Collection<Widget>`. 

1. We create a `Stream` of `Widget` objects via `Collection.stream()`
2. Filter it to produce a `Stream` containing only the red widgets
3. Transform it (map it) into a `Stream` of `int` values representing the weight of each red widget. 
4. Then this stream is summed to produce a total weight.


## Example 1

- Create an `ArrayList<Integer>` with values `0, 1, …, 9`
- We want to use a `Stream` to filter the values that are divisible by 3

``` java
list.stream()
	.filter(x -> x % 3 == 0)
	.forEach(System.out::println);
```

- Create an `Integer[]` of the filtered values

``` java
Integer[] list3 = list.stream()
					  .filter(x -> x % 3 == 0)
					  .toArray(Integer[]::new);
```

- Create an `Integer[]` of the filtered values mapped by doubling the values

``` java
Integer[] list3x2 = list.stream()
						.filter(x -> x % 3 == 0)
						.map(x -> x * 2)
						.toArray(Integer[]::new);
```

**Note:** For readability, putting each part of the `Stream` on a seperate line is preferred

## Example 2

- Create an `ArrayList<Integer>` with values `0, 1, …, 9`

- We want to use a `Stream` to:
1. Skip the first three elements
2. Then to filter the values that are divisible by 3

``` java
list.stream()
	.skip(3)
	.filter(x -> x % 3 == 0)
	.forEach(System.out::println);
```

- We want to use a stream to:
1. Limit the stream to the first five elements 
2. Then filter the values that are divisible by 3

``` java
list.stream()
	.limit(5)
	.filter(x -> x % 3 == 0)
	.forEach(System.out::println);
```

- We want to use a stream to:
1. Filter the values that are divisible by 3 
2. Use the `count()` to return the number of elements in the stream

``` java
System.out.println("Result: " + list.stream().filter(x ->x % 3 == 0).count());
```

## Example 3

- Create an `ArrayList<Integer>` with values `0, 1, 2, 0, 1, 2, 0, 1, 2, 0`

- Get the unique values
``` java
list.stream()
	.distinct()
	.forEach(System.out::println);
```

- Sort the values
``` java
list.stream()
	.sorted()
	.forEach(System.out::println);
```

- Return a sorted `Integer[]`

``` java
Integer[] listSorted = list.stream().sorted().toArray(Integer[]::new);
```

## [Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)

- In many of the previous examples, we are leveraging ***lambda expressions***.

- An ***anonymous class*** is a class without a name
- `x -> x % 3 == 0` in `filter()` is a lambda expression
	- It represents a function that takes one argument, and returns some `boolean`value, based off some check being done.
	- `filter()` will filter out elements which do NOT satisfy the check being performed.
	- High level, such a function, that returns some boolean value, are called [`Predicates`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)

## The `Predicate` Interface

- If you look at the Java documentation for `Streams`, you will see that many of the methods take a `Predicate` as a parameter.
- `Predicate` is a ***functional interface*** 
- Functional interfaces have ***exactly one abstract method*** that needs to be implemented.
	- For `Predicate`, `test()` must be implemented.
	- Functional interfaces can be defined via some lambda expression, as we are doing above.

- From the Java documentation:
- "This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference."

## Another example of a Functional Interface

- Another example of a functional interface is the `Comparator<T>` class we have used in the past.
	- It has exactly one abstract method to implement, `int compare(T o1, T o2);`
	- Note this method takes two arguments, and returns an int value.
		- Here could be a simple example of a lamda expression:
		- `(a,b) -> return a - b`