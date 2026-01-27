package utils;

public class User {

	private String role;
	private String username;
	private String password;

	public User(String role, String username, String password) {
		this.role = role;
		this.username = username;
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	
	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [role=" + role + ", username=" + username + ", password=" + password + "]";
	}

	

}
