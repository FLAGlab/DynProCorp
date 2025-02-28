# Smarthome Advertising Exemplar

This exemplar consists of a hoem with multiple rooms, in which events, like ring alerts, are forwarded through the rooms using the available devices in each of them. The advertising depends on the type of device available, its current use, the users in a room, and the type of event. All variations of events can be managed by means of dynamic adaptations to the base system behavior.

This folder contains the main home definition used for testing descriving the devices and rooms in the home.

The devices file contains all devices in the house given their ``name location volume_level``.
Each room in the rooms file is described by two lines. The first line contains the ``name`` of the room and the ``number`` of devices in it. The second line contains a list of space separated the devices' ``names``.  