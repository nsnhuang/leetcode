package _225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用双队列实现
 */
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stackqueue. */
    public void push(int x) {
        q1.offer(x);
    }
    
    /** Removes the element on top of the stackqueue and returns that element. */
    public int pop() {
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
        int tmp = q1.poll();
        while (q2.size() != 0) {
            q1.offer(q2.poll());
        }
        return tmp;
    }
    
    /** Get the top element. */
    public int top() {
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
        return q1.peek();
    }
    
    /** Returns whether the stackqueue is empty. */
    public boolean empty() {
       return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        int top = myStack.top();
        int pop = myStack.pop();
        boolean empty = myStack.empty();
        System.out.println("top:" + top);
        System.out.println("pop:" + pop);
        System.out.println("empty:" + empty);
    }
}

