package SerializationDemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import Conotroller.SysData;
import Model.Address;
import Model.Driver;
import Model.Item;
import Model.Parcel;
import Model.Receiver;
import Model.SmallParcel;
import Model.Vehicle;
import Model.WareHouse;
import Utils.Constants;
public class Delivery implements Serializable {


	private ArrayList<Object> SaveData ;
	
	//  SysData sys = new SysData();
	//private ArrayList <Parcel> allParcels;
    ArrayList <Driver> allDrivers= new ArrayList<>(SysData.getInstance().allDrivers()) ;
    ArrayList <WareHouse> WareHouses = new ArrayList<>(SysData.getInstance().WareHouses()) ;
    ArrayList <Item> allItems = new  ArrayList<>(SysData.getInstance().allItems()) ; 
     ArrayList<Vehicle> allVehicles= new  ArrayList<>(SysData.getInstance().getVehicles()) ; 
      
      
   // HashMap<String, Parcel> allParcelsMap;
  //  HashMap<String,Vehicle> allVehiclesMap;
  HashMap<Integer, WareHouse> allWareHouses = new HashMap<>(SysData.getInstance().getWareHouesMap());
 //   HashMap<Long,Receiver> allReciversMap;
    
	
	//String[] o = {"hello" , "HRU?" } ;
 public ArrayList<WareHouse> getWareHouses() {
		return WareHouses;
	}
	
	
	public ArrayList<Object> getData() {
		return SaveData;
	}
	
	public void setWareHouses(ArrayList<WareHouse> wareHouses) {
		WareHouses = wareHouses;
	}
	public ArrayList<Item> getAllItems() {
		return allItems;
	}
	public void setAllItems(ArrayList<Item> allItems) {
		this.allItems = allItems;
	}
	
	
	//ArrayList<String> oo ;
    public Delivery() {
    	SaveData = new ArrayList<>();
    //	allParcelsMap = SysData.getInstance().getParcelsMap() ;
    //allVehiclesMap = SysData.getInstance().getVehclesMap() ;
    	//allWareHouses = SysData.getInstance().getWareHouesMap() ;
    	//allReciversMap = SysData.getInstance().getReceiversMap() ;
    	//allParcels = SysData.getInstance().allParcels() ;
    //	allDrivers = SysData.getInstance().allDrivers() ; 
    	//WareHouses = new ArrayList<>(sys.WareHouses()) ;
    //	allItems = new  ArrayList<>(sys.allItems()) ;
    SaveData.add(WareHouses) ;
    System.out.println(WareHouses);
    SaveData.add(allItems) ;
    System.out.println(allItems);
    SaveData.add(allDrivers) ;
    SaveData.add(allVehicles) ;
    SaveData.add(allWareHouses) ;
    	//SaveData.addAll(allItems);
    //	allVehicles = SysData.getInstance().getVehicles() ;
    	//long catalogID, String itemName,  double price, boolean hasFreeShipping,double itemWeight)
    	
    	//----------------------------------Adding Warehouse -----------------------
    	/*
    	addWarehouse	2	Acre		,Naftali,	57,	1999112
    	addWarehouse	3	,Yokneam		,Nitzan	,24,	1888112
    	addWarehouse	4	Haifa,		Eli	,	12	,1777112
    	addWarehouse	5	Holon		,Nitzan,	45,	1999131
    	addWarehouse	6	Raanana		,Haiem,	6,	7878787
    	addWarehouse	7	Tel_Aviv	,street2	,16,	7777777
    	addWarehouse	8	Nazareth	,s3		,14	,7777777
    	addWarehouse	9	Afula	,	s5		,15,	7777777
    	addWarehouse	10	Karmiel   	,s2		,13	,7777777
    	addWarehouse	11	Eilat   	,s62		,10,	7777777
    	addWarehouse	12	Sderot   	,s134	,12	,7777777
    	addWarehouse	13	Rahat   	,s524,	5	,7777777
    	
    	*/

    	/*
    	Address address7 = new Address(Utils.E_Cities.Afula,s5	,15,7777777) ;
    	Address address8 = new Address(Utils.E_Cities.Karmiel  ,s2	,13	,7777777) ;
    	Address address9 = new Address(Utils.E_Cities.Eilat  	,s62,10,	7777777) ;
    	Address address10 = new Address(Utils.E_Cities.Haifa,	Eli	,12	,1777112) ;
    	Address address11 = new Address(Utils.E_Cities.Sderot   ,s134,12	,7777777) ;
    	Address address12 = new Address(Utils.E_Cities.Rahat   ,s524,	5,7777777) ;
    	*/
    
    	/**
    	addItem	741258,	headphones,	450	,TRUE,	0.1
    	addItem	852145	,chargerTypeC,	100,	TRUE,	0.1
    	addItem	953555	,hp_monitror,	700	,FALSE,	5.5 
    	addItem	953555,	dell_monitror,	600	,FALSE,	4.3 
    	addItem	582999	iPad		3000	FALSE	1.2
    	addItem	670214	Jacket_Nike	120	TRUE	1
    	addItem	670213	Nike_Shoes1	350	TRUE	1.2
    	addItem	600233	Magic_Box1	5000	TRUE	18
    	addItem	600233	Magic_Box2	6000	TRUE	19
    	addItem	600234	item1    	2000	TRUE	2
    	addItem	600234	item2    	21	TRUE	2
    	addItem	600234	item3    	300	TRUE	32
    	addItem	600234	item4    	100	TRUE	4.2
    	addItem	600234	item5    	100	TRUE	4.2
    	addItem	600235	yitem1    	100	TRUE	9.4
    	addItem	600235	yitem2    	120	TRUE	4
    	addItem	600235	yitem3    	100	TRUE	5.1
    
    	*/
    	
        
    	//allWareHouses = SysData.getInstance().getWareHouesMap() ;
    	
    	/*
    	
    	if(!allItems.isEmpty() ||! WareHouses.isEmpty()) {
    	System.out.println("this is all wareHouses : "+WareHouses);
    	System.out.println("all Items  :  "+allItems);
    	
    	}else {
    		System.out.println("both Are null - empty ! !");
    	}
    	*/
    }
    
	
}