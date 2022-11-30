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
				"조회한 게시글의 번호는 " + number + " 번 입니다.\n" +
				"게시글의 유형은 " + type + " 이고\n" +
				"게시글의 제목은 " + title + " 이며\n" +
				"게시글의 내용은 " + contents + " 입니다.\n" +
				"=====================================";
	}
	public void update(String type, String title, String contents) {
		this.type = type;
		this.title = title;
		this.contents = contents;
	}
	public Board(int number) {
		
		this.number = number;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (number != other.number)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}
	
	
}