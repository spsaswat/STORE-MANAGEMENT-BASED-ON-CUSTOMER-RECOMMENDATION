import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Admin{
    public String bname;
    String crucial="SS48AS51";
    Scanner sc = new Scanner(System.in);
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public Admin()throws IOException
    {
        Main();
        return;
    }
    public void Main()throws IOException
    {
        System.out.print("Enter Admin password: ");
        String s$=sc.nextLine();
        if(s$.equals(crucial)){
            while(true){
                System.out.print("\f");
                System.out.println("***************************WELCOME ADMIN******************************");
                System.out.println("\nEnter 1 to add books to library"+"\nEnter 2 to list all books in library"+"\nEnter 3 to quit\nEnter 4 to return");
                System.out.print("\nEnter Your Choice : ");
                int answer = sc.nextInt();
                System.out.print("\f");
                switch (answer)
                {
                    case 1:     addBooks();
                                break;
                    case 2:     new  ListBooks();
                                break;
                    case 3:     System.out.print("Goodbye!!!!");
                                System.exit(0);
                    case 4:     return;
                    default :   System.out.println("Wrong choice!!!!Choose again.");
                }
            }
        }
        else
            System.out.println("Wrong password!!!Goodbye!");
            System.exit(0);
    }
    void addBooks()throws IOException
    {
        System.out.println("*********************************Add or Remove Books******************************");
        System.out.print("Input Book Name: ");
        String bname = br.readLine();
        File file=new File(bname+".bk");
        File file2=new File("books.txt");
        if(file.exists())
        {
            int v=0;
            String book="";
            String aname="";
            try{
                   BufferedReader br=new BufferedReader(new FileReader(file));
                   v=Integer.parseInt(br.readLine());
                   book = br.readLine();
                   aname = br.readLine();
            }catch(FileNotFoundException e){}
            if(v>0){
                char ch='\u0000';int add=0;
                System.out.printf("\n%d copies of this book already EXIST!!!\n\nDo you want to add(or remove)copies (Y/N)? ",v);
                ch=sc.next().charAt(0);
                if(ch=='Y'||ch=='y'){
                    System.out.print("\nHow many copies do you want to add or remove(-ve no. to remove): ");
                    add=sc.nextInt();
                    System.out.printf("\nRemaning Copies= "+(v+add));//*******************************this line is not printing???????
                    PrintStream p=new PrintStream(new FileOutputStream(file));
                    p.println((v+add));
                    p.println(book);
                    p.println(aname);
                }
            }
         }
        else{
            File bno=new File("bno.txt");
            int no=0;
            try{
                BufferedReader b=new BufferedReader(new FileReader(bno));
                no=Integer.parseInt(b.readLine());
            }catch(FileNotFoundException e){}
            String[] arr=new String[(no*3)];
            BufferedReader input=new BufferedReader(new FileReader(file2));
            for(int i=0;i<arr.length;i++){
                arr[i]=input.readLine();
            }
            PrintStream p=new PrintStream(new FileOutputStream(file2));
            for(int i=0;i<arr.length;i++)
            {
                p.println(arr[i]);
            }
            PrintStream ps=new PrintStream(new FileOutputStream(bno));
            ps.println((++no));
            File bk = new File(bname+".bk");
            System.out.print("Input Author Name: ");
            String aname = br.readLine();
            System.out.print("Enter Number of copies you want to add: ");
            int c=Integer.parseInt(br.readLine());
            p.println(c);
            p.println(bname);
            p.println(aname);
            try{
                PrintWriter pw= new PrintWriter(bk);
                pw.println(c);
                pw.println(bname);
                pw.println(aname);
                pw.close();
            }catch(IOException e){}
        }
    }
}