package Model;
import java.util.Date;



public class Driver extends Person{
	
	/**
	 * Is the driver has valid license
	 */	
	private boolean hasValidLicense;
	private boolean driverInUse;
	private String password;
    public Driver(long id, String firstName, String surname, Date birthDate, Address address,
    		boolean hasValidLicense) 
    {
		super(id, firstName, surname, birthDate, address);
		this.hasValidLicense = hasValidLicense;
		this.driverInUse = false;
	}


	public Driver(long id) {
		super(id);
	
	}


	/********************** Getters/Setters of class*****************************/
	public String getPassword()	{
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	public boolean getHasValidLicense() {
		return hasValidLicense;
	}

	public void setDriverInUse(boolean isDriverInUse) {
		this.driverInUse = isDriverInUse;
	}
	
	public boolean isDriverInUse() {
		return this.driverInUse;
	}
	public void setHasValidLicense(boolean hasValidLicense) {
		this.hasValidLicense = hasValidLicense;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
}
