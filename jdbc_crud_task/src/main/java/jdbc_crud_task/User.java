package jdbc_crud_task;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private String address;
	private String facebookpassword;
	private String whatsuppassword;
	private String snappassword;
	private String twitterpassword;

	public String getSnappassword() {
		return snappassword;
	}

	public void setSnappassword(String snappassword) {
		this.snappassword = snappassword;
	}

	public String getTwitterpassword() {
		return twitterpassword;
	}

	public void setTwitterpassword(String twitterpassword) {
		this.twitterpassword = twitterpassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFacebookpassword() {
		return facebookpassword;
	}

	public void setFacebookpassword(String facebookpassword) {
		this.facebookpassword = facebookpassword;
	}

	public String getWhatsuppassword() {
		return whatsuppassword;
	}

	public void setWhatsuppassword(String whatsuppassword) {
		this.whatsuppassword = whatsuppassword;
	}

}
