import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class SimpleLinkedList<T> {
    private int size = 0;
    private SimpleLinkedListNode front = null;

    public SimpleLinkedList() {
    }
    public SimpleLinkedList(T[] values) {
        for (int i = 0; i < values.length; i++) {
            this.push(values[i]);
        }
    }

    public int size(){
        return this.size;
    }

    public void push(T value) {
        this.front = new SimpleLinkedListNode(value, this.front);
        this.size++;
    }

    public T pop() {
        if (this.front == null) {
            throw new NoSuchElementException();
        }

        T value = this.front.value;
        this.front = this.front.next;
        this.size--;

        return value;
    }

    public void reverse() {
        if (this.size == 0) {
            return;
        }

        SimpleLinkedListNode previous = null;
        SimpleLinkedListNode next;
        SimpleLinkedListNode current = this.front;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        this.front = previous;
    }

    public T[] asArray(Class<T> targetClass){
        SimpleLinkedListNode current = this.front;
        T[] targetInstance =  (T[]) Array.newInstance(targetClass, this.size());
        for (int i = 0; i < this.size; i++){
            targetInstance[i] = current.value;
            current = current.next;
        }
        return targetInstance;
    }

    private class SimpleLinkedListNode {
        private T value;
        private SimpleLinkedListNode next;
        private SimpleLinkedListNode(T value, SimpleLinkedListNode next){
            this.value = value;
            this.next  = next;
        }
    }
}
