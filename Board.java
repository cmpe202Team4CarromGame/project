

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;


public class Board extends World
{
    private int board;
    private int tries;
    private int rolls;
    private int score;
    private Text boardLabel;
    private Text tryLabel;
    private Text rollsLabel;
    private Text scoreLabel;
    private int board1;
    private int tries1;
    private int rolls1;
    private int score1;
    private Text boardLabel1;
    private Text tryLabel1;
    private Text rollsLabel1;
    private Text scoreLabel1;
    private int coinsMoving;
    private boolean failed;
    private boolean cleared=true;
    private boolean displayPoints = false;
    private boolean coinCollected=false;
    private int lastplayernumber;
    
    /**
     * Definition of the board setups.
     *   One row defines one board setup.
     *   The first number is the number of rolls for this board.
     *   The 2nd and 3rd are the coordinates for the gold marble.
     *   Following that: every pair places a steel marble, unless:
     *     if the next number is 0, then following is a horizontal bar;
     *     if the next number is 1, then following is a vertical bar
     */

    private static final int[][] setups = {  // board = 640x640
        /*{ 1, 320, 480, 320, 200 },
        { 2, 320, 320, 180, 320, 460, 320 },
        { 2, 320, 480, 200, 200, 440, 200 },
        { 3, 320, 320, 290, 480, 200, 190, 470, 230 },
        { 1, 120, 520, 420, 120, 520, 180 },*/
        { 500, 320, 480,      //Striker
            
            
            
            
            
            4,272,320,
            3,296,320,
            5,320,320,       //CenterCarromCoin   
            4,344,320,
            3,368,320,
            
            3,310,272,
            4,334,272,
            3,320,296,
            3,320,344,
            4,310,368,
            
            3,344,344,
            4,296,344,
            
            3,296,296,
            4,344,296,
            
            3,334,368,
            
            4,320,390,
            4,320,250,

         //   96,91,
          //  539,99,
           // 539,539,
            
            /*320, 180 ,
            320, 180 ,
            320, 180 ,
            320, 180 ,*/
            
            0,320,49,       //Horizontal Edge Boundary - top 
            0,320,590,      //Horizontal Edge Boundary - bottom 
            1,50, 315,      //Vertical Edge Boundary - left
            1, 590, 315     //Vertical Edge Boundary - right
        }//,
        
        //{ 2, 320, 480, 320, 180 , 0, 500, 50},  
        
       // { 1, 140, 400, 470, 400 , 1, 320, 433, 0, 320, 100},                          // indirect over 1 bar
        /*{ 1, 320, 480, 320, 90, 320, 200, 320, 310 },
        { 4, 320, 320, 200, 320, 440, 320, 260, 220, 380, 220, 260, 420, 380, 420 },  // six star
        { 1, 300, 520, 90, 320, 300, 100, 0, 390, 320},
        { 2, 360, 500, 90, 340, 325, 100, 570, 250, 0, 360, 330},
        { 2, 320, 320, 450, 95, 560, 140, 190, 545, 80, 500 },
        { 4, 320, 480, 120, 120, 120, 220, 220, 120, 220, 220, 320, 120, 320, 220,    // 10 in 2-rows
             420, 120, 420, 220, 520, 120, 520, 220 },*/
      // // { 1, 284, 546, 387, 293 , 1, 75, 320, 0, 320, 75, 0, 420, 380 },              // indirect over 2 bars
       //{ 3, 536, 130, 146, 508 , 0, 410, 230, 0, 230, 410 },            
       // { 4, 320, 135, 110, 200, 530, 200, 240, 470, 400, 470, 0, 320, 340 }, 
    };
    
    public Board()
    {    
       // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
       // super (500, 500, 1);
        super (840, 640, 1);
       
        Greenfoot.setSpeed (52);
       // Greenfoot.setWorld(this);
        setPaintOrder (ScoreBoard.class, Points.class, Coin.class, Arrow.class);
        
        /*for(int i=0;i<100;i++)
            {addObject ( new Bar(false),0,0);}*/

        board = 1;
        tries = 300;
        score = 0;
        
        // board1 = 1;
        tries1 = 300;
        score1 = 0;
        
        createCounters ();
        createCounters1 ();
        setUp (board);
    }

    /**
     * Do the acting for the board: check whether w succeeded or failed.
     */
    
