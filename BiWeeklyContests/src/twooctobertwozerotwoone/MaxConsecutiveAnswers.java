package twooctobertwozerotwoone;

import java.util.Scanner;

public class MaxConsecutiveAnswers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String answerKey = sc.next();
            int k = sc.nextInt();
            System.out.println(maxConsecutiveAnswers(answerKey, k));
        }
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int maxConsecutiveT = 0;
        int left = 0;
        int right = 0;
        int maxT = 0;
        int countF = 0;

        while (right < answerKey.length()) {
            if (answerKey.charAt(right) == 'F') {
                countF++;
            }

            while (countF > k) {
                if (answerKey.charAt(left) == 'F') {
                    countF--;
                }
                left++;
            }

            maxConsecutiveT = Math.max(maxConsecutiveT, right - left + 1);
            right++;
        }


        left = 0;
        right = 0;
        int countT = 0;
        int maxConsecutiveF = 0;


        while (right < answerKey.length()) {
            if (answerKey.charAt(right) == 'T') {
                countT++;

            }

            while (countT > k) {
                if (answerKey.charAt(left) == 'T') {
                    countT--;
                }
                left++;
            }

            maxConsecutiveF = Math.max(maxConsecutiveF, right - left + 1);
            right++;
        }

        return Math.max(maxConsecutiveT, maxConsecutiveF);
    }
    //my try->
    //    public static int maxConsecutiveAnswers(String answerKey, int k) {
//        StringBuilder sbT = new StringBuilder();
//        StringBuilder sbF = new StringBuilder();
//        int countT = 0;
//        int countF = 0;
//        char[] ch = answerKey.toCharArray();
//        for (int i = 0; i < answerKey.length(); i++) {
//            if (ch[i] == 'T') {
//                countT++;
//                sbT.append(ch[i]);
//            }
//            if (ch[i] == 'F') {
//                countF++;
//                sbF.append(ch[i]);
//            }
//        }
//        return countF + countT;
//    }

}
