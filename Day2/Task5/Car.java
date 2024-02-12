class Car implements Vehicle{
	
	
	@Override
	public void start(){
	
		System.out.println("Engine started");
	}
	
	@Override
	public void move(int distanceCovered){
	
		System.out.println("Car covered "+distanceCovered+" km distance");
	}
	
	@Override
	public void stop(){
		
		System.out.println("Car Stopped");		
	}
	
	@Override
	public String toString(){
		return "Economy speed = "+economySpeed +" km/h Fuel capacity = "+fuelCapacity+" litres";
	
	}

}
