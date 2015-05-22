import greenfoot.*;

/**
 * Write a description of class OpenButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OptionButton extends Actor implements Command
{
  int boardNumber;
   
  private GreenfootImage options = new GreenfootImage("options.png");
  private boolean mouseDown;
     
    public OptionButton() {
        
       // this.board=board;
        this.boardNumber=1;
      
        setImage(options);
      
        mouseDown = false;
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
    
       // board.setUp(boardNumber);
    
    }
}
