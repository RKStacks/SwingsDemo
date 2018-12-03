import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class MathFunda {

	public MathFunda() {
	}

	public static void main(String[] args) {
		//intValue();
				bigdecimal();
		//		bigPlay();

	}

	public static void intValue() {
		int totalAmountPaid = 0;
		int milkWater = 25;
		int balanceAmount = totalAmountPaid - milkWater;
		System.out.println("Collected " + totalAmountPaid);
		System.out.println("Paid : " + balanceAmount);
		//CHECK IF AMOUNT IS NOT IN NEGATIVE
		if (balanceAmount != -25 && balanceAmount != 0)
		{
			System.out.println("Amount is not neagitve");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Your Balance Is Negative. Cannot Countiue Until You Pay. \n Amount Paid : " + totalAmountPaid + " \n Remaning Amount : "
					+ balanceAmount, "Test", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Amount is  neagitve");
		}

	}

	public static void bigdecimal() {
		BigDecimal totalAmountPaid = new BigDecimal(200);
		//Deduct the Rs 25 From Total Amount Paid.
		BigDecimal milkWaterCharges = new BigDecimal(25);
		BigDecimal balanceAmount = totalAmountPaid.subtract(milkWaterCharges);

		System.out.println("totalAmountPaid " + totalAmountPaid);
		System.out.println("balanceAmount : " + balanceAmount);
		//This method returns -1, 0, or 1 as the value of this BigDecimal is negative, zero, or positive.
		//CHECK IF AMOUNT IS NOT IN NEGATIVE
		if (balanceAmount.signum() != -1 && balanceAmount.signum() != 0)
		{
			System.out.println("Amount is not neagitve");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Your Balance Is Negative. Cannot Countiue Until You Pay. \n Amount Paid :" + totalAmountPaid + " \n Remaning Amount : "
					+ balanceAmount, "Test", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Amount is  neagitve");
		}
	}

	public static void bigPlay() {
		// create 3 BigDecimal objects
		BigDecimal bg1, bg2, bg3;

		// create 3 int objects
		int i1, i2, i3;

		bg1 = new BigDecimal("123");
		bg2 = new BigDecimal("0");
		bg3 = new BigDecimal("-12");

		// assign the signum values of bg1,bg2,bg3 to i1,i2,i3 respectively
		i1 = bg1.signum();
		i2 = bg2.signum();
		i3 = bg3.signum();

		String str1 = "The Result of Signum function on " + bg1 + " is " + i1;
		String str2 = "The Result of Signum function on " + bg2 + " is " + i2;
		String str3 = "The Result of Signum function on " + bg3 + " is " + i3;

		// print i1,i2,i3 values
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}
}
