//displaying the main menu
import java.util.*;
import javax.swing.*;
import java.io.*;
class Account
{
    JOptionPane j=new JOptionPane();
    Scanner sc=new Scanner(System.in);
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    private String index;
    public Account(String ind)
    {   
        index=ind;
    }
    public void menu()throws Exception
    {
        do
        {
            String s1= 
                "\n\n------------------------Account Menu--------------------------"+
                "\n------------------------------------------------------------------"+
                "\n~Issue book....................................................1"+
                "\n~Return book..................................................2"+
                "\n~Current account..........................................3"+
                "\n~Search books...............................................4"+
                "\n~About us........................................................5"+
                "\n~Log Out..........................................................6"+
                "\n------------------------------------------------------------------"+             
                "\n\n"+
                "Kindly enter a key to browse your desired section:";
            String options[]={"1", "2", "3", "4", "5","6"};
            int opt=j.showOptionDialog(null, s1, "Account Menu", j.YES_NO_CANCEL_OPTION, j.QUESTION_MESSAGE, null, options, options[0]);
            opt++;
        outer:switch(opt) 
               {
                case 1:     try{
                             BufferedReader br=new BufferedReader(new FileReader(index+".dat"));
                             if((br.readLine()).length()>0)
                             {  System.out.println("You have not returned the last book.Return it first.");
                                break outer;}
                            }catch(Exception e){System.out.println(e.getMessage());}
                            do{
                                System.out.print("\f");
                                System.out.print("\nEnter book name: ");
                                String bname=br.readLine().trim();
                                // Giving a time delay
                                    System.out.print("\nSearching Our Database\nPlease Wait");
                                    for(int i=0;i<6;i++)
                                    {  
                                        Thread.sleep(70);
                                        System.out.print(".");
                                        Thread.sleep(180);
                                    }
                                File file=new File(bname+".bk");
                                String s2="";
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
                                        }
                                         catch(FileNotFoundException e){
                                             System.out.println(e);}
                                     PrintStream p=new PrintStream(new FileOutputStream(file));
                                     p.println(--v);
                                     p.println(book);
                                     p.println(aname);
                                     PrintStream p1=new PrintStream(new FileOutputStream(index+".dat"));
                                     p1.println(book);
                                     p1.println(aname);
                                     if(v>0){
                                     System.out.println("\n\nMatch Found!!!");
                                     Thread.sleep(700);
                                     System.out.print("\f");
                                     // To print Author & name
                                     System.out.printf("\nTitle: %s\nAuthor: %s",book,aname);
                                     System.out.println("\nThe Book you requested is sucessfully issued!!!!!");
                                     System.out.println("\nRemaning Copies= "+v);
                                     break outer;
                                    }
                                    else{
                                        System.out.println("\nSorry Stock has expired");
                                    }
                                }
                                System.out.println("\nBook not found.Want to view all available books ? ");
                                char c=sc.next().charAt(0);
                                if(c=='Y'||c=='y'){
                                    System.out.println("\nWorking.....");
                                    new ListBooks();
                                }
                                System.out.println("\nWant to re enter?(Y/N)");
                                char ch=sc.next().charAt(0);
                                if(ch!='Y'&&ch!='y')
                                    break outer;
                            }while(true);
                case 2:     String s2="";
                            try{
                                BufferedReader br=new BufferedReader(new FileReader(index+".dat"));
                                s2=br.readLine();}
                                catch(FileNotFoundException e){
                                    System.out.println(e);}
                            if(s2.length()>0)
                            {
                                String s3="";int v=0;
                                String book="";
                                String aname="";
                                 try{
                                    BufferedReader br=new BufferedReader(new FileReader(s2+".bk"));
                                    v=Integer.parseInt(br.readLine());
                                    book = br.readLine();
                                    aname = br.readLine();
                                   }
                                 catch(FileNotFoundException e){
                                     System.out.println(e);
                                }
                                PrintStream p2=new PrintStream(new FileOutputStream(index+".dat"));
                                p2.println("");
                                PrintStream p3=new PrintStream(new FileOutputStream(s2+".bk"));
                                p3.println(++v);
                                p3.println(book);
                                p3.println(aname);
                                System.out.println("Book successfully returned!!!  "+book);
                                System.out.println("Remaning Copies= "+v);
                                System.out.println("Enter your date of issue(eg Tue Mar 26) : ");
                                BufferedReader brr=new BufferedReader(new InputStreamReader(System.in));
                                String ss=brr.readLine();
                                new DateFinder().Main(ss);
                                System.out.println("Please rate this book!");
                                double r=sc.nextDouble();
                                new Recommend(r,book);
                                
                                break outer;
                               }
                            else
                                System.out.println("NO book to return!!!!");
                            break;
                case 3:     s2="";
                            String s3="";
                            try{
                                BufferedReader br=new BufferedReader(new FileReader(index+".dat"));
                                s2=br.readLine();
                                s3=br.readLine();
                            }
                                catch(FileNotFoundException e){
                                    System.out.println(e);}
                            if(s2.equals(""))
                                System.out.println("No book currently reading!");
                            else
                                System.out.println("Currently reading : "+s2+" by "+s3);
                            break;
                case 4:     System.out.println("Enter book name or part of it(From beginning)");
                            String s=br.readLine();
                            File bno=new File("bno.txt");
                            int no=0;           
                            try{
                                   BufferedReader b=new BufferedReader(new FileReader(bno));
                                   no=Integer.parseInt(b.readLine());
                            }catch(FileNotFoundException e){}   
                            BufferedReader input=new BufferedReader(new FileReader("books.txt"));
                            int flag=0;
                            for(int i=0;i<no;i++)
                            {
                                int left=Integer.parseInt(input.readLine());
                                String s4=input.readLine();
                                String s5=s4.substring(0,s.length());
                                if(s5.equalsIgnoreCase(s))
                                   System.out.println("\t"+(++flag)+".   "+s4+"\n\t   By : "+input.readLine()+"\n\t   Copies available : "+left);
                                else
                                    s4=input.readLine();   
                            }
                            if(flag==0)
                                System.out.println("No book match found!!!!");    
                            break;             
                case 5:     System.out.println("\nThis project was done by Soham Sarkar, Ayanabha Jana and Shubham Singh for DBMS project\n");
                            break;
                case 6:     System.out.print("Goodbye!");
                            System.exit(0);
                            break outer;
                default :   System.out.println("Wrong choice!!!!Choose again.");
               }
        }while(true);
    }
}