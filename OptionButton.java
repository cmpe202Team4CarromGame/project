import greenfoot.*;


public class OptionButton extends Actor implements Receiver
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
            InitialWorld initialworld = new InitialWorld();
            OptionsWorld op = new OptionsWorld();
           // hs.setNew(x, y);
            initialworld.selectButton(x,y);
           
        }
    }
   
    public void doAction()
    {
    
      Greenfoot.setWorld(new OptionsWorld());
    
    }
}
