class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty() && minStack.isEmpty()){
            stack.push(val);
            minStack.push(val);
        }else{
            stack.push(val);
            if(val<=minStack.peek()){
                minStack.push(val);
            }
        }
    }
    
    public void pop() {
        if(!stack.isEmpty() && !minStack.isEmpty()){
            int top = stack.peek();
            if(top==minStack.peek()){
                minStack.pop();
            }
            stack.pop();
        }
        
    }
    
    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }
    
    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}
