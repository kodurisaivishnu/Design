class ThreadSafeSingleton{

  private static ThreadSafeSingleton instance = null;
  private ThreadSafeSingleton(){}

  public synchronized static ThreadSafeSingleton getInstance(){
    if(instance == null){
      instance = new ThreadSafeSingleton();
    }
    return instance;
  }
}

class Main{
  public static void main(String[] args){

    ThreadSafeSingleton ob1 = ThreadSafeSingleton.getInstance();
    ThreadSafeSingleton ob2 = ThreadSafeSingleton.getInstance();

    System.out.println(ob1 == ob2);
  }
}