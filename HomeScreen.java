import greenfoot.*;

public class HomeScreen extends World
{

    MouseInfo mouse;
    
    public HomeScreen()
    {    
        
        super(600, 400, 1);
        setBackground("HomeScreen.png");
        addObject(new PlayButton(),300,50);
        addObject(new OptionButton(),300,150);
        addObject(new ExitButton(),300,300);
       
    }
    
    public void act()
    {
       
    }
    
    void setNew(int x, int y) {
         
         if(x>200 && x <400 && y>20 && y<80 )
         {
            ConcreteCommand cmd = new ConcreteCommand();
            cmd.setCommand(new PlayButton());
            System.out.println("there");
          }
           
         if(x>=250 && x<=365 && y>115 && y<200)
         {
            ConcreteCommand cmd = new ConcreteCommand();
            cmd.setCommand(new OptionButton());
            System.out.println("there11");
          } 
          if(x>238 && x<361 && y>=260 && y<=345)
         {
            ConcreteCommand cmd = new ConcreteCommand();
            cmd.setCommand(new ExitButton());
            System.out.println("there112");
          }
            System.out.println(x);
            System.out.println(y);
        }
    }







