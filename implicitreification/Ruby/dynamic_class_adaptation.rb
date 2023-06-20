class Node
  def initialize(neighbors)
    @neighbors = neighbors
  end
  def handle()
    puts("[Node] running the handle method")
  end
  def send()
    puts("[Node] running the send method")
  end
end

class Computer < Node
  def initialize(neighbors)
    super(neighbors)
  end
  def handle()
    super()
    puts("[Computer] running the handle method")
  end
end

computer = Computer.new([])
computer.send()
computer.handle()

# Create a new class at runtime
klass = Object.const_set("ComputerNew", Class.new)
puts(klass.ancestors)
computer_new = klass.new()
puts(computer_new)
klass.define_method(:"handle") { 
  |*args, **kwords, &block| 
  puts("[ComputerNew] running the handle method")
}
computer_new.handle()
