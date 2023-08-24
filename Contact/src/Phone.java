
public class Phone {
	
	String name;
	String hp;
	String company;
	
	public Phone(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	@Override
	public String toString() {
		return name+"\t"+hp+"\t"+company;
	}

}
