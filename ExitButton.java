import greenfoot.*;


public class ExitButton extends Actor implements Command
{
    private GreenfootImage exit = new GreenfootImage("ExitButton.png");

    public ExitButton() {
        setImage(exit);
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
    
      Greenfoot.stop();
    }
    
}
