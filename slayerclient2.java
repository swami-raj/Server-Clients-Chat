import java.io.*;
import java.net.*;
import java.util.Scanner;
public class slayerclient2 {
    public static void main(String[] args) {
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("press Y to start conversatation and press Q to exit");
            String str= sc.next();
            if(str.equals("Y")){
                Socket s=new Socket("localhost",5001);
                Scanner read1= new Scanner(s.getInputStream());
                PrintStream write1=new PrintStream(s.getOutputStream());
                while(true){
                    String sendmsg = sc.nextLine();
                    write1.println(sendmsg);
                    if(sendmsg.equals("Q")){
                        break;
                    }
                    String msgread = read1.nextLine();
                    System.out.println(msgread);
                    write1.flush();
                }
            }
        }
        catch (Exception e){

        }
    }
}
