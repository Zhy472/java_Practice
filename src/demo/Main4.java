package demo;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = sort(lists,0,lists.length-1);
        return res;
    }
    private ListNode sort(ListNode[] lists,int low ,int high){
        ListNode res=null;
        if(low<high){
            int mid = low+(high-low)/2;
            ListNode left = sort(lists,low,mid);
            ListNode right = sort(lists,mid+1,high);
            res = merge(left,right);
        }
        return res;
    }
    private ListNode merge(ListNode one, ListNode two){
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead.next;
        while(one!=null&&two!=null){
        if(one.val<two.val){
        cur = one;
        one = one.next;
        }
        else{
        cur = two;
        two = two.next;
        }
        cur= cur.next;
        }
        while(one!=null)cur.next = one;
        while(two!=null)cur.next = two;
        return dummyHead.next;
        }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


