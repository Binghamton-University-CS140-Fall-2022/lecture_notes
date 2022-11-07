------------------------
Miscelaneous Topics
------------------------

## Object orient programming

[From wikipedia:](https://en.wikipedia.org/wiki/Object-oriented_programming)

- ***Object-oriented programming (OOP)*** is a programming paradigm based on the concept of "objects", which can contain
data and code: data in the form of fields (often known as attributes or properties), and code, in the form of procedures (often known as methods).
- **Note:** This is what we've been doing for the past 11 weeks 

## Java parameters

- **Question:** Are they passed by value or by reference?
	- "By value" equates to ***passing a copy*** of the variable to the method
		-  For primitive types, this means changes to the parameter within the method have no effect on the original variable that was passed to the method 
	- "By reference" equates to passing the address (or pointer) of the variable to the method
		- For primitive types, this means changes to the parameter within the method directly effect the original that was passed to the method 

- **Answer:** Java passes all parameters by value
	- For objects
		- This equates to passing a reference of the object by value
		- The object can be modified, and the changes are reflected in the original object
		- But assigning a new object to the parameter does not effect the original, since the parameter is a copy of the reference of the original object

### Sample program
-  Declare
	-  int, String, int[], Integer[], and four Nodes
	-  The variables are initialized
	-  All are passed to a method as parameters

``` java
public class JavaParameters
{
	static class Node 
	{
		private int key;

		public Node(int k)
		{
			this.key = k;
		}

		public int getKey()
		{
			return this.key;
		}	

		public void setKey(int newKey)
		{
			this.key = newKey;
		}

		public String toString()
		{
			return "" + this.key;
		}
	}

	public static void manipulating_java_parameters(int a, String s, int[] prim_arr, Integer[] obj_arr, Node n1, Node n2, Node n3, Node n4)
	{
		a = 555;
		s = "Does this change?";

		for(int i = 0; i < prim_arr.length; ++i)
		{
			prim_arr[i] = i * 2;
		}

		for(int i = 0; i < obj_arr.length; ++i)
		{
			obj_arr[i] = i + 5;
		}

		prim_arr = new int[3];
		obj_arr = new Integer[7];

		n1 = new Node(17);
		n2 = new Node(18);

		n3.setKey(5666);
		n4.setKey(19284);
	}

	public static void main(String[] args)
	{
		int a 				= 36;
		String s 			= "test";
		int[] prim_arr 		= new int[]{5,2,3,1};
		Integer[] obj_arr	= new Integer[]{7,7,34,2,8};

		Node n1 = new Node(47);
		Node n2 = new Node(20);
		Node n3 = new Node(13);
		Node n4 = new Node(193);

		manipulating_java_parameters(a,s,prim_arr, obj_arr, n1, n2, n3, n4);

		System.out.println("a: " + a);
		System.out.println("s: " + s);
		System.out.println("prim_arr: " + java.util.Arrays.toString(prim_arr));
		System.out.println("obj_arr: " + java.util.Arrays.toString(obj_arr));

		System.out.println("n1: " + n1);
		System.out.println("n2: " + n2);
		System.out.println("n3: " + n3);
		System.out.println("n4: " + n4);

	}
}

```

-  In the method
	-  Assign new values to the `int`, `String`, `int[i]`, `Integer[i]`
		-  The `int` and `String` remain unchanged and the `int[i]` and `Integer[i]` are modified
		-  We also reallocate the `int[]` and `Integer[]`, nothing happens to the originals
-  Assign a new `Node` to one of the `Nodes` and change fields of two of the `Nodes`
	-  The field changes are seen in the original `Nodes`
	-  The `new Node()` assignment is not seen in the original

## Review of Inheritance

-  When a class `extends` another class, such as our `EnhancedBankAccount` extending our `BankAccount` class, the `EnhancedBankAccount` inherits some stuff (fields and methods) from the `BankAccount` class
	- The class that `extends` the class is called the ***sub class*** (or ***child class***)
	- The class that is extended is called the ***super class*** (or ***parent class***)
	-  Non private fields are inherited
	-  Non private methods inherited
	-  Constructors
	-  The sub class can override inherited fields/methods or use the super classes fields/methods
-  In particular, our `EnhancedBankAccount` classes constructors and methods used the `BankAccount` constructors and methods

### Example of ***Polymorphism*** in the `EnhancedBankAccount` class

-  For the `withdrawFromChecking` and `withdrawFromSavings` methods of the `EnhancedBankAccount`, we use the super methods to
maintain the checking and savings balance, but we then had ***additional code*** within the `EnhancedBankAccount` class to include ***additional functionality***
-  This is ***polymorphism***.
- Here's my `EnhancedBankAccount` `withdrawFromChecking()`:

``` java
public boolean withdrawFromChecking(double amount)
{
	boolean returnValue = false;
	java.util.Date date = new java.util.Date();

	if( super.withdrawFromChecking(amount) )
	{
		successfulTransactions.add(new Transaction("withdrawFromChecking", date, amount));
	}
	else
	{
		failedTransactions.add(new Transaction("withdrawFromChecking", date, amount));	
	}

	return returnValue;
}
```

-  We use the parent classes `withdrawFromChecking` to maintain the `checkingBalance`, but we also have additional
code to keep track of the transaction
-  And so, we have extended the functionality of the `BankAccount` class, and we have modified functionality of the method in the `EnhancedBankAccount` class

### [You can look over the Java tutorials for another example of polymorphism](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)

-  From the tutorial:

"The dictionary definition of polymorphism refers to a principle in biology in which an organism or species can have many different forms or stages. This principle can also be applied to object-oriented programming and languages like the Java language. Subclasses of a class can define their own unique behaviors and yet share some of the same functionality of the parent class."

- Another example was our `Bird` example, where we had a `Canary`, `BlueJay`, and `Cardinal` that all implemented their `sing()` methods in slightly specialized manners.