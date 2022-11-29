package test_44;


import lombok.Data;

@Data
public class Board {
	private static int count = 0;
	private String type;
	private String title;
	private String contents;
	private int number;
	public Board(String type, String title, String contents) {
		
		this.type = type;
		this.title = title;
		this.contents = contents;
		++count;
		number = count;
	}
	@Override
	public String toString() {
		return 
				"=====================================\n" +
				"조회한 게시글의 번호는 " + number + " 번 이고\n" +
				"게시글의 제목은 " + title + " 이며\n" +
				"게시글의 내용은 " + contents + " 입니다.\n" +
				"=====================================";
	}
	
}