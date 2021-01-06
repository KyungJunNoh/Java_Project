package abc;

public class Students {
	private String id,password,name, callnum, birth,stunum,gender,major;
	
	public Students(String id, String password, String name, String callnum, String birth, String stunum, String gender,
			String major) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.callnum = callnum;
		this.birth = birth;
		this.stunum = stunum;
		this.gender = gender;
		this.major = major;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCallnum() {
		return callnum;
	}

	public void setCallnum(String callnum) {
		this.callnum = callnum;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getStunum() {
		return stunum;
	}

	public void setStunum(String stunum) {
		this.stunum = stunum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public static void main(String[] args) {
		
	}

}
