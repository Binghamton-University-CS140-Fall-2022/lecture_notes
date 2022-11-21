-----------------------------
Reading From Standard Input
-----------------------------

- Throughout the course, we have been primarily reading from files and getting values from the command line
- We can also read input from the keyboard
- The keyboard input is via `System.in`, which is of type `InputStream`
	- We can read bytes directly from it
	- Or we can wrap an `InputStreamReader` around it and then wrap a `BufferedReader` around that and then read lines of text, versus individual bytes
``` java
BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
```

- If we use `while( (inn = input.readLine()) != null )` we need to enter a
`null` to exit the while loop, in mac / linux os, a `cntl-d` works.

- Or we can change it to `while( ((inn = input.readLine()) != null) &&
(inn.length() > 0) )` and then hitting `enter` without any other data will
get us out of the while loop
	- **Note:** ***Lazy evaluation*** will ensure that we don't try to execute `inn.length()` when `inn`
is `null`

## Reading from keyboard example

``` java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class ReadFromKeyboard
{
	public static void main(String[] args)
	{
		try 
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String inn;
			ArrayList<String> inputLines = new ArrayList<>();

			while( ((inn = input.readLine()) != null) && (inn.length() > 0) )
			{
				inputLines.add(inn);
			}

			System.out.println("inputLines.size() = " + inputLines.size());

			for(String s : inputLines)
			{
				System.out.println(s);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(-1);
		}
	}
}
```

## Reading input via the Scanner class

- We can also wrap a `Scanner` around `System.in` and use all of the functionality of the `Scanner`, which includes reading lines of input:

``` java
import java.util.ArrayList;
import java.util.Scanner;

class ReadFromKeyboard2
{
	public static void main(String[] args)
	{
		try 
		{
			Scanner input = new Scanner(System.in);
			String inn;
			ArrayList<String> inputLines = new ArrayList<>();

			while(input.hasNextLine())
			{
				inn = input.nextLine();
				if(inn.length() == 0)
				{
					break;
				}
				inputLines.add(inn);
			}

			System.out.println("inputLines.size() = " + inputLines.size());

			for(String s : inputLines)
			{
				System.out.println(s);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(-1);
		}
	}
}
```