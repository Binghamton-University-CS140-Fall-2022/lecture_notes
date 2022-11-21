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
