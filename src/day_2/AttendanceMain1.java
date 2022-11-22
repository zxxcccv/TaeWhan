package day_2;

import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceMain1 {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * 출석부 관리 프로그램
		 * 1. 학생등록
		 *  - 이름과 생년월일
		 * 2. 학생수정
		 *  - 이름과 생년월일로 검색해서 이름과 생년월일 수정
		 * 3. 학생삭제
		 *  - 이름과 생년월일로 검색해서 이름과 생년월일 수정
		 * 4. 학생 출결 확인
		 *  - 이름과 생년월일로 검색해서 해당 학생의 모든 출결을 확인
		 *  - 2022-11-22: O 
		 * 5. 출석확인
		 *  - 날짜 입력 : 2022-11-22
		 *  - 출석: O, 지각: /, 조퇴: \,결석: X
		 *  -
		 *  홍길동 출석현황 : X
		 *  고길동 출석현황 : O
		 *  임꺽정 출석현황 : /
		 *  
		 *  6. 출석수정
		 *   - 날짜 입력
		 *   - 수정할 학생의 이름과 생년월일 입력
		 *  7. 출석삭제
		 *   - 날짜 입력하여 해당 날짜 출석 삭제
		 *  8.날짜별 출석 확인
		 *   - 날짜 입력하여 해당 날짜의 모든 학생의 출석 여부를 확인
		 *  9.프로그램 종료
		 *  
		 *  학생 클래스: 이름과 생년월일
		 *  출석부 클래스: 학생들, 일지들
		 *  일지 클래스:날짜, 학생일지(학생이름, 생년월일, 출결);
		 */
		
		//메뉴창을 띄운다
		printMenu();
		int menu = 0;
		ArrayList<Student1> list = new ArrayList<Student1>();
		
		do {
			
				printStr("메뉴를 선택해주세요.");
				menu = scan.nextInt();
				switch(menu) {
				case 1:
					addMember(list);
					break;
				case 2:
					Student1 updateTmp = searchMember(list);
					
					if(!updateMember(list, updateTmp)) {
						printStr("입력받은 학생이 존재하지 않습니다.");
					}else
						printStr("학생정보 수정이 완료됐습니다.");
					break;
				case 3:
					//3.학생삭제
					break;
				case 4:
					//4.학생 출결 확인1
					break;
				case 5:
					//5.출석확인
					break;
				case 6:
					//6.출석수정
					break;
				case 7:
					//7.출석삭제
					break;
				case 8:
					//8.날짜별 출석 확인
					break;
				case 9:
					printStr("프로그램을 종료합니다.");
					break;
				default:
					printStr("잘못된 선택입니다.");
				}
		}while(menu != 9);
	}
	
	public static void printMenu() {
		System.out.println("===출석부 관리 프로그램 메뉴===");
		System.out.println("1.학생 등록");
		System.out.println("2.학생 수정");
		System.out.println("3.학생 삭제");
		System.out.println("4.학생 출결 확인");
		System.out.println("5.출석 확인");
		System.out.println("6.출석 수정");
		System.out.println("7.출석 삭제");
		System.out.println("8.날짜별 출석 확인");
		System.out.println("9.프로그램 종료");
		System.out.println("=========================");
	}
	public static void menuBar() {
		System.out.println("=========================");
	}
	public static void printStr(String str) {
		System.out.println(str);
	}
	public static boolean addMember(ArrayList<Student1> list) {
		printStr("학생의 이름을 등록해주세요.");
		scan.next(); //nextInt로 인한 입력버퍼처리를 위해서
		String name = scan.nextLine();
		printStr("학생의 생년월일을 입력해주세요.(XXXX-XX-XX)");
		String birth = scan.nextLine();
		Student1 member = new Student1(name, birth);
		if(list.contains(member)) {
			printStr("이미 등록된 학생입니다.");
			menuBar();
			return false;
		}else
			list.add(member);
			printStr("등록한 학생이 추가되었습니다.");
			menuBar();
			return true;
	}
	public static Student1 searchMember(ArrayList<Student1> list) {
		
		//아이디 입력
		printStr("수정할 학생이름을 입력하세요.");
		String name = scan.next();


		Student1 member = new Student1(name);
		
		
		int index = list.indexOf(member);
		if(index == -1) {
			return null;
		}
		Student1 tmp = list.get(index);
			return tmp;	
	}
	public static boolean updateMember(ArrayList<Student1> list, Student1 updateTmp) {
		if(updateTmp == null) {
			return false;
		}else
		System.out.print("수정할 이름을 입력하세요.");
		String name = scan.next();
		System.out.println("수정할 생년월일을 입력하세요.");
		String birth= scan.next();
		
		
		//입력받은 회원 정보를 이용하여 updateTmp를 수정
		updateTmp.update(name, birth);
		return true;
	}

}
