import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarAPI {

	public CalendarAPI() {
	}

	public static void main(String[] args) throws ParseException {
		api1();
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		System.out.println(date.getDate());

		compareDate();
	}

	private static void api1() {
		System.out.println(" Convert Date to String.");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(new Date());
		System.out.println(date); //15/10/2013
	}

	private static void api2() throws ParseException {
		System.out.println(" Convert String to Date.");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "31-08-1982 10:20:56";
		Date date = sdf.parse(dateInString);
		System.out.println(date); //Tue Aug 31 10:20:56 SGT 1982
	}

	private static void compareDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse("2009-12-31");
		Date date2 = sdf.parse("2010-01-31");

		System.out.println(sdf.format(date1));
		System.out.println(sdf.format(date2));

		if (date1.compareTo(date2) > 0)
		{
			System.out.println("Date1 is after Date2");
		}
		else if (date1.compareTo(date2) < 0)
		{
			System.out.println("Date1 is before Date2");
		}
		else if (date1.compareTo(date2) == 0)
		{
			System.out.println("Date1 is equal to Date2");
		}
		else
		{
			System.out.println("How to get here?");
		}
	}
}
