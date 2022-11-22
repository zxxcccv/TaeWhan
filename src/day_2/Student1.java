package day_2;

import lombok.Data;

@Data
public class Student1 {
	private String name;
	private String birth;
	
	public Student1(String name, String birth) {
		super();
		this.name = name;
		this.birth = birth;
	}

	public Student1(String name) {
		super();
		this.name = name;
	}
	public void update(String name, String birth) {
		this.name = name;
		this.birth = birth;
	}
	
}
