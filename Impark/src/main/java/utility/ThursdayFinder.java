package utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ThursdayFinder
{
    private static Calendar lastFoundDate = null;
    public static String getNextFirstOrThirdThursday(String format)
    {
       
        Calendar calendar;
        
      
        if (lastFoundDate == null)
        {
            calendar = Calendar.getInstance();
            calendar.setTime(new Date());
        } 
        else 
        {
            calendar = (Calendar) lastFoundDate.clone();
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

       
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.THURSDAY)
        {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

       
        while (!isFirstOrThirdThursday(calendar))
        {
            calendar.add(Calendar.WEEK_OF_YEAR, 1);
        }

       
        lastFoundDate = (Calendar) calendar.clone();

       
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(calendar.getTime());
    }

   
    private static boolean isFirstOrThirdThursday(Calendar calendar) 
    {
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);

  
        return (dayOfWeekInMonth == 1 || dayOfWeekInMonth == 3);
    }
    
 
    public static void main(String[] args) 
    {
        
        String nextThursday1 = getNextFirstOrThirdThursday("d-MMMM-yyyy");
        System.out.println("Next First or Third Thursday: " + nextThursday1);
        
       
        String nextThursday2 = getNextFirstOrThirdThursday("d-MMMM-yyyy");
        System.out.println("Next First or Third Thursday: " + nextThursday2);
        
        String nextThursday3 = getNextFirstOrThirdThursday("d-MMMM-yyyy");
        System.out.println("Next First or Third Thursday: " + nextThursday3);
        
        // You can reset the static variable to start over
        // ThursdayFinder.resetFinder();
    }
	
}
