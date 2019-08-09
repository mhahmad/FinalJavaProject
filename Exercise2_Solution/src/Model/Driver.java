package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;



public class Driver extends Person implements Serializable{
	
	/**
	 * Is the driver has valid license
	 */	
	private HashMap<WareHouse,Integer> warehousesToGo;
	private boolean hasValidLicense;
	private boolean driverInUse;
    public Driver(long id, String firstName, String surname, Date birthDate, Address address,
    		boolean hasValidLicense) 
    {
		super(id, firstName, surname, birthDate, address);
		this.hasValidLicense = hasValidLicense;
		this.driverInUse = false;
		warehousesToGo = new HashMap<WareHouse,Integer>();
	}
    
	public Driver(long id) {
		super(id);
	
	}


	/********************** Getters/Setters of class*****************************/
	public HashMap<WareHouse,Integer> getWareHousesToGo(){
		return warehousesToGo;
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
