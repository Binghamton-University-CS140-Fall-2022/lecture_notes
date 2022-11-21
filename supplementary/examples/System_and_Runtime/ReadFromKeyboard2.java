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