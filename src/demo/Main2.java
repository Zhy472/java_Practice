package demo;
import java.util.*;

//import static java.util.Arrays.sort;

public class Main2 {
    public static void main(String[] args) {
        int[] nums = {1,4,7,2,8,3};
        temp = new int[nums.length];
        System.out.println((1<<2));
//        qsort(nums,0,nums.length-1);
//        for (int num : nums) {
//            System.out.println(num);
//        }
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<nums[right]){
                if(target>nums[mid]&&target<=nums[right])left = mid+1;
                else right = mid-1;
            }
            else{
                if(target<nums[mid]&&target>=nums[left])left = mid+1;
                else right = mid-1;
            }
        }
        return -1;
    }

    static int[] temp;
    private static void qsort(int[] nums, int low, int high) {
        if(low<high){
            int mid = low + (high-low)/2;
            qsort(nums,low,mid);
            qsort(nums,mid+1,high);
            merge(nums,low,high,mid);
        }
    }

    private static void merge(int[] nums, int low, int high, int mid) {
        int i = low;
        int j = mid+1;
        int z = 0;
        while(i<=mid&&j<=high){
            if(nums[i]<=nums[j]) temp[z++] = nums[i++];
            else temp[z++] = nums[j++];
        }
        while(i<=mid)temp[z++] = nums[i++];
        while(j<=high) temp[z++] = nums[j++];
        z = 0;
        while(low<=high){
            nums[low++] = temp[z++];
        }
    }
}

