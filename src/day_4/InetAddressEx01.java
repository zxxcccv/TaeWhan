package day_4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx01 {

	public static void main(String[] args) {
		InetAddress ia = null;
		
		try {
			ia = InetAddress.getByName("localhost");
			System.out.println(ia);
			ia = InetAddress.getByName("www.naver.com");
			System.out.println(ia);
			ia = InetAddress.getLocalHost();
			System.out.println(ia);
			
				
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}
		

	}

}
