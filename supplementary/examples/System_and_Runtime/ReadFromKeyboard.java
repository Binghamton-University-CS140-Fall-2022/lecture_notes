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