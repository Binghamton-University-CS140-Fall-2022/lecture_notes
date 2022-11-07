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