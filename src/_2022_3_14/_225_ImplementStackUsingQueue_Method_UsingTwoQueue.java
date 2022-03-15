package _2022_3_14;

import java.util.LinkedList;
import java.util.Queue;
/*
   思路：利用两个queue，一个为data，一个为help
    1. push --> 直接压入data中
    2. pop --> 把data中的元素压到help中,当data中的size为1的时候,此时的元素为pop的元素
                 完成操作后,需要交换data和help的位置
    3. top---> 思路与pop一样，唯一的区别是把data中最后一个元素pop出来后，需要再次压入help中
 */

public class _225_ImplementStackUsingQueue_Method_UsingTwoQueue {
    private Queue<Integer> data;
    private Queue<Integer> help;
    public _225_ImplementStackUsingQueue_Method_UsingTwoQueue() {
         data=new LinkedList<>();
         help=new LinkedList<>();
    }

    public void push(int x) {
        data.offer(x);
    }

    public int pop() {
       while(data.size()!=1) help.offer(data.poll());
       int pop=data.poll();
       swap();
       return pop;
    }

    private void swap() {
        Queue<Integer> temp=new LinkedList<>();
        temp=data;
        data=help;
        help=temp;
    }

    public int top() {
        while(data.size()!=1) help.offer(data.poll());
        int top=data.poll();
        help.offer(top);
        swap();
        return top;

    }

    public boolean empty() {
         return data.isEmpty()&&help.isEmpty();
    }
}
