class StackArray {
    int[] arr;
    int top;
    int capacity;

    StackArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        arr[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return arr[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        StackArray st = new StackArray(5);

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Top: " + st.peek());
        System.out.println("Popped: " + st.pop());
        System.out.println("Top: " + st.peek());
        System.out.println("Size: " + st.size());
    }
}