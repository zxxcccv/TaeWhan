package test_44;

import java.util.ArrayList;
import lombok.Data;

@Data
public class MemberAndBoard {
	private BoardMember member;
	private ArrayList<Board> list = new ArrayList<Board>();
	
	public MemberAndBoard(BoardMember member, ArrayList<Board> list) {
		this.member = member;
		this.list = list;
	}
	
	
	
	
}