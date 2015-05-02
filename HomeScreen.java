import greenfoot.*;

public class HomeScreen extends World
{

    MouseInfo mouse;
    Command cmd;
    
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
    
    void setCommand(Command cmd)
    {
        
        this.cmd=cmd;
        invoke();
    
    
    }
    public void invoke(){
    
    cmd.execute();
    }
    
   
/*   void setNew(int x, int y) {
         
         if(x>160 && x <450 && y>185 && y<216 )
         {
            Command cmd = new ConcreteCommand();
            cmd.setReceiver(new PlayButton());
           
          }
           
         if(x>=160 && x<=450 && y>260 && y<294)
         {
            Command cmd = new ConcreteCommand();
            cmd.setReceiver(new OptionButton());
           
          } 
          if(x>160 && x<450 && y>=340 && y<=375)
         {
            Command cmd = new ConcreteCommand();
            cmd.setReceiver(new ExitButton());
           
          }
           
        }*/
    }







