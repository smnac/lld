package cab;
import java.util.ArrayList;

public class Rider extends Person{
	private int riderId;
	private ArrayList<Ride> completedRides;
	private Ride currentRide;
	

	public Rider(int id,String name) {
		super(name);
		riderId=id;
		completedRides=new ArrayList<Ride>();
		
	}
	
	public int getRiderId() {
		return riderId;
	}
	
	
	public void createRide(int id,int org,int dst,int seats)
	{
		Ride ride=new Ride();
		ride.setId(id);
		ride.setOrigin(org);
		ride.setDestination(dst);
		ride.setSeats(seats);
		ride.setRideStatus(RideStatus.CREATED);
		setCurrentRide(ride);
		
	}
	public void updateRide(int id,int org,int dst,int seats)
	{
		if(getCurrentRide().getRideStatus()==RideStatus.WITHDRAWN)
		{
			System.out.println("Error!! Cancelled rides can't be updated");
			return;
		}
		
		if(getCurrentRide().getRideStatus()==RideStatus.COMPLETED)
		{
			System.out.println("Already Completed rides can't be updated");
			return;
		}
		
		createRide(id,org,dst,seats);
		
	}
	
	public void withDrawRide(int id)
	{
		if(id!=getCurrentRide().getId())
		{
			System.out.println("Specified ride is not current ride and hence can't be cancelled");
			return;
		}
		
		if(getCurrentRide().getRideStatus()!=RideStatus.CREATED)
		{
			System.out.println("Ride is not ongoing and hence can't be cancelled");
			return;
		}
		
		getCurrentRide().setRideStatus(RideStatus.WITHDRAWN);
	}
	
	public  double closeRide()
	{
		if(getCurrentRide().getRideStatus()!=RideStatus.CREATED)
		{
			System.out.println("This ride is not ongoing and hence can't be closed");
			return 0;
		}
		
		getCurrentRide().setRideStatus(RideStatus.COMPLETED);
		
		completedRides.add(getCurrentRide());
		return getCurrentRide().calculateFare(completedRides.size()>=10);
		
	}
	
	

	public Ride getCurrentRide() {
		return currentRide;
	}

	public void setCurrentRide(Ride currentRide) {
		this.currentRide = currentRide;
	}
	
	

}
