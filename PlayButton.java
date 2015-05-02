import greenfoot.*;


public class PlayButton extends Actor implements Receiver
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
           // HomeScreen hs=new HomeScreen();
            InitialWorld initialworld = new InitialWorld();
            OptionsWorld op = new OptionsWorld();
           // hs.setNew(x, y);
            initialworld.selectButton(x,y);
            op.setNew(300,375);
           
            
        }
        
    }

    public void doAction()
    {
        Greenfoot.setWorld(new Board());
    }
}