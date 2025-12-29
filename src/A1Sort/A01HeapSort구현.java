package A1Sort;

import javax.swing.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// 트리 탐색 + 재귀적 호출을 통한 힙정렬
public class A01HeapSort구현 {
    public static void main(String[] args) {
//        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
////        1. 최초힙구성
////        1-1) 부모 노드(n/2)와 자식노드(n/2) 분리하여 부모노드를 대상으로 heapify
////        1-2) 자식 노드의 왼쪽노드 : 부모노드 X 2 + 1, 자식노드의 오른쪽 노드 : 부모노드 X 2 + 2
////        1-3) heapify 과정이 재귀호출로 이루어짐
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            heapify(i, arr,arr.length);
//        }
//
//        System.out.println(Arrays.toString(arr));
////        {1, 3, 5, 6, 7, 5, 9, 8, 6}
//
////        2. 루트노드와 최하위 노드를 자리 change해 가면서 재heapify
//
////        2-1) 자리 change한 마지막 노드는 heapify 대상에서 제외
////        2-2) 최소힙 -> 내림차순 정렬, 최대힙 -> 오름차순 정렬
//        for(int i=arr.length-1;i>=0;i--) {
//            int temp=arr[0];
//            arr[0]=arr[i];
//            arr[i]=temp;
//            heapify(0,arr, i);
//        }
//        System.out.println(Arrays.toString(arr));

//        pq를 통한 정렬방법
//        pq를 가지고 직접 정렬을 수행하기보다는 지속적으로 값을 add하고 poll해 나가는 상황에서 사용
        Queue<Integer> pq=new PriorityQueue<>(Arrays.asList(7, 6, 5, 8, 3, 5, 9, 1, 6));
        System.out.println(pq);
        System.out.println(pq.poll()); // poll의 복잡도 log(n)
        pq.add(2); // add의 복잡도 log(n)
    }

    static void heapify(int parentIndex, int[] arr,int length) {
//        자식 노드와의 비교, 만약 자식노드가 더 작으면 자리 change
        int nextIndex1 = parentIndex * 2 + 1;
        int nextIndex2 = parentIndex * 2 + 2;
        int temp = 0;
//        자식 노드가 두개 존재할 경우
        if (nextIndex1 <= length - 1 && nextIndex2 <= length - 1) {
            int min = Math.min(arr[nextIndex1], arr[nextIndex2]);
            if (arr[parentIndex] > min) {
                if (arr[nextIndex1] == min) {
                    temp = arr[parentIndex];
                    arr[parentIndex] = arr[nextIndex1];
                    arr[nextIndex1] = temp;
                    heapify(nextIndex1, arr,length);
                } else {
                    temp = arr[parentIndex];
                    arr[parentIndex] = arr[nextIndex2];
                    arr[nextIndex2] = temp;
                    heapify(nextIndex2, arr,length);
                }
            }
//            자식 노드가 하나만 존재하는 경우
        }
        else if (nextIndex1 <= length - 1 && nextIndex2 > length - 1) {
            if (arr[nextIndex1] < arr[parentIndex]) {
                temp = arr[parentIndex];
                arr[parentIndex] = arr[nextIndex1];
                arr[nextIndex1] = temp;
                heapify(nextIndex1, arr,length);
            }
        }
//        자리가 change된다면 재귀호출

//        heapify(자식노드의 index,arr);
    }

    static void bradHeapify(int parentIndex,int[] arr,int length) {
        int leftIndex=parentIndex*2+1;
        int rightIndex=parentIndex*2+2;
        int smallestIndex=parentIndex;
//        가장 작은 indexx값 찾기
        if(leftIndex<arr.length && arr[leftIndex]<arr[smallestIndex]) {
            smallestIndex=leftIndex;
        }
        if(rightIndex<arr.length && arr[rightIndex]<arr[smallestIndex]) {
            smallestIndex=rightIndex;
        }
//        가장 작은 index가 부모노드가 아니라면 자리 change 및 heapify
        if(parentIndex!=smallestIndex) {
            int temp=arr[parentIndex];
            arr[parentIndex]=arr[smallestIndex];
            arr[smallestIndex]=temp;
            heapify(smallestIndex,arr,length);
        }
    }


}
