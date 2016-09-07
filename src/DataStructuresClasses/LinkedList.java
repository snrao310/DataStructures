package DataStructuresClasses;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by S N Rao on 9/4/2016.
 */
public class LinkedList {

    public static int length;
    public LinkNode head;

    Scanner scanner=new Scanner(System.in);

    public LinkedList(){
        head=null;
        length=0;
    }


    public void populateList(){
        length=0;
        System.out.println("Enter numbers to add to linked list and then enter an alphabet");
        LinkNode node=head;
        while(scanner.hasNextInt()){
            if(head==null){
                int i=scanner.nextInt();
                node=new LinkNode(i);
                head=node;
            }
            else {
                node.next = new LinkNode(scanner.nextInt());
                node = node.next;
                node.next = null;
            }
            length++;
        }
    }


    public void insertToEnd(int data){
        if(head==null){
            head=new LinkNode(data);
            return;
        }

        LinkNode node=head;
        LinkNode newNode=new LinkNode(data);
        while (node.next!=null){
            node=node.next;
        }
        node.next=newNode;
        length++;
    }

    public void insertToBegining(int data){
        LinkNode node=head;
        LinkNode newNode=new LinkNode(data);
        newNode.next=head;
        head=newNode;
        length++;
    }

    public void insertToPosition(int data, int position){
        LinkNode nodeFront=head;
        LinkNode nodeBack=null;
        LinkNode newNode=new LinkNode(data);

        if(position==1){
            insertToBegining(data);
            return;
        }

        if(position==length){
            insertToEnd(data);
            return;
        }

        int i=0;
        while(i!=position-1){
            i++;
            nodeBack=nodeFront;
            nodeFront=nodeFront.next;
        }

        nodeBack.next=newNode;
        newNode.next=nodeFront;
        length++;
    }

    public void printList(){
        System.out.println(" The List is printed below: ");
        LinkNode node=head;
        while(node!=null){
            System.out.print(node.data+ " ");
            node=node.next;
        }
        System.out.print("\n");
    }


    public void deleteNodeFromEnd(){
        length--;
        LinkNode node=head;
        while(node.next.next!=null){
            node=node.next;
        }
        node.next=null;
    }

    public LinkNode deleteNodeFromBeginning(){
        length--;
        head=head.next;

        return head;
    }

    public void deleteNodeFromPosition(int position){
        if (position>length){
                return;
        }
        LinkNode node=head;
        LinkNode nodeBack=null;

        if(position==1){
            deleteNodeFromBeginning();
        }

        if(position==length){
            deleteNodeFromEnd();
        }

        int i=0;
        while(i!=position-1){
            i++;
            nodeBack=node;
            node=node.next;
        }
        nodeBack.next=node.next;
        length--;
    }

    public void deleteNodeValue(int value){
        LinkNode node=head;
        LinkNode nodeBack=null;

        if(head==null){
            return;
        }

        if(node.data==value){
            deleteNodeFromBeginning();
        }


        while( node!=null && node.data!=value){
            nodeBack=node;
            node=node.next;
        }

        if(node!=null) {
            nodeBack.next = node.next;
            length--;
        }
    }
}
