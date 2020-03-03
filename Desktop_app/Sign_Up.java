//sign up page for LIBRARY
import java.util.*;
import java.io.*;
import javax.swing.*;
class Sign_Up
{
    private int dd;
    private int mm;
    private int yy;
    public Sign_Up()
    {
        registration();
        return;
    }
    public void registration()
    {
        int pos = 0;
        JOptionPane j=new JOptionPane();//using the class JOptionPane, input will be taken through windows(panes)

        try{
            BufferedReader br=new BufferedReader(new FileReader("Index Codes.txt"));
            pos=Integer.parseInt(br.readLine());}
        catch(FileNotFoundException e){
            System.out.println(e);}
        catch(IOException e){
            System.out.println(e);}

        String name, email, pass;
        System.out.println("So, you are new to E.LIBRARY?");
        System.out.println("To access E.LIBRARY, we need your following details. Please register below (And give correct details):");
        System.out.println("\n\n\t\t\tLIBRARY Registration Form");
        System.out.println("\t\t______________________________________________");        
        System.out.println("\t\tThe details that you will be entering shall be displayed below:");

        try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
        name=j.showInputDialog(null, "Enter your full name", "Name", 1);
        System.out.println("Your name is "+name);
        email=j.showInputDialog(null, "Enter your email-id", "Email-id", 1);
        System.out.println("Your email-id is "+email);
        pass=j.showInputDialog(null, "Enter a desired password for account", "Password", 1);
        System.out.println("Your password is "+pass);
        j.showMessageDialog(null, "Now enter your date of birth(accordingly)", "Press Ok After Reading", j.INFORMATION_MESSAGE);
        do
        {
            try
            {
                dd=Integer.parseInt(j.showInputDialog(null, "Enter day of birth", "Day", j.QUESTION_MESSAGE));
                mm=Integer.parseInt(j.showInputDialog(null, "Enter month of birth", "Month", j.QUESTION_MESSAGE));      
                yy=Integer.parseInt(j.showInputDialog(null, "Enter year of birth", "Year", j.QUESTION_MESSAGE));
            }
            catch(Exception e){j.showMessageDialog(null, "Please enter a correct value!", "Input Error", j.ERROR_MESSAGE); continue;}
        }while(checkDOB(dd,mm,yy)==false);
        System.out.println("Your day of birth is "+dd);
        System.out.println("Your month of birth is "+mm);
        System.out.println("Your year of birth is "+yy);
        if(checkDOB(yy)==true)
        {
            try{
                System.out.println("Please wait while your data is stored...");
                Thread.sleep(2000);}
            catch(InterruptedException e){
                System.out.println("Error:"+e.getMessage());}

            j.showMessageDialog(null, "Your account index is: "+ ++pos, "Index Code", j.INFORMATION_MESSAGE);

            System.out.println("\n\nPlease enter this compulsory index number during login. Your index number is unique.");
            System.out.println("Congratulations! You have successfully created an account in LIBRARY!");
            System.out.println("Next time you login, you have to enter your password,e-mail id and your unique index no., that's all!");
            //index number conversion to string:
            String p="";
            p=p.valueOf(pos);
            //Creation of file names:
            String a="Name"+p+".dat";
            String b="E-mail id"+p+".dat";
            String d="Password"+p+".dat";
            String e1=p+".dat";
            try
            {   
                PrintStream p1=new PrintStream(new FileOutputStream(a));
                PrintStream p2=new PrintStream(new FileOutputStream(b));
                PrintStream p4=new PrintStream(new FileOutputStream(d));
                PrintStream p5=new PrintStream(new FileOutputStream("Index Codes.txt"));
                PrintStream p6=new PrintStream(new FileOutputStream(e1));
                p1.println(name);
                p2.println(email);
                p4.println(pass);
                p5.println(pos);
            }
            catch(Exception e)
            {
                System.out.println("Error:"+e.getMessage());
            }
            try{
                System.out.println("Loading...");
                Thread.sleep(2000);}
            catch(InterruptedException e){
                System.out.println("Error:"+e.getMessage());}
            return;
        }
        else{ j.showMessageDialog(null, "Since you are under 18, you cannot access LIBRARY", "Under 18 Members Are Not Allowed", j.ERROR_MESSAGE);
            System.exit(0);}
    }

    public boolean checkDOB(int yy)
    {
        Calendar c=Calendar.getInstance();
        int y=c.get(Calendar.YEAR);
        boolean b=false;
        if((y-yy)>=8)
            b=true;
        return b;        
    }

    public boolean checkDOB(int day, int month, int year)
    {
        int days[]={31,0,31,30,31,30,31,31,30,31,30,31};
        if(day<=0 || month<=0 ||year<=0)
            return false;
        if(month>=13)
            return false;
        if((year%4==0 && year%100!=0) || (year%400!=0))
            days[1]=28;
        else
            days[1]=29;
        if(day>days[month-1])
            return false;
        return true;
    }
}
