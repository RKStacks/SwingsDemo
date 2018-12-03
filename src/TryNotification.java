import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TryNotification {

	static Image	image		= Toolkit.getDefaultToolkit().getImage("images/tray.gif");

	static TrayIcon	trayIcon	= new TrayIcon(image, "Tester2");

	public static void main(String[] a) throws Exception {
		if (SystemTray.isSupported())
		{
			SystemTray tray = SystemTray.getSystemTray();

			trayIcon.setImageAutoSize(true);
			trayIcon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("In here");
					trayIcon.displayMessage("Tester!", "Some action performed", TrayIcon.MessageType.INFO);
				}
			});
			/*
			 * Double click action performed *
			 */
//			trayIcon.addActionListener(new ActionListener() {
//			    @Override
//			    public void actionPerformed(ActionEvent e) {
//			        try {
//			            Desktop dst = Desktop.getDesktop();
//			            dst.open(new File(location));
//			            /*
//			             * reset the location to root location again.
//			             */
////			            location = Root_Location_Here // again setting root location
//			        } catch (Exception ex) {
//			            logger.error("------- error with folder opening double click "
//			                    + ex.getMessage());
//			        }
//			    }
//			});
			try
			{
				tray.add(trayIcon);
			}
			catch (AWTException e)
			{
				System.err.println("TrayIcon could not be added.");
			}
		}
	}
}
