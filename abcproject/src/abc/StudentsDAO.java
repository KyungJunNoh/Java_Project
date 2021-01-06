package abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentsDAO {
	ArrayList<Students> list;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection con;

	public StudentsDAO() {
		list = new ArrayList<>();
		getConnection();
	}

	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "NGJ", "12345");
		} catch (Exception e) {
			System.out.println("오류");
		}
		return con;
	}

	// insert
	public int insert(Students s) {
		String sql = "insert into Students"
				+ "(id,password,name,callnum,birth,stunum,gender,major)"
				+ " values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, s.getId());
			ps.setString(2, s.getPassword());
			ps.setString(3, s.getName());
			ps.setString(4, s.getCallnum());
			ps.setString(5, s.getBirth());
			ps.setString(6, s.getStunum());
			ps.setString(7, s.getGender());
			ps.setString(8, s.getMajor());

			if (ps.executeUpdate() >= 1) {
//				JOptionPane.showMessageDialog(null, "환영합니다");
				return 1;
			}
		} catch (SQLException e) {
			return 0;
//			JOptionPane.showMessageDialog(null, "중복된 아이디가 있습니다.");
//			e.printStackTrace();
		}
		return 0;
	}
	
	
	//로그인
	public void login(Stuid s) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con =DriverManager.getConnection(dburl,"NGJ","12345");
			String sql ="select * from students where id = ? and pwd = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1,s.getJoin_id());
			ps.setString(2,s.getJoin_pwd());
			rs = ps.executeQuery();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String args[]) {

	}
}
