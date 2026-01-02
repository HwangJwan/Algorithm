package A7이분탐색;

public class A01BinarySearch {
    public static void main(String[] args) {
//        이분탐색은 사전에 정렬된 데이터를 대상으로 log(n)의 복잡도의 검색을 수행하는 알고리즘
//        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
//        int target = 17;
//        start, end index를 두고 mid(start+end/2)를 계산.
//        mid의 값이 target보다 크다면 end=mid-1
//        mid의 값이 target보다 작다면 start=mid+1
//        mid의 값이 target과 일치하면 answer=mid; break;

//        int start=0;
//        int end=arr.length-1;
//        int answer=0;
//        while(start<=end) {
//            int mid=(start+end)/2;
//            if(arr[mid]==target) {
//                answer=mid;
//                break;
//            }
//            else if(arr[mid]>target) {
//                end=mid-1;
//            }
//            else if(arr[mid]<target){
//                start=mid+1;
//            }
//            else {
//                answer=-1;
//                break;
//            }
//        }
//        System.out.println(answer);

//        응용상황 : target이 arr에 있다면 index값을 리턴하고, arr에 없다면 있어야할 자리 index를 리턴
//        answer가 ==뿐만 아니라 >또는 <상황에서도 세팅 될 수 있음
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 20;
        int start = 0;
        int answer = -1;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                answer = mid;
                break;
            } else if (arr[mid] > target) {
                end = mid - 1;
                answer = mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
//            못 찾으면 마지막에 start가 end넘어감. 그 넘어간 자리가 찾지못한 해당 숫자의 자리
            if (start > end) {
                answer = start;
            }
        }
        System.out.println(answer);
    }
}

