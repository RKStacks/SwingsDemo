import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ModalProgressBar {

	public ModalProgressBar() {
	}

	public static void main(String[] args) {
		JFrame parentFrame = new JFrame();
		parentFrame.setSize(500, 150);
		JLabel jl = new JLabel();
		jl.setText("Count : 0");

		parentFrame.add(BorderLayout.CENTER, jl);
		parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		parentFrame.setVisible(true);

		final JDialog progressDialog = new JDialog(parentFrame, "", true);
		final JProgressBar progressBar = new JProgressBar(0, 500);
		progressBar.setIndeterminate(true);
		progressDialog.add(BorderLayout.CENTER, progressBar);
		progressDialog.add(BorderLayout.NORTH, new JLabel("Please Wait Checking For Existing Member"));
		progressDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		progressDialog.setSize(300, 75);
		progressDialog.setLocationRelativeTo(parentFrame);

		Thread t = new Thread(new Runnable() {
			public void run() {
				progressDialog.setVisible(true);
			}

		});
		t.start();

		for (int i = 0; i <= 300; i++)
		{
			jl.setText("Count : " + i);
			//			progressBar.setValue(i);
			if (i == 200)
			{
				//				System.exit(0);
				//				progressDialog.setVisible(false);
				progressDialog.dispose();
				if (t != null)
				{
					t.suspend();
					t = null;
				}

			}
			try
			{
				Thread.sleep(25);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		//		progressDialog.setVisible(true);
	}
}
