package Model;

import java.util.Date;

public class Coordinator extends Person {

	private String password ;
	public Coordinator(long id , String firstName , String lastName,String password) {
		super(id,firstName,lastName);
		this.password = password;
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "[ Name : " + this.getFirstName() + " " + this.getSurname() + " , ID : " + this.getId() + " ]";
	}

	
	

}
