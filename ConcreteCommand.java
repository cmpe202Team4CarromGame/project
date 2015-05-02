import greenfoot.*;

public class ConcreteCommand extends Actor implements Command
{
    
    
    Receiver buttonClick;
    
    public ConcreteCommand(){
    
    }
   
    public void setReceiver(Receiver target)
    {
        this.buttonClick=target;
//         buttonClick.execute();
    
    }
    
    public void execute()
    {
        buttonClick.doAction();
    
    }
 
    
}
