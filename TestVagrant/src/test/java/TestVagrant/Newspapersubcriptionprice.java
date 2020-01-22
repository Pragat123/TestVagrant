package TestVagrant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Newspapersubcriptionprice extends getRatesbasedonNewspaper {
	
	HashMap<String, ArrayList<Double>> storetnewspaperwithvalues= null;
    
    public HashMap<String, ArrayList<Double>> getRatesbasedonENterNewspaper(String EnterNewspaper) {
		
		   ArrayList<Double> Toirates = new ArrayList<Double>();
		   Toirates.add(3.0);
		   Toirates.add(5.0);
		   Toirates.add(6.0);
		   
		   ArrayList<Double> Hindurates = new ArrayList<Double>();
		   Hindurates.add(2.5);
		   Hindurates.add(4.0);
		   Hindurates.add(4.0);
		   
		   ArrayList<Double> ETrates = new ArrayList<Double>();
		   ETrates.add(2.0);
		   ETrates.add(2.0);
		   ETrates.add(10.0);
		   
		   ArrayList<Double> BMrates = new ArrayList<Double>();
		   BMrates.add(1.5);
		   BMrates.add(1.5);
		   BMrates.add(1.5);
		   
		   ArrayList<Double> HTrates = new ArrayList<Double>();
		   HTrates.add(2.0);
		   HTrates.add(4.0);
		   HTrates.add(4.0);
		   
		   
		   storetnewspaperwithvalues = new HashMap<String, ArrayList<Double>>();
		   if(EnterNewspaper.equalsIgnoreCase("TOI"))
		   storetnewspaperwithvalues.put(EnterNewspaper, Toirates);
		   else if (EnterNewspaper.equalsIgnoreCase("Hindu"))
		   storetnewspaperwithvalues.put(EnterNewspaper, Hindurates);
		   else if (EnterNewspaper.equalsIgnoreCase("ET"))
		   storetnewspaperwithvalues.put(EnterNewspaper, ETrates);
		   else if (EnterNewspaper.equalsIgnoreCase("BM"))
		   storetnewspaperwithvalues.put(EnterNewspaper, BMrates);
		   else if (EnterNewspaper.equalsIgnoreCase("HT"))
		   storetnewspaperwithvalues.put(EnterNewspaper, HTrates);
		   
		   
		   return storetnewspaperwithvalues;
	   
	   }

	public void gettotalSubscriptionpricebasedOnEnterNewspaperandDates(String EnterstartdateinDDMMYYYYwithslashinbtween, 
			String ENterEndateinDDMMYYYYwithslashinbtween,
			String Newspaper) {

		String startdate = EnterstartdateinDDMMYYYYwithslashinbtween;
	    String enddate = ENterEndateinDDMMYYYYwithslashinbtween;

	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    try
	    {
	      //Date start = sdf.parse(startdate);
	      Calendar start = Calendar.getInstance();
	      start.setTime(sdf.parse(startdate));
	      
	      
	      //Date end = sdf.parse(enddate);
	      Calendar end = Calendar.getInstance();
	      end.setTime(sdf.parse(enddate));
	     
	      int SaturdayWeekends =0;
	      int SundayWeekends =0;
	      int workingDays=0;
	      
	      while(!start.after(end))//removed ; (semi-colon)
	      {
	        //int day = start.getDay();
	        int day = start.get(Calendar.DAY_OF_WEEK);
	        //if ((day != Calendar.SATURDAY) || (day != Calendar.SUNDAY)) if it's sunday, != to Saturday is true
	        if ((day == Calendar.SATURDAY) 
	        		)
	        	SaturdayWeekends++;
	        else if((day == Calendar.SUNDAY))
	        	SundayWeekends++;
	        else if ((day != Calendar.SATURDAY) && (day != Calendar.SUNDAY))
	            workingDays++;
	        //System.out.println(workingDays);//moved
	        start.add(Calendar.DATE, 1);//removed comment tags
	      }
	      System.out.println("No of saturdays in a Given Dates or Month are :"+SaturdayWeekends);
	      System.out.println("No of sundays in a Given Dates or Month are :"+SundayWeekends);
	      System.out.println("No of Workingdays in a Given Dates or Month are :"+workingDays);

	      Double noOfSaturday = Double.valueOf(SaturdayWeekends);
	      Double noOfSunday = Double.valueOf(SundayWeekends);
	      Double noOfWorkingDays = Double.valueOf(workingDays);
	    
	      HashMap<String, ArrayList<Double>> map =  getRatesbasedonENterNewspaper(Newspaper);
	      ArrayList<Double> rates = map.get(Newspaper);
	      System.out.println("Rates for the "+Newspaper+" Newspaper in Weekdays is :"+rates.get(0));
	      System.out.println("Rates for the "+Newspaper+" Newspaper in Saturday is :"+rates.get(1));
	      System.out.println("Rates for the "+Newspaper+" Newspaper in Saturday is :"+rates.get(2));
	      
	      
	      Double totalExpense = (noOfWorkingDays * rates.get(0) + noOfSaturday * rates.get(1) + noOfSunday * rates.get(2));
	      System.out.println("Total Expense for given "+Newspaper+" Newspaper"+" is :"+totalExpense);
	    
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }

	}


       public static void main(String[] args) {
		
		Newspapersubcriptionprice obj = new Newspapersubcriptionprice();
		obj.gettotalSubscriptionpricebasedOnEnterNewspaperandDates("01/01/2020","31/01/2020","ET");
		
	}	
	  

	}


