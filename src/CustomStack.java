class CustomStack<T> {
    private T[] stackArray;
    private int top;
    private int capacity;

    // Constructor to initialize the stack with a given size
    @SuppressWarnings("unchecked")
    public CustomStack(int size) {
        this.capacity = size;
        this.stackArray = (T[]) new Object[size];
        this.top = -1;
    }

    // Push operation
    public void push(T item) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full!");
        }
        stackArray[++top] = item;
    }

    // Pop operation
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return stackArray[top--];
    }

    // Peek operation
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return stackArray[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Get the current size of the stack
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // Output: 30
        System.out.println("Stack size: " + stack.size()); // Output: 3

        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Stack size after pop: " + stack.size()); // Output: 2
    }
}
