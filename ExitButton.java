import greenfoot.*;


public class ExitButton extends Actor implements Receiver
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
            InitialWorld initialworld = new InitialWorld();
            OptionsWorld op = new OptionsWorld();
            initialworld.selectButton(x,y);
        }
    }
    
    
    
    
    public void doAction()
    {
    
      Greenfoot.stop();
    }
    
}
