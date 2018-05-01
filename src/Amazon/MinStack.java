package Amazon;

import java.util.Stack;

/**
 * Created by kushal on 10/24/17.
 */
class MinStack {
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if(minStack.peek()>x){
            minStack.push(x);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
