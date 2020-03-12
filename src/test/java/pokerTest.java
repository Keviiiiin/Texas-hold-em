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
    public void test_card_type(){
        //Given
        //1高牌，2对子，3两对，4三条，5顺子，6同花，7葫芦，8四条，9同花顺
        HashMap<Integer, ArrayList<String>> cardsMap = new HashMap<>();
        Map<Integer,ArrayList<String>> Colors = new HashMap<>();
        int [][]twoCards = new int[2][4];
        int [] result = new int [9];

        cardsMap.put(1,new ArrayList<>(Arrays.asList("2♣ J♠ T♣ K♦ A♥".split(" "))));
        cardsMap.put(2,new ArrayList<>(Arrays.asList("Q♣ 2♠ 5♣ 9♦ 2♥".split(" "))));
        cardsMap.put(3,new ArrayList<>(Arrays.asList("Q♣ 2♠ 2♣ 9♦ Q♥".split(" "))));
        cardsMap.put(4,new ArrayList<>(Arrays.asList("Q♣ 2♠ Q♣ 9♦ Q♥".split(" "))));
        cardsMap.put(5,new ArrayList<>(Arrays.asList("5♣ 2♠ 4♣ 6♦ 3♥".split(" "))));
        cardsMap.put(6,new ArrayList<>(Arrays.asList("5♠ 7♠ 5♠ 6♠ 3♠".split(" "))));
        cardsMap.put(7,new ArrayList<>(Arrays.asList("8♣ 8♦ 8♥ 4♠ 4♣".split(" "))));
        cardsMap.put(8,new ArrayList<>(Arrays.asList("5♣ 2♠ 5♠ 5♦ 5♥".split(" "))));
        cardsMap.put(9,new ArrayList<>(Arrays.asList("T♣ A♣ Q♣ J♣ K♣".split(" "))));
        //When
        HashMap<Integer, ArrayList<Integer>> tempMap = new HashMap<>();
        for (int i = 1; i <= 9 ; i++) {
            //黑色方和白色方是同一副牌
            tempMap.put(0,poker.getVirtualPoint(cardsMap.get(i)));
            tempMap.put(1,poker.getVirtualPoint(cardsMap.get(i)));
            Colors.put(0,cardsMap.get(i));
            Colors.put(1,cardsMap.get(i));
            twoCards[0] = poker.isSamePoint(tempMap.get(0));
            twoCards[1] = poker.isSamePoint(tempMap.get(1));

            result[i-1] = poker.judgeType(tempMap,Colors,twoCards)[0];
        }
        //Then
        for (int i = 0; i < 9; i++) {
            Assert.assertEquals(i+1, result[i]);
        }
    }
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
        ArrayList<String> black_1 = new ArrayList<>(Arrays.asList("9♦ T♣ 6♦ 9♠ T♦".split(" ")));
        ArrayList<String> white_1 = new ArrayList<>(Arrays.asList("Q♦ T♠ T♥ Q♥ 5♥".split(" ")));

        ArrayList<String> black_2 = new ArrayList<>(Arrays.asList("9♦ 6♣ 6♦ 9♠ T♦".split(" ")));
        ArrayList<String> white_2 = new ArrayList<>(Arrays.asList("6♠ 7♠ 9♣ 6♥ 9♥".split(" ")));
        String result_1 = poker.compare(black_1,white_1);
        String result_2 = poker.compare(black_2,white_2);

        Assert.assertEquals("White wins",result_1);
        Assert.assertEquals("Black wins",result_2);
    }

    @Test
    public void should_return_winner_when_both_OnePair() {
        ArrayList<String> black = new ArrayList<>(Arrays.asList("9♦ T♣ J♦ 9♠ K♦".split(" ")));
        ArrayList<String> white = new ArrayList<>(Arrays.asList("8♦ A♠ 2♥ 8♥ 5♥".split(" ")));
        ArrayList<String> black_1 = new ArrayList<>(Arrays.asList("9♦ T♣ K♦ 8♠ T♦".split(" ")));
        ArrayList<String> white_1 = new ArrayList<>(Arrays.asList("K♦ T♠ T♥ Q♥ 5♥".split(" ")));
        String result = poker.compare(black,white);
        String result_1 = poker.compare(black_1,white_1);

        Assert.assertEquals("Black wins",result);
        Assert.assertEquals("White wins",result_1);
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

    //随机发牌测试
    @Test
    public void random_deal() {
        String [] Points = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
        String [] Colors = {"♠","♣","♥","♦"};
        //创建牌盒，键是编号，值是牌
        HashMap<Integer, String> hm = new HashMap<Integer, String>();

        //创建ArrayList，存储编号
        ArrayList<Integer> array = new ArrayList<Integer>();

        //从0开始往HashMap里面存储编号，并存储对应的牌。同时往ArrayList里面存储编号
        int index = 0;

        for (String number : Points) {
            for (String color : Colors) {
                hm.put(index, number + color );
                array.add(index);
                index++;
            }
        }
        Collections.shuffle(array);

        StringBuilder blackString = new StringBuilder();
        StringBuilder whiteString = new StringBuilder();
//        Random blackRandom = new Random();
//        Random whiteRandom = new Random();
        for (int i = 0; i < 10; i++) {
            if(i%2 == 0)
                blackString.append(hm.get(array.get(i))).append(" ");
            else
                whiteString.append(hm.get(array.get(i))).append(" ");
        }

        ArrayList<String> black = new ArrayList<>(Arrays.asList(blackString.toString().split(" ")));
        ArrayList<String> white = new ArrayList<>(Arrays.asList(whiteString.toString().split(" ")));


        Map<Integer,ArrayList<String>> Color = new HashMap<>();
        int [][]twoCards = new int[2][4];
        int blackType,whiteType;
        String []type = {"高牌","一对","两对","三条","顺子","同花","葫芦","四条","同花顺"};
        HashMap<Integer, ArrayList<Integer>> tempMap = new HashMap<>();
        tempMap.put(0,poker.getVirtualPoint(black));
        tempMap.put(1,poker.getVirtualPoint(white));
        Color.put(0,black);
        Color.put(1,white);
        twoCards[0] = poker.isSamePoint(tempMap.get(0));
        twoCards[1] = poker.isSamePoint(tempMap.get(1));

        int []resultType = new int[2];
        resultType[0] = poker.judgeType(tempMap,Color,twoCards)[0];
        resultType[1] = poker.judgeType(tempMap,Color,twoCards)[1];

        System.out.println("黑色方的牌是：");
        for (String s : black) {
            System.out.print(s + " ");
        }
        System.out.print("-------" + type[resultType[0]-1]);
        System.out.println();
        System.out.println("白色方的牌是：");
        for (String s : white) {
            System.out.print(s + " ");
        }
        System.out.print("-------" + type[resultType[1]-1]);
        System.out.println();
        String result = poker.judgeWinner(tempMap,Color,resultType,twoCards);
        System.out.println(result);
    }
}