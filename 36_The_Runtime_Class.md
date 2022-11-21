----------------------
The Runtime Class
----------------------

The `Runtime` class allows your program to interact with the environment.

- `Runtime.getRuntime()` 
	- returns the `Runtime` object associated with the current program
- `availableProcessors()` 
	- returns the number of processors available to the program
	- This appears to take into account hyper threading
- `freeMemory()` 
	- returns the amount of free memory in the virtual machine
	- Calling gc() may change this value
- `maxMemory()` 
	- returns the maximum amount of memory the virtual machine will attempt to use
	- This can be changed via the `-Xmx` flag
- `totalMemory()` 
	- returns the total amount of memory in the virtual machine
	- This can change over time
- `gc()` 
	- runs the garbage collector
- `exit(int exitStatus)`
	- terminates the current virtual machine
- `halt(int exitStatus)`
	- forcibly terminates the current virtual machie
- There is a collection of `exec` methods for executing a command





## Example

Below is an example to showcase using the `RunTime` class.

- To run the entire program you will need to execute with `-Xmx13G` to allocate ***13GB to the heap***
- Execute `System.getEnv()` and output the key and value pairs via an enhanced for loop
- Execute `System.getEnv()` and output the key and value pairs via an iterator for the key set
- Execute `System.getProperties()` and output the key and value pairs via an iterator over the key set
- Get the `RunTime` object associated with the virtual machine, call it `rt`

- Execute `rt.availableProcessors()`
- Execute `rt.freeMemory()` in bytes and MB
- Execute `rt.maxMemory()` in bytes and MB
- Execute `rt.totalMemory()` in bytes and MB
- Allocate a ***4GB*** `int` array and output the memory info
- Assign the `int` array to `null`, call `rt.gc()`, and output the memory info
- Call `rt.gc()` and output the memory info
- Allocate three more ***4GB*** `int` arrays and output the memory info

``` java
class exampleSystemAndRunTime
{
	public static void main(String[] args)
	{
		java.util.Map<String, String> currentEnv = System.getenv();
		System.out.println("System.getEnv() via enhanced for loop");
		for( java.util.Map.Entry<String, String> entry : currentEnv.entrySet() )
		{
			System.out.println("\t" + entry.getKey() + " -> " + entry.getValue());
		}
		System.out.println();
		
		java.util.Iterator<String> it = currentEnv.keySet().iterator();
		System.out.println("System.getEnv() via iterator");
		while( it.hasNext() )
		{
			String key = it.next();
			System.out.println("\t" + key + " -> " + currentEnv.get(key));
		}
		System.out.println();
		
		java.util.Properties props = System.getProperties();
		java.util.Set<String> propsNames = props.stringPropertyNames();
		System.out.println("System.getProperties() via iterator");
		it = propsNames.iterator();
		while( it.hasNext() )
		{
			String key = it.next();
			System.out.println("\t" + key + " -> " + props.get(key));
		}
		System.out.println();
		
		Runtime rt = Runtime.getRuntime();
		System.out.println("availableProcessors() = " + rt.availableProcessors());
		System.out.println();
		
		System.out.println("freeMemory() in bytes = " + rt.freeMemory());
		System.out.println("freeMemory() in MB = " + rt.freeMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("maxMemory() in bytes = " + rt.maxMemory());
		System.out.println("maxMemory() in MB = " + rt.maxMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("totalMemory() in bytes = " + rt.totalMemory());
		System.out.println("totalMemory() in MB = " + rt.totalMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("alocating a large int array with 1024 x 1024 x 1024 elements");
		int[][][] largeArray = new int[1024][1024][1024];
		System.out.println();
		
		System.out.println("freeMemory() in bytes = " + rt.freeMemory());
		System.out.println("freeMemory() in MB = " + rt.freeMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("maxMemory() in bytes = " + rt.maxMemory());
		System.out.println("maxMemory() in MB = " + rt.maxMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("totalMemory() in bytes = " + rt.totalMemory());
		System.out.println("totalMemory() in MB = " + rt.totalMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("calling the garbage collector");
		rt.gc();
		System.out.println();
		
		System.out.println("freeMemory() in bytes = " + rt.freeMemory());
		System.out.println("freeMemory() in MB = " + rt.freeMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("maxMemory() in bytes = " + rt.maxMemory());
		System.out.println("maxMemory() in MB = " + rt.maxMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("totalMemory() in bytes = " + rt.totalMemory());
		System.out.println("totalMemory() in MB = " + rt.totalMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("assigning the large int array to null and calling the garbage collector");
		largeArray = null;
		rt.gc();
		System.out.println();
		
		System.out.println("freeMemory() in bytes = " + rt.freeMemory());
		System.out.println("freeMemory() in MB = " + rt.freeMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("maxMemory() in bytes = " + rt.maxMemory());
		System.out.println("maxMemory() in MB = " + rt.maxMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("totalMemory() in bytes = " + rt.totalMemory());
		System.out.println("totalMemory() in MB = " + rt.totalMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("alocating another three large int arrays with 1024 x 1024 x 1024 elements");
		int[][][] largeArray1 = new int[1024][1024][1024];
		System.out.println("first done");
		int[][][] largeArray2 = new int[1024][1024][1024];
		System.out.println("second done");
		int[][][] largeArray3 = new int[1024][1024][1024];
		System.out.println("third done");
		System.out.println();
		
		System.out.println("freeMemory() in bytes = " + rt.freeMemory());
		System.out.println("freeMemory() in MB = " + rt.freeMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("maxMemory() in bytes = " + rt.maxMemory());
		System.out.println("maxMemory() in MB = " + rt.maxMemory()/((1024*1024)));
		System.out.println();
		
		System.out.println("totalMemory() in bytes = " + rt.totalMemory());
		System.out.println("totalMemory() in MB = " + rt.totalMemory()/((1024*1024)));
		System.out.println();
	}
}
```
