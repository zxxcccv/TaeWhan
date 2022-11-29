package test_44;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardMain {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/*  - 게시글 종류는 자유, 공지는 기본
			- 게시글 종류는 추가 가능
			- 게시글을 회원만 작성 가능
			- 회원 가입, 로그인 기능 필요
			- 비회원은 작성, 수정 불가능, 조회 가능
			- 회원 정보와 게시글을 파일에 저장하여 관리
		 */
		ArrayList<BoardMember> memberList = new ArrayList<BoardMember>();
		ArrayList<Board> boardList = new ArrayList<Board>();
		ArrayList<MemberAndBoard> MABList = new ArrayList<MemberAndBoard>();
		int menu = -1;
		String name, id, pw;
		int count = 0;
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			switch(menu) {
			case 1: 
				printStr("ID를 입력해주세요.");
				id = scan.nextLine();
				printStr("password를 입력해주세요.");
				pw = scan.nextLine();
				//아이디와 비밀번호를 비교하여 동일한 정보가 리스트에 존재하면 로그인완료
				BoardMember member = new BoardMember(id, pw);
				
				int index = memberList.indexOf(member);
				if(index == -1) {
					continue;
				}
				BoardMember a = memberList.get(index);
				
				if(a.getPw().equals(member.getPw())) {
					//작성할 게시글의 종류를 선택해주세요.
					printStr("작성할 게시글의 종류를 입력해주세요.(공지or자유)");
					String type = scan.nextLine();
					printStr("작성할 게시글의 제목을 입력해주세요.");
					String title = scan.nextLine();
					printStr("작성할 게시글의 내용을 입력해주세요.");
					String contents = scan.nextLine();
					Board list = new Board(type, title, contents);
					boardList.add(list);
					++count;
					printStr("게시글이 등록되었습니다. 등록된 게시글의 번호는 " + count + "번 입니다.");
					MemberAndBoard b = new MemberAndBoard(member, boardList);
				}else {
					printStr("아이디 혹은 비밀번호가 잘못되었습니다.");
				}
				
				break;
			case 2:
				printStr("조회할 게시글의 번호를 입력해주세요.");
				int number = scan.nextInt();
				scan.nextLine();
				System.out.println(boardList.get(number-1));
				break;
				
			case 3:
				printStr("ID를 입력해주세요.");
				id = scan.nextLine();
				printStr("password를 입력해주세요.");
				pw = scan.nextLine();
				
				BoardMember member1 = new BoardMember(id, pw);
				index = memberList.indexOf(member1);
				if(index == -1) {
					continue;
				}
				BoardMember b = memberList.get(index);
				
				if(b.getPw().equals(member1.getPw())) {
					//비밀번호가 맞다면 MemberAndBoard에서 b로 쓴 BoardList를 가져온다
					//id와 pw를 비교하듯이 b에 상응되는 BoardList가 아니라면 수정권한 X
					//
				}
				
				
				
				printStr("수정할 게시글의 번호를 입력해주세요.");
				number = scan.nextInt();
				scan.nextInt();
				
				break;
			case 4:
				memberJoin(memberList);
				break;
			case 5:
				printStr("프로그램을 종료합니다.");
				printBar();
				break;
			default:
				printStr("잘못된 선택입니다.");
			}
			
		}while(menu != 5);
	}
	public static void printStr(String str) {
		System.out.println(str);
	}
	public static void printBar() {
		System.out.print("===========================");
	}
	public static void printMenu() {
		printStr("======== 메뉴 선택 창 ========");
		printStr("1. 게시글 작성");
		printStr("2. 게시글 조회");
		printStr("3. 게시글 수정");
		printStr("4. 회원가입");
		printStr("5. 종료");
		printStr("===========================");
		printStr("메뉴 선택: ");
	}
	public static void memberJoin(ArrayList<BoardMember> memberList) {
		printStr("4. 회원가입");
		printStr("이름을 입력해주세요.");
		String name = scan.nextLine();
		printStr("아이디를 입력해주세요.");
		String id = scan.nextLine();
		printStr("비밀번호를 입력해주세요.");
		String pw = scan.nextLine();
		BoardMember member = new BoardMember(name, id, pw);
		if(memberList.contains(member)) {
			printStr("이미 존재하는 아이디입니다.");
		}else {
			memberList.add(member);
			printStr("회원가입이 완료되었습니다.");
		}
	}

}
