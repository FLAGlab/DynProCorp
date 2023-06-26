# Home Advertising Tests

Description of the smart home advertinsing exemplar examples

## Test set-up

The smart home set-up is used to define the a home by descriving each of the rooms and appliances in the home. Note that multiple instances of the same appliance can be used in different rooms, and that you could define different instances of the same room.

Each home environment is defined in its own `.txt` file `environment-XX.txt` (where the XX corresponds to the number of the environment).

Each environment descriptions starts with a line with two coma separated numbers, n and m, where m corresponds to the initial number of rooms n the home and m corresponds to the number of appliances. 

The following 3n lines describe the room. The first line is the _unique_ room name, the second line corresponds to the initial occupancy status of the room (i.e., occupied, free), the third line is a comma separated list containing the names of all devices in the room.

The following 3m lines describe a device. The first lines contais the _unique_ devices name, the second line is the initial devies' state (e.g., on, off), and the third line corresponds to the initial intensity leve of the device (e.g., volume, luminosity). All devices have one functionality called `advertise`.
 
## Use Cases


### Case 1 - Ferris Bueller's day off

If there are no occupied rooms the advertising should happen in the hallway.

- environment-1: 
  - Advertising on the TV with sound for the Bedroom as the only occupied room
  - **Data-file**: `case-1-env-1.txt`
  - **Expected output file**: `out-1-env-1.txt`


### Case 2 - Home alone

If there is a single occuppied room Upon a `ring()` event, the advertising should be observed in each of the occupied rooms.

- environment-1: 
  - Advertising on the TV with sound for the Bedroom as the only occupied room
  - **Data-file**: `case-1-env-1.txt`
  - **Expected output file**: `out-1-env-1.txt`

### Case 3 - Mr. and Ms. Smith

Multiple rooms occupied 

- environment-1: 
  - Advertising on the TV with sound for the Bedroom as the only occupied room
  - **Data-file**: `case-1-env-1.txt`
  - **Expected output file**: `out-1-env-1.txt`


### Case 4 - Snail's strategy

Moving users from an occupied room to a free room should change the status of the rooms. The advertising should change accordingly only advertising on occupied rooms. 

- environment-1: 
Starting from the user at the Bedroom, a `ring()` event should make sound on the tv. Moving the user to the bathroom should now occupy said room. A `ring()` event should now advertise with sound on the radio. The results of the tests should be.
  - Advertising on the TV with sound for the Bedroom
  - Bedroom is occupied and Bathroom free
  - Bedroom becomes free and Bathroom becomes occupied
  - Advertising on the Radio with sound for the Bathroom

### Case 5 - Ex-machina

Turning on a device in a room, changes the behavior of the device itself.

- environment-1: 
Adversign on a tv that is functioning will not advertize with sound but displaying a message on the screen
  - Advertising on the TV with sound for the Bedroom
  - Turn tv on (has no effect)
  - Advertising on the TV displaying message on the screen for the Bathroom

### Case 6 - Click

Adding a new device on a room

- environment-1: 
Add a light that advertices by turning on the light with different intensity levels.
  - Turn tv on (has no effect)
  - Advertising on the TV displaying message on the screen for the Bathroom

### Case 7 - The boss bay

Adding a new user that requires a different behavior for rooms. When babys are in a room, no sound advertising should happen.

- environment-1:


### Case 8 - Hall pass

Moving the users to the hall will rever to the base behavior (Case 1)

- environment-1:



