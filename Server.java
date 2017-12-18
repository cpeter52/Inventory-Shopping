import java.io.*;
import java.net.*;
import java.util.*;
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket connection = new ServerSocket(9090);
        int x=0;
        int count =0;
        int selection =0;
        int totalPrice =0;
        List<Integer> cart = new ArrayList<Integer>();
        int bananaCart=0;
        int orangeCart=0;
        int pineappleCart=0;
        int watermelonCart=0;
        boolean shop = false;

        
        System.out.println("Server running.");
       try{
            Socket clientSocket = connection.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            String message = "Connected!";
            System.out.println(message);
            out.println(message);
            Random generator = new Random();
            int bananas = generator.nextInt(10) + 10;
            int oranges = generator.nextInt(10) + 10;
            int pineapples = generator.nextInt(10) + 10;
            int watermelons = generator.nextInt(10) + 10;
            int bananaPrice =2;
            int orangePrice =3;
            int pineapplePrice =5;
            int watermelonPrice =8;
            out.println(bananas);
            out.println(oranges);
            out.println(pineapples);
            out.println(watermelons); 
            
            //Read in array for cart
            System.out.println("Collecting!");
            bananaCart = Integer.parseInt(input.readLine());
            orangeCart = Integer.parseInt(input.readLine());
            pineappleCart = Integer.parseInt(input.readLine());
            watermelonCart = Integer.parseInt(input.readLine());
            
            //Calculate totals
            cart.add(bananaCart*bananaPrice);
            cart.add(orangeCart*orangePrice);
            cart.add(pineappleCart*pineapplePrice);
            cart.add(watermelonCart*watermelonPrice);
            
            while(x < cart.size()){
                totalPrice = totalPrice + cart.get(x);
                x++;
            }  
            //Print totals
            message = ("Your total is $"+totalPrice+".");
            out.println(message);
            System.out.println(message);
                clientSocket.close();   
       } finally {    
           connection.close();
           System.out.println("Connection closed!");
           System.exit(0);
       }  
    }  
}
