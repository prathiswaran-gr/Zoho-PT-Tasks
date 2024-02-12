public interface Vehicle{

	final static double economySpeed = 50.0;
	final static int fuelCapacity = 50;
	
	void start();
	void move(int distance);
	void stop();
	
	

}

// Interface supports multiple inheritance where abstract classes not
// Interface achieves 100% abstraction
// Interface should have method definition and default/static methods contains body
// The fields in interface should be final static which means that, since Interfaces doesn't instantiate object so the fields were static and those field cannot be re-assigned or changed.
// interface members were public in default
// We can do the nested interface, class -> interface and that can be accessed using implements keyword eg) implements className.interfaceName
// Yes, we can define variables in interfaces but they are final and static in default.

