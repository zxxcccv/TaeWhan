package Test_3;

import java.io.File;
import java.io.IOException;

public class FileEx02 {

	public static void main(String[] args) {
		File f = new File("D:/test");//맨앞에 씨나 디가 없으면 상대경로라고 한다.
		
		if(f.mkdir()) {
			System.out.println("폴더가 생성되었습니다.");
		}else {
			System.out.println("폴더 생성에 실패했습니다.");
		}//이미 있는 폴더이거나 상위폴더가 없는 경우에 실패함
		

		if(f.mkdirs()) {
			System.out.println("폴더들이 생성되었습니다.");
		}else {
			System.out.println("이미 폴더들이 있습니다.");
		}
		if(f.isDirectory())
		System.out.println("폴더명 : " + f.getName());
		if(f.isFile())
			System.out.println("파일명 : " + f.getName());
		
		if(f.delete()) {
			System.out.println("폴더가 삭제되었습니다.");
			
		}else {
			System.out.println("없는 폴더입니다.");
			
		}
	}

}
