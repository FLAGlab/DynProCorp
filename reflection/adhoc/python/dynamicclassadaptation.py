class Node :
    def test(self) :
        return "I am a node"
class BufferedNode :
    def test(self) :
        return "I am a buffered node"
    
class Computer (Node) :
    def __init__(self,a,b) :
        self.a = a
        self.b = b
    def __str__(self) :
        return "haha"
        
node = Computer(1,2)
print(node) #haha

class ComputerNew (Node) :
    def __init__(self,a,b) :
        self.a = a
        self.b = b
    def __str__(self) :
        return "WOEHAHAHA"        

print("Q1 : Can you change a class by another one?")
# Yes you can but existing instances will still refer to old class.
# New instances point to new class.

Computer = ComputerNew
print(node) #haha <- STILL PRINTS OLD METHOD; INSTANCE HASN'T
node2 = ComputerNew(3,4)
print(node2) #WOEHAHAHA <- PRINTS NEW METHOD

print("Q1bis : Can you change the class of an instance by another one at runtime?")
# Yes.
node.__class__ = ComputerNew
print(node) #WOEHAHAHA <- PRINTS NEW METHOD

#print("Q1tris")
# Can you change the class of all instance of a given class at runtime?
# No, the list of all instances is not stored centrally (I think).

print("Q2 : Can you delete a method from a class?")
# Yes and it directly affects the existing instances.
del ComputerNew.__str__
print(node2) #<__main__.ComputerNew object at 0x7fdc582244d0> <- since __str__ was deleted

print("Q3 : Can you add a method to a class?")
# Yes and it directly affects the existing instances.
def __str__(self) :
    return "WOEHAHAHA"
ComputerNew.__str__ = __str__
print(node2) #WOEHAHAHA <- PRINTS NEW METHOD

print("Q4 : Can I change the superclass of a class dynamically?")
print(node2.test()) # I am a node
node2.__class__.__bases__ = (BufferedNode,)
print(node2.test()) # I am a buffered node

print("Q5 : Can I dynamically add a new class?")
# (yes: example taken from https://stackoverflow.com/questions/100003/what-are-metaclasses-in-python)
Foo = type('Foo', (), {'bar':True})
# dynamically creates a class of the form
# class Foo(object):
#     bar = True
# now we dynamically define a sublass of that class
# first define a function that will become a method of that subclass
def echo_bar(self):
    print(self.bar)
# create a subclass of the form
# class FooChild(Foo):
#     def echo_bar(self):
#         print(self.bar)
FooChild = type('FooChild', (Foo,), {'echo_bar': echo_bar})
hasattr(Foo, 'echo_bar') # False
hasattr(FooChild, 'echo_bar') # True
my_foo = FooChild()
my_foo.echo_bar() # prints True

