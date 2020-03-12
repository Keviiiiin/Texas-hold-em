import java.util.*;

/**
 * @description: 德州扑克比大小
 * @author: iccKevin
 * @create: 2020-03-12 12:35
 **/
public class poker {
    public String compare(ArrayList<String > Black,ArrayList<String > White){
        Map<Integer,ArrayList<Integer>> Points = new HashMap<>();
        Map<Integer,ArrayList<String>> Colors = new HashMap<>();

        Points.put(0,getVirtualPoint(Black));
        Points.put(1,getVirtualPoint(White));

        Colors.put(0,Black);
        Colors.put(1,White);

        int [][]twoCards = new int[2][4];
        twoCards[0] = isSamePoint(Points.get(0));
        twoCards[1] = isSamePoint(Points.get(1));

        //判断双方牌型
        int []type = judgeType(Points,Colors,twoCards);

        //判断谁赢
        String result = judgeWinner(Points,Colors,type,twoCards);

        return result;
    }

    public String judgeWinner(Map<Integer, ArrayList<Integer>> points, Map<Integer, ArrayList<String>> colors,int[]type,int[][]twoCards) {
        ArrayList<Integer> bPoint = points.get(0);
        ArrayList<Integer> wPoint = points.get(1);
        String result = null;
        if(type[0] > type[1])
            result = "Black wins";
        else if(type[0] < type[1])
            result = "White wins";
        else {
            if(type[0] == 1 || type[0] == 6) {
                for (int i = 4; i >= 0; i--) {
                    if(bPoint.get(i)>wPoint.get(i)) {
                        result = "Black wins";
                        break;
                    }
                    else if(bPoint.get(i)<wPoint.get(i)) {
                        result = "White wins";
                        break;
                    }
                }
                if(result == null)
                    result = "Tie";
            }
            else if(type[0] == 2 || type[0] == 4 ||type[0] == 8) {
                if(twoCards[0][2]>twoCards[1][2])
                    result = "Black wins";
                else if(twoCards[0][2]<twoCards[1][2])
                    result = "White wins";
                else
                    result = "Tie";
            }
            else if(type[0] == 3 || type[0] == 7) {
                if(twoCards[0][3]>twoCards[1][3])
                    result = "Black wins";
                else if(twoCards[0][3]<twoCards[1][3])
                    result = "White wins";
                else
                    result = "Tie";
            }
            else{
                if(bPoint.get(0)>wPoint.get(0))
                    result = "Black wins";
                else if(bPoint.get(0)<wPoint.get(0))
                    result = "White wins";
                else
                    result = "Tie";
            }
        }
        return result;
    }

    public int[] judgeType(Map<Integer, ArrayList<Integer>> points, Map<Integer, ArrayList<String>> colors,int [][] twoCards) {
        int type[] = new int[2];
        for (int i = 0; i < 2; i++) {
            //如果是同花
            if (isFlush(colors.get(i)))
                type[i] = 6;
            //如果包含对子
            if(twoCards[i][0] == 1){
                //8四条：1 3 x x
                //7葫芦：1 3 x y
                //4三条：1 2 x x
                //3两对：1 2 x y
                //2一对：1 1 x -1
                switch (twoCards[i][1]){
                    case 3:{
                        if(twoCards[i][2] == twoCards[i][3])
                            type[i] = 8;
                        else
                            type[i] = 7;
                        break;
                    }
                    case 2:{
                        if(type[i] == 6)
                            break;
                        else {
                            if(twoCards[i][2] == twoCards[i][3])
                                type[i] = 4;
                            else
                                type[i] = 3;
                        }
                        break;
                    }
                    case 1:{
                        if(type[i] != 6)
                            type[i] = 2;
                        break;
                    }
                }
            }
            //如果不包含对子
            else {
                //9同花顺，6同花，5顺子，1高牌
                if(isFlushStraight(colors.get(i),points.get(i)))
                    type[i] = 9;
                else if (isStraight(points.get(i)))
                    type[i] = 5;
                else{
                    if(type[i] != 6)
                        type[i] = 1;
                }
            }
        }
        return type;
    }

    //判断有无重复元素，返回int []same,其中same[0]表示是否重复，same[1]表示重复了几个，same[2]~same[3]表示重复元素是谁
    //same[4]对应牌型 => 2对子，3两对，4三条，7葫芦，8四条
    public int[] isSamePoint(ArrayList<Integer> point) {
        int []same = {0,0,-1,-1,0};
        int temp = point.get(0);
        int count = 0;
        for (int i = 1; i < 5; i++) {
            if(temp == point.get(i)){
                if(count == 0)
                    same[2] = temp;
                else
                    same[3] = temp;
                count ++;
            }
            else
                temp = point.get(i);
        }
        if(count != 0){
            same[0] = 1;
            same[1] = count;
        }
        return same;
    }
    //取出点数并排序
    public ArrayList<Integer> getVirtualPoint(ArrayList<String> pk){
        ArrayList<Integer> point = new ArrayList<>();
        for (String card : pk) {
            char c = card.charAt(0);
            if(c>='2' && c<='9')
                point.add(c-'2');
            else if(c=='T')
                point.add(8);
            else if(c=='J')
                point.add(9);
            else if(c=='Q')
                point.add(10);
            else if(c=='K')
                point.add(11);
            else if(c=='A')
                point.add(12);
        }
        Collections.sort(point);
        return point;
    }
    //判断是不是同花
    private boolean isFlush(ArrayList<String> pk) {
        HashSet<Character> color = new HashSet<Character>();
        //取出花色放入HashSet
        for (String card : pk) {
            color.add(card.charAt(1));
        }
        return color.size()== 1;
    }

    //判断是不是顺子
    private boolean isStraight(ArrayList<Integer> point) {
        return point.get(4) - point.get(0) == 4;
    }
    //判断是不是同花顺
    private boolean isFlushStraight(ArrayList<String> pk,ArrayList<Integer> point){
        return isFlush(pk) && isStraight(point);
    }

}