package ChocoGUI;
import Choco.PriceConvert;
import ChocoGUI.ChocoPro;
import java.awt.*;
import java.io.*;

public class Storage {
   
    static Choconame Choconame;
    static ChocoPro rec;
    
    
    public static void main (String[]args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        rec = new ChocoPro();
        Choconame = new Choconame("Chocolates.txt");
        String tempName="";
        int tempPop=0;
        char c = menu();
        while(c!='Q')
        {
            switch(c)
            {
                case 'L':
                    System.out.println("These are the Chocolate you have available");
                    Choconame.choprint();
                    break;
                case'A':
                    System.out.println("Enter the chocolates you have recieved");
                    tempName=br.readLine();
                    System.out.println("How much of "+tempName+" (In KG)");
                    tempPop=Integer.parseInt(br.readLine());
                    Choconame.choadd(tempName,tempPop);
                    break;
                case'R':
                    System.out.println("Enter the chocolate not available anymore");
                    tempName = br.readLine();
                    Choconame.chodelete(tempName);
                    break;                               
                case'F':
                    System.out.println("Enter the chocolate you wish to check for");
                    tempName=br.readLine();
                    rec=Choconame.chofind(tempName);
                    if(rec==null)
                        System.out.println(tempName+"is not available");
                    else
                    System.out.println("Chocolate: "+rec.getName()+"\t\t Weight available(KG): "+rec.getChocoPro());
                    break;
               case'S':
                   System.out.println("Enter the name of the file to save");
                   tempName=br.readLine();
                   Choconame.save(tempName);
                   break;
               case'P':
                   PriceConvert.Cashout();
                   break;
              }
            c = menu();
            
        }
        System.out.println("\nBye");
    }
    
    
    
    public static char menu() throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ChocoPro cp=new ChocoPro();
        System.out.println("Chocolate Stock Menu");
        System.out.println("L - List all");
        System.out.println("A - Add a chocolate");
        System.out.println("R - Remove a chocolate");
        System.out.println("F - Find a chocolate");
        System.out.println("P - Use price converter");
        System.out.println("S - Save the file");
        System.out.println("Q - Quit");
        System.out.println("\n Please select an option");
        String choice= br.readLine().toUpperCase();
        return choice.charAt(0);
    }
    
}
