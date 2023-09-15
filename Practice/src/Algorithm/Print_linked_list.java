package Algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/2-09-02-13:52
 * @Description：Algorithm
 */
/*输入一个链表的头节点，从尾到头反过来返回每一个节点的值（数组放回）
* 步骤：
    * 链表的节点值，
    * 返回到栈中，
    * 从栈中读取到数组中*/
public class Print_linked_list {
    public static void main(String[] args) {
//        向链表插入数据
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        System.out.println(Arrays.toString(Print_linked_list.linkToReversal(head)));
    }

    public static int[] linkToReversal(ListNode head){

        //声明一个栈存放链表节点值
        Stack<Integer> stack = new Stack<>();
        //声明指针指向头节点，利用栈的性质：先进后出
        ListNode current = head;

        while (current!=null){
            //压栈
            stack.push(current.val);
            current=current.next;
        }
        int size = stack.size();
        //声明数组接收出栈数据
        int[] arr = new int[size];
        for (int i=0;i<size;i++){
            arr[i]=stack.pop();
        }
        return arr;
    }

//    声明链表
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
