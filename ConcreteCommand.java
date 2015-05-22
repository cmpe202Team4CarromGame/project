import greenfoot.*;

public class ConcreteCommand extends Actor
{
    
    
    Command buttonClick;
    
    public ConcreteCommand(){
    
    }
   
    public void setCommand(Command command)
    {
        this.buttonClick=command;
         buttonClick.execute();
    
    }
 
    
}
