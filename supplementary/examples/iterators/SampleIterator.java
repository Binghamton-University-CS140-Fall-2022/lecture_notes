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