from abc import ABC, abstractmethod
from typing import override

class Shape(ABC):
  @abstractmethod
  def draw(self):
    pass

class Circle(Shape):
  @override
  def draw(self):
    print("Drawing Circle")


class Square(Shape):
  @override 
  def draw(self):
    print("Drawing Square")
    

class ShapeFactory:
  def get_shape(self, shape_type):
    if shape_type.lower() == 'circle':
      return Circle()
    elif shape_type.lower() == 'sqaure':
      return Square()
    return None


shape_factory = ShapeFactory()

circle = shape_factory.get_shape("Circle")
square = shape_factory.get_shape("Sqaure")


circle.draw()
square.draw()



