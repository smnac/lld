package cab;

public class Ride {
	
	private int id;
	private int origin;
	private int destination;
	private int seats;
	private RideStatus rideStatus;
	static final int AMT_PER_KM=20;
	
	public Ride() {
		id=origin=destination=seats=0;
		rideStatus=RideStatus.IDLE;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RideStatus getRideStatus() {
		return rideStatus;
	}
	public void setRideStatus(RideStatus rideStatus) {
		this.rideStatus = rideStatus;
	}
	public void setOrigin(int origin) {
		this.origin = origin;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public double calculateFare(boolean isPriorityCustomer)
	{
		int dist=destination-origin;
		
		if(seats<2)
		{
			return dist * AMT_PER_KM * (isPriorityCustomer?0.75:1);
		}
		
		return dist*seats*AMT_PER_KM* (isPriorityCustomer?0.5:0.75);
	}
	
	
	
	

}
