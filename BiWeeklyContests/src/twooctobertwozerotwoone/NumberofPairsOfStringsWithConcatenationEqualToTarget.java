package twooctobertwozerotwoone;

import java.util.Scanner;

public class NumberofPairsOfStringsWithConcatenationEqualToTarget {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String target = sc.next();
            int n = sc.nextInt();
            String[] nums = new String[n];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = sc.next();
            }
            System.out.println(numOfPairs(nums, target));
        }
    }

    public static int numOfPairs(String[] nums, String target) {
        int lengthOfNums = nums.length;
        int count = 0;

        for (int i = 0; i < lengthOfNums; i++) {
            for (int j = i + 1; j < lengthOfNums; j++) {
                if ((nums[i] + nums[j]).equals(target)) {
                    count++;
                }
                if ((nums[j] + nums[i]).equals(target)) {
                    count++;
                }
            }
        }
        return count;
    }
}
