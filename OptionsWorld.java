import greenfoot.*;

/**
 * Write a description of class OptionsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OptionsWorld extends World
{

    /**
     * Constructor for objects of class OptionsWorld.
     * 
     */
    public OptionsWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("background1.png");
        addObject(new PlayButton(),300,375);
    }
    
      void setNew(int x, int y) {
         
         if(x>240 && x <550 && y>350 && y<400 )
         {
             Command optioncmd = new ConcreteCommand();
             HomeScreen optionScreen = new HomeScreen();
             optioncmd.setReceiver(new PlayButton());
             optionScreen.setCommand(optioncmd);  
            
          }
        
        
        }
    
    
    
    
}
