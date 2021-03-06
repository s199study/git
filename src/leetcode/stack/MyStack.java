package leetcode.stack;

import java.util.*;

/**
 * @author : 石建雷
 * @date :2019/8/6
 */

public class MyStack {


   static Queue<Integer> a;
   static Queue<Integer> b;


    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();

    }

    /**
     * Push element x onto stack.
     *
     */
    public void push(int x) {
        a.offer(x);
        while (!b.isEmpty()) {
            a.offer(b.poll());
        }
        Queue temp = a;
        a = b;
        b = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return b.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {

        return b.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return b.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
        System.out.println(b.size());

    }
}
