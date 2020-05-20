
import java.util.*;

public class Blackjack {

    private int cardPosition = 0;
    private boolean gotAce;
    private final int MAX_SCORE = 21;

    public static Scanner ask = new Scanner(System.in);

    public void newGame(){
        String answer;
        System.out.print("Play another game? (y/n) ");
        answer = ask.next();
        if (answer.equals("n")) {
            ask.close();
            System.exit(0);
        }
    }

    public void raiseCardPosition(int num){
        cardPosition += num;
    }

    public List<Integer> newDeck(){
        List<Integer> deck = new ArrayList<Integer>();

        for (int i = 0; i < 13; i++){
            for (int y = 0; y < 4; y++){
                deck.add(i + 1);
            }   
        }
        return deck;
    }

    public String cardConvert(int card){
        String convertedCard = "";

        switch(card) {
            case 1:
                convertedCard = "A";
                break;
            case 2:
                convertedCard = "2";
                break;
            case 3:
                convertedCard = "3";
                break;
            case 4:
                convertedCard = "4";
                break;
            case 5:
                convertedCard = "5";
                break;
            case 6:
                convertedCard = "6";
                break;
            case 7:
                convertedCard = "7";
                break;
            case 8:
                convertedCard = "8";
                break;
            case 9:
                convertedCard = "9";
                break;
            case 10:
                convertedCard = "10";
                break;
            case 11:
                convertedCard = "J";
                break;
            case 12:
                convertedCard = "Q";
                break;
            case 13:
                convertedCard = "K";
                break;
        }

        return convertedCard;
    }

    public int trueValue(int num){
        switch(num){
            case 1:
                num = 11;
                gotAce = true;
                break;
            case 11:
            case 12:
            case 13:
                num = 10;
                break;
        }
        return num;
    }

    public List<Integer> deckShuffle(List<Integer> deckToShuffle){
        for (int i = 0; i < 4; i++){
            Collections.shuffle(deckToShuffle);
        }
        return deckToShuffle;
    }

    public int[] deal(List<Integer> shuffeldDeck){
        
        int [] hand = new int[10];
        hand[0] = shuffeldDeck.get(cardPosition);
        hand[1] = shuffeldDeck.get(cardPosition+1);
        raiseCardPosition(2);
        return hand;
    }

    public String checkScore(int x){
        
        if (x > MAX_SCORE){
            if (!gotAce){
                System.out.println("you got more then 21...you lost");
                return "Lose";
            }
            else return "GotA";
        
        } 
        else if (x == MAX_SCORE){
            System.out.println("You got 21! you won!");
            return "Win";
        }
        else { 
            System.out.println("You got " + x);
            return "Ongoing";
        }
    }

    public int draw(int hand, List<Integer> deck){
        String ans = "";
        while (hand < MAX_SCORE){
            System.out.println("Draw card? (y/n) ");
            ans = ask.next();
            if (ans.equals("y")){
                hand += trueValue(deck.get(cardPosition));
                System.out.println("You got " + cardConvert(deck.get(cardPosition)));
                if ((hand > MAX_SCORE) && (gotAce)){
                    hand -= 10;
                    gotAce = false;
                }
                raiseCardPosition(1);
                System.out.println("You now have: " + hand);
            }
            else break;
        }
        return hand;
    }
}