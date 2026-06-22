class Lazy {
  private static Lazy instance = null;

  private Lazy() {}

  public static Lazy getInstance(){
    if(instance == null){
      instance = new  Lazy();
    }
    return instance;
  }
}

class Main{
  public static void main(String[] args) throws Exception{
    Lazy ob1 = Lazy.getInstance();
    Lazy ob2 = Lazy.getInstance();
    // Eager(); get error
    System.out.println(ob1 == ob2);
  }
}