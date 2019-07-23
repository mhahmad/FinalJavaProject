package SerializationDemo;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Serialization {

	public void serialize(Delivery div , String fileName) {
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
			
			out.writeObject(div);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("the file u are looking for does Not Exist ! - Sooooorry ");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
     public Serialization() {
    	 super();
    	 
     }
     
     
     
}
