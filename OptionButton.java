import greenfoot.*;


public class OptionButton extends Actor implements Command
{
  private GreenfootImage options = new GreenfootImage("options.png");
  
  public OptionButton() {
        setImage(options);
   }
 
   public void act() {
         
        if (Greenfoot.mouseClicked(this)) {
            MouseInfo m=Greenfoot.getMouseInfo();    
            int x=m.getX();
            int y=m.getY();
            HomeScreen hs=new HomeScreen();
            hs.setNew(x, y);
        }
    }
   
    public void execute()
    {
    
      Greenfoot.setWorld(new OptionsWorld());
    
    }
}
