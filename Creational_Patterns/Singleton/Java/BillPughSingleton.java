class BillPughSingleton{
  private BillPughSingleton(){}

  private static class Holder{
    private static final BillPughSingleton INSTANCE = new BillPughSingleton();
  }

  public static BillPughSingleton getInstance(){
    return Holder.INSTANCE;
  }
}


class Main{
  public static void main(String[] args){
    BillPughSingleton ob1 = BillPughSingleton.getInstance();
    BillPughSingleton ob2 = BillPughSingleton.getInstance();

    System.out.println(ob1 == ob2);
  }
}