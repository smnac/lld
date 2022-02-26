package cab;
import java.util.ArrayList;

public class CabCompany {
	
	private int drivers;
	private ArrayList<Rider> riders;
	
	public CabCompany(int drivers, ArrayList<Rider> riders) {
		if(drivers<riders.size())
		{
			System.out.println("Warning! There are no sufficient drivers !!");
		}
		this.drivers = drivers;
		this.riders = riders;
	}
	
	public void createRide(int rid,int id,int org,int dst,int seats)
	{
		
		if(drivers==0)
		{
			System.out.println("No available drivers ride is not created");
			return;
		}
		
		for(Rider rider:riders)
			if(rider.getRiderId()==rid)
			{
				rider.createRide(id, org, dst, seats);
				drivers--;
				return;
			}
		
	}
	
	public void updateRide(int rid,int id,int org,int dst,int seats)
	{
		
		
		
		for(Rider rider:riders)
			if(rider.getRiderId()==rid)
			{
				rider.updateRide(id, org, dst, seats);
				drivers--;
				return;
			}
		
	}
	public void withDrawRide(int rid,int id)
	{
		
		
		
		for(Rider rider:riders)
			if(rider.getRiderId()==rid)
			{
				rider.withDrawRide(id);
				drivers++;
				return;
			}
		
	}
	public double closeRide(int rid)
	{
		
		
		
		for(Rider rider:riders)
			if(rider.getRiderId()==rid)
			{
				
				drivers++;
				return rider.closeRide();
			}
		
		return 0;
		
	}
	
	

}
