package birch; 

public class Dog {
        
    // the Bicycle class has three fields
	protected String name;
        
    // the Bicycle class has one constructor
    public Dog(String Name) {
        name = Name;
    }

    public String getName() {
    	String output = "";
	    output += "Name is: " + name;
	    return output;
    }
    
    public void setName(String Name) {
    	name = Name;
    }
        
}
