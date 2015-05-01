import greenfoot.*;


public class PlayButton extends Actor implements Command
{
    private GreenfootImage play = new GreenfootImage("play_now_button.png");
     
    public PlayButton() {
        setImage(play);
       
    }
    
    public void act() {
       
        
        
        if (Greenfoot.mouseClicked(this)) {
            MouseInfo m=Greenfoot.getMouseInfo();    
            int x=m.getX();
            int y=m.getY();
            HomeScreen hs=new HomeScreen();
            OptionsWorld op = new OptionsWorld();
            hs.setNew(x, y);
            op.setNew(300,375);
            
        }
        
    }
       
    
  
    public void execute()
    {
        Greenfoot.setWorld(new Board());
    }
}