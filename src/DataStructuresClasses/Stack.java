package DataStructuresClasses;

import java.util.EmptyStackException;

/**
 * Created by S N Rao on 9/4/2016.
 */
public class Stack<T> {

    private static class StackNode<T>{
        public T data;
        public StackNode<T> next;

        public StackNode(T data){
            this.data=data;
            next=null;
        }
    }

    public StackNode<T> top;

    public void push(T data){
        StackNode<T> stackNode=new StackNode<T>(data);
        stackNode.next=top;
        top=stackNode;
    }

    public T pop() {
        if(top==null) throw new EmptyStackException();
        T value = top.data;
        top = top.next;
        return value;
    }

    public T peek(){
        if(top==null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        if(top==null){
            return true;
        }
        return false;
    }
}
