import java.util.*;

public class Main{
    private static int score;
    

    private static void checkStatus(String status){
        if (status.equals("Win") || status.equals("Lose"))
            System.exit(0);
        else if (status.equals("GotA"))
            score =- 10;
    }
    public static void main (String [] args){

        Blackjack bj = new Blackjack();
        
        List<Integer> d1 = bj.deckShuffle(bj.newDeck());

        int[] h1 = bj.deal(d1);
        int[] h2 = bj.deal(d1);

        score = bj.trueValue(h1[0]) + bj.trueValue(h1[1]);
        System.out.println("You got " + bj.cardConvert(h1[0])+" "+bj.cardConvert(h1[1]));
        checkStatus(bj.checkScore(score));
        

        if (h2[0] + h2[1] == 21){
            System.out.println("Dealer got 21! you lose...");
            System.exit(0);
        }
        System.out.println("Dealer got " + bj.cardConvert(h2[0]));
        
        score = bj.draw(score, d1);
        checkStatus(bj.checkScore(score));
    }
}