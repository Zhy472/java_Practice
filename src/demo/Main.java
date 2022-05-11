package demo;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        Collection<Integer> list = Collections.synchronizedCollection(new ArrayList<Integer>());
        HashMap<Integer,Integer>map = new HashMap<>();
        System.out.println("喵喵喵");
    }
}








class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

 class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}



