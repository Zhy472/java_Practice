package demo;

import java.util.*;
import java.util.stream.Collectors;

public class ACM {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] record = new int[size];
        for (int i = 0; i < size; i++) {
            record[i] = sc.nextInt();
        }
        System.out.println(process(record,size));
    }

    private static int process(int[] record, int size) {
        int low = 0;
        int high = size-1;
        int coutOne = 0;
        while (low<=size-1){
            if (record[low]==1){
                coutOne++;
                low++;
            }
            else if (record[low]!=0)
                low++;
            else break;
        }
        while (high>=0){
            if (record[high]==1){
                coutOne++;
                high--;
            }
            else if (record[high]!=0)
                high--;
            else
                break;
        }
        int maxNumer = 0,count = 0,count0=0,count1=0;
        for (int i = low; i <= high; i++) {
            if (record[i]==0){
                count0++;
                count++;
                if (count>maxNumer)
                    maxNumer = count;
            }
            else if (record[i]==1){
                count1++;
                count=0;
            }
        }
        if (count0>count1)return coutOne+count0;
        else return coutOne+maxNumer+count1;
    }
}
