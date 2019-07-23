package SerializationDemo;

public class SerializationApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Delivery D1 = new Delivery() ; 
		System.out.println(" just created the delivery Instance ! ");
		
		Serialization demo = new Serialization() ;
		demo.serialize(D1, "src/SerializationDemo/Del1.ser");
		System.out.println(" Done - think! ");
	}

}
