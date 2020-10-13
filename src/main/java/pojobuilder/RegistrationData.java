package pojobuilder;

public class RegistrationData {
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private int age;
	private String sex;
	
	/**
	 * Getters and Setters
	 */
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return ""
				+ "Firstname: " + firstname
				+ " Lastname: "  + lastname
				+ " Username: " + username
				+ " Password" + password
				+ " Age: " + age
				+ " Sex: " + sex;
	}

}
