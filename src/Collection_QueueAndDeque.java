import java.util.ArrayDeque;

public class Collection_QueueAndDeque {
    public static void main(String args[]) {
        Stack<Integer> newQueue = new Stack<Integer>();
        newQueue.addInStack(5);
        newQueue.addInStack(8);
        newQueue.addInStack(25);
        newQueue.addInStack(3);
        System.out.println(newQueue.amountOfElements());
        System.out.println(newQueue.lastElementInStack());
    }
    public static class Stack<T> {
        private ArrayDeque<T> stack = new ArrayDeque<T>();
        public void addInStack(T element) {
            stack.push(element);
        }
        public T removeFromStack() {
            return stack.pollLast();
        }
        public int amountOfElements() {
            int counter = 0;
            for(T singleElement : stack) {
                if (singleElement != null) {
                    counter++;
                }
            }
            return counter;
        }
        public boolean isStackEmpty() {
            if(amountOfElements() == 0) {
                return true;
            } else {
                return false;
            }
        }
        public boolean isStackFull() {
            if(amountOfElements() >= 16) {
                return true;
            } else {
                return false;
            }
        }
        public void cleanStack() {
            while(amountOfElements() != 0) {
                stack.removeLast();
            }
            System.out.println("Стэк очищен!");
        }
        public T lastElementInStack() {
            return stack.peekLast();
        }
    }
}
