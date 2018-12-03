
package com.data.mining;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {

	public static void main(String[] args) throws IOException {
		Test test = new Test();

	}

	private static void test1(String website) {
		URL url;
		InputStream is = null;
		DataInputStream dis;
		String line;

		try
		{
			url = new URL(website);
			is = url.openStream(); // throws an IOException
			dis = new DataInputStream(new BufferedInputStream(is));

			while ((line = dis.readLine()) != null)
			{
				System.out.println(line);
			}
		}
		catch (MalformedURLException mue)
		{
			mue.printStackTrace();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{
			try
			{
				is.close();
			}
			catch (IOException ioe)
			{
				System.err.println("Error " + ioe.toString());
			}
		}
	}

}
