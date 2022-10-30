----------------------
Implicit parameters
----------------------

In Java, the object associated with the instantiation of a class is an ***implicit*** argument or parameter to the classes' instance methods.

- That is, the instance methods need to know what object they are being called on
- The static methods of a class have the object ***explicitly*** stated as part of the method invocation
	- For example, the `String` class has a `length()` method
	- If we instantiate a `String` with `String s = new String(“abcdef”);` then execute `s.length();`, the object `s` of type `String` is an ***implicit*** argument or parameter to the method `length()`
	- If we have a `public static int length(String s)` method, then `s` is an ***explicit*** argument or parameter


## Example - The Rectangle class

- The Java `Rectangle` class has instance fields:
	- `x`, `y`, `width`, `height`

### Translate method of Rectangle

- It also has an instance method `translate(int dx, int dy)` which translates the values of `x` & `y` by `dx` & `dy` respectively.
- For the sake of discussion below, suppose we create two Rectangles `r1` & `r2`
	- `Rectangle r1 = new Rectangle(0, 0, 10, 10);` and 
	- `Rectangle r2 = new Rectangle(0, 0, 20, 20);`

### Instance methods vs Static / Class methods

- ***Instance methods*** are those that have to be called on an object. 
	- If a method needs access to read or modify instance fields, then the method needs access to the reference `this`, which we call the ***implicit parameter***

- The other methods are ***static methods***. 
	- If the method is more stand-alone, then they can be declared as `static`.
	- These are also called ***class methods***, and they do not have the implicit parameter in their activation records, since they do not reference any instance fields.
	- eg, `Math.max()`

### Translating a particular Rectangle object

- Suppose we perform `r1.translate(10, 10);` 
- There is only **one copy** of the code for the method `translate`, not one copy for each object.
- **Question:** How is it that `translate` moves `r1` above and not `r2` then?
- **Answer:** The code of `translate` has to receive a reference to the object it will read information from or modify.
	- there is an implicit parameter, with the name `this`, which is a reference to the object `r1`, that is provided to the `translate` method (along with the two explicit parameters `dx` & `dy`).


### Clarity on how the implicit parameter is working
- In the `r1.translate(int dx, int dy)` method call, the implicit argument allows the `translate` method to modify the correct
`Rectangle` object
- The code for translate can be written as
	- `x = x+dx;`
	- `y = y+dy;`
or
	- `this.x = this.x+dx;`
	- `this.y = this.y+dy;`
- They are synonymous to the compiler.
	- And if the current value of `this` is a reference to `r1`, then the code executed is:
		- `r1.x = r1.x+dx;`
		- `r1.y = r1.y+dy;`

### Key Takeaway: The reference is passed as if it were a parameter

- The activation record of a method contains various parts, starting with the space designated for parameters, where the arguments are stored. 
- For instance methods, the reference to the object is also stored in the activation record as if it were a paramter.
- It is called the ***implicit parameter***.