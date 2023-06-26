# Home Advertisong Tests

Description of the home automation exemplar examples

## Test set-up

The home set-up is used to define the a home by descriving each of the rooms and appliances in the home. Note that multiple instances of the same appliance can be used in different rooms, and that you could define different instances of the same room.

Each home environment is defined in its own `.txt` file `environment-XX.txt` (where the XX corresponds to the number of the environment).

Each environment descriptions starts with a line with two coma separated numbers, n and m, where m corresponds to the number of rooms n the home and m corresponds to the number of appliances. 

The following 3n lines describe the room. The first line is the room name, and the second line corresponds to the occupancy status of the room (i.e., occupied, free) is a comma separated list containing the names of all devices in the room.

The following 3m lines describe a device. The first lines contais the devices's name, the second line is the devies' state (e.g., on, off), and the third line corresponds to the intensity leve of the device (e.g., volume luminosity).
 
## Use Cases


### Case 1 - Ring

Upon a `ring()` event, the advertising should be observed in each of the occupiedn rooms.

- environment-1: 
  - Advertising on the TV with sound for the Bedroom as the only occupied room

### Case 2 - Move user

Moving a user from an occupied room to a free room should change the status of the rooms. The advertising should change accordingly only advertising on occupied rooms. 

- environment-1: 
Starting from the user at the Bedroom, a `ring()` event should make sound on the tv. Moving the user to the bathroom should now occupy said room. A `ring()` event should now advertise with sound on the radio. The results of the tests should be.
  - Advertising on the TV with sound for the Bedroom
  - Bedroom is occupied and Bathroom free
  - Bedroom becomes free and Bathroom becomes occupied
  - Advertising on the Radio with sound for the Bathroom

### Case 3 - On device

Turning on a device in a room, changes the behavior of the device itself.

- environment-1: 
Adversign on a tv that is functioning will not advertize with sound but displaying a message on the screen
  - Advertising on the TV with sound for the Bedroom
  - Turn tv on (has no effect)
  - Advertising on the TV displaying message on the screen for the Bathroom

