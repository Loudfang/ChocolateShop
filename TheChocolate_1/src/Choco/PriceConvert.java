
package Choco;
import java.util.*;
import java.text.*;

public class PriceConvert {  
    static String Cashout;
    
    
  public static void Cashout() 
  
  {
      
     System.out.println("Enter the weight in grams of the chocolate"); 
    double weight;
    Scanner in = new Scanner(System.in); 
    DecimalFormat twoD = new DecimalFormat("#.00");  // Ensures the format is to 2 decimal places
 
   
    weight = in.nextDouble();
 
    weight = (weight *0.38);   // 0.38 is the price of 1 gram of chocolate
 
    System.out.println("The price in AED is : " +(twoD.format(weight))); //Prints the output in the right format for currency
     
    
    Cashout();
}

    
}




