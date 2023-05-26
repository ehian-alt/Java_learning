import java.util.Arrays;
public class Test_and_exam {
    static int findMax(int[] nums){
        Arrays.sort(nums);
        System.out.println(nums.length);
        int l = 0, r = nums.length-1;
        while(l<r){
            if (nums[l] == -nums[r]){
                return nums[r];
            }else if (-nums[l]>nums[r]){
                l++;
            }else{
                r--;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        int[] nums = new int[]{2, 4, 8, 1, 10, 8, 9, 4};
        System.out.println(findMax(nums));
    }
}