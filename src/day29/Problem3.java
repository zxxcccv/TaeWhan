package day29;

import lombok.Data;

public class Problem3 {

	public static void main(String[] args) {
		//게시글에 제목에 공지가 있는지 확인하는 코드입니다. 아래 코드 결과를 작성하고,
		//왜 그렇게 결과가 나오는지 설명하세요. 원래 목적에 맞게 동작시키려면 어느부분을 수정해야하는지
		//작성하고 수정하는 코드를 작성하세요.
		Board2 board2 = new Board2();
		board2.setTitle("공지사항");
		String search = "공지사항";
		if(board2.title == search) {
			System.out.println("제목에 공지가 포함되었습니다.");
		}else {
			System.out.println("제목에 공지가 포함되어 있지 않습니다.");
		}

	}

}

@Data
class Board2{
	String title, contents;

	public Board2() {
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board2 other = (Board2) obj;
		
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	
}

