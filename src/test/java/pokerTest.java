import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @description: 测试类
 * @author: iccKevin
 * @create: 2020-03-11 16:35
 **/
public class pokerTest {
    poker poker = new poker();
    @Test
    public void should_return_Tie_when_same(){
        ArrayList<String> black = new ArrayList<>(Arrays.asList("Q♣ 2♠ 2♣ 9♦ Q♥".split(" ")));
        ArrayList<String> white = new ArrayList<>(Arrays.asList("9♦ Q♣ 2♠ 2♣ Q♥".split(" ")));
        String result = poker.compare(black,white);
        Assert.assertEquals("Tie",result);
    }

    @Test
    public void should_return_winner_when_both_FlushStraight() {
        ArrayList<String> black = new ArrayList<>(Arrays.asList("4♣ 5♣ 6♣ 7♣ 8♣".split(" ")));
        ArrayList<String> white = new ArrayList<>(Arrays.asList("A♦ Q♦ T♦ J♦ K♦".split(" ")));
        String result = poker.compare(black,white);
        Assert.assertEquals("White wins",result);
    }

    @Test
    public void should_return_winner_when_both_Four() {
        ArrayList<String> black = new ArrayList<>(Arrays.asList("J♦ 5♣ J♠ J♥ J♣".split(" ")));
        ArrayList<String> white = new ArrayList<>(Arrays.asList("9♠ 9♦ 7♣ 9♥ 9♣".split(" ")));
        String result = poker.compare(black,white);
        Assert.assertEquals("Black wins",result);
    }

    @Test
    public void should_return_winner_when_both_FullHouse() {
        ArrayList<String> black_1 = new ArrayList<>(Arrays.asList("6♣ 6♦ K♠ 6♥ K♣".split(" ")));
        ArrayList<String> white_1 = new ArrayList<>(Arrays.asList("A♠ A♦ 2♣ 2♦ A♥".split(" ")));

        ArrayList<String> black_2 = new ArrayList<>(Arrays.asList("K♣ 6♦ 6♠ K♥ K♠".split(" ")));
        ArrayList<String> white_2 = new ArrayList<>(Arrays.asList("A♠ 2♥ 2♣ 2♦ A♥".split(" ")));

        String result_1 = poker.compare(black_1,white_1);
        String result_2 = poker.compare(black_2,white_2);
        Assert.assertEquals("White wins",result_1);
        Assert.assertEquals("Black wins",result_2);
    }

    @Test
    public void should_return_winner_when_both_Flush() {
        ArrayList<String> black = new ArrayList<>(Arrays.asList("J♦ 9♦ 6♦ 7♦ 8♦".split(" ")));
        ArrayList<String> white = new ArrayList<>(Arrays.asList("3♥ 4♥ 2♥ Q♥ 5♥".split(" ")));
        String result = poker.compare(black,white);
        Assert.assertEquals("White wins",result);
    }

    @Test
    public void should_return_winner_when_both_Straight() {
        ArrayList<String> black = new ArrayList<>(Arrays.asList("T♠ 9♦ 6♦ 7♦ 8♦".split(" ")));
        ArrayList<String> white = new ArrayList<>(Arrays.asList("7♥ 8♥ T♥ 9♣ J♥".split(" ")));
        String result = poker.compare(black,white);
        Assert.assertEquals("White wins",result);
    }

    @Test
    public void should_return_winner_when_both_Three() {
        ArrayList<String> black = new ArrayList<>(Arrays.asList("9♥ 9♦ 9♠ 7♦ 8♦".split(" ")));
        ArrayList<String> white = new ArrayList<>(Arrays.asList("6♥ 6♣ A♥ Q♥ 6♦".split(" ")));
        String result = poker.compare(black,white);
        Assert.assertEquals("Black wins",result);
    }

    @Test
    public void should_return_winner_when_both_TwoPair() {
        ArrayList<String> black = new ArrayList<>(Arrays.asList("9♦ T♣ 6♦ 9♠ T♦".split(" ")));
        ArrayList<String> white = new ArrayList<>(Arrays.asList("Q♦ T♠ T♥ Q♥ 5♥".split(" ")));
        String result = poker.compare(black,white);
        Assert.assertEquals("White wins",result);
    }

    @Test
    public void should_return_winner_when_both_OnePair() {
        ArrayList<String> black = new ArrayList<>(Arrays.asList("9♦ T♣ J♦ 9♠ K♦".split(" ")));
        ArrayList<String> white = new ArrayList<>(Arrays.asList("8♦ A♠ 2♥ 8♥ 5♥".split(" ")));
        String result = poker.compare(black,white);
        Assert.assertEquals("Black wins",result);
    }

    @Test
    public void should_return_winner_when_both_HighCard() {
        ArrayList<String> black = new ArrayList<>(Arrays.asList("A♦ T♣ 6♦ 9♠ 3♦".split(" ")));
        ArrayList<String> white = new ArrayList<>(Arrays.asList("T♦ 4♠ A♥ 6♥ 5♥".split(" ")));
        String result = poker.compare(black,white);
        Assert.assertEquals("Black wins",result);
    }

    @Test
    public void should_return_winner_when_different() {
        ArrayList<String> black = new ArrayList<>(Arrays.asList("9♦ T♣ 6♦ 9♠ T♦".split(" ")));
        ArrayList<String> white = new ArrayList<>(Arrays.asList("T♦ T♠ T♥ Q♥ 5♥".split(" ")));
        String result = poker.compare(black,white);
        Assert.assertEquals("White wins",result);
    }
}