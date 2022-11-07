------------
Enumerations
-------------

- The `enum` type is a data type that allows a variable to be set to one of a ***set of predefined constant values***

## [The following is from the Java Tutorials](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
- "You should use enum types any time you need to represent a fixed set of constants. That includes natural enum types such as the planets in our solar system and data sets where you know all possible values at compile time—for example, the choices on a menu, command line flags, and so on."

## Simple Example

``` java
public enum DaysOfWeek 
{
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
```

## More impressive example

``` java

class sampleEnumDaysOfWeek
{
	public enum DaysOfWeek
	{
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}
	
	public enum DaysOfWeekEnhanced
	{
		SUNDAY ("Sunday", "sunday"), 
		MONDAY ("Monday", "monday"), 
		TUESDAY ("Tuesday", "tuesday"), 
		WEDNESDAY ("Wednesday", "wednesday"), 
		THURSDAY ("Thursday", "thursday"), 
		FRIDAY ("Friday", "friday"), 
		SATURDAY ("Saturday", "saturday");
		
		private final String dayCapitalized;
		private final String dayLowerCase;
		
		DaysOfWeekEnhanced(String dayCapitalized, String dayLowerCase)
		{
			this.dayCapitalized = dayCapitalized;
			this.dayLowerCase = dayLowerCase;
		}
		
		private String dayCapitalized()
		{
			return dayCapitalized;
		}
		
		private String dayLowerCase()
		{
			return dayLowerCase;
		}
	}
	
	public static void main(String[] args)
	{
		DaysOfWeek dayOfWeek = null;
		DaysOfWeekEnhanced dayOfWeek2 = null;
		
		if( args.length > 0 )
		{
			if( args[0].equals("1") )
			{
				dayOfWeek = DaysOfWeek.SUNDAY;
				dayOfWeek2 = DaysOfWeekEnhanced.SUNDAY;
			}
			
			if( args[0].equals("2") )
			{
				dayOfWeek = DaysOfWeek.MONDAY;
				dayOfWeek2 = DaysOfWeekEnhanced.MONDAY;
			}
			
			if( args[0].equals("3") )
			{
				dayOfWeek = DaysOfWeek.TUESDAY;
				dayOfWeek2 = DaysOfWeekEnhanced.TUESDAY;
			}
			
			if( args[0].equals("4") )
			{
				dayOfWeek = DaysOfWeek.WEDNESDAY;
				dayOfWeek2 = DaysOfWeekEnhanced.WEDNESDAY;
			}
			
			if( args[0].equals("5") )
			{
				dayOfWeek = DaysOfWeek.THURSDAY;
				dayOfWeek2 = DaysOfWeekEnhanced.THURSDAY;
			}
			
			if( args[0].equals("6") )
			{
				dayOfWeek = DaysOfWeek.FRIDAY;
				dayOfWeek2 = DaysOfWeekEnhanced.FRIDAY;
			}
			
			if( args[0].equals("7") )
			{
				dayOfWeek = DaysOfWeek.SATURDAY;
				dayOfWeek2 = DaysOfWeekEnhanced.SATURDAY;
			}
			
		}
		
		if( dayOfWeek == DaysOfWeek.SUNDAY )
		{
			System.out.println("day is " + dayOfWeek + " " + dayOfWeek2.dayCapitalized() + " " + dayOfWeek2.dayLowerCase());
		}
		
		if( dayOfWeek == DaysOfWeek.MONDAY )
		{
			System.out.println("day is " + dayOfWeek + " " + dayOfWeek2.dayCapitalized() + " " + dayOfWeek2.dayLowerCase());
		}
		
		if( dayOfWeek == DaysOfWeek.TUESDAY )
		{
			System.out.println("day is " + dayOfWeek + " " + dayOfWeek2.dayCapitalized() + " " + dayOfWeek2.dayLowerCase());
		}
		
		if( dayOfWeek == DaysOfWeek.WEDNESDAY )
		{
			System.out.println("day is " + dayOfWeek + " " + dayOfWeek2.dayCapitalized() + " " + dayOfWeek2.dayLowerCase());
		}
		
		if( dayOfWeek == DaysOfWeek.THURSDAY )
		{
			System.out.println("day is " + dayOfWeek + " " + dayOfWeek2.dayCapitalized() + " " + dayOfWeek2.dayLowerCase());
		}
		
		if( dayOfWeek == DaysOfWeek.FRIDAY )
		{
			System.out.println("day is " + dayOfWeek + " " + dayOfWeek2.dayCapitalized() + " " + dayOfWeek2.dayLowerCase());
		}
		
		if( dayOfWeek == DaysOfWeek.SATURDAY )
		{
			System.out.println("day is " + dayOfWeek + " " + dayOfWeek2.dayCapitalized() + " " + dayOfWeek2.dayLowerCase());
		}
	}
}
```