
import java.util.*;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args){
        List<Integer> deck = new ArrayList<Integer>();
        IntStream.range(0, 4).forEach(
            n -> {
                IntStream.range(1, 14).forEach(
                    m -> {
                        switch(m) {
                            case 11:
                            case 12:
                            case 13:
                                m = 10;
                        };
                        deck.add(m);
                    }
                );
            }
        );
        
        IntStream.range(0, 5).forEach(
            n -> {
                Collections.shuffle(deck);
            }
        );

        Scanner ask = new Scanner(System.in);

        int playerDraw1 = deck.get(0) ;
        int playerDraw2 = deck.get(1) ;
        int dealerDraw1 = deck.get(2) ;
        int dealerDraw2 = deck.get(3) ;

        System.out.println("You got: " + playerDraw1 + " " + playerDraw2);
        System.out.println("Dealer got: " + dealerDraw1);
        
        int playerDraw = 0;
        int dealerDraw = 0;
        int dealerHand = dealerDraw1 + dealerDraw2;
        int hand = playerDraw1 + playerDraw2;

        int draw = 4 ;

        while (true) {
            if (hand > 21)
                break;
            System.out.println("Current Hand: " + hand);
            System.out.print("Draw more? ( y/n ) ");
            String answer = ask.next();

            if (answer.equals("y")) {
                playerDraw = deck.get(draw) ;
                System.out.println("You got " + playerDraw);
                hand += playerDraw;
                draw += 1 ;
            }
            else break;
        }

        ask.close();

        if (hand > 21) {
            System.out.print("You got more then 21");
            System.exit(0); 
        }
        else if (hand == 21) {
            System.out.print("BlackJack!");
            System.exit(0);
        }
        System.out.println("Dealer Second is: " + dealerDraw2);

        while (dealerHand < 16) {
            dealerDraw = deck.get(draw);
            System.out.println("Dealer got " + dealerDraw);
            dealerHand += dealerDraw;
            draw += 1;
        }

        System.out.println("Dealer hand is: " + dealerHand);
        if (dealerHand > 21){
            System.out.println("Dealer lost");
            System.exit(0);
        }
        if (hand > dealerHand) {
            System.out.print("Win");
        }
        else if (hand == dealerHand)
            System.out.print("Draw");
        else if (hand < dealerHand)
            System.out.print("Lose");
    }
}

