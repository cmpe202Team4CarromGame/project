import greenfoot.*;  

public abstract class SmoothMover extends Actor
{
    private Vector movement;
    private double exactX;
    private double exactY;
    
    public SmoothMover()
    {
        this(new Vector());
    }
    
    public SmoothMover(Vector movement)
    {
        this.movement = movement;
    }
    

    public void move() 
    {
        exactX = exactX + movement.getX();
        exactY = exactY + movement.getY();
        super.setLocation((int) exactX, (int) exactY);
    }
    
    public void setLocation(double x, double y) 
    {
        exactX = x;
        exactY = y;
        super.setLocation((int) x, (int) y);
    }
    
    public void setLocation(int x, int y) 
    {
        exactX = x;
        exactY = y;
        super.setLocation(x, y);
    }

    public double getExactX() 
    {
        return exactX;
    }

    public double getExactY() 
    {
        return exactY;
    }

    public void addForce(Vector force) 
    {
        movement.add(force);
    }
    
    public void accelerate(double factor)
    {
        movement.scale(factor);
        if (movement.getLength() < 0.15) {
            movement.setNeutral();
        }
    }
    
    public double getSpeed()
    {
        return movement.getLength();
    }
    
    public void stop()
    {
        movement.setNeutral();
    }
    
    public Vector getMovement() 
    {
        return movement;
    }
}
