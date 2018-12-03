import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

import quick.dbtable.Column;
import quick.dbtable.DBTable;

public class QuickTableFrame extends JFrame {

	private static final long	serialVersionUID	= -631092023960707898L;

	public QuickTableFrame() {
		try
		{
			// Use system look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			// set Frame properties
			setSize(300, 200);
			setVisible(true);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);

			// create a new quicktable
			DBTable dBTable1 = new DBTable();

			// add to frame
			getContentPane().add(dBTable1);

			// set the database driver to be used, we are using jdbc-odbc driver
			dBTable1.setDatabaseDriver("com.mysql.jdbc.Driver");

			/*
			 * set the jdbc url,"quicktabledemo" is the data source we have
			 * created for the database
			 */
			dBTable1.setJdbcUrl("jdbc:mysql://localhost:3306/classicmodels");
			dBTable1.setUser("admin");
			dBTable1.setPassword("admin");
			// set the select statement which should be used by the table
			dBTable1.setSelectSql("select * from customers");

			// to create the navigation bars for the table
			dBTable1.createControlPanel();
			// connect to database & create a connection
			dBTable1.connectDatabase();

			// fetch the data from database to fill the table
			dBTable1.refresh();

			//			Column column = dBTable1.getColumn(8);
			//			System.out.println(column.getColumnName());
			//			column.setColumnName("Supplier Name");
			//			System.out.println(column.getColumnName());
			//			Column totalColumn = dBTable1.addColumn("Total");
			//			setUpSportColumn(dBTable1, totalColumn);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void setUpSportColumn(DBTable table, Column sportColumn) {
		//Set up the editor for the sport cells.
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Snowboarding");
		comboBox.addItem("Rowing");
		comboBox.addItem("Knitting");
		comboBox.addItem("Speed reading");
		comboBox.addItem("Pool");
		comboBox.addItem("None of the above");
		sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

		//Set up tool tips for the sport cells.
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setToolTipText("Click for combo box");
		sportColumn.setCellRenderer(renderer);
	}

	public static void main(String[] args) {
		// create a new table frame
		QuickTableFrame myframe = new QuickTableFrame();
	}

}
