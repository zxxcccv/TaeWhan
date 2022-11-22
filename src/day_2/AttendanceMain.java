package day_2;

import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceMain {
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
		
		int menu = -1;
		
		Attendance attendance = new Attendance();
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			menuBar();
			runMenu(menu, attendance);
		
					
				
		}while(menu != 3);
	}
	
	private static void runMenu(int menu, Attendance attendance) {
		ArrayList<Student> stds = attendance.getStds();
		ArrayList<Log> logs = attendance.getLogs();
		switch(menu) {
		case 1:
			managementStudents(stds);
			break;
		case 2:
			//managementLogs(logs, stds);
			break;
		case 3:
			printStr("프로그램 종료");
			menuBar();
			break;
		default:
			printStr("잘못된 메뉴입니다.");
			menuBar();
			break;
		}
		
	}
	private static void managementStudents(ArrayList<Student> stds) {
		printSubMenu(1);
		int subMenu = scan.nextInt();
		scan.nextLine();
		switch(subMenu) {
		case 1: addStudent(stds); break;
		case 2: updateStudent(stds); break;
		case 3: deleteStudent(stds); break;
		case 4: printStr("취소했습니다."); break;
		default: printStr("메뉴를 잘못입력했습니다.");
			menuBar();
		}
	}
	public static void addStudent(ArrayList<Student> stds) {
		if(stds == null) 
			throw new RuntimeException("예외 발생 : 학생 정보를 관리하는 리스트가 없습니다.");
		
		System.out.print("이름 입력 : ");
		String name = scan.nextLine();
		System.out.print("생일 입력 : ");
		String birthday = scan.nextLine();
		Student std = new Student(name, birthday);
		if(stds.indexOf(std) != -1) {//@Data에서 이퀄스를 자동으로 생성해줘서 따로 이퀄스를 오버라이딩 하지않았음
			printStr("학생 정보를 추가하지 못했습니다.");
			return;
		}
		stds.add(std);
		printStr("학생 정보를 추가했습니다.");
			
	}

	private static void printMenu() {
		System.out.println("===출석부 관리 프로그램 메뉴===");
		System.out.println("1.학생 관리");
		System.out.println("2.출석 관리");
		System.out.println("3.종료");
		System.out.println("=========================");
		System.out.println("메뉴 선택 : ");
	}
	private static void printSubMenu(int menu) {
		switch(menu) {
		case 1:
			printStr("===학생 관리 메뉴===");
			printStr("1. 학생 추가");
			printStr("2. 학생 수정");
			printStr("3. 학생 삭제");
			printStr("4. 취소");
			printStr("=================");
			printStr("메뉴 선택 : ");
			break;
		case 2:
			printStr("===출석 관리 메뉴===");
			printStr("1. 출석 체크 - 전체");
			printStr("2. 출석 확인 - 개별");
			printStr("3. 출석 확인 - 날짜별");
			printStr("4. 출석 수정");
			printStr("5. 출석 삭제");
			printStr("6. 취소");
			printStr("=================");
			printStr("메뉴 선택 : ");
			
			break;
		
		default:
			printStr("잘못된 메뉴입니다.");
		}
	}
	private static void menuBar() {
		System.out.println("=========================");
	}
	private static void printStr(String str) {
		System.out.println(str);
	}
	
	public static void updateStudent(ArrayList<Student> stds) {
		if(stds == null) 
			throw new RuntimeException("예외 발생 : 학생 정보를 관리하는 리스트가 없습니다.");
		
		System.out.print("이름 입력 : ");
		String name = scan.nextLine();
		System.out.print("생일 입력 : ");
		String birthday = scan.nextLine();
		Student std = new Student(name, birthday);
		int index = stds.indexOf(std);
		if(index == -1) {
			printStr("입력 정보와 일치하는 학생이 없습니다.");
			return;
		}
		System.out.print("수정할 이름 입력 : ");
		name = scan.nextLine();
		System.out.print("수정할 생일 입력 : ");
		birthday = scan.nextLine();
		std = new Student(name, birthday);
		stds.set(index, std);
		printStr("학생 정보를 수정했습니다.");
		
	}
	public static void deleteStudent(ArrayList<Student> stds) {
		if(stds == null) 
			throw new RuntimeException("예외 발생 : 학생 정보를 관리하는 리스트가 없습니다.");
		
		System.out.print("이름 입력 : ");
		String name = scan.nextLine();
		System.out.print("생일 입력 : ");
		String birthday = scan.nextLine();
		Student std = new Student(name, birthday);
		int index = stds.indexOf(std);
		if(index == -1) {
			printStr("입력 정보와 일치하는 학생이 없습니다.");
			return;
		}
		
		
		stds.remove(index);
		printStr("학생 정보를 삭제했습니다.");
		
	}

}
