package SerializationDemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import Conotroller.SysData;
import Model.Driver;
import Model.Item;
import Model.Parcel;
import Model.Receiver;
import Model.SmallParcel;
import Model.Vehicle;
import Model.WareHouse;
import Utils.Constants;

public class Delivery implements Serializable {

	/**
	private static SysData instance;
	private ArrayList <Parcel> allParcels;
    private ArrayList <Driver> allDrivers;
    private ArrayList <WareHouse> WareHouses;
    private ArrayList <Item> allItems;
    private ArrayList<Vehicle> allVehicles ;

  
    HashMap<String, Parcel> allParcelsMap;
    HashMap<String,Vehicle> allVehiclesMap;
    HashMap<Integer, WareHouse> allWareHouses;
    HashMap<Long,Receiver> allReciversMap;
    
    */
	
	String[] o = {"hello" , "HRU?" } ;
	ArrayList<String> oo ;
    public Delivery() {
    	/**
    	allParcelsMap = SysData.getInstance().getParcelsMap() ;
    	allVehiclesMap = SysData.getInstance().getVehclesMap() ;
    	allWareHouses = SysData.getInstance().getWareHouesMap() ;
    	allReciversMap = SysData.getInstance().getReceiversMap() ;
    	allParcels = SysData.getInstance().allParcels() ;
    	allDrivers = SysData.getInstance().allDrivers() ; 
    	WareHouses = SysData.getInstance().WareHouses() ;
    	allItems = SysData.getInstance().allItems() ;
    	allVehicles = SysData.getInstance().getvehicles() ;
    	
    	
    	  allParcels = new ArrayList<Parcel>();
          allParcels.add(new SmallParcel("51565",null));
          allDrivers = new ArrayList<Driver>();
          WareHouses = new ArrayList<WareHouse>();
          WareHouses.add(Constants.BASE_WAREHOUSE);
          allItems = new ArrayList<Item>();
          allParcelsMap = new HashMap<String, Parcel>();
          allVehiclesMap = new HashMap<String, Vehicle>();
          allWareHouses = new HashMap<Integer, WareHouse>();
          allWareHouses.put(1, Constants.BASE_WAREHOUSE);
          allReciversMap = new HashMap<Long, Receiver>();
          allVehicles= new ArrayList(allVehiclesMap.values()) ;
     
              	*/
    	
    	oo= new ArrayList<>();
    	oo.add("hello");
    	oo.add("okoaskd") ;
    	
    }
    
	
}
