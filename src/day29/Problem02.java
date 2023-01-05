package day29;

import lombok.Data;

public class Problem02 {

	public static void main(String[] args) {
		// 아래코드는 에러가 발생하는데, 원인과 해결방안을 설명해라
		
		int i;
		for(i = 1; i<=10;i++) {
			System.out.println(i);
		}
		

	}

}

@Data
class Board1{
	int num;
	
	public void Board(int num) {
		this.num = num;
	}
}
