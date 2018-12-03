import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class MyProgressBarTest {
	private static final long	serialVersionUID	= 1L;

	private static JProgressBar	progressBar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MyProgressBarTest obj = new MyProgressBarTest();
				obj.createGUI();
			}
		});
	}

	public void createGUI() {
		final JFrame frame = new JFrame();

		JPanel panel = new JPanel();
		final JButton button = new JButton("Progress");

		progressBar = new JProgressBar();

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				MyCustomProgressBarDialog progressBarObj = new MyCustomProgressBarDialog(progressBar, frame);
				progressBarObj.createProgressUI();

				MyActionPerformer actionObj = new MyActionPerformer(progressBar, progressBarObj, button);
				actionObj.execute();

			}
		});

		panel.add(button);
		frame.add(panel);

		frame.setTitle("JProgressBar Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(200, 300);
		frame.setVisible(true);
	}
}

class MyActionPerformer extends SwingWorker<String, Object> {

	JProgressBar				fProgressBar;
	MyCustomProgressBarDialog	progressDialog;
	JButton						button;

	public MyActionPerformer(JProgressBar progressBar, MyCustomProgressBarDialog progressDialog, JButton button) {
		this.fProgressBar = progressBar;
		this.fProgressBar.setVisible(true);
		this.fProgressBar.setIndeterminate(true);
		this.button = button;
		this.progressDialog = progressDialog;

		this.button.setEnabled(false);
	}

	protected String doInBackground() throws Exception {

		calculateResult();
		return "Finished";
	}

	protected void done() {
		fProgressBar.setVisible(false);
		this.progressDialog.setVisible(false);
		this.button.setEnabled(true);
	}

	public void calculateResult() {
		for (int i = 0; i < 500000; i++)
		{
			System.out.println("Progress Bar: " + i);
		}
	}
}

class MyCustomProgressBarDialog extends JDialog {
	private static final long	serialVersionUID	= 1L;

	private static JProgressBar	progressBar;
	private JFrame				motherFrame;
	private JLabel				label				= new JLabel("loading.. ");
	private JButton				button;

	public MyCustomProgressBarDialog(JProgressBar progressBar, JFrame frame) {

		this.progressBar = progressBar;
		this.motherFrame = frame;
		this.button = button;
	}

	public void createProgressUI() {
		add(label, BorderLayout.NORTH);
		add(progressBar, BorderLayout.CENTER);
		setSize(100, 50);
		setAlwaysOnTop(true);
		setLocationRelativeTo(motherFrame);
		setUndecorated(true);
		setVisible(true);
	}
}