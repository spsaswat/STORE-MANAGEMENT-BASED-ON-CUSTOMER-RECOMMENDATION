//Sign in page
import java.io.*;
import javax.swing.*;
class Sign_In
{
    private String name;   
    private String pass;
    public Sign_In()throws Exception//default constructor
    {        
        showGet();
    }

    public void showGet()throws Exception
    {
        //for checking if all details are correct:
        int a=0;
        JOptionPane j=new JOptionPane();

        System.out.println("\n\nTo start with, you need to enter your name, password and index number. \nIf they exist in our records then you can access our services");
        String n=j.showInputDialog(null, "Enter your email-id", "Email-id", 1);    
        String p=j.showInputDialog(null, "Enter your password", "Password", 1);
        String in=j.showInputDialog(null, "Enter your unique account index code", "Index Code", 1);
        try
        {
            BufferedReader br1=new BufferedReader(new FileReader("E-mail id"+in+".dat"));            
            BufferedReader br3=new BufferedReader(new FileReader("Password"+in+".dat"));
            name=br1.readLine();            
            pass=br3.readLine();
        }
        catch(FileNotFoundException e)
        {
            j.showMessageDialog(null, "Sorry, but the index code you entered is not valid!", "Wrong Index Code", j.WARNING_MESSAGE);
        }
        catch(IOException e)
        {
            System.out.println("Error:"+e.getMessage());
        }

        try
        {          
            System.out.println("Checking our records.......");
            Thread.sleep(2000);
        }
        catch(InterruptedException ie)
        {
            System.out.println("Error:"+ie.getMessage());
        }  

        if(n.equalsIgnoreCase(name)==true)
            a++;
        if(p.equals(pass)==true)
            a++;
        if(a==2)
        {                      
            String chknm="";
            try{BufferedReader nm=new BufferedReader(new FileReader("Name"+in+".dat"));
                chknm=nm.readLine();}
            catch(Exception e){System.out.println(e);}                
            System.out.println("\n\n\n\n\n\n\n\n\nWelcome "+chknm+"!!!");
            System.out.println("\n\tYour account has been verified. Now you can access our library!");
            Account obj=new Account(in);   
            obj.menu();
        }
        else
            j.showMessageDialog(null, "Sorry, but your account does not exist...please check your name, email id and password", "Account Existence: 0", j.ERROR_MESSAGE);
    }
}
