package birch; 


public class MountainBike extends Bicycle {
        
    // the MountainBike subclass adds one field
    public int seatHeight;

    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight,
                        int startCadence,
                        int startSpeed,
                        int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }   
        
    // the MountainBike subclass adds one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }   
        
    // the MountainBike subclass adds one method
    public String toString() {
	    String output = "";
	    
	    output += "XCadence: " + Integer.toString(super.cadence);

	    output += "Height: " + Integer.toString(seatHeight);

	    output += " " + super.toString();

	    return output;
    }   
    
    public void throwNow()
    {
		throw new TrmException("Exception thrown by throwNow()");
    }
}
