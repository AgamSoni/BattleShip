/*Agam.S
 * This program stimulates a battleship game in which 2 players play the game of battleship on computerized grids and ships.*/
import java.util.Scanner; // import scanner
public class BattleshipGame{ // open program
  public static void main (String[]args){ // main method
    int row = 5; // 5 rows
    int column = 5; // 5 columns
    System.out.println("****************************\n|                          |\n|   WELCOME TO BATTLESHIP  |\n|                          |\n****************************"); // intro
    System.out.println("In this game both players will set up their grid's with ships in a strategic way that the opponent isn't able to guess your ships position and sink it during their strike. Also both players are urged to look away when the other is taking their turn for the fun of the game."); // rules
    System.out.println("PLAYER 1 \nThis is your grid place your ships strategically in order to protect them from enemy fire. \nTip-: Don't put the ships close to each other."); // Player begins to set his grid
    int [][]grid=new int[row][column]; // initializing arrays for player 1 in which his ship coordinates are stored
    int [][]grid1=new int[row][column]; // initializing arrays for player 1 in which his ship coordinates are stored
    // prints the empty grid for player 1 just to see how the grid will look like
    for( int i = 0; i<row;i++){
      for(int j = 0; j<column;j++){
        System.out.print(grid[i][j] + "   ");
      }
      System.out.println("   ");
    }
    // player 1 entering x and y coordinates of his ships by the help of class Player
    Player abc = new Player();
    for(int i =0; i<5;i++){
      int x = abc.setx(i);
      int y = abc.sety(i);
      printGridafterchange(x , y, grid, row, column); // sent the values to method of print grid which prints grid whith each ship
    }
    System.out.println("Player 1, you’re done, please look away the other player has to make their grid. Thanks"); // rule
    // for loop to leave 37 lines so player 2 can't see player 1's ship placement
    for (int i = 0; i < 37; i++) { // makes space between both players grids
      System.out.println();
    }
    
    System.out.println("PLAYER 2 \nIts your turn to place your ships strategically in order to protect them from enemy fire. \nTip-: Don't put the ships close to each other. \nHere's your grid plant your ships :");// intro for player 2
    //print blank grid for player 2
    for( int i = 0; i<row;i++){
      for(int j = 0; j<column;j++){
        grid1[i][j] = 0;
        System.out.print(grid1[i][j] + "   ");
      }
      System.out.println("   ");
    }
    
    // Player 2 entering the x and y coordinates of his ships by the help of class Player
    Player def = new Player();
    for(int i =0; i<5;i++){
      int x = def.setx(i);
      int y = def.sety(i);
      printGridafterchange1(x , y, grid1, row, column);
    }
    System.out.println("Player 2 your done.");
    // for loop to leave 37 lines so player 1 can't see player 2's ship placement
    for (int i = 0; i < 37; i++) {
      System.out.println();
    }     
    // Strikes between the players
    System.out.println("****************************\n|                          |\n|        STRIKE TIME       |\n|                          |\n****************************"); // intro
    System.out.println("Now both players have set their grids, NOW GET READY FOR WAR! Hope you didn't look at your opponent’s ship placement! Player 1 goes first and then player 2, taking turns between players");
    // space between player 1 and intro of strikes
    for(int i=0;i<6; i++){
      System.out.println();
    }
    boolean check = false; // Boolean to check if all ships are hit or not
    int sum = 0; // counter that will be recording the number of destroyed ships in the opponents players grid to see if player 1 won
    int sum1 = 0; // counter that will be recording the number of destroyed ships in the opponents players grid to see if player 2 won
    // do loop for strikes alternating between player 1 and player 2
    do{
      while(check==false){
        Scanner in = new Scanner (System.in); // call scanner      
        // player 1 strike
        System.out.println("Player 1, this is your grid, if there are any other number then 1's on the coordinates where you placed your ship, then they are the ships that got eliminated.");
        printGrid(grid); // print player 1 to see his own grid
        System.out.println("Player 1 enter the x coordinate of your strike from 0-4:");
        int p1xs = in.nextInt(); // saves the x coordinate of strike
        // checks for invalid x values
        while(p1xs < 0 || p1xs > 4){
          System.out.println("Invalid entry, enter again");
          p1xs = in.nextInt();
        }
        System.out.println("Player 1 enter the y coordinate of your strike from 0-4:");
        int p1ys = in.nextInt(); // saves y values
        // check for invalid y value
        while(p1ys < 0 || p1ys > 4){
          System.out.println("Invalid entry, enter again");
          p1ys = in.nextInt();
        }
        // the following piece of code if to check if strike was successful, flop, or strike at the same spot again.
        if(grid1[p1xs][p1ys]==1){
          grid1[p1xs][p1ys] = 2;
          System.out.println("Boom!!! You got the ship, Congrats!");
        }
        
        else if(grid1[p1xs][p1ys]==0){
          System.out.println("Oh no you missed, try again next time and next time try not to enter this coordinate again!");
        }
        else if(grid1[p1xs][p1ys]==2){
          System.out.println("You have already strike this ship coordinate, remember the ship coordinates you already hit");
        }
        // for loop to leave 37 lines so player 2 can't see player 1's strike coordinates
        for (int i = 0; i < 37; i++) { // makes space between both players grids
          System.out.println();
        }      
        
        
        // Player 2 strike    
        System.out.println("Player 2, this is your grid, if there are any numbers other then 1's on the coordinates where you placed your ships, then they are the ships that got eliminated.");
        printGrid1(grid1); // player 2 to see his grid after strikes
        System.out.println("Player 2 enter the x coordinate of your strike from 0-4:");
        int p2xs = in.nextInt(); // save x value of strike
        while(p2xs < 0 || p2xs > 4){
          System.out.println("Invalid entry, enter again");
          p2xs = in.nextInt(); // check for invalid
        }
        System.out.println("Player 2 enter the y coordinate of your strike from 0-4:");
        int p2ys = in.nextInt(); // save y value of strike
        while(p2ys < 0 || p2ys > 4){
          System.out.println("Invalid entry, enter again");
          p2ys = in.nextInt();// check for invalid
        }
        // the following piece of code if to check if strike was successful, flop, or strike at the same spot again.
        if(grid[p2xs][p2ys]==1){
          grid[p2xs][p2ys] = 2;
          System.out.println("Boom!!! You got the ship, Congrats!");
        }
        
        else if(grid[p2xs][p2ys]==0){
          System.out.println("Oh no you missed, try again next time and next time try not to enter this coordinate again!");
        }
        else if(grid1[p1xs][p1ys]==2){
          System.out.println("You have already strike this ship coordinate, remember the ship coordinates you already hit");
        }
        /*// for loop to leave 37 lines so player 1 can't see player 2's strike coordinates
         for (int i = 0; i < 37; i++) { // makes space between both players grids
         System.out.println();
         }*/
        // the following for loops are to check which player gets all their ships eliminated and tells that the other player has won.
        // for loop to check if player 2 won
        for(int i =0;i<5;i++){
          for(int j=0;j<5;j++){
            if (grid[i][j] == 2) {
              grid[i][j] = 3;
              sum++;
              if(sum == 5){
                check=true;
                System.out.println("Player 2 win's, player 1 all your ships sunk right to the bottom of the sea.");
                break;
              }
            }
          }
        }
        // for loop to check if player 1 won
        for(int i =0;i<5;i++){
          for(int j=0;j<5;j++){
            if (grid1[i][j] == 2) {
              grid1[i][j] = 3;
              sum1++;
              if(sum1 == 5){
                check=true;
                System.out.println("Player 1 win's, player 2 all your ships sunk right to the bottom of the sea.");
                break;
              }  
            }
          }
        }       
        // for loop to leave 37 lines so player 1 can't see player 2's strike coordinates
        for (int i = 0; i < 37; i++) { // makes space between both players grids
          System.out.println();
        }      
      }// end while loop
    }// end do loop
    
    // while loop to end game if all the ships of one player is sunk.
    while(check != true);
  }// end main method
  
