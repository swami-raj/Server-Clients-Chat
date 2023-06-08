import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class slayerclient {
    public static void main(String[] args) {
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("press Y to start conversatation and press Q to exit");
            String button=sc.next();
            if(button.equals("Y")) {

                Socket s = new Socket("localhost", 5001);
                Scanner read = new Scanner(s.getInputStream());
                PrintStream write = new PrintStream(s.getOutputStream());

                while (true) {
                    String sendmsg = sc.nextLine();
                    write.println(sendmsg);
                    if(sendmsg.equals("Q")){
                        break;
                    }
                    String msgread = read.nextLine();
                    System.out.println(msgread);
                    write.flush();
                }
            }
        }
        catch (Exception e){

        }
    }
}
