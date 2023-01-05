package db.day1;

import java.sql.*; //데이터베이스 연동 관련 모든 클래스
import java.util.ArrayList;

import lombok.Data;

public class DBTest1 {

	static Statement stmt = null; //sql 구문을 실행하는 역할 >> 전달하기 위해서 필요함
	static ResultSet rs = null; //select 할때, 결과를 담아야 하므로 필요하다.
	static PreparedStatement pstmt = null; //statement객체의 기능 향상을 위해 필요함 
	
	public static void main(String[] args) {
		Connection con = null;//Connection 객체생성
		 /* mysql : DBMS
         * localhost : 내부 로컬 주소-> 프로그램이 실행되는 서버와 DB가 같은 PC에 있는 경우
         * university : 데이터베이스명 
         */
		String url = "jdbc:mysql://localhost/university";
        String id = "root";
        String pw = "root";
        ArrayList<Student1> list = null;
        con = connect(url, id, pw);
        
        try {
			stmt = con.createStatement();
			
			insertStudent(con,"2022160006","바길동",1,"재학","2022160002");
			
			
			list = selectAllStduent(con);
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        
        connectClose(con);
	}
	
	public static Connection connect(String url,String id,String pw) {
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver"); //JDBC 드라이버를 메모리에 동적으로 로딩하기 위해서 Class.forName()을 이용한다. 
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("[연결 성공]");
		}
		catch(ClassNotFoundException e){
		    System.out.println("[드라이버 로딩 실패]");
		}
		catch(SQLException e){
		    System.out.println("[에러: " + e +"]");
		}
		return con;
	}
	
	public static void connectClose(Connection con) {
		try{
            if( con != null && !con.isClosed()){
                con.close();
                System.out.println("[연결 해제]");
            }
        }
        catch( SQLException e){
            e.printStackTrace();
        }
	}
	
	public static ArrayList<Student1> selectAllStduent(Connection con) throws SQLException {
		String sql = "select st_num, st_name, st_semester, st_state, st_pr_num from student";
		//pstmt.setString(1,조건);
		//pstmt.setString(2,조건);
		//rs = pstmt.executeQuery(sql);
		rs = stmt.executeQuery(sql);
		ArrayList<Student1> list = new ArrayList<Student1>();
		while(rs.next()) {
			String st_num = rs.getString(1);
			String st_name = rs.getString(2);
			int st_semester = rs.getInt(3);
			String st_state = rs.getString(4);
			String st_pr_num = rs.getString(5);
			Student1 std = new Student1(st_num, st_name, st_semester, st_state, st_pr_num);
			list.add(std);
		}
		return list;
	}
	public static void insertStudent(Connection con, String st_num, String st_name,
			int st_semester, String st_state, String st_pr_num) throws SQLException{
		String sql = "insert into student(st_num, st_name, st_semester, "+
				"st_state, st_pr_num) values(?, ?, ?, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, st_num);
				pstmt.setString(2, st_name);
				pstmt.setInt(3, st_semester);
				pstmt.setString(4, st_state);
				pstmt.setString(5, st_pr_num);
				
				int count = pstmt.executeUpdate();
				if(count == 0) {
					System.out.println("[추가 실패]");
				}else {
					System.out.println("[추가 성공]");
				}
	}
}
@Data
class Student1{
	private String st_num;
	private String st_name;
	private int st_semester;
	private String st_state;
	private String st_pr_num;

	public Student1(String st_num, String st_name, int st_semester, String st_state, String st_pr_num) {
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_semester = st_semester;
		this.st_state = st_state;
		this.st_pr_num = st_pr_num;
	}
	
}