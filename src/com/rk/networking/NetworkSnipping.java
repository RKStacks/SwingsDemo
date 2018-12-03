
package com.rk.networking;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;

public class NetworkSnipping {

	public static void main(String[] args) throws SocketException, UnknownHostException {
		List<NetworkInterface> networkInterfaces = Collections.list(NetworkInterface.getNetworkInterfaces());

		ListIterator<NetworkInterface> listIterator = networkInterfaces.listIterator();
		System.out.println("===================================");
		System.out.println("Started Snippffing");
		while (listIterator.hasNext())
		{
			NetworkInterface networkInterface = listIterator.next();


			String displayName = networkInterface.getDisplayName();
			byte[] hardwareAddress = networkInterface.getHardwareAddress();
			String name = networkInterface.getName();

			System.out.println("Display Name : " + displayName);
			System.out.println("Hardware Address : " + hardwareAddress);
			System.out.println("Name : " + name);
			Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
			System.out.println("--------------------------------");
			System.out.println("Getting Inet Addresses");
			System.out.println("--------------------------------");
			while (inetAddresses.hasMoreElements())

			{
				System.out.println("Found Inet Address Details");
				InetAddress inetAddress = inetAddresses.nextElement();

				String canonicalHostName = inetAddress.getCanonicalHostName();
				String hostAddress = inetAddress.getHostAddress();
				String hostName = inetAddress.getHostName();

				System.out.println("Host Address : " + hostAddress);
				System.out.println("Host Name :" + hostName);
				System.out.println("Canonical Host Name : " + canonicalHostName);

				
				System.out.println("Getting Loopback Address details of " + canonicalHostName);
				InetAddress loopbackAddress = InetAddress.getLoopbackAddress();

				String loopbackHostAddress = loopbackAddress.getHostAddress();
				String loopbackHostname = loopbackAddress.getHostName();
				System.out.println("Loopback Host Name : " + loopbackHostname);
				System.out.println("Loopback Host Address : " + loopbackHostAddress);

				System.out.println("Getting Local Host Details of " + canonicalHostName);

				InetAddress localHost = inetAddress.getLocalHost();
				String localhostName = localHost.getHostName();
				String localHostAddress = localHost.getHostAddress();
				String localHostCanonicalHostName = localHost.getCanonicalHostName();

				System.out.println("Local Host Name : " + localhostName);
				System.out.println("Local Host Address : " + localHostAddress);
				System.out.println("Localhost Canonical Host name :" + localHostCanonicalHostName);

				Enumeration<NetworkInterface> subInterfaces = networkInterface.getSubInterfaces();
				
				System.out.println("------------------------------------------------------------");
				System.out.println("Getting Sub Interface Details of " + canonicalHostName);
				System.out.println("------------------------------------------------------------");
				while (subInterfaces.hasMoreElements())
				{

					NetworkInterface subInterface = subInterfaces.nextElement();

					String subInterfaceDisplayName = subInterface.getDisplayName();
					System.out.println("Sub Interface Name : " + subInterfaceDisplayName);
				}
			}
		}
		System.out.println("===================================");
		
	}

}
