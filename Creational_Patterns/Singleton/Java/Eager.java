class Eager{
  private static final Eager instance = new Eager();

  private Eager(){}

  public static Eager getInstance(){
    return instance;
  }
}
 
class Main{
  public static void main(String args[]){
    Eager ob1 = Eager.getInstance();
    Eager ob2 = Eager.getInstance();
    // Eager(); get error
    System.out.println(ob1 == ob2);
  }
}