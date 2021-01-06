package abc;

public class Stuid {
	String join_id,join_pwd;

	public Stuid(String join_id, String join_pwd) {
		super();
		this.join_id = join_id;
		this.join_pwd = join_pwd;
	}

	public String getJoin_id() {
		return join_id;
	}

	public void setJoin_id(String join_id) {
		this.join_id = join_id;
	}

	public String getJoin_pwd() {
		return join_pwd;
	}

	public void setJoin_pwd(String join_pwd) {
		this.join_pwd = join_pwd;
	}
}