  // Method1 that prints the grid with placement of ships for player 1
  public static void printGridafterchange( int x, int y, int[][]grid, int row, int column){ // method open  
    grid[x][y] = 1;
    for( int i = 0; i<row;i++){
      for(int j = 0; j<column;j++){        
        System.out.print(grid[i][j] + "   ");
      }
      System.out.println("   ");
    }
  }// method close
  
  // Method2 that prints the grid with placement of ships for player 2
  public static void printGridafterchange1( int x, int y, int[][]grid1, int row, int column){ // method open  
    grid1[x][y] = 1;
    for( int i = 0; i<row;i++){
      for(int j = 0; j<column;j++){        
        System.out.print(grid1[i][j] + "   ");
      }
      System.out.println("   ");
    }
  }// method close
  
  // Method3 to print grids after strikes for player 1
  public static void printGrid(int[][] g) {// method open
    for (int i = 0; i < g.length; i++) {
      for (int j = 0; j < g[i].length; j++)
        System.out.print(g[i][j] + "   ");
      System.out.println();
    }
  }// method close
  
  // Method4 to print grids after strikes for player 2
  public static void printGrid1(int[][] g) {// method open
    for (int i = 0; i < g.length; i++) {
      for (int j = 0; j < g[i].length; j++)
        System.out.print(g[i][j] + "   ");
      System.out.println();
    }
  } // method close
  
}// end program
