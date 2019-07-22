package Model;

import java.util.Date;

public class Coordinator extends Person {

	private String password ;
	public Coordinator(long id , String firstName , String lastName,Date birthDate,Address address,String password) {
		super(id,firstName,lastName,birthDate,address);
		this.password = password;
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
