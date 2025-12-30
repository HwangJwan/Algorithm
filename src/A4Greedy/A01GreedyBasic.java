package A4Greedy;

//  greedy(탐욕법) : 현재로써 최적의 해를 선택했을때, 전체의 최적해를 보장하는 알고리즘
public class A01GreedyBasic {
    public static void main(String[] args) {
//        1원, 5원, 10원, 20원짜리의 동전이 있을 때, 이를 조합하여 99를 만들수 있는 조합 중에 최소 개수를 구하라
        int[] arr = {10, 5, 1, 20};
        int total = 0;
        int goal = 99;

        while (goal != 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i] && goal > arr[i]) {
                    max = arr[i];
                }
            }
            total += goal / max;
            goal %= max;
        }
        System.out.println(total);

    }
}
