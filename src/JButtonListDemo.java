import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class JButtonListDemo implements Runnable {

	private JList	jlist;

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new JButtonListDemo());
	}

	@Override
	public void run() {
		Object[] items = new CheckListItem[] { new CheckListItem("Apple"), new CheckListItem("Banana"), new CheckListItem("Carrot"), new CheckListItem("Date"),
				new CheckListItem("Eggplant"), new CheckListItem("Fig"), new CheckListItem("Guava"), };

		jlist = new JList(items);
		jlist.setCellRenderer(new CheckBoxListRendere());
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.setVisibleRowCount(5);
		jlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				clickButtonAt(event.getPoint());
			}
		});

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new JScrollPane(jlist));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void clickButtonAt(Point point) {
		int index = jlist.locationToIndex(point);
		CheckListItem item = (CheckListItem) jlist.getModel().getElementAt(index);
		System.out.println(item.toString() + " # " + item.isSelected());

		//	    jlist.repaint(jlist.getCellBounds(index, index));
	}

	public class ButtonItem {
		private JButton	button;

		public ButtonItem(String name) {
			button = new JButton(name);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(button.getText() + " was clicked.");
				}
			});
		}

		public JButton getButton() {
			return button;
		}

		@Override
		public String toString() {
			return button.getText();
		}
	}

	public class CheckBoxIitem {
		private JCheckBox	checkBox;

		public CheckBoxIitem(String name) {
			checkBox = new JCheckBox(name);
			checkBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					System.out.println(checkBox.getText() + " was clicked.");
				}
			});
		}

		public JCheckBox getCheckBox() {
			return checkBox;
		}

		@Override
		public String toString() {
			return checkBox.getText();
		}
	}

	class CheckListItem {

		private String	label;
		private boolean	isSelected	= false;

		public CheckListItem(String label) {
			this.label = label;
		}

		public boolean isSelected() {
			return isSelected;
		}

		public void setSelected(boolean isSelected) {
			this.isSelected = isSelected;
		}

		@Override
		public String toString() {
			return label;
		}
	}

	class CheckBoxListRendere extends JCheckBox implements ListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			setEnabled(list.isEnabled());
			setSelected(((CheckListItem) value).isSelected());
			setFont(list.getFont());
			setBackground(list.getBackground());
			setForeground(list.getForeground());
			setText(value.toString());
			return this;
		}

	}

	class ButtonListRenderer extends JButton implements ListCellRenderer {
		/**
		 * 
		 */
		private static final long	serialVersionUID	= 1L;

		@Override
		public Component getListCellRendererComponent(JList comp, Object value, int index, boolean isSelected, boolean hasFocus) {
			setEnabled(comp.isEnabled());
			setFont(comp.getFont());
			setText(value.toString());

			if (isSelected)
			{
				setBackground(comp.getSelectionBackground());
				setForeground(comp.getSelectionForeground());
			}
			else
			{
				setBackground(comp.getBackground());
				setForeground(comp.getForeground());
			}

			return this;
		}
	}
}
