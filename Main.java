
import java.util.*;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args){
        List<Integer> deck = new ArrayList<Integer>();
        IntStream.range(0, 4).forEach(
            n -> {
                IntStream.range(1, 14).forEach(
                    m -> {
                        deck.add(m);
                    }
                );
            }
        );

        Map<Integer, String> diction = new HashMap<>();

        for (int i : deck){
            String b = String.valueOf(i);
            switch(i) {
                case 1:
                    b = "A";
                    break;
                case 11:
                    b = "J";
                    break;
                case 12:
                    b = "Q";
                    break;
                case 13:
                    b = "K";
                    break;
            }
            diction.put(i, b);
        }
       
        IntStream.range(0, 5).forEach(
            n -> {
                Collections.shuffle(deck);
            }
        );
        int ace = 11;
        boolean gotAce = false;
        boolean dgotAce = false;

        Scanner ask = new Scanner(System.in);

        int playerDraw1 = deck.get(0) ;
        int playerDraw2 = deck.get(1) ;
        int dealerDraw1 = deck.get(2) ;
        int dealerDraw2 = deck.get(3) ;
        
        System.out.println("You got: " + diction.get(playerDraw1) + " " + diction.get(playerDraw2));
        System.out.println("Dealer got: " + diction.get(dealerDraw1));

        switch(playerDraw1){
            case 11:
            case 12:
            case 13:
                playerDraw1 = 10;
        }
        if (playerDraw1 == 1){
            playerDraw1 = ace;
            gotAce = true;
        }
        switch(playerDraw2){
            case 11:
            case 12:
            case 13:
                playerDraw2 = 10; 
        }
        if (playerDraw2 ==1){
            playerDraw2 = ace;
            gotAce = true;
        }
        switch(dealerDraw1){
            case 11:
            case 12:
            case 13:
                dealerDraw1 = 10; 
        }
        if (dealerDraw1 == 1){
            dealerDraw1 = ace;
            dgotAce = true;
        }
        switch(dealerDraw2){
            case 11:
            case 12:
            case 13:
                dealerDraw2 = 10; 
        }
        if (dealerDraw2 == 1){
            dealerDraw2 = ace;
            dgotAce = true;
        }
        int dealerHand = dealerDraw1 + dealerDraw2;
        int hand = playerDraw1 + playerDraw2;

        if (hand == 21) {
            System.out.println("BlackJack!");
            System.exit(0);
        }
        if (dealerHand == 21) {
            System.out.println("Dealer got BlackJack!");
            System.exit(0);
        }
        
        int playerDraw = 0;
        int dealerDraw = 0;
        
        int draw = 4 ;

        while (true) {
            if (hand > 21){
                if (gotAce){
                    hand -= 10;
                    gotAce = false;
                } else break;
            }
            System.out.println("Current Hand: " + hand);
            System.out.print("Draw more? ( y/n ) ");
            String answer = ask.next();

            if (answer.equals("y")) {
                playerDraw = deck.get(draw) ;
                System.out.println("You got " + diction.get(playerDraw));
                switch(playerDraw){
                    case 11:
                    case 12:
                    case 13:
                        playerDraw = 10; 
                }
                if (playerDraw == 1){
                    if (hand + 11 < 22)
                        playerDraw = ace;
                }
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
        if (dealerDraw2 == 11)
            dealerDraw2 = 1;
        System.out.println("Dealer Second is: " + diction.get(dealerDraw2));

        while (dealerHand <= 16) {
            if (dealerHand > 21)
                if (dgotAce){
                    dealerHand -= 10;
                    dgotAce = false;
                }
            dealerDraw = deck.get(draw);
            System.out.println("Dealer got " + diction.get(dealerDraw));
            switch(dealerDraw){
                case 11:
                case 12:
                case 13:
                    dealerDraw = 10;
            }
            if (dealerDraw == 1){
                if (hand + 11 < 22)
                    dealerDraw = ace;
            }
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

