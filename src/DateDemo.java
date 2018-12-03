import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create two dates
		Date currentDate = new Date();

		Date dateofBirth = new Date();
		dateofBirth.setDate(6);
		dateofBirth.setMonth(6);
		dateofBirth.setYear(84);

		// make 3 comparisons with them
		int comparison = currentDate.compareTo(dateofBirth);
		int comparison2 = dateofBirth.compareTo(currentDate);
		int comparison3 = currentDate.compareTo(currentDate);

		//the value 0 if the argument Date is equal to this Date;
		//a value less than 0 if this is before the Date argument; ie -1
		//a value greater than 0 if this Date is after the Date argument. ie. 1

		// print the results
		System.out.println("Comparison Result:" + comparison);
		System.out.println("Comparison2 Result:" + comparison2);
		System.out.println("Comparison3 Result:" + comparison3);

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("DOB : " + dateFormat.format(dateofBirth));
		System.out.println("Current : " + dateFormat.format(currentDate));

		Calendar calendar = Calendar.getInstance();

		System.out.println(calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.MONTH));

	}
}
