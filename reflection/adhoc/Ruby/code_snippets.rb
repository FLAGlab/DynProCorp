class A
end

class B
  def initialize()
    @var_b = 15
  end
end

### ADDING AND REMOVING ATTRIBUTES ON INSTANCES

# # Single add followed by a single remove
# a = A.new()
# puts(a.inspect())
# a.instance_variable_set(:@var_a, "var_a")
# puts(a.inspect())
# a.remove_instance_variable(:@var_a)
# puts(a.inspect())

# Work also by using the notion of class << instance
# class << a
#   attr_accessor :var_a
# end
# a.var_a = 15

# # Single remove of an existing variable
# b = B.new()
# puts(b.inspect())
# b.remove_instance_variable(:@var_b)
# puts(b.inspect())

# # Single add followed by a single remove. What does it happen when we have two instances of a same class?
# a1 = A.new()
# a2 = A.new()
# puts(a1.inspect())
# puts(a2.inspect())
# a1.instance_variable_set(:@var_a, "var_a")
# puts(a1.inspect())
# puts(a2.inspect()) # The instance a2 is not impacted since we work on the instance a1
# a1.remove_instance_variable(:@var_a)
# puts(a1.inspect())
# puts(a2.inspect())

### ADDING AND REMOVING ATTRIBUTES ON CLASSES
# The isse is the fact we directly use the notion of singleton classes, so we cannot update the structure of the class.
# But see the two examples below

## Example 1
# a1 = A.new()
# puts(a1.inspect())

# class A 
#   def initialize() 
#     @var_aa = 15
#   end
# end

# puts(a1.inspect()) # No instance variable @var_aa exists for the instance a1 because the method is not called
#                    # To ensure this variable exists, we should add a code to execute the initialisation of the variable

# a2 = A.new()
# puts(a2.inspect())

# # The following does not work because the variable does not exist
# # a1.remove_instance_variable(:@var_aa)
# puts(a1.inspect())
# a2.remove_instance_variable(:@var_aa)
# puts(a2.inspect())

## Example 2
# With a module eval we can change the structure of the method to add getters and setters in order to get and set the variable
a1 = A.new
puts(a1.inspect())

a1.class.module_eval { attr_accessor :var_aa }
a1.var_aa = 15

puts(a1.inspect())

a2 = A.new()
a2.var_aa = 15
puts(a2.inspect())

a1.remove_instance_variable(:@var_aa)
puts(a1.inspect())
a2.remove_instance_variable(:@var_aa)
puts(a2.inspect())
