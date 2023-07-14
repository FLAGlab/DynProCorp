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

If there are no occupied rooms the advertising should happen in the hallway. This is the base case for all following cases.

- environment-1: 
  - Advertising on the Chime in the Hall
  - **Data-file**: `case-1-env-1.txt`
  - **Expected output file**: `out-1-env-1.txt`


### Case 2 - Home alone

If there is a single occuppied room. Upon a `ring()` event, the advertising should be observed only in the occupied room.

- environment-1: 
  - Advertising on the TV with sound for the Livingroom as the only occupied room
  - **Data-file**: `case-2-env-1.txt`
  - **Expected output file**: `out-2-env-1.txt`

### Case 3 - Mr. and Ms. Smith

Multiple rooms occupied. Upon a `ring()` event, the advertising should be observed in each of the occupied rooms. 

- environment-1: 
  - Advertising on the TV with sound for the Livingroom and on the Bathroom radio with sound
  - **Data-file**: `case-3-env-1.txt`
  - **Expected output file**: `out-3-env-1.txt`


### Case 4 - Snail's strategy

Moving users from an occupied room to a free room should change the status of the rooms. The advertising should change accordingly only advertising only on the occupied room. 

- environment-1: 
Starting from the user at the Bedroom, a `ring()` event should make sound on the tv. Moving the user to the bathroom should now occupy said room. A `ring()` event should now advertise with sound on the radio. The results of the tests should be.
  - Advertising on the TV with sound for the Bedroom
  - Bedroom is occupied and Bathroom free
  - Move user from Bedroom to Bathroom
  - Bedroom becomes free and Bathroom becomes occupied
  - Advertising on the Radio with sound for the Bathroom
  - **Data-file**: `case-4-env-1.txt`
  - **Expected output file**: `out-4-env-1.txt`


### Case 5 - Ex-machina

Turning on a device in a room, changes the behavior of the device itself.

- environment-1: 
Adversign on a tv that is functioning will not advertize with sound but displaying a message on the screen
  - Advertising on the TV with sound for the Bedroom
  - Turn tv on (has no effect)
  - Advertising on the TV displaying message on the screen for the Bathroom
  - **Data-file**: `case-5-env-1.txt`
  - **Expected output file**: `out-5-env-1.txt`

### Case 6 - Click

Adding a new device on a room

- environment-1: 
Add a light that advertices by turning on the light with different intensity levels.
  - Turn tv on (has no effect)
  - Advertising on the TV displaying message on the screen for the Bedroom
  - Adding a new light device to the Bedroom
  - Advertising by turning on the lights to a given intensity
  - **Data-file**: `case-6-env-1.txt`
  - **Expected output file**: `out-6-env-1.txt`

### Case 7 - The boss bay

Adding a new user that requires a different behavior for rooms. When babys are in a room, no sound advertising should happen.

- environment-1:
If there is a baby in a room, then no sound will be made by devices in said room not to disturb the baby
  - Adversiting on the Livingroom's tv with sound
  - Add baby to livingroom
  - Adversising on the Livingroom's tv by displaying a message
  - **Data-file**: `case-7-env-1.txt`
  - **Expected output file**: `out-7-env-1.txt`

### Case 8 - Hall pass

Moving the users to the hall will revert to the base behavior (Case 1)

- environment-1:
Whenever there are multiple users in a room, and they all move to the hall, `ring()` are advertised in the hall.
  - Adversiting on the Livingroom and Bathroom
  - Move all users to the hall
  - Advertising on the Chime in the Hall
  - **Data-file**: `case-8-env-1.txt`
  - **Expected output file**: `out-8-env-1.txt`



