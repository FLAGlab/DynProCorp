class Packet :
    
    id = 0

    @classmethod
    def get_id(cls) :
        cls.id += 1
        return "P_"+str(cls.id)
    
    def __init__(self,dest,data=None,metadata=None) :
        """
        pre:  `id` is an integer uniquely iddentifying the package
              `dest` is the Node to which this packet is destined
              `data` is a string containing the the actual data content carried by this Packet ,
              None if not provided
              `metadata` contains information regarding the network through which this Packet
              has been travelling, None if not provided
              `processed` is a Boolean indicating whether the package has been processed
              by its destination node
        """
        self.id = Packet.get_id()
        self.destination = dest
        self.data = data
        self.metadata = metadata
        self.processed = False

    def content(self) :
        content = "content"
        if self.data :
            content += " " + str(self.data)
        else :
            content = "no " + content
        return content

    def __str__(self) :
        return "Packet {} destined for {} carrying {}".format(self.id,str(self.destination),self.content())