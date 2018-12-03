import java.awt.Dimension;
import java.math.BigDecimal;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class OperationsTableModel extends JFrame {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 7844943242956834261L;
	private JTable				table;
	private SimpleTableModel	model;
	Vector<Operations> vector = new Vector<Operations>(10, 10);

	public OperationsTableModel() {

		model = new SimpleTableModel(vector);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void addDataToVector(){
		vector.addElement(new Operations(new Long(0), "Test 0", "A", new BigDecimal(1.0), new BigDecimal(1.0),
				new BigDecimal(1.0), new BigDecimal(1.0), new BigDecimal(1.0), new BigDecimal(1.0), "Total",
				new Long(1), "ABC"));
	}

	public static void main(String[] arg) {
		OperationsTableModel m = new OperationsTableModel();

		m.setVisible(true);
		m.setSize(new Dimension(600, 300));
		m.validate();
		m.addDataToVector();
		m.addDataToVector();

		int count = m.model.getRowCount();
		for (int i = 0; i < count; i++)
		{

			Operations operations = m.model.getOperationsAtValue(i);
			System.out.println("Operations " + operations.getEmployeeID() + "## " + operations.getEmployeeName());

			System.out.println("Column A " + m.model.getValueAt(i, 0));
			System.out.println("Column B " + m.model.getValueAt(i, 1));
			System.out.println("Column C " + m.model.getValueAt(i, 2));
			System.out.println("Column D " + m.model.getValueAt(i, 3));
			System.out.println("Column E " + m.model.getValueAt(i, 4));
		}
	}

	class SimpleTableModel extends AbstractTableModel {
		/**
		 *
		 */
		private static final long	serialVersionUID	= 1L;

		public String[]				columnsName			= { "Name", "Operation", "10 To 11", "11 To 12", "12 To 1",
																"1.30 To 2.30:", "2.30 To 4.30", "4.30 To 5.45",
																"Total" };

		public Class[]				types				= { String.class, String.class, BigDecimal.class,
																BigDecimal.class, BigDecimal.class, BigDecimal.class,
																BigDecimal.class, BigDecimal.class, String.class };

		Vector<Operations>			vector;

		public SimpleTableModel(Vector<Operations> vector) {
			super();
			this.vector = vector;
		}

		public int getColumnCount() {
			return columnsName.length;
		}

		public int getRowCount() {
			return vector.size();
		}
		public Vector<Operations> getDataVector(){
			return vector;
		}

		public Operations getOperationsAtValue(int row){
			return vector.get(row);
		}
		public void setValueAt(Object value, int row, int col) {
			Operations operations = (Operations) (vector.elementAt(row));

			switch (col) {
				case 0:
					operations.setEmployeeName((String) value);
					break;
				case 1:
					operations.setOperationName((String) value);
					break;
				case 2:
					operations.setRate10((BigDecimal) value);
					break;
				case 3:
					operations.setRate11((BigDecimal) value);
					break;
				case 4:
					operations.setRate12((BigDecimal) value);
					break;
				case 5:
					operations.setRate1((BigDecimal) value);
					break;
				case 6:
					operations.setRate2((BigDecimal) value);
					break;
				case 7:
					operations.setRate4((BigDecimal) value);
					break;
				case 8:
					operations.setTotal((String) value);
					break;
			}
		}

		public String getColumnName(int col) {
			return columnsName[col];
		}

		public Class getColumnClass(int col) {
			return types[col];
		}

		public Object getValueAt(int row, int col) {
			Operations operations = (Operations) (vector.elementAt(row));
			switch (col) {
				case 0:
					return operations.getEmployeeName();
				case 1:
					return operations.getOperationName();
				case 2:
					return operations.getRate10();
				case 3:
					return operations.getRate11();
				case 4:
					return operations.getRate12();
				case 5:
					return operations.getRate1();
				case 6:
					return operations.getRate2();
				case 7:
					return operations.getRate4();
				case 8:
					return operations.getTotal();
			}
			return new String();
		}
	}

}
