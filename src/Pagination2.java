import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Pagination2 {

	public Pagination2() {
	}

	public static JPanel makePanel() {
		final int USER_SPECIFIED_NUMBER_OF_ROWS = 5;
		JPanel p = new JPanel(new BorderLayout());
		String[] columnNames = { "String", "Integer", "Boolean" };
		Object[][] data = { { "AA", 1, true }, { "BB", 2, false }, { "cc", 3, true }, { "dd", 4, false },
				{ "ee", 5, false }, { "FF", -1, true }, { "GG", -2, false }, { "HH", -3, true }, { "II", -4, false },
				{ "JJ", -5, false }, { "KK", 11, true }, { "LL", 22, false }, { "MM", 33, true }, { "NN", 44, false },
				{ "OO", 55, false }, };
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		final JTable table = new JTable(model);
		table.setFillsViewportHeight(true);
		final RowFilter<TableModel, Integer> filter = new RowFilter<TableModel, Integer>() {
			@Override
			public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
				int vidx = table.convertRowIndexToView(entry.getIdentifier());
				//System.out.println(vidx);
				return vidx < USER_SPECIFIED_NUMBER_OF_ROWS;
			}
		};
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model) {
			@Override
			public void toggleSortOrder(int column) {
				RowFilter<? super TableModel, ? super Integer> f = getRowFilter();
				setRowFilter(null);
				super.toggleSortOrder(column);
				setRowFilter(f);
			}
		};
		table.setRowSorter(sorter);
		sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.DESCENDING)));
		p.add(new JCheckBox(new AbstractAction("viewRowIndex < " + USER_SPECIFIED_NUMBER_OF_ROWS) {
			/**
			 *
			 */
			private static final long	serialVersionUID	= 1L;

			public void actionPerformed(ActionEvent e) {
				sorter.setRowFilter(((JCheckBox) e.getSource()).isSelected() ? filter : null);
			}
		}), BorderLayout.NORTH);
		p.add(new JScrollPane(table));
		p.setPreferredSize(new Dimension(512, 240));
		return p;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}

	public static void createAndShowGUI() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(makePanel());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
