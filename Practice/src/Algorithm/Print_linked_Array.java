package Algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/2-09-02-14:18
 * @Description：Algorithm
 */
public class Print_linked_Array {

    public static void main(String[] args) {
//        向链表插入数据
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(3);
        head.next.next = new ListNode1(2);
        System.out.println(Arrays.toString(Print_linked_Array.reversal_Link(head)));
    }

//    计算链表长度
    public static int getLength(ListNode1 head){
        ListNode1 current = head;
        int length = 0;
        while (current!=null){
            length++;
            current=current.next;
        }
        return length;
    }

//    反转数组
    public static int[] reversal_Array(int[] arr){
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        int[] arr1 = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr1[i]=list.get(i);
        }
        return arr1;
    }

//    利用数组来方向打印链表
    public static int[] reversal_Link(ListNode1 head){
        ListNode1 current = head;
        int len = Print_linked_Array.getLength(current);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i]=current.val;
            current=current.next;
            if (current==null){
                break;
            }
        }
        return Print_linked_Array.reversal_Array(arr);
    }

//    声明链表
    static class ListNode1 {
        int val;
        ListNode1 next;

        ListNode1(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
