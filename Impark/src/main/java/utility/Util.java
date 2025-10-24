package utility;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Assert;
import path.Path;

public class Util
{
	public static String generateRandomNumber( int length )
	{
		String numbers="112345637891234567894123456789";
		char[] num = new char[length];
		for(int i=0; i<length; i++ )
		{
			int index = (int) (Math.random()*length);
			num[i]=numbers.charAt(index);
		}
		return String.valueOf(num);
	}
	
	public static int getRandomNumberOneToFive()
	{
		int index = (int) (Math.random()*5);
		if(index == 0 )
		{
				index = 1;
		}
		return index;
	}
	
	public static int getRandomNumberOneToTen()
	{
		int index = (int) (Math.random()*10);
		if(index == 10 )
		{
				index = index-1;
		}
		if(index == 0 )
		{
				index = 1;
		}
		return index;
	}
	
	public static int getRandomNumberOneToTwenty()
	{
		int index = (int) (Math.random()*20);
		if(index == 10 )
		{
				index = index-1;
		}
		if(index == 0 )
		{
				index = 1;
		}
		
		return index;
	}
	
	public static String getCurrentTimeTwelveHrFormat()
	{
		String t = null;
		Date d1 = new Date();
		SimpleDateFormat sdt = new SimpleDateFormat("HH:mm:ss");
		String time = sdt.format(d1);

		try 
		{
		    final SimpleDateFormat sdf = new SimpleDateFormat("H:mm:ss");
		    final Date dateObj = sdf.parse(time);
		    t = new SimpleDateFormat("K:mm:ss").format(dateObj);
		} 
		catch (final ParseException e)
		{
		    e.printStackTrace();
		}
		return t;
	}
	
	public static String getCurrentTimeTwentyFourHrFormat()
	{
		Date dt = new Date();
	    SimpleDateFormat dateFormat;
	    dateFormat = new SimpleDateFormat("kk:mm:ss");
	    System.out.println("Time in 24 hr format = "+dateFormat.format(dt));
		return dateFormat.format(dt);
	}
	
	public static String addMinIntoTwentyFourTime(Long min)
	{
		LocalTime time = LocalTime.parse(Util.getCurrentTimeTwentyFourHrFormat());
		String t = time.plusMinutes(min).toString();
		return t;
	}
	
	public static long getCurrentTimeInToMinutes()
	{
		long totalMinutes=0;
		String time = Util.getCurrentTimeTwelveHrFormat();
		System.out.println("Current time :="+time);
		String[] t = time.split(":");
		long hourM = ( Long.parseLong(t[0]) * 60 );
		totalMinutes = hourM + Long.parseLong(t[1]);
		totalMinutes = totalMinutes + ( Long.parseLong(t[2])/60 );
		return totalMinutes;
	}
	
	public static long convertTimeInToMinutes( String currentTime )
	{
		long totalMinutes=0;
		currentTime = currentTime.substring(0,currentTime.length()-2);
		currentTime = currentTime.trim();
		String[] t = currentTime.split(":");
		long hourM = ( Long.parseLong(t[0]) * 60 );
		totalMinutes = hourM + Long.parseLong(t[1]);
		totalMinutes = totalMinutes + ( Long.parseLong(t[2])/60 );
		return totalMinutes;
	}
	
	public static String getCurrentSystemDate( String format )
	{
		Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat(format);
	    String str = formatter.format(date);
	    return str;
	}
	
	public static Date getCurrentSystemDateAsDate( String format ) throws ParseException
	{
		String currentDate = getCurrentSystemDate( format );
	    Date curretDate = new SimpleDateFormat(format).parse(currentDate);
	    return curretDate;
	}
	
