class Node :

    def __init__(self,name,neighbors) :
        """
        pre:  `name` is a string with the name of this Node
              `neighbors` is the list of Nodes to which this Node will
              propagate all packets not destined to itself
        """
        self.name = name
        self.neighbors = neighbors
    
    def __str__(self) :
        return "{} named {}".format(str(type(self).__name__),str(self.name))
    
    def handle(self, packet) :
        """
        pre:  `packet` is a Packet
        post: check if Packet is destined to this node;
              if so, process it, if not, forward it to neighbors
        """
        if packet.destination is self :
            print("{} arrived at destination {}\n".format(packet,self))
            self.process(packet)
        else :
            for node in self.neighbors :
                node.handle(packet)
        
    def process(self, packet) :
        """
        pre:  `packet` is a Packet
        post: since Node is an abstract class, processing
              does nothing; should be implemented by a subclass
        """
        packet.processed = True
    
class Computer (Node) :
    
    def __init__(self, name, neighbors, compute = lambda x: x) :
        """
        pre:  `compute` is function that will transform the data
              of the packets that can be handled by this computer,
              by default it is just the identity function that does nothing
        post: packet has been processed by computing it
        """
        super().__init__(name,neighbors)
        self.compute = compute
        
    def process(self, packet) :
        """
        pre:  `packet` is a Packet
        post: packet has been processed by computing it
        """
        super().process(packet)
        #packet.data = packet.data[::-1] # reverse the string
        packet.data = self.compute(packet.data)
        print("Packet computed by computer became:")
        print(packet.data)

class Printer (Node) :
    
    def process(self, packet) :
        """
        pre:  `packet` is a Packet
        post: packet has been processed by printing it
        """
        super().process(packet)
        print("Packet processed by printer which printed:")
        print(packet.data)
