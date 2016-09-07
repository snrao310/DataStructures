package ExecutionClasses;

import DataStructuresClasses.BinarySearchTree;
import DataStructuresClasses.Graph;
import DataStructuresClasses.LinkedList;
import static java.lang.System.out;

/**
 * Created by S N Rao on 9/4/2016.
 */
public class MainClass {

    public static void main(String args[]){

        out.println("LINKED LIST TEST");
        LinkedList list=new LinkedList();
        list.populateList();
        list.printList();

        out.println("Inserting 10 to the end");
        list.insertToEnd(10);
        list.printList();

        out.println("Inserting 19 to the beginning");
        list.insertToBegining( 19);
        list.printList();

        out.println("Inserting 22 to the position 2");
        list.insertToPosition( 22, 2);
        list.printList();

        out.println("Deleting from the beginning");
        list.deleteNodeFromBeginning();
        list.printList();

        out.println("Deleting from the end");
        list.deleteNodeFromEnd();
        list.printList();

        out.println("Deleting node at position 2");
        list.deleteNodeFromPosition( 2);
        list.printList();



        out.println(" \n\nTREE TEST");
        BinarySearchTree bst=new BinarySearchTree();
        out.println("\nTree\nAdding nodes 6,4,7,19,2,1,5");
        bst.addNode(6);
        bst.addNode(4);
        bst.addNode(7);
        bst.addNode(19);
        bst.addNode(2);
        bst.addNode(1);
        bst.addNode(5);
        bst.inOrderTraverse();
        out.println("\nDeleting node 4");
        bst.deleteNode(4);
        bst.inOrderTraverse();


        out.println("\n\nGRAPH TESTS");
        Graph graph=new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addNode(7);
        graph.addEdge(1,2);
        graph.addEdge(2,1);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(5,6);
        graph.BFS(1);
        graph.BFS(5);
        graph.removeNode(3);
        graph.DFS(1);
    }
}
