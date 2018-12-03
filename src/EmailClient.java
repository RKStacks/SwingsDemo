import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class EmailClient {

	public EmailClient() {
	}

	public static void main(String[] args) {
		//// TODO Auto-generated method stub

		try
		{	File file2=new File("C:\\Users\\Riz\\Desktop\\employeeReport.pdf");
			//C:\Shree Garments Inventory System\Reports\employeeReport.pdf
			File file = new File("C:/Shree%20Garments%20Inventory%20System/Reports/employeeReport.pdf");

			String str2="C:\\Program Files\\Microsoft Office\\Office15\\outlook.exe /a " + file.getAbsolutePath();
			System.out.println(str2);

			String str = "C:\\Program Files\\Microsoft Office\\Office15\\outlook.exe /a " + file2.getAbsolutePath();

			Runtime runtime = Runtime.getRuntime();
			runtime.exec(str2);

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static void sendUsingOutlook() throws URISyntaxException, IOException {
		Desktop desktop = Desktop.getDesktop();
		String url = "";
		URI mailTo;
		File file = new File("C:\\Users\\Riz\\Desktop\\operationsReport.pdf");
		URL attachmentUIR = file.toURI().toURL();
		System.out.println(attachmentUIR);

		url = "mailTo:test@gmail.com" + "?subject=" + "TEST%20SUBJECT" + "&body=" + "TEST%20BODY" + "&a='" + attachmentUIR + "';";
		//url = "mailTo:test@gmail.com" + "?subject=" + "TEST%20SUBJECT" + "&body=" + "TEST%20BODY";
		mailTo = new URI(url);

		desktop.mail(mailTo);
	}

}
