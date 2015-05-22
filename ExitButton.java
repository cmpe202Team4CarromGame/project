import greenfoot.*;


public class ExitButton extends Actor implements Command
{
   
    //Board board = new Board();
    int boardNumber;
    private GreenfootImage exit = new GreenfootImage("ExitButton.png");
    private boolean mouseDown;
     
    public ExitButton() {
        
       // this.board=board;
        this.boardNumber=1;
        setImage(exit);
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
    
      Greenfoot.stop();
    }
    
}
