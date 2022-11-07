------------------------
HashMap and TreeMap
------------------------

## HashMap vs TreeMap implementation wise

-  The `HashMap` is a ***hash table implementation*** of the `Map` interface
-  The `TreeMap` is a ***tree implementation*** of the `Map` interface

## Description of the Map Interface

-  The `Map` interface maps ***keys*** to ***values***
	-  The keys are unique
	-  Each key can be mapped to one value
-  The Map interface is equivalent to **Dictionaries** in Python
-  Both are part of the `java.util package`
-  When defined, we specify the type of the key and the type of the value associated with the key


## Instantiation of these Maps

-  To define and instantiate a `HashMap` and `TreeMap` that have `Integer` keys and `String` values:

```java
HashMap<Integer, String> hMap = new HashMap<>()
TreeMap<Integer, String> tMap = new TreeMap<>()
```

## Storage under the hood

-  The `HashMap` uses a ***hash table*** to store the keys
	-  The keys are ***not maintained*** in any particular order
-  The `TreeMap` uses a ***Red-Black tree*** to store the keys
	-  The keys ***are maintained in sorted order***, either the ***natural order*** or the order specified by a ***comparator***

## Some of the Map methods

| Method | Description |
| ------ | ----------- |
| `put(key, value)` | add the key & value pair to the map. If the key already exists in the map, the existing value associated with the key is replaced with “value” |
| `get(key)` | returns the value associated with the key. Returns `null` if the key does not exist in the map |
| `containsKey(key)` | returns true if the key exists in the map, false otherwise. |
| `containsValue(value)` | returns true if the value exists in the map, false otherwise. |
| `remove(key)` | Removes the key and associated value from the map. |
| `keySet()` | Returns a `Set` view of the keys. |
| `values()` | Returns a `Collection` view of their values. |

-  There are many other methods

## Time Complexities

- `TreeMap` guarantees ***log(n) time*** for `containsKey`, `get`, `put`,
and `remove` method calls
- `HashMap` provides ***constant time*** for `get` and `put` methods
	- **Note:** This depends on the initial capacity and load factor associated with the HashMap

## Sample code

`testHashMapAndTreeMap.java`

-  Adds keys [1000, 1009] with associated values to a `HashMap` and `TreeMap`
	-  Adds two copies of each key with different values
	-  We see that the second value is the one that remains
-  Outputs the size of the two Maps
	-  Each have 10 elements
-  Searches for some keys that are in the Map and some keys that are not in the Map
	-  Removes the keys that are found in the Map
-  Outputs the size of the two Maps
	-  Each have 5 elements


``` java
public class testHashMapAndTreeMap
{
	public static void main(String[] args)
	{
		HashMap<Integer, String> hMap = new HashMap<>()
		TreeMap<Integer, String> tMap = new TreeMap<>()

		//1. Put some values in each map
		hMap.put(1000, "1");
		hMap.put(1001, "2");
		hMap.put(1002, "3");
		hMap.put(1003, "4");
		hMap.put(1004, "5");
		hMap.put(1005, "6");
		hMap.put(1006, "7");
		hMap.put(1007, "8");
		hMap.put(1008, "9");
		hMap.put(1009, "10");

		System.out.println(hMap.get(1004));

		tMap.put(1000, "run");
		tMap.put(1001, "hop");
		tMap.put(1002, "jump");
		tMap.put(1003, "duck");
		tMap.put(1004, "gallop");
		tMap.put(1005, "sprint");
		tMap.put(1006, "crawl");
		tMap.put(1007, "walk");
		tMap.put(1008, "swim");
		tMap.put(1009, "play");

		System.out.println(tMap.get(1006));

		//2. Reusing the same keys overwrites the previous values held in the map
		hMap.put(1000, "red");
		hMap.put(1001, "orange");
		hMap.put(1002, "yellow");
		hMap.put(1003, "green");
		hMap.put(1004, "blue");
		hMap.put(1005, "purple");
		hMap.put(1006, "brown");
		hMap.put(1007, "white");
		hMap.put(1008, "black");
		hMap.put(1009, "grey");

		System.out.println(hMap.get(1004));

		tMap.put(1000, "penguin");
		tMap.put(1001, "otter");
		tMap.put(1002, "cat");
		tMap.put(1003, "dog");
		tMap.put(1004, "giraffe");
		tMap.put(1005, "gold fish");
		tMap.put(1006, "eel");
		tMap.put(1007, "deer");
		tMap.put(1008, "shark");
		tMap.put(1009, "elephant");

		System.out.println(tMap.get(1006));

		System.out.println("Sizes BEFORE removals");
		System.out.println("Hash map size: " + hMap.size());
		System.out.println("Tree map size: " + tMap.size());

		for(int i = 995; i <= 1004; ++i)
		{
			if(hMap.containsKey(i))
			{
				hMap.remove(i);
			}

			if(tMap.containsKey(i))
			{
				tMap.remove(i);
			}
		}

		System.out.println("Sizes AFTER removals");
		System.out.println("Hash map size: " + hMap.size());
		System.out.println("Tree map size: " + tMap.size());

	}
}
```
