//First page
import java.util.*;
public class Intro_Main
{
    public static void main(String args[])throws Exception
    {
        int ch=0;
        do{
        System.out.println("\t***********            **                **      *********        ");   
        System.out.println("\t***********            **                **      **      **       ");
        System.out.println("\t**                     **                **      **       **      ");
        System.out.println("\t*******                **                **      **********       ");
        System.out.println("\t*******                **                **      **       **      ");
        System.out.println("\t**                     **                **      **        **     ");
        System.out.println("\t***********    **      ************      **      **       **   ** ");
        System.out.println("\t***********    **      ************      **      **********    ** ");
        System.out.println("\n\t\tWelcome to the best fully electronic library!");
        System.out.println();

        do{
            System.out.println("\tPlease specify :\n\nIf you are a member,press 1\nIf you want to be a member,press 2\nAdministrator,press 3\nPress 4 to exit");
            System.out.print("\n\tEnter Your Choice: ");
            ch=new Scanner(System.in).nextInt();
            if(ch!=1 && ch!=2 && ch!=3 && ch!=4)
            System.out.println("OOPS! Please try again.");
        }while(ch!=1&&ch!=2&&ch!=3&&ch!=4);
         System.out.print("\f");
        switch(ch)
        {
            case 1:   new Sign_In();
                      break;  
            case 2:   new Sign_Up();
                      break;
            case 3:   new Admin();
                      break;
            case 4:   System.out.println("Goodbye");
                      System.exit(0);
        }
        }while(ch!=4);
    }
}