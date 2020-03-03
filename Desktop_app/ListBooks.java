import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ListBooks
{
    public ListBooks()throws IOException
    {
        print();
    }
    public void print()throws IOException
    {
        System.out.printf("\f");
        Scanner sc=new Scanner(System.in);
        char ch='\u0000';
        File bno=new File("bno.txt");
        int no=0;
        try{
               BufferedReader b=new BufferedReader(new FileReader(bno));
               no=Integer.parseInt(b.readLine());
        }catch(FileNotFoundException e){}
        
        File file=new File("books.txt");
        BufferedReader input=new BufferedReader(new FileReader(file));
        String[][] arr=new String[no][4];
        int i,v=0;
        for(i=0;i<no;i++){
            arr[i][0]=Integer.toString((i+1));
            arr[i][3]=input.readLine();
            arr[i][1]=input.readLine();
            arr[i][2]=input.readLine();
            File copy=new File(arr[i][1]+".bk");
            try{
                   BufferedReader br=new BufferedReader(new FileReader(copy));
                   arr[i][3]=(br.readLine());
            }catch(FileNotFoundException e){}
        } 
        
        System.out.printf("%s  %23s%38s%30s\n","Serial No.","Book Title","Author Name","Copies Left");
        for(i=0;i<no;i++)
            System.out.printf("\n    %-15s  %-40s%-35s%-34s",arr[i][0],arr[i][1],arr[i][2],arr[i][3]);
        System.out.println("\n\n\nPress Y to go back to previous menu,press any key to exit");
        ch=sc.next().charAt(0);
        if(ch!='Y'&&ch!='y'){
           System.out.print("Goodbye!!!!");
           System.exit(0); 
        }
    }
}
