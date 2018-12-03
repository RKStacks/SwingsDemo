import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class FindLastDateOfMonth {
	public static void main(String[] args) throws ParseException {
		findLastDate();
		
		//another way is below
		int actualMaximum = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(actualMaximum);
	}

	private static void findLastDate() {
		Date date = new Date();
		//		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		//		Date convertedDate = dateFormat.parse(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));

		System.out.println("Last Date " + c.get(Calendar.DATE));
	}
}
