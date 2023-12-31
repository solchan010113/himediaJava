import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Service {
	
	Scanner sc = new Scanner(System.in);
	List<Phone> list = new ArrayList<Phone>();
	
	public void run() throws IOException {
		getContact();
		int num = 0;
		do {
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.print(">메뉴번호 :");
			num = sc.nextInt();
			switch(num) {
			case 1 : showContact(list);
					 break;
			case 2 : addContact();
			 		 break;
			case 3 : removeContact();
			 		 break;
			case 4 : searchContact();
			 		 break;
			case 5 : System.out.println("안녕히가세요");
			         break;
			default : System.out.println("다시.");
			}
		} while(num != 5);
	}
	
	public void showContact(List<Phone> list) {
		System.out.println("<1.리스트>");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+1+".\t"+list.get(i));
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
		list.add(new Phone(name,hp,company));
		System.out.println("[등록되었습니다.]");
		saveContact();
	}
	
	public void removeContact() {
		System.out.println("<3.삭제>");
		System.out.print(">번호 : ");
		int removeNum = sc.nextInt();
		list.remove(removeNum-1);
		System.out.println("[삭제되었습니다.]");
		saveContact();
	}

	public void searchContact() {
		System.out.println("<4.검색>");
		System.out.print(">이름 : ");
		String name = sc.next();
		List<Phone> searchList = list.stream()
								.filter(p -> p.name.contains(name))
								.collect(Collectors.toList());
		showContact(searchList);
	}
	
	public void getContact() throws IOException {
		 
			FileReader fr = new FileReader("./PhoneDB.txt");
			int a;
			String phone ="";
			
			while((a = fr.read()) != -1) {
				phone += (char)a;
			}
			if(!phone.equals("")) {
				for(String str : phone.split("\r\n")) {
					String[] strArr = str.split(",");
					list.add(new Phone(strArr[0],strArr[1],strArr[2]));
				}
			}
	}
	
	public void saveContact()  {
		
		
		
			try {
				FileWriter fw = new FileWriter("./PhoneDB.txt");
				for(Phone phone : list) {
					fw.write(phone.name+","+phone.hp+","+phone.company+"\r\n");
				}
				fw.flush();
				fw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
