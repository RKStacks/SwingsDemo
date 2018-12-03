import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jdatepicker.impl.JDatePickerImpl;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;

public class JOptionPaneTest implements ActionListener {

	private JTextField			txtThreadColor;

	private JTextField			txtThreadNumber;

	private JTextField			txtThreadColor_1;

	private JTextField			txtThreadNumber_1;

	JLabel						lblItemName					= new JLabel("Item Name:");

	JTextField					txtQuantity					= new JTextField();

	JTextField					txtContent					= new JTextField();

	JTextField					txtItemName					= new JTextField();

	DefaultListModel<String>	itemListModel				= new DefaultListModel<>();

	JList<String>				itemList					= new JList<String>(itemListModel);

	DefaultListModel<String>	contentListModel			= new DefaultListModel<>();

	JList<String>				contentList					= new JList<String>(contentListModel);

	DefaultListModel<String>	quantityListModel			= new DefaultListModel<>();

	JList<String>				quantityList				= new JList<String>(quantityListModel);

	JButton						btnRemoveContent			= new JButton("Remove");

	JButton						btnAddContent				= new JButton("Add");

	JButton						btnRemoveQuantity			= new JButton("Remove");

	JButton						btnAddQuantity				= new JButton("Add");

	private static int			TEXT_FIELD_HEIGHT			= 35;

	private static int			BUTTON_WIDTH				= 80;

	private static int			BUTTON_HEIGHT				= 40;

	private final JLabel		lblinNumbers				= new JLabel("(In Numbers)");

	private JTextField			txtName;

	private JTextField			txtMobile;

	JLabel						lblRates					= new JLabel("View By Rates:");

	JLabel						lblDate						= new JLabel("View By Dates:");

	JComboBox<Object>			styleComob					= null;

	JComboBox<Object>			operationCombo				= null;

	JComboBox<Object>			rateCombo					= null;

	JDatePickerImpl				date						= null;

	JDatePickerImpl				fromDate					= null;

	JDatePickerImpl				toDate						= null;

	//Other Variables For Form Properties
	int							DEFAULT_BOX_WIDTH			= 350;

	int							DEFAULT_BOX_HEIGHT			= 40;

	int							DEFAULT_LABEL_WIDTH			= 150;

	int							DEFAULT_LABEL_HEIGHT		= 40;

	int							DEFAULT_COLUMN_WIDTH_MAX	= 250;

	int							DEFAULT_COLUMN_WIDTH_MIN	= 100;
	JLabel						lblImage;
	private Webcam				webcam						= null;
	private WebcamPanel			panel						= null;
	private WebcamPicker		picker						= null;

	/**
	 * @wbp.parser.entryPoint
	 */
	public JOptionPaneTest() {

		JPanel formPanel = new JPanel();
		formPanel.setBackground(SystemColor.activeCaption);
		formPanel.setPreferredSize(new Dimension(300, 300));
		formPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		formPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		formPanel.setLayout(null);

		JFrame jFrame = new JFrame();
		jFrame.setResizable(false);
		jFrame.setType(Type.POPUP);
		jFrame.getContentPane().add(formPanel);

		jFrame.setTitle("Change Picture");
		jFrame.setLocationRelativeTo(null);
		//		jFrame.setPreferredSize(new Dimension(300, 300));
		jFrame.setSize(236, 289);
		jFrame.setVisible(true);
	}

