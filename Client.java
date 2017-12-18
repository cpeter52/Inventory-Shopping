import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.*;

public class Client {

    public static void main(String[] args) throws IOException {
        String localHost = "127.0.0.1";
        Socket clientSocket = new Socket(localHost, 9090);
        boolean check = false;
        int number = 0;
        int cost =0;
        int selection = 0;
        List<Integer> banCart = new ArrayList<Integer>();
        List<Integer> orgCart = new ArrayList<Integer>();
        List<Integer> pineappCart = new ArrayList<Integer>();
        List<Integer> watermelCart = new ArrayList<Integer>();
        int banTotal = 0;
        int orgTotal = 0;
        int pineappTotal = 0;
        int watermelTotal = 0;
        String total = null;
        
        //Scanners
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        Scanner in = new Scanner(System.in);
        String message = input.readLine();
        System.out.println(message + "...");
        System.out.println("Welcome to the Online Fruit Stand! Now displaying our current inventory.");
        //Get stock numbers from the server
        int bananas = Integer.parseInt(input.readLine());
        int oranges = Integer.parseInt(input.readLine());
        int pineapples = Integer.parseInt(input.readLine());
        int watermelons = Integer.parseInt(input.readLine());
        //Loop through to shop
        do {
            //Create options along with stock numbers
            System.out.println("1.Bananas - $2 Each) -"+ bananas +" in stock");
            System.out.println("2.Oranges - $3 Each) -"+ oranges +" in stock");
            System.out.println("3.Pineapples - $5 Each) -"+ pineapples +" in stock");
            System.out.println("4.Watermelons - $8 Each) -"+ watermelons +" in stock");
            System.out.println("5.Finished");
            System.out.println("Select the corresponding number to the fruit you want!");
            //Check for integer
            if (in.hasNextInt()) {
                number = in.nextInt();
                //Take user inputs and select the corresponding option
                //if case doesn't make it will iterate back through
                switch (number) {
                //                 BANANAS
                    case 1:
                        System.out.println("How many bananas would you like?");
                        	//Check for integer
                            if (in.hasNextInt())
                                selection = in.nextInt();
                            //Check to make sure what is requested isn't bigger than the stock
                            if(selection > bananas | selection < 0){
                                System.out.println("Sorry, that is invalid. Please enter a whole number!");
                                System.out.println("Please request equal to or lower than our stock!");
                                in.next();
                            }else{
                                //Update cart and manage stock
                                System.out.println("Updating your cart!");
                                int bananaUpdate = bananas - selection;
                                banCart.add(selection);
                                bananas = bananaUpdate;
                                //Ask if they want to continue
                                System.out.println("Continue shopping?");
                                System.out.println("1.Yes");
                                System.out.println("2.No");
                                //Check for integer
                                    if(in.hasNextInt()){
                                        number = in.nextInt();
                                    }
                                    switch (number) {
                                        case 2:
                                            
                                            check = true;
                                           
                                            break;
                                        case 1:
                                            
                                            break;
                                        default:System.out.println("Select the corresponding number to the fruit you want!");
                                            in.next();
                                            break;
                                    }
                                  }
                        break;
                    case 2:
                         //         ORANGES
                        System.out.println("How many oranges would you like to purchase?");
                            if (in.hasNextInt())
                                selection = in.nextInt();
                            if(selection > oranges | selection < 0){
                                System.out.println("Sorry, that is invalid. Please enter a whole number!");
                                System.out.println("Please request equal to or lower than our stock!");
                                in.next();
                            }else{
                                System.out.println("Updating your cart!");
                                int orangeUpdate = oranges - selection;
                                orgCart.add(selection);
                                oranges = orangeUpdate;
                                System.out.println("Would you like to continue shopping?");
                                System.out.println("1.Yes");
                                System.out.println("2.No");
                                    if(in.hasNextInt()){
                                        number = in.nextInt();
                                    }
                                    switch (number) {
                                        case 2:
                                            
                                            check = true;
                                           
                                            break;
                                        case 1:
                                            
                                            break;
                                        default:System.out.println("Select the corresponding number to the fruit you want!");
                                            in.next();
                                            break;
                                    }
                                  }
                        break;
                    case 3:  
                         //        PINEAPPLES
                        System.out.println("How many Pineapples would you like to purchase?");
                            if (in.hasNextInt())
                                selection = in.nextInt();
                            if(selection > pineapples | selection < 0){
                                System.out.println("Sorry, that is invalid. Please enter a whole number!");
                                System.out.println("Please request equal to or lower than our stock!");
                                in.next();
                            }else{
                                System.out.println("Updating your cart!");
                                int pineappleUpdate = pineapples - selection;
                                pineappCart.add(selection);
                                pineapples = pineappleUpdate;
                                System.out.println("Would you like to continue shopping?");
                                System.out.println("1.Yes");
                                System.out.println("2.No");
                                    if(in.hasNextInt()){
                                        number = in.nextInt();
                                    }
                                    switch (number) {
                                        case 2:
                                            
                                            check = true;
                                           
                                            break;
                                        case 1:
                                            
                                            break;
                                        default:System.out.println("Select the corresponding number to the fruit you want!");
                                            in.next();
                                            break;
                                    }
                                  }
                        break;
                    case 4:
                         //               WATERMELONS
                        System.out.println("How many Watermelons would you like to purchase?");
                            if (in.hasNextInt())
                                selection = in.nextInt();
                            if(selection > watermelons | selection <0){
                                System.out.println("Sorry, that is invalid. Please enter a whole number!");
                                System.out.println("Please request equal to or lower than our stock!");
                                in.next();
                            }else{
                                System.out.println("Updating your cart!");
                                int watermelonUpdate = watermelons - selection;
                                watermelCart.add(selection);
                                watermelons = watermelonUpdate;
                                System.out.println("Would you like to continue shopping?");
                                System.out.println("1.Yes");
                                System.out.println("2.No");
                                    if(in.hasNextInt()){
                                        number = in.nextInt();
                                    }
                                    switch (number) {
                                        case 2:
                                            check = true;
                                           
                                            break;
                                        case 1:
                                            
                                            break;
                                        default:System.out.println("Select the corresponding number to the fruit you want!");
                                            in.next();
                                            break;
                                    }
                                  }
                        break;
                    case 5:
                        check = true;

                        break;
                    default:
                        break;
                }
                } else {
                System.out.println("Please enter the corresponding number to your option");
                in.next();
            }			
            // Print totals
        } while (!(check));
        System.out.println("You have purchased...\n ");
        if(banCart.size()+orgCart.size()+pineappCart.size()+watermelCart.size() ==0){
            System.out.println("Nonthing is in your cart");
        }else{
        for(int x = 0; x < banCart.size(); x++){
         banTotal = banTotal+banCart.get(x);
        }
        out.println(banTotal);
        System.out.println(banTotal +" bananas");
        for(int x = 0; x < orgCart.size(); x++){
         orgTotal = orgTotal+orgCart.get(x);
        }
        out.println(orgTotal);
        System.out.println(orgTotal +" oranges");        
        for(int x = 0; x < pineappCart.size(); x++){
         pineappTotal = pineappTotal+pineappCart.get(x);
        }
        out.println(pineappTotal);
        System.out.println(pineappTotal +" pineapples");       
        for(int x = 0; x < watermelCart.size(); x++){
         watermelTotal = watermelTotal+watermelCart.get(x);
        }
        out.println(watermelTotal);
        System.out.println(watermelTotal +" watermelons");        
        System.out.println(" ");
        }
        total = (input.readLine());
        System.out.println(total);
        System.out.println("Shutting Down.");
        //Close
        clientSocket.close();
        System.exit(0);
    }
}