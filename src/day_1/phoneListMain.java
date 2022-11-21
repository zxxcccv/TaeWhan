package day_1;

import java.util.ArrayList;
import java.util.Scanner;

public class phoneListMain {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/* 전화번호를 관리하는 프로그램을 작성하세요.
		 * 1. 전화번호 추가(성, 이름, 직장, 전화번호들(이름 : 번호))
		 * 2. 전화번호 수정
		 *    - 이름으로 검색(성+이름)
		 *    - 검색된 사람들 중에서 선택
		 *    - 성, 이름을 수정할건지, 
		 *      기존 등록된 전화번호를 수정할건지,
		 *      새 전화번호를 등록한건지를 선택하여 동작
		 * 3. 전화번호 삭제
		 *    - 이름으로 검색(성+이름)
		 *    - 검색된 사람들 중에서 선택
		 *    - 선택된 사람의 연락처를 삭제
		 * 4. 전화번호 조회
		 *    - 이름으로 검색
		 *    - 검색된 사람들 중에서 선택
		 *    - 선택된 사람의 연락처를 출력
		 * */
		int menu = -1;
		
		ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
		do {
			
			printMenu();//메뉴 출력
			
			menu = scan.nextInt();//메뉴 입력받음
			printBar();
			String name, company;
			int number;
			switch(menu) {
			case 1: 
				//선택한 메뉴에 대한 기능 실행
				int optionMenu = 1;
				while(optionMenu == 1) {
				//1.번호 추가
				scan.nextLine();//엔터처리
				System.out.print("이름 : ");//성명, 직장 입력
				name = scan.nextLine();
				System.out.print("회사 : ");
				company = scan.nextLine();
				System.out.print("전화번호 : ");
				number = scan.nextInt();
				
				PhoneBook book = new PhoneBook(name, company, number);
				list.add(book);
				
				System.out.println("전화번호를 추가로 더 입력하시겠습니까?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				optionMenu = scan.nextInt();
				}
				
				break;
			case 2:
				//2. 번호 수정
				System.out.print("수정하려는 전화번호의 이름을 입력해주세요.");
				scan.nextLine();//엔터처리?
				name = scan.nextLine();
				printBar();
				int index = list.indexOf(name);
				if(index == -1) {
					System.out.println("일치하는 게시글이 없습니다.");
					continue;
				}
				PhoneBook tmp = list.get(index);
				break;
				
				//이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
	
				//수정할 전화번호부를 선택
	
				//서브 메뉴 출력
	
				//서브 메뉴 선택
	
				//서브 메뉴 실행
				//1. 이름, 직장 수정
					//이름 직장 입력
	
					//이름, 직장을 수정
					
				//2. 기존 전화번호 수정
					//기존 전화번호들를 출력
	
					//수정할 전화번호를 선택
	
					//이름, 번호를 입력
	
					//선택한 전화번호 이름, 번호를 수정
				//3. 새 전화번호 추가
					//이름 번호를 입력
			
					//새 전화번호를 추가
				
			case 3:
				//3. 번호 삭제
				//이름을 입력
				
				//이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
		
				//삭제할 전화번호부를 선택
	
				//전화번호를 삭제
				break;
			case 4:
				//4. 번호 조회
				//이름을 입력
				System.out.print("조회하려는 전화번호의 이름을 입력해주세요.");
				scan.nextLine();//엔터처리?
				name = scan.nextLine();
				printBar();
				for(PhoneBook tm : list) {
					if(tm.getName().contains(name.trim())) {
						System.out.println(tm);
						System.out.println("===============");
					
					}
				}
				
				
				//이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
		
				//조회할 전화번호부를 선택
	
				//전화번호 조회
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				
			}
			
			
			
			
			
		}while(menu != 5);
			
	}
	public static void printMenu() {
		System.out.println("=======선택 메뉴=======");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.println("5. 종료");
		System.out.println("=====================");
		System.out.print("메뉴 선택 : ");
	}
	public static void printBar() {
		System.out.println("=====================");
	}


}
