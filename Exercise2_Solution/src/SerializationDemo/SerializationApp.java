package SerializationDemo;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import Model.Driver;
import Model.Item;
import Model.Receiver;
import Model.Vehicle;
import Model.WareHouse;

public class SerializationApp implements Serializable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Delivery D1 = new Delivery() ; 
		 ArrayList<Object> list1 = D1.getData() ;
		// ArrayList<WareHouse> list2 = D1.getWareHouses();
		System.out.println("the size of array Items : "+D1.getAllItems().size());
		System.out.println("the size of array WareHouse : "+D1.getWareHouses().size());
		System.out.println(" just created the delivery Instance ! ");
		//listt.addAll((Collection<?>) D1.getAllItems()) ;
	//	listt.addAll( D1.getWareHouses());
		//System.out.println("the lllllist is : "+list1);
		Serialization demo = new Serialization() ;
	
			try {
			demo.serialize(list1, "src/SerializationDemo/Del2.ser");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			return ;
		}
	//	demo.serialize(list2, "src/SerializationDemo/Del2.ser");
		System.out.println(" Serialization Done -I think! ");
		
		ArrayList<Object> List = demo.deserialize("src/SerializationDemo/Del2.ser");
		System.out.println("is the deserialization successfull  ?");
	//	System.out.println("AllWAreHousse  "+D2.getWareHouses());
	
		
		System.out.println("AllItems 's -Size   "+List.size());
		
     	ArrayList<WareHouse> wh = (ArrayList<WareHouse>) List.get(0) ;
	
  	    ArrayList<Item> item = (ArrayList<Item>) List.get(1) ;
		System.out.println(wh+"**\n"+item);
		
		ArrayList<Driver> Drivers = (ArrayList<Driver>)List.get(2) ;
		ArrayList<Vehicle> vehicles = (ArrayList<Vehicle>) List.get(3);
		 HashMap<Integer, WareHouse> allWareHouses = (HashMap<Integer,WareHouse>)List.get(4);
		 HashMap<String,Receiver> allReceiversMap = (HashMap<String,Receiver>)List.get(5);
		System.out.println("the Drivver are : "+Drivers);
		System.out.println("the vihcles : "+ vehicles);
		System.out.println("the Warhouses Map : "+ allWareHouses);
		System.out.println("All Receivers : " + allReceiversMap);
		System.out.println("SIZE OF MAP : " + allReceiversMap.size());
 
	}

	
	
}