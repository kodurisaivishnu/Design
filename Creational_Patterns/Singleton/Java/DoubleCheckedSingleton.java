class DoubleCheckedSingleton{
  volatile static DoubleCheckedSingleton instance = null;

  private DoubleCheckedSingleton(){}

  public static DoubleCheckedSingleton getInstance(){
    if(instance == null){
      synchronized (DoubleCheckedSingleton.class){
        if(instance == null){
          instance = new DoubleCheckedSingleton();
        }
      }
    }
    return instance;
  }
}


class Main{
  public static void main(String[] args){
    DoubleCheckedSingleton ob1 = DoubleCheckedSingleton.getInstance();
    DoubleCheckedSingleton ob2 = DoubleCheckedSingleton.getInstance();
    System.out.println(ob1 == ob2);
  }
}
