import java.io.*;
import java.net.*;
import java.util.Scanner;

public class slayerserver {
    public static void main(String[] args) {
        try{
            ServerSocket ss=new ServerSocket(5001);
            System.out.println(InetAddress.getLocalHost());
            System.out.println(InetAddress.getLocalHost().getHostName());
            Scanner sc=new Scanner(System.in); //to read data from consol
            Socket s=ss.accept();
            System.out.println("Connection established");
            Scanner read=new Scanner(s.getInputStream());  //to read data coming from client
            PrintStream write=new PrintStream(s.getOutputStream()); //to write data to socket

                while (true) {
                    String msgread = read.nextLine();
                    System.out.println(msgread);
                    if(msgread.contains("Q")){
                        System.out.println("Connection terminated");
                        break;
                    }
                    String sendmsg = sc.nextLine();
                    write.println(sendmsg);
                }
                write.flush();
                s.close();

        }
        catch (Exception e){

        }
    }
}
