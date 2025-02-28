package basebehavior;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Home {
	
	private ArrayList<Room> rooms;
	
	public Home() {
		this.rooms = createRooms();
		System.out.println(this.rooms);
	}
	
	public ArrayList<Appliance> createDevices() {
		try {
			 BufferedReader br = new BufferedReader(new FileReader("data/devices.txt")); 
				String line; 
				String[] data;
				Appliance device;
				ArrayList<Appliance> appliances = new ArrayList<Appliance>();
				while((line = br.readLine()) != null) {
					data = line.split(" ");
					device = new Appliance(data[0], data[1]);
					device.setVolume(Integer.parseInt(data[2]));
					appliances.add(device);
				}
				return appliances;

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return new ArrayList<Appliance>();
	}
	
	public ArrayList<Room> createRooms() {
		try {
			ArrayList<Appliance> devices = createDevices();
			BufferedReader br = new BufferedReader(new FileReader("data/rooms.txt"));
			ArrayList<Room> rooms = new ArrayList<Room>();
			String line;
			String[] data;
			Room room;
			while((line = br.readLine()) != null) {
				data = line.split(" ");
				room = new Room(data[0]);
				int numDevices = Integer.parseInt(data[1]);
				String[] deviceNames = br.readLine().split(" ");
				for(String name : deviceNames) {
					for(Appliance device : devices) {
						if(device.getName().equals(name) && device.getLocation().equals(data[0]))
							room.addAppliance(device);
					}
				}
				rooms.add(room);
			}
			return rooms;
				
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return new ArrayList<Room>();
	}
	
	public ArrayList<Room> getRooms() {
		return this.rooms;
	}
	
	public void doorBell() {
		System.out.println("Base door ring");
	}
	
	public void checkHome() {
		List<Room> occupiedRooms = this.rooms.stream().filter(r -> r.getUsers() > 0).collect(Collectors.toList());
		if(occupiedRooms.size() == this.rooms.size())
			System.out.println("Full house");
		else 
			System.out.println("Not full");
	}
	
	public static void main(String[] args) {
		Home home = new Home();
		Room bedroom = home.getRooms().get(1);
		Appliance tv = bedroom.getAppliance("TV");


		System.out.println("RUNNING SMARTHOME WITH COP");
		home.doorBell();

		//user in a room
		System.out.println("\n USER IN ROOM TEST ");
		bedroom.userEnter();
		home.doorBell();

		//user using the tv in the bedroom
		System.out.println("\n APPLIANCE ON TEST ");
		tv.switchState();
		tv.setVolume(21);
		home.doorBell();

		//back to the default behavior
		System.out.println("\n BASE BEHAVIOR TEST ");
		tv.switchState();
		home.doorBell();
		bedroom.userExit();
		System.out.println(" ");
		home.doorBell();

		/* BABY IN ROOM TEST */
		System.out.println("\n BABY TEST ");
		bedroom.userEnter();
		bedroom.babyInRoom();
		home.doorBell();
		bedroom.babyLeave();
		home.doorBell();
		bedroom.userExit();

		/* FULL HOME TEST */
		System.out.println("\n FULL HOME TEST ");
		for(Room r : home.getRooms()) {
			r.userEnter();
		}
		home.checkHome();
		home.doorBell();
		System.out.println(" ");
		bedroom.userExit();
		home.checkHome();
		home.doorBell();
		
	}
}
