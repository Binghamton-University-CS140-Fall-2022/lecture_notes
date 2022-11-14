public class Simple
{

	private int a;
	private int b;

	public Simple(int a, int b)
	{
		this.a = a;
		this.b = b;
	}

	public static void foo(int a)
	{
		a = 7;
	}

	public static void bar(Simple thisIsPassedByValue)
	{
		thisIsPassedByValue.a = 50;
		thisIsPassedByValue.b = 50;

		thisIsPassedByValue = new Simple(30,30);
		thisIsPassedByValue.a = 777;
	}

	public String toString()
	{
		return "(" + this.a + "," + this.b + ")";
	}

	public static void main(String[] args)
	{
		int x = 3;
		foo(x);
		System.out.println(x);

		Simple s = new Simple(11,11);
		System.out.println(s);
		bar(s);
		System.out.println(s);
	}
}
