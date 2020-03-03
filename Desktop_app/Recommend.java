import java.util.*;
import java.io.*;
import java.util.Map.Entry;
public class Recommend
{
    static Vector v1,v2;
    static double x1;
    static String xname;
    public Recommend(double x,String xx)throws IOException
    {
        x1=x;
        xname=xx;
        Main();
    }
        
    public static void Main()throws IOException
    {
        Map<String, Map<String, Double>> data = new HashMap<>();
        v1=new Vector();
        System.out.printf("\f");
        Scanner sc=new Scanner(System.in);
        char ch='\u0000';
        File bno=new File("bno.txt");
        int no=0;
        try{
               BufferedReader b=new BufferedReader(new FileReader(bno));
               no=Integer.parseInt(b.readLine());
        }catch(FileNotFoundException e){}
        String arr[][]=new String[no][4];
        File file=new File("books.txt");
        BufferedReader input=new BufferedReader(new FileReader(file));
        int i,k;
        double rate=0.0;
        for(i=0;i<no;i++){
            arr[i][0]=Integer.toString((i+1));
            arr[i][3]=input.readLine();
            arr[i][1]=input.readLine();
            arr[i][2]=input.readLine();
            File copy=new File(arr[i][1]+".bk");
            try{
                   BufferedReader br=new BufferedReader(new FileReader(copy));
                   arr[i][3]=(br.readLine());
                   //Storing all the books in vector
                   v1.add(arr[i][1]);
            }catch(FileNotFoundException e){}
        }
        int n;
        File f=new File("Index Codes.txt");
        BufferedReader b1=new BufferedReader(new FileReader(f));
        n=Integer.parseInt(b1.readLine());
        v2=new Vector();
        String name="";
        for(i=0;i<n;i++)
        {
            File f1=new File("name"+(i+1)+".dat");
            BufferedReader b2=new BufferedReader(new FileReader(f1));
            name=b2.readLine();
            //Storing all the usernames in vector
            v2.add(name);
        }
        System.out.println("Welcome admin! You are requested to give the ratings of the books for the following users");
        System.out.println("If a user has not read a book,enter -1");
        for(i=0;i<v2.size();i++)
        {
            HashMap<String, Double> u = new HashMap<>(); 
            System.out.println(v2.get(i));
            for(k=0;k<v1.size();k++)
            {
             System.out.print(v1.get(k)+":");
              rate=sc.nextDouble();
              if(rate!=-1.0)
             u.put(v1.get(k).toString(),rate);  
            }
            data.put(v2.get(i).toString(),u);
        }
        Recommend re=new Recommend(data);
        HashMap<String, Double> user = new HashMap<>();
        user.put(xname,x1);
        System.out.println("As per your rating...");
        Recommend.print(user); 
        System.out.println("We recommend you...");
        Recommend.print(re.predict(user)); 
    }
    Map<String, Map<String, Double>> mData; 
    Map<String, Map<String, Double>> diffMatrix; 
    Map<String, Map<String, Integer>> freqMatrix; 
    public Recommend(Map<String, Map<String, Double>> data) 
 { 
  mData = data; 
  buildDiffMatrix(); 
 } 
 /**
 * Based on existing data, and using weights, 
 * try to predict all missing ratings. 
 * The trick to make this more scalable is to consider 
 * only mDiffMatrix entries having a large  (>1) mFreqMatrix 
 * entry. 
 * 
 * It will output the prediction 0 when no prediction is possible. 
 */ 
 public Map<String, Double> predict(Map<String, Double> user) 
 { 
  HashMap<String, Double> predictions = new HashMap<>(); 
  HashMap<String, Integer> frequencies = new HashMap<>(); 
  for (String j : diffMatrix.keySet()) 
  { 
   frequencies.put(j, 0); 
   predictions.put(j, 0.0); 
  } 
  //We are going to calculate all the missing ratings by comparing with differences matrix
  for (String j : user.keySet()) 
  { 
   for (String k : diffMatrix.keySet()) 
   { 
    try 
    { 
     //Linear regression
     Double newval = (diffMatrix.get(k).get(j) + user.get(j)) * freqMatrix.get(k).get(j).intValue(); 
     predictions.put(k, predictions.get(k) + newval); 
     frequencies.put(k, frequencies.get(k) + freqMatrix.get(k).get(j).intValue()); 
    } catch (NullPointerException e) 
    {} 
   } 
  } 
  HashMap<String, Double> cleanpredictions = new HashMap<>(); 
  for (String j : predictions.keySet()) 
  { 
   if (frequencies.get(j) > 0) 
   { 
    cleanpredictions.put(j, predictions.get(j) / frequencies.get(j).intValue()); //predictions made on basis of weighted averages which is number of users who have rated a pair of products
   } 
  } 
  for (String j : user.keySet()) 
  { 
   cleanpredictions.put(j, user.get(j)); 
  } 
  return cleanpredictions; 
 } 
 
 public static void print(Map<String, Double> user) 
 { 
  for (String j : user.keySet()) 
  { 
   System.out.println(" " + j + " --> " + user.get(j).floatValue()); 
  } 
 } 
 
 public void buildDiffMatrix() 
 { 
  diffMatrix = new HashMap<>(); 
  freqMatrix = new HashMap<>(); 
  // first iterate through users 
  for (Map<String, Double> user : mData.values()) 
  { 
   // then iterate through user data 
   for (Entry<String, Double> entry : user.entrySet()) 
   { 
    String i1 = entry.getKey(); 
    double r1 = entry.getValue(); 
 
    if (!diffMatrix.containsKey(i1)) 
    { 
     diffMatrix.put(i1, new HashMap<String, Double>()); 
     freqMatrix.put(i1, new HashMap<String, Integer>()); 
    } 
 
    for (Entry<String, Double> entry2 : user.entrySet()) 
    { 
     String i2 = entry2.getKey(); 
     double r2 = entry2.getValue(); 
 
     int cnt = 0; 
     if (freqMatrix.get(i1).containsKey(i2)) cnt = freqMatrix.get(i1).get(i2); 
     double diff = 0.0; 
     if (diffMatrix.get(i1).containsKey(i2)) diff = diffMatrix.get(i1).get(i2); 
     double new_diff = r1 - r2; 
     /*If somebody rated the item before, we increase the frequency count by one and 
      * the difference between the item's ratings, both are stored in frequency and
      * difference matrix
      */
     freqMatrix.get(i1).put(i2, cnt + 1); 
     diffMatrix.get(i1).put(i2, diff + new_diff); 
    } 
   } 
  } 
  /*Now we calculate the similarity scores and store it in diff matrix. The
   * main logic is to divide the calculated item rating's difference by the number
   * of its occurences
   */
  for (String j : diffMatrix.keySet()) 
  { 
   for (String i : diffMatrix.get(j).keySet()) 
   { 
    Double oldvalue = diffMatrix.get(j).get(i); 
    int count = freqMatrix.get(j).get(i).intValue(); 
    diffMatrix.get(j).put(i, oldvalue / count); 
   } 
  } 
 } 


}
        