package DataStructuresClasses;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Created by S N Rao on 9/4/2016.
 */
public class Queue<T> {

    public static class QueueNode<T>{
        public T data;
        public QueueNode next;

        public QueueNode(T data){
            this.data=data;
            next=null;
        }
    }

    public QueueNode<T> first;
    public QueueNode<T> last;

    public void enqueue(T data){
        QueueNode<T> node=new QueueNode<T>(data);
        if(last!=null){
            last.next=node;
        }
        last=node;
        if(first==null){
            first=node;
        }
    }

    public T dequeue(){
        if(first==null){
            throw new NoSuchElementException();
        }
        T value=first.data;
        first=first.next;
        if(first==null){
            last=null;
        }
        return value;
    }

    public T peek(){
        if(first==null){
            throw new NoSuchElementException();
        }
        else{
            return first.data;
        }
    }

    public boolean isEmpty(){
        return (first==null);
    }

}
