import java.util.Calendar;

public class DailyCounter {

	static int	counter	= 1;

	public DailyCounter() {
	}

	public static void main(String[] args) {

		incrementCounter();

	}

	private static void incrementCounter() {
		Calendar calendar = Calendar.getInstance();
		String closingDate = calendar.get(Calendar.DATE) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.YEAR);
		System.out.println("closingDate =" + closingDate);

		String openingDate = calendar.get(Calendar.DATE) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.YEAR);
		System.out.println("openingDate =" + openingDate);

		//If closing date is not equals to opening then reset the counter this means that app is started in next day
		if (!closingDate.equals(openingDate))
		{
			counter = 0;
		}

		for (int i = 0; i < 20; i++)
		{

			if (i == 10)
			{
				openingDate = calendar.get(Calendar.DATE) + 1 + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.YEAR);
				System.out.println("Opening Date Change " + openingDate);
				if (!closingDate.equals(openingDate))
				{
					counter = 1;
				}

			}
			System.out.println("Counter : " + counter);
			counter++;

		}

	}
}
