package cab;
import java.util.ArrayList;

public class TestRide {

	public static void main(String[] args) {
		Rider rider1 = new Rider(1,"Adarsh");
		Rider rider2 = new Rider(2,"Mala");
		Rider rider3 = new Rider(3,"Uday");
		Rider rider4 = new Rider(4,"Savitha");
		ArrayList<Rider> riders = new ArrayList<>();
		riders.add(rider1);
		riders.add(rider2);
		riders.add(rider3);
		riders.add(rider4);
		
		
		Driver driver1 = new Driver("Guru Raj");
		Driver driver2 = new Driver("Manju");
		
		
		CabCompany uber=new CabCompany(2, riders); 
		
		uber.createRide(1,1, 10, 30, 2);
		uber.updateRide(1,1, 10, 40, 2);
		System.out.println(uber.closeRide(1));
		uber.withDrawRide(1,1);
		
		
		
		

	}

}
