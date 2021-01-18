import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Zealots {
    
    private final int max;
    private final int min;
    
    private int turn;
    public  int count=0;
    public  static int num=0;
    
    private final String name;
    private final String record;
    private final String turnf;
    
    
    public Zealots(String a,int b,int c, int min, int max){
        this.turn=c;
        this.min=min;
        this.max=max;
        this.name=a+".txt";
        this.record="Record "+a+".txt";
        this.turnf="Turn "+a+".txt";
        num = b;
    }
    
//    public Service(String a, int min, int max){
//        this.turn=min;
//        this.min=min;
//        this.max=max;
//        this.name=a.concat(".txt");
//        this.record=a.concat("Record.txt");
//        this.turnf=a.concat("turn.txt");
//    }    
    
    public void turn(){
        this.count++;
        this.turn++;
        num++;
        try{
            PrintWriter pw;
            
            pw = new PrintWriter(new FileOutputStream(new File(this.name),true));
            pw.printf("%03d",this.turn);            
            pw.println();
            pw.close();
            
            pw = new PrintWriter(new FileOutputStream(new File(this.record),true));
            pw.printf("In: %03d - %s",this.turn,Date());            
            pw.println();
            pw.close();
            
            pw = new PrintWriter(new FileOutputStream(new File(this.turnf)));
            pw.printf("%03d",this.turn);
            pw.close();
            
            pw = new PrintWriter(new FileOutputStream(new File("Total number in queue.txt")));
            pw.printf("%d",num);
            pw.close();
        }
        catch (IOException e) {
            System.out.println("Problem with file output"); 
        }
        
        System.out.printf("Your number: %03d\n%s\n",this.turn,Date());
    }
    
    public String call(int n,int m) throws FileNotFoundException, IOException{
        num--;     
        PrintWriter pw;
        String s="0";
        
        BufferedReader br = new BufferedReader(new FileReader(this.name));
        for(int i=0; i<n; i++)
            s=br.readLine();
        
        pw = new PrintWriter(new FileOutputStream(new File("Total number in queue.txt")));
        pw.printf("%d",num);
        pw.close();
        
        pw = new PrintWriter(new FileOutputStream(new File(this.record),true));
        pw.printf("Out: %s - %s",s,Date());            
        pw.println();
        pw.close();
        
        display(n,m);
        
        return s;
    }
    
    public void display(int n,int m) throws FileNotFoundException, IOException{
        PrintWriter pw;
        String s="0";
        
        BufferedReader br = new BufferedReader(new FileReader(this.name));
        for(int i=0; i<n; i++)
            s=br.readLine();
        
        pw = new PrintWriter(new FileOutputStream(new File("Display.txt"),true));
        pw.printf("Number: "+s);
        pw.println();
        pw.printf("Counter:"+m);            
        pw.println();
        pw.close();
        
    }
        
    private static String Date(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date    today = Calendar.getInstance().getTime();
        return df.format(today);
    }
    
    

    

}
    