   public void act() 
    {
     
        
        if (cleared) {
            Coin striker = getStriker();
            
            if ( striker != null) {
              //  addObject (new Points ("200"), striker.getX()+70, striker.getY()-30);
                Greenfoot.playSound("ping.wav");
              //  addScore (300 + rolls*300); // 100 for clearing the board 
                                           // 200 for gold marble still on it,
                                           // plus 300 per unused roll
            }
            else {
               // addScore (100 + rolls*300,getActualStriker().getPlayerNumber()); // 100 for clearing the board
                                            // plus 300 per unused roll
            }
            cleared = false;
            displayPoints = true;
        }
        else if (displayPoints) {
            if ( pointsImageGone() ) {
                displayPoints = false;
                nextBoard();
            }
        }
        else if (failed) {
            lostBoard (getActualStriker().getPlayerNumber());
        }
        /*if(Greenfoot.mouseClicked(this))
        {
            System.out.println("Inside clicked..");
            MouseInfo mouse1 = Greenfoot.getMouseInfo();
            System.out.println(mouse1.getX());
              
            if((mouse1.getX()>=175 ||mouse1.getX()<=475) && mouse1.getY()==480)
            {
                goldMarble.setLocation(mouse1.getX(),mouse1.getY());
                System.out.println("inside clicked");
            }
        } */
    }
   
    public void coinMoving(boolean moves)
    {
       
        if (moves) {
            coinsMoving++;
        }
        else {
            coinsMoving--;
            if (coinsMoving == 0) {           // all movement stopped
                
                if ( isBoardClear() ) {
                    cleared = true;
                }
                else if (rolls == 0) {
                    failed = true;
                }
                else if (! haveStriker()) {
                    //failed = true;
                   // addObject(new GoldMarble(), 320, 480);
                  switch(lastplayernumber)
                            {
                                case 1: addObject ( new Striker(2),320,150);break;
                                case 2: addObject ( new Striker(1),320,480);break;
                            }
                }
                else
                {
                     Striker currentPlayer= getActualStriker();
                    if(coinCollected)
                       { /*addObject(new GoldMarble(), 320, 480);*/ currentPlayer.setDefaultLocation(Greenfoot.getMouseInfo());}
                    else
                        { /*addObject(new GoldMarble(), 320, 480);*/
                            lastplayernumber=currentPlayer.getPlayerNumber();
                            removeObject(currentPlayer);
                            int playerNumber=currentPlayer.getPlayerNumber();
                            switch(playerNumber)
                            {
                                case 1: addObject ( new Striker(2),320,150);break;
                                case 2: addObject ( new Striker(1),320,480);break;
                                default: addObject ( new Striker(1),320,480);break;
                            }
                        }//addObject(new GoldMarble(), 320, 150);
                  coinCollected=false;
                  currentPlayer= getActualStriker();
                }
            }
        }
    }

    /**
     * Record that a roll has been completed.
     */
    public void countRoll(int playerNumber)
    {
        if(playerNumber==1)
        {
            rolls--;
            rollsLabel.setText("Rolls left: " + rolls);
        }
        else
        {
            rolls1--;
            rollsLabel1.setText("Rolls left: " + rolls1);
        }
     }

    /**
     * A steel marble dropped off the board.
     */
    public void steelCoinDropped(String name)
    {
      //  String coinType = getObjects (Coin.class).size();
      //String name="s";
     // System.out.println("In steel coin dropped "+name);
      
      if((name=="White" && getActualStriker().getPlayerNumber()==1)||(name=="Black" && getActualStriker().getPlayerNumber()==2))
      {
          addScore(10,getActualStriker().getPlayerNumber());
          coinCollected=true;
      }
      else if(name=="Striker")
      {
          addScore(-10,lastplayernumber);
          coinCollected=true;
      }
      else if(name=="Queen")
      {
          addScore(100,getActualStriker().getPlayerNumber());
          coinCollected=true;
      }
      
       else
      {
          addScore(-10,getActualStriker().getPlayerNumber());
          coinCollected=true;
       }
        //addScore(10,getActualStriker().getPlayerNumber());
        
    }
    
    /**
     * The gold marble dropped off the board.
     */
    public void strikerDropped()
    {
        // nothing to do - we wait until all movement has stopped before doing anything
        //failed = true;
        addScore(-10,getActualStriker().getPlayerNumber());
    }
    
    /**
     * Check whether the board has been cleared.
     */
    private boolean isBoardClear()
    {
        int coins = getObjects (Coin.class).size();
        int striker = getObjects (Striker.class).size();
        
        boolean flag=false;
        
        if(coins - striker == 0)
            flag=true;
        else if(getBlackCoinCount()==0 && getQueenCount()==0)
            flag=true;
        else if(getWhiteCoinCount()==0 && getQueenCount()==0)
            flag=true;
            
        return flag;
    }
    
    /**
     * Check whether we still have the gold marble on the board.
     */
    private boolean haveStriker()
    {
        return getStriker() != null;
    }
    
    /**
     * Check whether the board has been cleared.
     */
    private boolean pointsImageGone()
    {
        return getObjects (Points.class).size() == 0;
    }
    
    /**
     * Check whether the gold marble is on the board.
     */
    private Coin getStriker()
    {
        List<Actor> coins = getObjects (Striker.class);
        if (coins.size() == 0) {
            return null;
        }
        else {
            return (Coin) coins.get(0);
        }
    }
    
