import java.util.*;

public class DouDiZhuPro {
    public static void main(String[] args) {
        System.out.println("请输入玩家一的名字");
        String num1 = new Scanner(System.in).next();
        System.out.println("请输入玩家二的名字");
        String num2 = new Scanner(System.in).next();
        System.out.println("请输入玩家三的名字");
        String num3 = new Scanner(System.in).next();
        System.out.println("这三名玩家的名字分别是" + num1 + "," + num2 + "," + num3);
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> lowCards = new ArrayList<>();
        HashMap<Integer,String> cards=new HashMap<>();
        ArrayList<String> ddcard=new ArrayList<>();
        cards.put(0,"大王");
        cards.put(1,"小王");
        List<String> flowerColors =  List.of("♣","♠","♦","♥");
        List<String> theSerialNumber = List.of("2", "A", "k", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        for (int i = 0; i < theSerialNumber.size(); i++) {
            for (int i1 = 0; i1 < flowerColors.size(); i1++) {
                ddcard.add(flowerColors.get(i1)+theSerialNumber.get(i));
            }
        }
        for (int i = 0; i < ddcard.size(); i++) {//将牌存入HashMap集合
            int c=i+2;
            cards.put(c,ddcard.get(i));
        }
        /*Set<Map.Entry<Integer, String>> entries = cards.entrySet();        ** 对cards进行遍历 **
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        for (Map.Entry<Integer, String> bianLi:entries
             ) {
            System.out.println(bianLi);
        }*/

        ArrayList<Integer> theKeyIndex =new ArrayList<>();  //存储牌的Keys   **可以单没必要的方法 ，直接匿名即可 ** 错错错错有必要
        for (int i = 0; i < 54; i++) {                                         /*为的是使用Collections.shuffle（）方法*/
            theKeyIndex.add(i);                                                 /*如果用匿名就不会被打乱*/
        }
        Collections.shuffle(theKeyIndex);  //打乱key键

        for (int i = 0; i < theKeyIndex.size(); i++) {  //将keys分配给各个玩家
            if(i>50) {//将索引为51,52,53得值赋给底牌
                lowCards.add(theKeyIndex.get(i));
            }else{  //运用取模运算来分别给三位玩家赋key键
                if (i % 3 == 0) {
                    player01.add(theKeyIndex.get(i));
                } else if (i % 3 == 1) {
                    player02.add(theKeyIndex.get(i));
                } else if (i % 3 == 2) {
                    player03.add(theKeyIndex.get(i));
                }
            }
        }
        //将各个玩家的keys从小到大排好序
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(lowCards);

        System.out.println("此次发牌结果如下：");
        System.out.println(num1 + "的手牌：");
        System.out.print("[");
        for (int i = 0; i < player01.size(); i++) {
            if(i==player01.size()-1){
                System.out.print(cards.get(player01.get(i)));
            }else{
                System.out.print(cards.get(player01.get(i))+",");
            }
        }
        System.out.println("]");
        System.out.println(num2 + "的手牌：");
        System.out.print("[");
        for (int i = 0; i < player02.size(); i++) {
            if(i==player02.size()-1){
                System.out.print(cards.get(player02.get(i)));
            }else{
                System.out.print(cards.get(player02.get(i))+",");
            }
        }
        System.out.println("]");
        System.out.println(num3 + "的手牌：");
        System.out.print("[");
        for (int i = 0; i < player03.size(); i++) {
            if(i==player03.size()-1){
                System.out.print(cards.get(player03.get(i)));
            }else{
                System.out.print(cards.get(player03.get(i))+",");
            }
        }
        System.out.println("]");
        System.out.println("底牌：");
        System.out.print("[");
        for (int i = 0; i < lowCards.size(); i++) {
            if(i==lowCards.size()-1){
                System.out.print(cards.get(lowCards.get(i)));
            }else{
                System.out.print(cards.get(lowCards.get(i))+",");
            }
        }
        System.out.println("]");

           /*
        System.out.print("[");                       **********此为打印的第一种格式，但是解决不了最后取消逗号
        for (Integer keys:player01
             ) {
                System.out.print(cards.get(keys)+",");
        }
        System.out.println("]");*/

        /*System.out.print("[");                                *//*此为第二种打印，解决了上一个格式的bug*//*
        for (int i = 0; i < player01.size(); i++) {
            if(i==player01.size()-1){
                System.out.print(cards.get(player01.get(i)));
            }else{
                System.out.print(cards.get(player01.get(i))+",");
            }
        }
        System.out.println("]");*/

        /*System.out.print("[");                           //此小段代码为author想用迭代器来输出牌的最后一个数后不带逗号的格式 ，结果失败了。
        Iterator<Integer> iterator01 = player01.iterator();
        while*/


    }
}
