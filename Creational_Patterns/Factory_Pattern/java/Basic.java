interface Shape{
  public void draw();
}

class Circle implements Shape{
  @Override
  public void draw(){
    System.out.println("Drawing Circle");
  }
}


class Square implements Shape{
  @Override
  public void draw(){
    System.out.println("Drawing Square");
  }
}


class ShapeFactory{
  public static Shape getShape(String shape){
    if(shape.equalsIgnoreCase("circle")){
      return new Circle();
    }else if(shape.equalsIgnoreCase("square")){
      return new Square();
    }else{
      return null;
    }
  }
}


class Main{
  public static void main(String args[]){
    Shape circle = ShapeFactory.getShape("circle");
    Shape square = ShapeFactory.getShape("square");

    circle.draw();
    square.draw();
  }
}