	private void itntChangePicDialog() {
		JPanel formPanel = new JPanel();
		formPanel.setBackground(SystemColor.activeCaption);
		formPanel.setPreferredSize(new Dimension(300, 300));
		formPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		formPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		formPanel.setLayout(null);

		JFrame jFrame = new JFrame();
		jFrame.setResizable(false);
		jFrame.setType(Type.POPUP);
		jFrame.getContentPane().add(formPanel);

		Box imageBox = Box.createVerticalBox();
		imageBox.setBorder(new LineBorder(new Color(51, 153, 255), 2, true));
		imageBox.setBounds(35, 23, 150, 150);
		lblImage = new JLabel("");
		lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblImage.setPreferredSize(new Dimension(150, 150));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setIcon(new ImageIcon("D:\\Workspace\\ITNT-SYSTEM\\images\\attendance.png"));
		imageBox.add(lblImage);
		formPanel.add(imageBox);

		JButton btnOpenWebcam = new JButton("Open Webcam");
		btnOpenWebcam.setActionCommand("webcamCapture");
		btnOpenWebcam.addActionListener(this);
		btnOpenWebcam.setToolTipText("Open Webcam");
		btnOpenWebcam.setBounds(43, 217, 133, 23);
		formPanel.add(btnOpenWebcam);

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(this);
		btnBrowse.setActionCommand("explorerPC");
		btnBrowse.setToolTipText("Upload Picture From PC");
		btnBrowse.setBounds(65, 186, 89, 23);
		formPanel.add(btnBrowse);
		jFrame.setTitle("Change Picture");
		jFrame.setLocationRelativeTo(null);
		//		jFrame.setPreferredSize(new Dimension(300, 300));
		jFrame.setSize(236, 289);
		jFrame.setVisible(true);
	}

