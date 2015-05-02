import greenfoot.*;
public class InitialWorld extends World
{

    public InitialWorld()
    {    

         super(800,400, 1); 
         Greenfoot.setWorld(new HomeScreen());
        
     
    }
    
    public void selectButton(int x , int y)
    {
    
      if(x>160 && x <450 && y>185 && y<216 )
         {
             Command playcmd = new ConcreteCommand();
             HomeScreen playScreen = new HomeScreen();
             playcmd.setReceiver(new PlayButton());
             playScreen.setCommand(playcmd);
           
         }
           
         if(x>=160 && x<=450 && y>260 && y<294)
         {
          
             Command optioncmd = new ConcreteCommand();
             HomeScreen optionScreen = new HomeScreen();
            optioncmd.setReceiver(new OptionButton());
            optionScreen.setCommand(optioncmd);  
           
          } 
        
          if(x>160 && x<450 && y>=340 && y<=375)
         {
             Command exitcmd = new ConcreteCommand();
             HomeScreen exitScreen = new HomeScreen();
             exitcmd.setReceiver(new OptionButton());
             exitScreen.setCommand(exitcmd);  
           
        }
    
    
    
    }
    
    
}
