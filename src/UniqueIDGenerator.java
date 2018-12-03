import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIDGenerator {
	private SecureRandom		random					= new SecureRandom();
	static char[]				CHARSET_AZ_09			= "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	private static final String	ALPHA_NUMERIC_STRING	= "RIZ12345";

	public UniqueIDGenerator() {
	}

	public static void main(String[] args) throws InterruptedException {

		AtomicInteger atomicInteger = new AtomicInteger(99);
		test2(atomicInteger);
		System.out.println("------------------------");
//		try
//		{
//			Thread.sleep(10000);
//		}
//		catch (InterruptedException e)
//		{
//			e.printStackTrace();
//		}
		test2(atomicInteger);
	}

	public static void test2(AtomicInteger atomicInteger) {
		String[] associates = { "Rizwan Khan", "Khurram Khan", "Sanam Jung" };
		String[] guest = { "Rizwan Ahmad Khan", "Nooreen Khan", "Afreen Faithma" };
		for (int i = 0; i < guest.length; i++)
		{
			String name = guest[i];
			String associatesName = associates[i];
			String uniqueID2 = name.trim().substring(0, 1).concat(associatesName.trim().substring(0, 1) + "" + atomicInteger.incrementAndGet());
			System.out.println(uniqueID2);
		}
	}

	public static void test() {
		UniqueIDGenerator uniqueIDGenerator = new UniqueIDGenerator();
		AtomicInteger atomicInteger = new AtomicInteger(100);

		for (int i = 0; i < 10; i++)
		{

			String name = "Rizwan Ahmad Khan";
			String associates = "Chandrahas Ninave";

			String uniqueID = name.trim().substring(0, 1).concat(associates.trim().substring(0, 1));
			String uniqueID2 = name.trim().substring(0, 1).concat(associates.trim().substring(0, 1));
			String uniqueID3 = name.trim().substring(0, 1).concat(associates.trim().substring(0, 1));
			System.out.println("-----");
			System.out.println("Type 1 :" + uniqueID.concat(randomString(CHARSET_AZ_09, 2)).toUpperCase() + "" + atomicInteger.incrementAndGet());
			System.out.println("-----");
			System.out.println("Type 2 :" + uniqueID2.concat("" + atomicInteger.incrementAndGet()).toUpperCase());
			System.out.println("-----");
			System.out.println("Type 3 :" + uniqueID3.concat(generateRandomString(2)).toUpperCase() + "" + atomicInteger.incrementAndGet());
		}
	}

	public String nextSessionId() {
		return new BigInteger(130, random).toString(32);
	}

	private void secureUniqueID() {
		try
		{
			//Initialize SecureRandom
			//This is a lengthy operation, to be done only upon
			//initialization of the application
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");

			//generate a random number
			String randomNum = new Integer(prng.nextInt()).toString();

			//get its digest
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] result = sha.digest(randomNum.getBytes());

			System.out.println("Random number: " + randomNum);
			System.out.println("Message digest: " + hexEncode(result));
		}
		catch (NoSuchAlgorithmException ex)
		{
			System.err.println(ex);
		}
	}

	/**
	 * The byte[] returned by MessageDigest does not have a nice
	 * textual representation, so some form of encoding is usually performed.
	 *
	 * This implementation follows the example of David Flanagan's book
	 * "Java In A Nutshell", and converts a byte array into a String
	 * of hex characters.
	 *
	 * Another popular alternative is to use a "Base64" encoding.
	 */
	static private String hexEncode(byte[] aInput) {
		StringBuilder result = new StringBuilder();
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		for (int idx = 0; idx < aInput.length; ++idx)
		{
			byte b = aInput[idx];
			result.append(digits[(b & 0xf0) >> 4]);
			result.append(digits[b & 0x0f]);
		}
		return result.toString();
	}

	public static String randomString(char[] characterSet, int length) {
		Random random = new SecureRandom();
		char[] result = new char[length];
		for (int i = 0; i < result.length; i++)
		{
			// picks a random index out of character set > random character
			int randomCharIndex = random.nextInt(characterSet.length);
			result[i] = characterSet[randomCharIndex];
		}
		return new String(result);
	}

	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0)
		{
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	private static Random	random1	= new Random((new Date()).getTime());

	/**
	 * generates an alphanumeric string based on specified length.
	 * @param length # of characters to generate
	 * @return random string
	 */
	public static String generateRandomString(int length) {
		char[] values = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
				'4', '5', '6', '7', '8', '9' };
		String out = "";
		for (int i = 0; i < length; i++)
		{
			int idx = random1.nextInt(values.length);
			out += values[idx];
		}
		return out;
	}
}
