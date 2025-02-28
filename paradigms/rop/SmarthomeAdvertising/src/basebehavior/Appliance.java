package basebehavior;

public class Appliance {
	String name;
	boolean state;
	int volume;
	String location;
	
	public Appliance(String name, String location) {
		this.name = name;
		this.volume = 50;
		this.state = false;
		this.location = location;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void switchState() {
		this.state = !this.state;
		if(state)
			//activate in use
			state = state;
		else
			//deactivate inuse
			state = state;
	}
	
	public void setVolume(int level) {
		this.volume = level;
	}
	
	public void setLocation(String roomName) {
		this.location = roomName;
	}
	
	public void playSound(String message) {
		int tempVolume = this.volume;
		if(tempVolume == 0) 
			this.setVolume(60);
		String display = this.state ? "on" : "off";
		System.out.println(this.location +"'s " + this.name + " is " + display +"!!");
		System.out.println(message + " output on " + this.location + "'s " + this.name + " at " + this.volume + "% volume" ); 
	}
	
	
}
