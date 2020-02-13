
import java.util.*;


public class Main {
    public static void main(String[] args){
        Random card = new Random();
        Scanner ask = new Scanner(System.in);

        int playerDraw1 = card.nextInt(10) + 1;
        int playerDraw2 = card.nextInt(10) + 1;
        int dealerDraw1 = card.nextInt(10)+1;
        int dealerDraw2 = card.nextInt(10)+1;

        System.out.println("You got: " + playerDraw1 + " " + playerDraw2);
        System.out.println("Dealer got: " + dealerDraw1);
        
        int playerDraw = 0;
        int dealerHand = dealerDraw1 + dealerDraw2;
        int hand = playerDraw1 + playerDraw2;

        while (true) {
            if (hand > 21)
                break;
            System.out.println("Current Hand: " + hand);
            System.out.print("Draw more? ( y/n ) ");
            String answer = ask.next();

            if (answer.equals("y")) {
                playerDraw = card.nextInt(10)+1;
                System.out.println("You got " + playerDraw);
                hand += playerDraw;
            }
            else break;
        }

        if (hand > 21) {
            System.out.print("Lose");
            System.exit(0); 
        }
        System.out.println("Dealer Second is: " + dealerDraw2);
        
        if (hand > dealerHand) {
            System.out.print("Win");
        }
        else if (hand == dealerHand)
            System.out.print("Draw");
        else if (hand < dealerHand)
            System.out.print("Lose");
        
    }
}

