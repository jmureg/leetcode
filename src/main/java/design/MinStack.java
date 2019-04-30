package design;

import java.util.Stack;

public class MinStack {
    Stack<int[]> stack = null;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stack = new Stack<int[]>();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        //minStack.push(5);
        System.out.println(minStack.getMin());   //--> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
    }

    public void push(int x) {
        if (stack != null && stack.size() > 0) {
            this.stack.add(new int[]{x, Math.min(stack.peek()[1], x)});
        } else {
            this.stack.add(new int[]{x, x});
        }

    }

    public void pop() {
        if (stack != null && stack.size() > 0) {
            stack.remove(stack.size() - 1);
        }
    }

    public int top() {
        if (stack != null && stack.size() > 0) {
            int[] lastElem = stack.peek();

            return lastElem[0];
        }

        return -1;
    }

    public int getMin() {
        if (stack.size() > 0) {
            return (stack.peek())[1];
        } else {
            return -1;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
