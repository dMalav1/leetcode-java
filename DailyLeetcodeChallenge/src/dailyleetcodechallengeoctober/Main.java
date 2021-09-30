package dailyleetcodechallengeoctober;

import java.util.Scanner;

import static dailyleetcodechallengeoctober.PartitionToKEqualSumSubsets.canPartitionKSubsets;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(canPartitionKSubsets(nums, k));
        }
    }
}
