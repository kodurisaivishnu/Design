interface Logistics{
  public void send();
}

class Air implements Logistics{
  @Override
  public void send(){
    System.out.println("Sending via Air");
  }
}

class Road implements Logistics{
  @Override
  public void send(){
    System.out.println("Sending via Road");
  }
}

class LogisticsFactory{
  public static Logistics getLogistics(String mode){
    if(mode.equalsIgnoreCase("air")){
      return new Air();
    }else if(mode.equalsIgnoreCase("road")){
      return new Road();
    }else{
      return null;
    }
  }
}

class LogisticsService{
  public void send(String mode){
    Logistics logistics = LogisticsFactory.getLogistics(mode);
    logistics.send();
  }
}


class Main{
  public static void main(String[] args){
    LogisticsService logistics = new LogisticsService();
    logistics.send("air");
    logistics.send("road");
  }
}