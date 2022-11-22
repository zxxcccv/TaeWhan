package day_2;

import lombok.Data;

@Data
public class StudentLog {
	
	private Student std;
	private String state;
	
	public StudentLog(String name, String birthday, String state) {
		std = new Student(name, birthday);
		this.state = state;
		
	}
	public StudentLog(Student std, String state) {
		this.std = new Student(std);//깊은 복사를 하기위해
		this.state = state;
	}
	
}
