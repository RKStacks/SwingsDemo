import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class VectorTest {

	public VectorTest() {
	}

	public static void main(String[] args) {
		Vector<Salary> vector = new Vector<Salary>(10, 10);
		int bundle = 1;
		for (int i = 0; i < 5; i++)
		{

			Salary salary = new VectorTest().new Salary();
			salary.setBundleNumber("Bundle " + bundle);
			salary.setLayerNumber("Layer 1");
			salary.setOperationName("Opt " + i);
			bundle++;
			vector.add(salary);

		}

		Iterator<Salary> iterator = vector.iterator();
		System.out.println("Display Entry");
		while (iterator.hasNext())
		{
			Salary temp = iterator.next();
			System.out.println(temp.getBundleNumber() + " Layer : " + temp.getLayerNumber() + " Opt :" + temp.getOperationName());
		}

		Salary salary = new VectorTest().new Salary();
		salary.setBundleNumber("Bundle " + 1);
		salary.setLayerNumber("Layer 1");
		salary.setOperationName("Opt " + 0);

		System.out.println(vector.indexOf(salary));
		System.out.println(vector.contains(salary));

		iterator = vector.iterator();

		while (iterator.hasNext())
		{
			Salary temp = iterator.next();

			System.out.println("Same Entry Exists " + checkBundleAgainsLayerAndOpt(temp, salary));
		}

	}

	private static int checkBundleAgainsLayerAndOpt(Salary lhs, Salary rhs) {
		if (lhs.getLayerNumber().equalsIgnoreCase(rhs.getLayerNumber()) && lhs.getOperationName().equalsIgnoreCase(rhs.getOperationName()))
		{
			if (lhs.getBundleNumber().equalsIgnoreCase(rhs.getBundleNumber()))
			{
				System.out.println(rhs.getBundleNumber() + " Found");
				return 1;
			}
		}
		return -1;
	}

	public class Salary {
		String	operationName;
		String	layerNumber;
		String	bundleNumber;

		public String getOperationName() {
			return operationName;
		}

		public void setOperationName(String operationName) {
			this.operationName = operationName;
		}

		public String getLayerNumber() {
			return layerNumber;
		}

		public void setLayerNumber(String layerNumber) {
			this.layerNumber = layerNumber;
		}

		public String getBundleNumber() {
			return bundleNumber;
		}

		public void setBundleNumber(String bundleNumber) {
			this.bundleNumber = bundleNumber;
		}

	}

	public class Entry implements Comparator<Salary> {

		private int checkBundleAgainsLayerAndOpt(Salary lhs, Salary rhs) {
			if (lhs.getLayerNumber().equalsIgnoreCase(rhs.getLayerNumber()) && lhs.getOperationName().equalsIgnoreCase(rhs.getOperationName()))
			{
				if (lhs.getBundleNumber().equalsIgnoreCase(rhs.getBundleNumber()))
				{
					return 1;
				}
			}
			return -1;
		}

		@Override
		public int compare(Salary lhs, Salary rhs) {

			return checkBundleAgainsLayerAndOpt(lhs, rhs);
		}
	}
}