    /**
     * Record the fact that an attempt at a board has been unsuccessful.
     * Start over if there are tries left, else game over.
     */
    public void lostBoard(int playerNumber) 
    {
        if(playerNumber==1)
        {
            tries--;
            tryLabel.setText ("Tries left: " + tries);
        }
        else
        {
            tries1--;
            tryLabel1.setText ("Tries left: " + tries1);
        }
       
        
        if (tries == 0 || tries1 == 0) {
            Greenfoot.playSound("sad-trombone.wav");
            gameOver("Game Over");
        }
        else {
            Greenfoot.delay(100);
            setUp (board);
        }
    }
    
    /**
     * Game's up.
     */
    public void gameOver(String message) 
    {
        if(score1<=score)
            addObject (new ScoreBoard(message, score), 320, getHeight()/2);
         else
            addObject (new ScoreBoard(message, score1), 320, getHeight()/2);
            
        Greenfoot.stop();
    }

    /**
     * Record a score.
     */
    public void addScore(int points,int playerNumber)
    {
        if(playerNumber==1)
        {
         score = score + points;
         scoreLabel.setText ("Score: " + score + "      ");
        }
        else
        {
            score1 = score1 + points;
         scoreLabel1.setText ("Score: " + score1 + "      ");
        }
    }
    
    /**
     * Check whether a given point is off the board.
     */
    public boolean isOffBoard (int x, int y) 
    {
        if((x<=100 && y<=100) || (x>=540 && y<=100) || (x<=97 && y>=540) || (x>=540 && y>=540))
            return true;
        else
            return false;   
    }
    
  
    /**
     * Show the next board (if there is one). Otherwise game's over with a win.
     */
    private void nextBoard()
    {
        Greenfoot.delay(60);
        board++;
        if (board % 3 == 0) {
            tries++;
            tryLabel.setText("Tries left: " + tries);
        }
        if (board <= setups.length) {
            boardLabel.setText("BOARD " + board);
            setUp (board);
        }
        else {
            
            int winner=0;
            String result;
            
            
            if(score1>score)
                winner=2;
            else if(score1<score)
                winner=1;
           
            if(winner==0)
                result="Its a Tie !!";
            else
                result="Player "+winner+" Wins !";    
                
            gameOver (result);
        }
    }
    
    public void setUp(int boardNumber)
    {
        removeObjects (getObjects (Coin.class));
        removeObjects (getObjects (Bar.class));
        
        int[] current = setups[boardNumber-1];
        int i = 0;
        rolls = current[i++];
        rolls1 = rolls;
        
        addObject ( new Striker(1), current[i++], current[i++]);
        // addObject ( new GoldMarble(2), 320, 150);
         
        while (i < current.length) {
            int next = current[i++];
            if (next == 0) {
                addObject ( new Bar(false), current[i++], current[i++]);
            }
            else if (next == 1) {
                addObject ( new Bar(true), current[i++], current[i++]);
            }
            else if (next == 3) {
                addObject ( new BlackCoin(), current[i++], current[i++]);
            }
            else if (next == 4) {
                 addObject ( new WhiteCoin(), current[i++], current[i++]);
            }
            else if (next == 5) {
                 addObject ( new QueenCoin(), current[i++], current[i++]);
            }
            /*else {
                addObject ( new Coin(), next, current[i++]);
            }*/
        }
        
        rollsLabel.setText ("Rolls left: " + rolls);
        rollsLabel1.setText ("Rolls left: " + rolls1);
        failed = false;
        cleared = false;
        coinsMoving = 0;
    }
    
    private void createCounters()
    {
        boardLabel = new Text("Player 1");
        addObject (boardLabel, 670, 120);
        tryLabel = new Text("Tries left: " + tries);
        addObject (tryLabel, 670, 150);
        rollsLabel = new Text("Rolls left: " + rolls);
        addObject (rollsLabel, 670, 200);
        scoreLabel = new Text("Score: " + score + "      ");
        addObject (scoreLabel, 670, 230);
    }
     private void createCounters1()
    {
        boardLabel1 = new Text("Player 2");
        addObject (boardLabel1, 670, 380);
        tryLabel1 = new Text("Tries left: " + tries1);
        addObject (tryLabel1, 670, 410);
        rollsLabel1 = new Text("Rolls left: " + rolls1);
        addObject (rollsLabel1, 670, 430);
        scoreLabel1 = new Text("Score: " + score1 + "      ");
        addObject (scoreLabel1, 670, 460);
    }
     private Striker getActualStriker()
    {
        List<Actor> coins = getObjects (Striker.class);
        if (coins.size() == 0) {
            return null;
        }
        else {
            return (Striker)coins.get(0);
        }
    }
    
    public int getBlackCoinCount()
    {
        return  getObjects (BlackCoin.class).size();
    }
    
    public int getWhiteCoinCount()
    {
        return  getObjects (WhiteCoin.class).size();
    }
    
    public int getStrikerCount()
    {
        return  getObjects (Striker.class).size();
    }
    
      public int getQueenCount()
    {
        return  getObjects (QueenCoin.class).size();
    }
    
    
}