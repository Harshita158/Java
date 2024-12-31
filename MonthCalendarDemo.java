import java.util.*;
import java.text.*;
import java.util.Calendar;

class MonthCalendarDemo
{

	String getmonthname(int month)
	{
		String monthname=null;
		switch(month)
		{
			case 1: monthname = "January";
				break;
			case 2: monthname = "February";
				break;
			case 3: monthname = "March";
				break;
			case 4: monthname = "April";
				break;
			case 5: monthname = "May";
				break;
			case 6: monthname = "June";
				break;
			case 7: monthname = "July";
				break;
			case 8: monthname = "August";
				break;
			case 9: monthname = "September";
				break;
			case 10: monthname = "October";
				break;
			case 11: monthname = "November";
				break;
			case 12: monthname = "December";
				break;
		}
		return monthname;
	}	

	void printmonthtitle(int year,int month)
	{
		System.out.println("         <"+ getmonthname(month) + " " +year+">");
		System.out.println("");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}

	boolean leapyear(int year)
	{
		return year%400==0 || (year%4==0 && year%100!=0);
	}	

	int daysinmonth(int year,int month)
	{
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||   month == 10 || month == 12)
        	return 31;
      		if (month == 4 || month == 6 || month == 9 || month == 11)
        	return 30;
		if (month ==2)
			if(leapyear(year))
			return 29;
			else
			return 28;
		return 0;
	}

	int totaldays(int year, int month)
	{
		int total =0;
		int i;
		for(i=1905;i<year;i++)
		{
			if (leapyear(i))
				total= total + 366;
			else
				total= total + 365;
		}
		for (i=1; i < month; i++)
			total=total + daysinmonth(year,i);
		return total;
	}

	// 1 january 1905 starts from sunday so it is consider for reference.
	int startday(int year , int month)
	{
		int start1905 =0;
		int days=totaldays(year, month);
		return days%7;	
	}	

	void printmonthbody(int year, int month)
	{
		int start = startday(year, month);
      		int Days = daysinmonth(year, month);
      		int i = 0;
      		for (i = 0; i < start; i++)
       			System.out.print("    ");
      		for (i = 1; i <=Days; i++) 
			{
        		if (i < 10)
          			System.out.print("   " + i);
        		else
          			System.out.print("  " + i);
        		if ((i + start) % 7 == 0)
          			System.out.println();
      			}
     		System.out.println();
		System.out.println("------------------------------");
	}

	void datetime()
	{
		Date date = new Date();
		SimpleDateFormat formatTime = new SimpleDateFormat("hh.mm aa");
		String time = formatTime.format(date);
		System.out.println("                    " + time);
		DateFormat Date = DateFormat.getDateInstance();
		Calendar cals = Calendar.getInstance();
		String CurrentDate= Date.format(cals.getTime());
		System.out.println("                    "+CurrentDate);
		System.out.println();
		
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter event: ");
		String event = sc.nextLine();
		System.out.print("Enter date: ");
		int date=sc.nextInt();
		System.out.print("Enter month: ");
		int month=sc.nextInt();
		System.out.print("Enter year: ");
		int year=sc.nextInt();
		System.out.println("------------------------------");
		MonthCalendarDemo a= new MonthCalendarDemo();

		if(month<1 || month>12)
			System.out.println("Wrong input!");
		else
			a.printmonthtitle(year,month);
			a.printmonthbody(year,month);
			a.datetime();
			System.out.println("* "+ date +" "+ a.getmonthname(month)+" :"+" "+event);
	}
}