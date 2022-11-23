package Test_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamEx03 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		
		try {
			fis = new FileInputStream("test.txt");
			fos = new FileOutputStream("test.txt");
			dis = new DataInputStream(fis);
			dos = new DataOutputStream(fos);
			String name = "홍길동";
			int age = 10;
			dos.writeChars(name);
			dos.writeInt(age);
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				fis.close();
				fos.close();
				dis.close();
				dos.close();
			}catch (IOException e) {
				e.printStackTrace();
				
			}
		}

	}

}
