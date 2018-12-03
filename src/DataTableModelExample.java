import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class DataTableModelExample extends JFrame {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	private JTable				table;

	private SimpleTableModel	model;

	public DataTableModelExample() {
		Vector dummyMacData = new Vector(10, 10);
		dummyMacData.addElement(new Data(new Integer(100), "A", "1", "C", "E"));
		dummyMacData.addElement(new Data(new Integer(105), "R", "2", "S", "E"));
		model = new SimpleTableModel(dummyMacData);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);
	}

	public static void main(String[] arg) {
		DataTableModelExample m = new DataTableModelExample();

		m.setVisible(true);
		m.setSize(new Dimension(600, 300));
		m.validate();

		int count=m.model.getRowCount();
		for(int i=0;i<count;i++){

			Object object = m.model.getValueAt(i, 0);
			if(object instanceof Data){
				System.out.println("its Data " + ((Data)object).getTest());
			}
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

		public String[]	m_colNames	= { "A", "B", "C", "D", "E" };

		public Class[]	m_colTypes	= { Integer.class, String.class, String.class, String.class, String.class };

		Vector			m_macDataVector;

		public SimpleTableModel(Vector macDataVector) {
			super();
			m_macDataVector = macDataVector;
		}

		public int getColumnCount() {
			return m_colNames.length;
		}

		public int getRowCount() {
			return m_macDataVector.size();
		}

		public void setValueAt(Object value, int row, int col) {
			Data macData = (Data) (m_macDataVector.elementAt(row));

			switch (col) {
				case 0:
					macData.setA((Integer) value);
					break;
				case 1:
					macData.setB((String) value);
					break;
				case 2:
					macData.setC((String) value);
					break;
				case 3:
					macData.setD((String) value);
					break;
				case 4:
					macData.setE((String) value);
					break;
			}
		}

		public String getColumnName(int col) {
			return m_colNames[col];
		}

		public Class getColumnClass(int col) {
			return m_colTypes[col];
		}

		public Object getValueAt(int row, int col) {
			Data macData = (Data) (m_macDataVector.elementAt(row));

			switch (col) {
				case 0:
					return macData.getA();
				case 1:
					return macData.getB();
				case 2:
					return macData.getC();
				case 3:
					return macData.getD();
				case 4:
					return macData.getE();
			}

			return new String();
		}
	}

}

class Data {
	private Integer	a;

	private String	b;

	private String	c;

	private String	d;

	private String	e;

	private String test="Other data reside here";

	public Data() {
	}

	public Data(Integer aa, String bb, String cc, String dd, String ee) {
		a = aa;
		b = bb;
		c = cc;
		d = dd;
		e = ee;
	}

	public Integer getA() {
		return a;
	}

	public String getB() {
		return b;
	}

	public String getC() {
		return c;
	}

	public String getD() {
		return d;
	}

	public String getE() {
		return e;
	}

	public void setA(Integer aa) {
		a = aa;
	}

	public void setB(String macName) {
		b = macName;
	}

	public void setC(String cc) {
		c = cc;
	}

	public void setD(String dd) {
		d = dd;
	}

	public void setE(String ee) {
		e = ee;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
}
