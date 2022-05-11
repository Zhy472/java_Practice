package demo;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main5  {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String wash = wash(s);
        int res = Integer.MAX_VALUE;
        int cur = process(wash,0);
        res = Math.min(res,cur);
        System.out.println(res);
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
    }

    private static int process(String s,int pre) {
        int res = Integer.MAX_VALUE;
        int len =s .length();
        if (s==null)return pre;
        if (len==1)return pre+1;
        for (int mask = 0; mask < (1<<len); mask++) {
            StringBuilder sb  = new StringBuilder();
            int temp = pre;
            for (int i = 0; i < len; i++) {
                if ((mask&(1<<i))==0){
                    temp++;
                    sb.append(s.charAt(i)=='0'?'1':'0');
                }
                else sb.append(s.charAt(i));
            }
            String exchangeS = sb.toString();
            String newS = wash(exchangeS);
            int temp2 = temp+pre;
            while(newS!=null||newS.length()!=1)temp2+=process(newS,temp+pre);
            res = Math.min(res,temp2);
        }
        return res;
    }

    public static String wash(String s){
        char[] chars = s.toCharArray();
        Deque<Character>stack = new LinkedList<>();
        int len = s.length();
        for(int i = 0;i<len;i++){
            if (!stack.isEmpty()&&s.charAt(i)==stack.peek()&&s.charAt(i)=='1')stack.pop();
            else stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())sb.append(stack.pop());
        return sb.toString();
    }
}