	public static String getPreviousSystemDate( String format , String previousDaysCount)
	{ 
		int minusDays = Integer.parseInt(previousDaysCount);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, -minusDays);
		Date previousDate = calendar.getTime();
		String result = formatter.format(previousDate);
		return result;
	}
	
	public static String getNextSystemDate( String format , String nextDaysCount)
	{ 
		int plusDays = Integer.parseInt(nextDaysCount);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, +plusDays);
		Date nestDate = calendar.getTime();
		String result = formatter.format(nestDate);
		return result;
	}
	
	public static String getFutureDate(int days)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, +days);
		Date futureDate = calendar.getTime();
		String result = formatter.format(futureDate);
		return result;
	}
	
	public static String getCurrentSystemDateWithMoreMins( String format , int minute)
	{ 
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//calendar.add(Calendar.DAY_OF_YEAR, -1);
		calendar.add(Calendar.MINUTE, minute);
		Date previousDate = calendar.getTime();
		String result = formatter.format(previousDate);
		return result;
	}
	
	public static String getFormattedDateAndTime(String format, String value ) throws ParseException
	{
		SimpleDateFormat ft = new SimpleDateFormat(format, Locale.US);
		java.util.Date t=ft.parse(value);
		ft.applyPattern(format);
		String formattedValue = ft.format(t);
		System.out.println(formattedValue);
		Assert.assertEquals(value, formattedValue);
	    return formattedValue;
	}
	
	public static String getDownloadedFileName()
	{
		String filePath=Path.downloadPath;
		File file = new File(filePath);
		String name = null;
		
		if(file.exists() && file.isDirectory())
		{
			File[] files = file.listFiles();
			for(int i=0;i<files.length;i++)
			{
				name = files[i].getName();
			}
		}
		return name;
	}
	
	public static void clearDownload()
	{
		String tempFileDir=Path.downloadPath;
		File file = new File(tempFileDir);
		if( file.isDirectory() && file.exists() )
		{
			File[] availableFiles = file.listFiles();
			for( int i=0; i<availableFiles.length; i++)
			{
				availableFiles[i].delete();
			}
		}
	}
	
	public static void myMethod()
	{
		String date = Util.getCurrentSystemDateWithMoreMins("dd-MM-yyyy", 0);
		String[] today = date.split(" ");
		//String t = times[0]+" "+times[1];
		String d[] = today[0].split("-");
		String dd = d[0];
		String mm = d[1];
		String yyyy = d[2];
		
		System.out.println(dd+"-"+mm+"-"+yyyy);
		String time = Util.getCurrentTimeTwentyFourHrFormat();
		System.out.println(time);
		String t[] = time.split(":");
		String hh = t[0];
		String dmin= t[1];
		System.out.println(hh+":"+dmin);
		System.out.println("My time is:=");
	}
	
	public static int convertMonthNameToNumber(String monthName) throws ParseException 
	{
	    SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
	    Date date = monthFormat.parse(monthName);
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    return calendar.get(Calendar.MONTH) + 1; // +1 because Calendar.MONTH is 0-based
	}
	
	public static void main(String[] args) throws ParseException 
	{
		Util.myMethod();
		String date = Util.getCurrentSystemDateWithMoreMins("dd-MM-yyyy hh:mm a", 0);
		String[] times = date.split(" ");
		String time = times[1]+":00"+" "+times[2];
		System.out.println("time is:="+time);
		date = date.split(" ")[0];
		System.out.println("Date is:="+date);
		
		
		//System.out.println(Util.getPreviousSystemDate("MM/dd/yyyy"));
		
		
		String productInfo = "production name. 11 November 2022, ISSN: 2049-3630; EISSN: 2049-3631; ISBN: 978-3-16-148410-0; 7(issue)sec-1; subsec1; subsec2; subsec3; subsec4";
		System.out.println("productInfo:=="+productInfo);
		Assert.assertTrue(productInfo.contains("sec-1"));
		
		System.out.println(Util.getCurrentSystemDate("YYYY-MM-dd"));
		//System.out.println(Util.getPreviousSystemDate("YYYY-MM-dd"));
		
		System.out.println("THIS:"+Util.getCurrentSystemDate("EEEE"));
		System.out.println(Util.getCurrentTimeTwelveHrFormat());
		
		String timeOfDay = Util.getCurrentTimeTwelveHrFormat();
		System.out.println("timeOfDay:="+timeOfDay);
		String hrs = timeOfDay.split(":")[0];
		System.out.println("Hrs:="+hrs);
		String mns = timeOfDay.split(":")[1];
		System.out.println("mns:="+mns);
		
		//String timeOfDay24 = Util.addMinIntoTime(10L);
		//System.out.println("timeOfDay24:="+timeOfDay24);
		
		System.out.println("File is:="+Util.getDownloadedFileName());
		System.out.println("Random number is:="+Util.getRandomNumberOneToTwenty());
		String pathEleValue = "$103.95";
		pathEleValue = pathEleValue.substring(1);
		System.out.println(pathEleValue);
		
		System.out.println(Util.getPreviousSystemDate("dd-MM-yyyyHH:mm","30"));
		System.out.println(Util.getCurrentSystemDate("HH:mm"));
		
		System.out.println(Util.getCurrentSystemDate("dd/MM/yyyy hh:mm aa"));
		System.out.println(Util.getCurrentSystemDate("dd-MM-yyyy'T'HH:mm"));
		System.out.println(Util.getCurrentSystemDate("dd-MM-yyyy' 'HH:mm"));
		
		System.out.println(Util.getCurrentSystemDate("MM"));
		
		System.out.println(Util.convertMonthNameToNumber("August"));
	}
}
