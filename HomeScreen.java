import greenfoot.*;

public class HomeScreen extends World
{

    MouseInfo mouse;
    
    public HomeScreen()
    {    
        
        super(600, 400, 1);
        setBackground("background.png");
        addObject(new PlayButton(),300,200);
        addObject(new OptionButton(),300,280);
        addObject(new ExitButton(),300,360);
       
    }
    
    public void act()
    {
       
    }
    
    void setNew(int x, int y) {
         
         if(x>160 && x <450 && y>185 && y<216 )
         {
            ConcreteCommand cmd = new ConcreteCommand();
            cmd.setCommand(new PlayButton());
           
          }
           
         if(x>=160 && x<=450 && y>260 && y<294)
         {
            ConcreteCommand cmd = new ConcreteCommand();
            cmd.setCommand(new OptionButton());
           
          } 
          if(x>160 && x<450 && y>=340 && y<=375)
         {
            ConcreteCommand cmd = new ConcreteCommand();
            cmd.setCommand(new ExitButton());
           
          }
           
        }
    }







