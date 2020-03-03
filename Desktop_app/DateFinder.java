import java.util.*;
import java.io.*;
public class DateFinder
{
    public void Main(String d2)
    {
        String m[]={"Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
        int day[]={31,28,31,30,31,30,31,31,30,31,30,31};
        Date date=java.util.Calendar.getInstance().getTime();  
        String d=date.toString();
        String d1=d.substring(0,d.indexOf(' ',8));
        //File f=new File("fine") 
        String m1=d1.substring(d1.indexOf(' ')+1,d1.lastIndexOf(' '));
        String m2=d2.substring(d2.indexOf(' ')+1,d2.lastIndexOf(' '));
        if(m1.equalsIgnoreCase(m2))
        {
            int day1=Integer.parseInt(d1.substring(d1.lastIndexOf(' ')+1));
            int day2=Integer.parseInt(d2.substring(d2.lastIndexOf(' ')+1));
            if(day1-day2>1)
            new Fine(day1-day2-1);
            else
            System.out.println("No fine for you");
        
    }
    else
    {
        //checking for unequal months
        int i,k,dd=0,a;
        for( i=0;i<12;i++)
        {
            if(m1.equalsIgnoreCase(m[i]))
            {
                for( k=0;k<12;k++)
                {
                    if(m2.equalsIgnoreCase(m[k]))
                    {
                     dd=day[k]-Integer.parseInt(d2.substring(d2.lastIndexOf(' ')+1))+1;
                    break;
                }
                }
                 a=k+1;
                while(a!=i)
                {
                    dd=dd+day[a];
                    a++;
                }
                dd=dd+Integer.parseInt(d1.substring(d1.lastIndexOf(' ')+1));
            }
    }
        new Fine(dd-1);
}
}
}