public class testHashMapAndTreeMap
{
	public static void main(String[] args)
	{
		java.util.HashMap<Integer, String> hMap = new java.util.HashMap<>();
		java.util.TreeMap<Integer, String> tMap = new java.util.TreeMap<>();

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