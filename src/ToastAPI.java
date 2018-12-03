import java.awt.Color;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.nitido.utils.toaster.Toaster;

public class ToastAPI {

	public ToastAPI() {
	}

	public static void main(String[] args) {

		Toaster toasterManager = new Toaster();
		toasterManager.setBackgroundImage(createImage("toastbg.png", ""));
		toasterManager.setStep(5);
		toasterManager.setMargin(10);

		toasterManager.setBorderColor(Color.BLUE);
		toasterManager.setMessageColor(Color.white);
		toasterManager.setDisplayTime(1000);
		toasterManager.showToaster("Hello");
	}

	public static Image createImage(String name, String description) {

		URL imageURL = null;
		try
		{
			imageURL = new URL(ToastAPI.class.getResource(name).toExternalForm());
		}
		catch (MalformedURLException e)
		{

			System.err.println("Error while creating image : " + name + " Error : " + e);
		}

		if (imageURL == null)
		{
			System.err.println("Resource not found: " + name);
			return null;
		}
		else
		{
			return (new ImageIcon(imageURL, description)).getImage();
		}
	}
}
