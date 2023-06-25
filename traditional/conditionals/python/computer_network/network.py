""" This is the main file to launch the network simulation """

from packet import Packet
from node import Node, Computer, Printer

class Network :

    def __init__(self) :
        """
        pre:  
        post: a network of nodes has been created of which start
              has been declared as a special node from where
              messages will start to get propagated
        """
        node6 = Computer("reversor",[],lambda x : x[::-1]) # computer will reverse data of package
        node5 = Printer("Student Printer 1001",[node6])
        node4 = Computer("comp2",[node5])
        node3 = Printer("INGI Laser Printer 2048",[node4])
        node2 = Computer("comp2",[node3])
        node1 = Computer("comp1",[node2])
        self.start = node1
        self.printer = node3
        self.computer = node6
        
    def send(self,package) :
        """
        pre:  package is a Package to be send throughout the network,
              to get handled by its destination node
        post: package has been asked to be handled by the start node
              of the network, who will propagate it to other nodes
              if need be
        """
        self.start.handle(package)


network = Network()
p1 = Packet(network.printer,"Hello World")
p2 = Packet(network.computer,"Hello World")
network.send(p1)
network.send(p2)
