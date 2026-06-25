import java.util.*;

interface Button{
  void render();
}

interface CheckBox{
  void select();
}

class LightButton implements Button{
  @Override
  public void render(){
    System.out.println("Rendering Light Button");
  }
}

class DarkButton implements Button{
  @Override
  public void render(){
     System.out.println("Rendering Dark Button");
  }
}

class LightCheckBox implements CheckBox{
  @Override
  public void select(){
    System.out.println("Selecting Light CheckBox");
  }
}


class DarkCheckBox implements CheckBox{
  @Override
  public void select(){
    System.out.println("Selecting Dark CheckBox");
  }
}

interface ThemeFactory{
  Button createButton();
  CheckBox createCheckBox();
}

class LightThemeFactory implements ThemeFactory{
  @Override
  public Button createButton(){
    return new LightButton();
  }

  @Override
  public CheckBox createCheckBox(){
    return new LightCheckBox();
  }
}


class DarkThemeFactory implements ThemeFactory{
  @Override
  public Button createButton(){
    return new DarkButton();
  }

  @Override
  public CheckBox createCheckBox(){
    return new DarkCheckBox();
  }
}


class ThemeService{
  HashMap<String,ThemeFactory> registry= new HashMap<>();

  ThemeFactory factory = null;

  public ThemeService(String theme){
    registry.put("light",new LightThemeFactory());
    registry.put("dark",new DarkThemeFactory());
    this.factory = registry.get(theme);
  }

  public void renderButton(){
    factory.createButton().render();
  }

  public void renderCheckBox(){
    factory.createCheckBox().select();
  }

  public void renderAll(){
    renderButton();
    renderCheckBox();
  }
}

class Main{
  public static void main(String[] args){
    ThemeService ts = new ThemeService("dark");
    ts.renderAll();
  }
}
