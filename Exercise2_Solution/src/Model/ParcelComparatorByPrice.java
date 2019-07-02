package Model;

import java.util.Comparator;

public class ParcelComparatorByPrice implements Comparator<Parcel>{
	
	@Override
	public int compare(Parcel o1, Parcel o2) {
		// TODO Auto-generated method stub
		return (int)(o1.getCurrentCost()-o2.getCurrentCost());
	}

}
