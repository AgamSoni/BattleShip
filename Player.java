/*Agam.S
 * This program lets both player enter their x and y values of their ship coordinates allowing them to make their grids seperately.*/
import java.util.Scanner; // import scanner
public class Player{ // open class
  private int[] x = new int[5]; // intialize instant variable for x values and store then in an array of size 5
  private int[] y = new int[5]; // intialize instant variable for 5 values and store then in an array of size 5
  // this methods mutates the x coordinates of the original grid to the values entered by user. It also checks for invalid entry's
  public int setx(int i){ 
    Scanner in = new Scanner(System.in);
    System.out.println("Please place your ship by entering x from 0-4: ");
    x[i] = in.nextInt();
    while( x[i] > 4 || x[i] < 0){
      System.out.println ("Invalid entry, please enter again");
      x[i] = in.nextInt(); 
    }
    return x[i]; // return x to the method in main class where they the original grid
  }
  // this methods mutates the y coordinates of the original grid to the values entered by user. It also checks for invalid entry's
  public int sety(int i){
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter y from 0-4: ");
    y[i] = in.nextInt();
    
    while( y[i] > 4 || y[i] < 0){
      System.out.println ("Invalid entry, please enter again");
      y[i] = in.nextInt();
    }
    return y[i]; // return y to the method in main class where they change the original grid
  }
  // access the array of new x for the method in main class to print grid
  public int[] getx(){
    return x;
  }
    // access the array of new y for the method in main class to print grid
  public int[] gety(){
    return y;
  }
}// close class