	private void queryForm() {
		JPanel formPanel = new JPanel();
		formPanel.setPreferredSize(new Dimension(622, 500));
		formPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		formPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		formPanel.setLayout(null);

		JLabel lblQueryName = new JLabel("Query Name");
		lblQueryName.setBounds(27, 25, 148, 34);
		formPanel.add(lblQueryName);

		final JTextField txtQueryName = new JTextField();
		txtQueryName.setBounds(120, 25, 367, 34);
		formPanel.add(txtQueryName);
		txtQueryName.setColumns(10);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(27, 70, 148, 34);
		formPanel.add(lblDescription);

		final JTextArea txtDescription = new JTextArea();
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(txtDescription);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL));
		scrollpane.setVerticalScrollBar(new JScrollBar(JScrollBar.VERTICAL));
		scrollpane.setBounds(120, 75, 367, 124);
		txtDescription.setBounds(120, 75, 367, 124);
		txtDescription.setWrapStyleWord(true);
		formPanel.add(scrollpane);

		JLabel lblQuery = new JLabel("Query");
		lblQuery.setBounds(27, 226, 148, 34);
		formPanel.add(lblQuery);

		JTextPane txtQuery = new JTextPane();
		txtQuery.setBounds(120, 231, 367, 115);
		JScrollPane scrollPane = new JScrollPane(txtQuery);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL));
		scrollPane.setVerticalScrollBar(new JScrollBar(JScrollBar.VERTICAL));
		scrollPane.setBounds(120, 231, 367, 115);
		formPanel.add(scrollPane);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtQueryName.setText("");
				txtDescription.setText("");
			}
		});

		btnClear.setBounds(299, 373, 89, 23);
		formPanel.add(btnClear);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(398, 373, 89, 23);
		formPanel.add(btnSave);

		JFrame jFrame = new JFrame();
		jFrame.getContentPane().add(formPanel);
		jFrame.setTitle("Query History");
		jFrame.setLocationRelativeTo(null);
		jFrame.setPreferredSize(new Dimension(622, 500));
		jFrame.setSize(622, 500);
		jFrame.setVisible(true);
	}

	private void fieldPanel() {

		JPanel fieldPanel = new JPanel();
		fieldPanel.setPreferredSize(new Dimension(688, 309));
		fieldPanel.setLayout(null);

		//Create fields for stitch thread
		JLabel lblMainFabric = new JLabel("Stitch Thread:");
		lblMainFabric.setBounds(23, 12, 124, 18);
		fieldPanel.add(lblMainFabric);

		JTextArea txtStitchThread = new JTextArea();
		txtStitchThread.setBounds(33, 36, 200, 242);
		txtStitchThread.setLineWrap(true);
		txtStitchThread.setWrapStyleWord(true);
		fieldPanel.add(txtStitchThread);

		//Create fields for contrast thread
		JLabel lblNewLabel = new JLabel("Contrast Thread:");
		lblNewLabel.setBounds(251, 12, 118, 18);
		fieldPanel.add(lblNewLabel);

		JTextArea txtContrastThread = new JTextArea();
		txtContrastThread.setBounds(250, 36, 200, 242);
		txtContrastThread.setLineWrap(true);
		txtContrastThread.setWrapStyleWord(true);
		fieldPanel.add(txtContrastThread);

		//Show input dialog box with above fields
		int result = JOptionPane.showConfirmDialog(null, fieldPanel, "Update Thread Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		JLabel lblThreadColor = new JLabel("Thread Color:");
		lblThreadColor.setBounds(462, 12, 118, 18);
		fieldPanel.add(lblThreadColor);

		txtThreadColor = new JTextField();
		txtThreadColor.setBounds(462, 36, 220, 42);
		fieldPanel.add(txtThreadColor);
		txtThreadColor.setColumns(10);

		JLabel lblThreadNumber = new JLabel("Thread Number:");
		lblThreadNumber.setBounds(462, 100, 118, 18);
		fieldPanel.add(lblThreadNumber);

		txtThreadNumber = new JTextField();
		txtThreadNumber.setColumns(10);
		txtThreadNumber.setBounds(462, 130, 220, 42);
		fieldPanel.add(txtThreadNumber);
	}

	private void itemPanel() {

		JPanel panel = new JPanel();
		panel.add(new JLabel("Item Details"));
		panel.setLayout(null);
		/**Item Name fields**/
		lblItemName.setBackground(Color.WHITE);
		lblItemName.setBounds(20, 24, 80, 30);
		lblItemName.setForeground(Color.BLACK);
		panel.add(lblItemName);
		txtItemName.setToolTipText("Enter Item Name (Mandatory)");
		txtItemName.setBounds(140, 22, 200, TEXT_FIELD_HEIGHT);
		panel.add(txtItemName);

		/**Content & Color fields**/
		JLabel lblContentcolor = new JLabel("Content:");
		lblContentcolor.setForeground(Color.BLACK);
		lblContentcolor.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblContentcolor.setBackground(Color.WHITE);
		lblContentcolor.setBounds(20, 66, 105, 30);
		panel.add(lblContentcolor);

		txtContent.setToolTipText("Enter Content/ Color (Mandatory)");
		txtContent.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		txtContent.setBounds(140, 66, 200, 35);
		panel.add(txtContent);

		btnRemoveContent.setBounds(234, 113, 93, 30);
		btnAddContent.setBounds(140, 113, 82, 30);

		panel.add(btnRemoveContent);
		panel.add(btnAddContent);

		contentList.setVisibleRowCount(10);
		contentList.setValueIsAdjusting(true);
		contentList.setLayoutOrientation(JList.VERTICAL);
		contentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentList.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		contentList.setBounds(0, 0, 183, 85);

		//Initialize and create scroll pane for materialList
		JScrollPane contentListSP = new JScrollPane(contentList);
		contentListSP.setBounds(352, 64, 200, 216);
		contentListSP.setPreferredSize(new Dimension(200, 100));
		panel.add(contentListSP);

		/**Item Quantity Fields**/
		JLabel lblQuantity = new JLabel("Item Quantity:");
		lblQuantity.setForeground(Color.BLACK);
		lblQuantity.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblQuantity.setBackground(Color.WHITE);
		lblQuantity.setBounds(20, 281, 105, 30);
		panel.add(lblQuantity);

		txtQuantity.setToolTipText("Enter Item Quantity (Mandatory)");
		txtQuantity.setText("");
		txtQuantity.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		txtQuantity.setBounds(140, 279, 200, 35);
		panel.add(txtQuantity);

		btnRemoveQuantity.setBounds(234, 326, 93, 30);

		btnAddQuantity.setBounds(136, 326, 93, 30);

		panel.add(btnRemoveQuantity);
		panel.add(btnAddQuantity);

		quantityList.setVisibleRowCount(10);
		quantityList.setValueIsAdjusting(true);
		quantityList.setLayoutOrientation(JList.VERTICAL);
		quantityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		quantityList.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		quantityList.setBounds(0, 0, 183, 85);

		//Initialize and create scroll pane for materialList
		JScrollPane quantityListSP = new JScrollPane(quantityList);
		quantityListSP.setBounds(352, 303, 200, 216);
		quantityListSP.setPreferredSize(new Dimension(200, 100));
		panel.add(quantityListSP);
		lblinNumbers.setForeground(Color.BLACK);
		lblinNumbers.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblinNumbers.setBackground(Color.WHITE);
		lblinNumbers.setBounds(20, 323, 105, 30);

		panel.add(lblinNumbers);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton.setBounds(129, 523, 93, 30);
		panel.add(btnNewButton);

		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		button.setBounds(247, 523, 93, 30);
		panel.add(button);
	}

	private static void display() {

		String[] items = { "One", "Two", "Three", "Four", "Five" };
		JComboBox combo = new JComboBox(items);
		JTextField field1 = new JTextField("1234.56");
		JTextField field2 = new JTextField("9876.54");
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(combo);
		panel.add(new JLabel("Field 1:"));
		panel.add(field1);
		panel.add(new JLabel("Field 2:"));
		panel.add(field2);
		int result = JOptionPane.showConfirmDialog(null, panel, "Test", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION)
		{
			System.out.println(combo.getSelectedItem() + " " + field1.getText() + " " + field2.getText());
		}
		else
		{
			System.out.println("Cancelled");
		}
	}

	private static void contentPanel() {

		JPanel editPanel = new JPanel();
		editPanel.setPreferredSize(new Dimension(310, 111));
		editPanel.setLayout(null);

		//Create fields for stitch thread
		JLabel lblMainFabric = new JLabel("Content Name:");
		lblMainFabric.setBounds(23, 12, 124, 18);
		editPanel.add(lblMainFabric);

		JTextField txtContent = new JTextField("Content");
		txtContent.setBounds(33, 36, 205, 45);
		editPanel.add(txtContent);

		JLabel lblNewLabel = new JLabel("Quantity (In Digits):");
		lblNewLabel.setBounds(23, 93, 118, 18);
		//editPanel.add(lblNewLabel);

		JTextField txtQuantity = new JTextField("1111");
		txtQuantity.setBounds(33, 123, 205, 45);
		//editPanel.add(txtQuantity);

		int result = JOptionPane.showConfirmDialog(null, editPanel, "Update Material Content Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				new JOptionPaneTest();
				//				contentPanel();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		switch (actionCommand) {
			case "webcamCapture":
				break;
			case "explorerPC":
				showFileChooser();
				break;
		}
	}

	private void showFileChooser() {
		try
		{

			FileFilter filter = new FileNameExtensionFilter("Image Files", new String[] { "gif", "png", "jpg" });
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setName("Select Profile Picture");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setMultiSelectionEnabled(false);
			fileChooser.addChoosableFileFilter(filter);
			fileChooser.setFileFilter(filter);
			fileChooser.setApproveButtonText("Set");
			int showOpenDialog = fileChooser.showOpenDialog(null);
			if (showOpenDialog == JFileChooser.APPROVE_OPTION)
			{
				System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
				BufferedImage img = ImageIO.read(fileChooser.getSelectedFile());
				Image dimg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(dimg);
				lblImage.setIcon(imageIcon);
			}
		}
		catch (IOException e)
		{

			e.printStackTrace();
		}
	}
}
