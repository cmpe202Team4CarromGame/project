import greenfoot.*;  

public class Striker extends Coin
{
    private Arrow arrow;
    private int playerNumber;
    
    Striker(int number)
    {
        this.playerNumber=number;
    }

    public void act() 
    {
            super.act();
            if (! isMoving()) {
                checkDrag();
            }
    }    

    
    private void checkDrag()
    {
        /* The mouse clicked if block will determine the position of the mouse stricker on screen
         * in the specific cordinate range
         */
        if(Greenfoot.mouseClicked(getWorld()))
        {
            //System.out.println("Inside clicked..");
            MouseInfo mouse1 = Greenfoot.getMouseInfo();
          //  System.out.println(mouse1.getX());
           // System.out.println(mouse1.getY());
           /* if((mouse1.getX()>=175 && mouse1.getX()<=475) && (mouse1.getY()>480 && mouse1.getY()< 500))
            {
                setLocation(mouse1.getX(),mouse1.getY());
                //System.out.println("inside clicked with condition");
            }
            else
            {
                setLocation(320,480);
            }*/
            
            setDefaultLocation(mouse1);
        }
       
        if(Greenfoot.mouseDragged(this)) 
        {
            //System.out.println("Mouse dragged...");
            MouseInfo mouse = Greenfoot.getMouseInfo();
            int dx = mouse.getX()-getX();
            int dy = mouse.getY()-getY();
            if (arrow == null) 
            {   // just starting to drag now
                arrow = new Arrow(dx, dy);
                getWorld().addObject( arrow, getX(), getY() );
            }
            else 
            {
                arrow.setImage(dx, dy);
            }
        }
        if(Greenfoot.mouseDragEnded(this) && arrow != null) {
            getWorld().removeObject(arrow);
            getBoard().countRoll(getPlayerNumber());
            arrow = null;
            MouseInfo mouse = Greenfoot.getMouseInfo();
            Vector force = new Vector(getExactX() - mouse.getX(), getExactY() - mouse.getY());
            force.scale(0.1);
            addForce (force);
            setMoving(true);
        }
   } 
   
   
    public void hasDropped()
    {
        getBoard().strikerDropped();
    }
    
    public int getPlayerNumber()
    {
        return this.playerNumber;
    }
    
    public void setDefaultLocation(MouseInfo mouse1)
    {
        int player=this.playerNumber;
        if(player==1)
        {
              if((mouse1.getX()>=175 && mouse1.getX()<=475) && (mouse1.getY()>480 && mouse1.getY()< 500))
            {
                setLocation(mouse1.getX(),mouse1.getY());
                //System.out.println("inside clicked with condition");
            }
            else
            {
                setLocation(320,480);
            }
        }
        else
        {
              if((mouse1.getX()>=175 && mouse1.getX()<=475) && (mouse1.getY()>150 && mouse1.getY()<170))
            {
                setLocation(mouse1.getX(),mouse1.getY());
                //System.out.println("inside clicked with condition");
            }
            else
            {
                setLocation(320,150);
            }
        }
    }
    
}
