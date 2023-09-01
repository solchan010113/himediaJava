package com.javaex.phonebook;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Service {
	
	Scanner sc = new Scanner(System.in);
	List<PersonVO> list = null ;
	PersonDAO personDAO = new PersonDAO();
	
	public void run() throws IOException {
		int num = 0;
		do {
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.수정 6.종료");
			System.out.print(">메뉴번호 :");
			num = sc.nextInt();
			switch(num) {
			case 1 : showContact();
					 break;
			case 2 : addContact();
			 		 break;
			case 3 : removeContact();
			 		 break;
			case 4 : searchContact();
			 		 break;
			case 5 : updateContact();
					 break;
			case 6 : System.out.println("안녕히가세요");
			         break;
			default : System.out.println("다시.");
			}
		} while(num != 6);
	}
	
	public void showContact() {
		System.out.println("<1.리스트>");
		list = personDAO.selectPersonList();
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public void addContact() {
		System.out.println("<2.등록>");
		System.out.print(">이름 : ");
		String name = sc.next();
		System.out.print(">휴대전화 : ");
		String hp = sc.next();
		System.out.print(">회사전화 : ");
		String company = sc.next();
		PersonVO person = new PersonVO(name,hp,company);
		int count = personDAO.insertPerson(person);
		if(count < 0) System.out.println("등록 실패");
		else System.out.println("["+count+"건이 등록되었습니다.]");
	}
	
	public void updateContact() {
		System.out.println("<5.수정>");
		list = personDAO.selectPersonList();
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.print(">번호 : ");
		int personId = sc.nextInt();
		System.out.print(">이름 : ");
		String name = sc.next();
		System.out.print(">휴대전화 : ");
		String hp = sc.next();
		System.out.print(">회사전화 : ");
		String company = sc.next();
		PersonVO person = new PersonVO(personId,name,hp,company);
		int count = personDAO.updatePerson(person);
		if(count < 0) System.out.println("수정 실패");
		else System.out.println("["+count+"건이 수정되었습니다.]");
	}
	
	public void removeContact() {
		System.out.println("<3.삭제>");
		System.out.print(">번호 : ");
		int removeNum = sc.nextInt();
		int count = personDAO.deletePerson(removeNum);
		if(count < 0) System.out.println("삭제 실패");
		else System.out.println("["+count+"건이 삭제되었습니다.]");
	}

	public void searchContact() {
		System.out.println("<4.검색>");
		System.out.print(">이름 : ");
		String name = sc.next();
		list = personDAO.selectSearchPersonList(name);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	
}
