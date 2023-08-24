import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		System.out.println("***전화번호 관리 프로그램***");
		Service service = new Service();
		service.run();
	}

}
