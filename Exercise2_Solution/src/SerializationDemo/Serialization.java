package SerializationDemo;

import Model.Item;

import java.io.*;
import java.util.*;

public class Serialization implements Serializable {

	public void serialize(ArrayList<Object> lists, String fileName) throws IOException{
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
			
			out.writeObject(lists);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("the file u are looking for does Not Exist ! - Sooooorry ");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Object> deserialize(String fileName) {
		
		ArrayList<Object> it = new ArrayList<>() ;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName)) ){
			it =(ArrayList<Object>)in.readObject() ;
		
			System.out.println("***"+it);
		}catch (IOException | ClassNotFoundException ex) {
			System.out.println("not Able to Deserialize the file"+fileName);
			System.out.println(ex.getMessage());
			
		}
		
		
		return it ;
	}
	
	 
     public Serialization() {
    	 super();
    	 
     }
     
     
     
}