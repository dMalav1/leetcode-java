package twooctobertwozerotwoone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumNumberOfWaysToPartitionAnArray {

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
            System.out.println(waysToPartition(nums, k));
        }
    }

    public static int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        long[] arr = new long[n];
        long totalSum = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = (long) (nums[i]);
            totalSum += arr[i];
        }
        long[] sum = new long[n];
        sum[0] = arr[0];

        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + (long) arr[i];
        }

        int res = 0;

        Map<Long, Integer> leftSum = new HashMap(), rightSum = new HashMap();

        for (int idx = 1; idx < n; ++idx) {
            if (sum[idx - 1] == sum[n - 1] - sum[idx - 1]) {
                res++;
            }
        }

        long temp = 0;
        for (int i = n - 1; i > 0; --i) {
            temp += arr[i];
            rightSum.put(temp, rightSum.getOrDefault(temp, 0) + 1);
        }

        temp = 0;
        long newSum = totalSum + (long) (k) - arr[0];
        if (newSum % 2 == 0 && rightSum.containsKey(newSum / 2)) {
            res = Math.max(res, rightSum.get(newSum / 2));
        }
        for (int idx = 1; idx < n; ++idx) {
            temp += arr[idx - 1];
            leftSum.put(temp, leftSum.getOrDefault(temp, 0) + 1);
            if (rightSum.containsKey(totalSum - temp)) {
                int fr = rightSum.get(totalSum - temp);
                if (fr == 1)
                    rightSum.remove(totalSum - temp);
                else
                    rightSum.put(totalSum - temp, fr - 1);
            }

            newSum = totalSum + (long) (k) - arr[idx];
            if (newSum % 2 != 0)
                continue;

            int cl = leftSum.getOrDefault(newSum / 2, 0), cr = rightSum.getOrDefault(newSum / 2, 0);
            res = Math.max(res, cl + cr);
        }

        return res;
    }
}
