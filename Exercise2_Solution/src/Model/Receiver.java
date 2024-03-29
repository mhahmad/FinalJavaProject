package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import Utils.Constants;
//ADAM
public class Receiver extends Person implements Serializable
{
	/**
	 * Receiver e-mail for announcing about the parcel
	 */
	private String email;
	/**
	 * List of received items of the person
	 */
	ArrayList<Item> receivedItems;
	
	
	/**
	 * Full constructor
	 * @param id
	 * @param firstName
	 * @param surname
	 * @param birthDate
	 * @param address
	 * @param email
	 */
	public Receiver(long id, String firstName, String surname, Date birthDate, Address address, String email) {
		super(id, firstName, surname, birthDate, address);
		setEmail(email);
		receivedItems = new ArrayList<Item>();
	}
	
	/**
	 * Partial constructor
	 * @param id
	 */
	public Receiver(long id) {
		super(id);
	}

	/**
	 * Update list of item when a parcel arrive to destination
	 * item must appear only once at the list
	 * if the new parcel include some items that already appear, need to change only the quantity
	 * @param sp
	 */
	public void updateReceivedItems(Parcel p) {
		for(Item item:p.listOfItem) 
		{
			receivedItems.add(item);
		}
	}
	
	
	/**
	 * Check that email is valid.
	 * Email must be in the form : example_12@walla.com
	 * Ending can be only com/co.il
	 * Server can be only: gmail/walla/hotmail
	 * */
	public boolean checkEmailIsValid(String email) {
		// TODO 
		char c;
		String length="";
		boolean serverCorrectness=false;
		int pos=0;
		if (email.isEmpty())
			return false;
		for (int i=0 ; i<email.length(); i++){
			c=email.charAt(i);
			if (i==0 && c=='@')
				return false;
			/*reach to position of the ending email name*/
			else if (c=='@') {
				pos=i;
				break;
			}
		}
		/*inValid email*/
		if (pos==0) return false;
		else
		{
			/*Getting the server name*/
			String server=email.substring(pos+1,email.indexOf("."));
			for (String allow : Constants.ALLOWED_SERVER )
				if (server.equals(allow)){
					length=allow;
					serverCorrectness=true;
					break;
				}
			/*check if server match with one of the allowed option*/
			if (!serverCorrectness)return false;
			/*Check ending*/
			serverCorrectness=false;
			String end=email.substring(pos+1+length.length()+1, email.length());
			for (String allow : Constants.ALLOWED_ENDING_EMAIL )
				if (end.equals(allow)){
					serverCorrectness=true;
					break;
				}
			if (!serverCorrectness)return false;
		}
		return true;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<Item> getReceivedItems()
	{
		return this.receivedItems;
	}
	
	
	public void setEmail(String email) {
		if(checkEmailIsValid(email))
			this.email =email;
		else 
			this.email = null;
	}
	


}
