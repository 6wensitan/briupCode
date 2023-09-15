package Algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/2-09-02-15:26
 * @Description：Algorithm
 */
/*
* 用两个栈实现一个队列，队列的声明如下，请实现它的两个函数appendTail和deleteHead，
* 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
* （若队列中没有元素，deleteHead返回-1。
* appendTail成功返回null*/

//    队列特点：先进先出，
//    栈特点：先进后出
public class Stack_implementation_queue {

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        Object[] result = new Object[6];

        result[0] = null; // CQueue
        result[1] = queue.deleteHead(); // deleteHead
        queue.appendTail(5); // appendTail
        queue.appendTail(2); // appendTail
        result[4] = queue.deleteHead(); // deleteHead
        result[5] = queue.deleteHead(); // deleteHead

        System.out.println(Arrays.toString(result));

    }
    static class CQueue{
        //使用两个栈来实现队列的增删
        Stack<Integer> stack ;
        Stack<Integer> stack1 ;
        public CQueue() {
            stack = new Stack<Integer>();
            stack1 = new Stack<Integer>();
        }

        public void appendTail(int value){
        /*
        为什么不用判断栈是否会满（针对Java内置栈）
        Java内置的Stack类是基于Vector实现的，Vector是动态数组，它的容量可以根据需要自动增长。
        因此，Java内置的Stack类不会满，可以一直添加元素到栈中。*/
            stack.push(value);
        }

        public int deleteHead() {
            if (!stack1.isEmpty()) {
                return stack1.pop();
            }
            //如果原始栈为空，则无数据
            if (stack.isEmpty()) {
                return -1;
            }
            /*
             * 先判断辅助栈中是否有元素，如果有直接返回，
             * 如果没有则需要从原始栈中不断pop，进而不断push进stack1，
             * 最后直接pop元素即可达到效果*/
            while (!stack.isEmpty()) {
                int topValue = stack.pop();
                stack1.push(topValue);
            }
            return stack1.pop();
        }
    }
}
