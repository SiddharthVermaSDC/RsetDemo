package util;

public class Logging {
	
	
	public static void Debug(String tag, String text)
	{

	System.out.println ( tag + ":" + text);
	}
	public static void Error(String tag, String text)
	{

	System.out.println ( tag + ":" + text);
	}
	public static void Exception(String tag, String text)
	{

	System.out.println ( tag + ":" + text);
	}
	public static void Warning(String tag, String text)
	{

	System.out.println ( tag + ":" + text);
	}
}
