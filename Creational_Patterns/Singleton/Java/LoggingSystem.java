import java.util.*;

class Logger{
  private Logger(){}

  static class Holder{
    static {
    try {
        System.out.println("Creating the instance");
        Thread.sleep(500);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}
    private static final Logger INSTANCE = new Logger();
  }

  public static Logger getInstance(){
    return Holder.INSTANCE;
  }

  public void log(String message){
    System.out.println("Logging : "+ message);
  }
}

class Worker extends Thread{
  private final int id;
  Worker(int id) {
    this.id = id;
  }
  @Override
  public void run(){
    Logger logger = Logger.getInstance();
    logger.log("Worker [ " + id +" ] is Logging");
  }
}

class Main {
  public static void main(String[] args) throws Exception{
    ArrayList<Thread> threads = new ArrayList<>();
    for(int i = 0; i < 5;i++){
      Thread t = new Worker(i);
      threads.add(t);
      t.start();
    }

    for(Thread t : threads){
      t.join();  // wait for all workers
    }

    Logger nonThread = Logger.getInstance();
    nonThread.log("from the nonThread");
  }
}