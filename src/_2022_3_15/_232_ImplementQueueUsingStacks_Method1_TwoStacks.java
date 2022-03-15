package _2022_3_15;

import java.util.Stack;

public class _232_ImplementQueueUsingStacks_Method1_TwoStacks {
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    /*
      思路: 利用两个Stack,inStack和outStack
        1--> push 直接push进入inStack
        2--> pop  2.1 看outStack里面是否有值，如果有的话直接pop,没有的话需要把
                      inStack里面的所有值pop出来push到outStack中去
     */

    public _232_ImplementQueueUsingStacks_Method1_TwoStacks () {
         inStack=new Stack<>();
         outStack=new Stack<>();
    }
    public void push(int x) {
        inStack.push(x);

    }

    public int pop() {
        if(!outStack.isEmpty()) return outStack.pop();
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.pop();

    }

    public int peek() {
        if(!outStack.isEmpty()) return outStack.peek();
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.peek();

    }

    public boolean empty() {
        return inStack.isEmpty()&&outStack.isEmpty();

    }
}
