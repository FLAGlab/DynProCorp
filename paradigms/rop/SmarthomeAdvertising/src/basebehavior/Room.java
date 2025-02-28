package basebehavior;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Room {
	private String name;
	ArrayList<Appliance> appliances;
	int users;
	boolean baby;
	
	public Room(String name) {
		this.name = name;
		this.appliances = new ArrayList<Appliance>();
		this.users = 0;
		this.baby = false;
	}
	
	public void checkState() {
		int num;
		if(this.users == 0)
			num = 0; //deactivate
		//activate
	}
	
	public void userEnter() {
		this.users += 1;
		this.checkState();
	}
	
	public void userExit() {
		this.users = Math.max(0, this.users - 1);
		this.checkState();
	}
	
	public int getUsers() {
		return this.users;
	}
	
	public Appliance getAppliance(String name) {
		return this.appliances.stream().filter(a -> a.getName().equals(name)).collect(Collectors.toList()).get(0);
	}
	
	public void addAppliance(Appliance device) {
		this.appliances.add(device);
	}
	
	public void playsound() {
		System.out.println("-");
	}
	
	public void babyInRoom() {
		this.baby = true;
		this.userEnter();
		System.out.println("BabyInRoom");
	}
	
	public void babyLeave() {
		this.baby = false;
		this.userExit();
		System.out.println("Not babyInRoom");
		
	}
}
