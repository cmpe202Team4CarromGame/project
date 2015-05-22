import greenfoot.*;


public class PlayButton extends Actor implements Command
{
    int boardNumber;
    private GreenfootImage play = new GreenfootImage("play_now_button.png");
    private boolean mouseDown;
     
    public PlayButton() {
        
   
        this.boardNumber=1;
        setImage(play);
        
        
    }
    
    public void act() {
       
        
        
        if (Greenfoot.mouseClicked(this)) {
            MouseInfo m=Greenfoot.getMouseInfo();    
            int x=m.getX();
            int y=m.getY();
            HomeScreen hs=new HomeScreen();
            
            System.out.println("This is y"+y);
            
            hs.setNew(x, y);
            
        }
        
    }
       
    
  
    public void execute()
    {
        Greenfoot.setWorld(new Board());
    }
}