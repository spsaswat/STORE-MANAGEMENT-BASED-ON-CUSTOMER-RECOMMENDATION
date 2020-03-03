public class Fine

{
    static int d;
    public Fine(int x)
    {
        d=x;
        main();
    }
    public static void main()

    {
        //slab calculation
    double f=0.0;
    if(d<30)
    f=d*2.0;
    else if(d<60)
    f=60.0+(d-30)*10;
    else if(d<120)
    f=60.0+300.0+(d-60)*20;
    else
    f=360.0+600.0+(d-120)*40;
    
    System.out.println("Your fine is: Rs "+f);
}
}
    
    
     
    
     
    
    