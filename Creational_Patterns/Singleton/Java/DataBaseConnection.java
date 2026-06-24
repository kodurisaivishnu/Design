class DataBaseConnection{
  private DataBaseConnection(){}

  private class Holder{
    private static final DataBaseConnection INSTANCE = new DataBaseConnection();
  }

  public static DataBaseConnection getInstance(){
    return Holder.INSTANCE;
  }

  public void query(String sql){
    System.out.println("Executing Query...."+ sql);
  }
}

class Main{
  public static void main(String[] args){
    DataBaseConnection ob1 = DataBaseConnection.getInstance();
    DataBaseConnection ob2 = DataBaseConnection.getInstance();

    System.out.println(ob1.equals(ob2));

    ob1.query("select * from table");
  }
}

