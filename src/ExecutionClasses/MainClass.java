package ExecutionClasses;

import DataStructuresClasses.LinkedList;
import static java.lang.System.out;

/**
 * Created by S N Rao on 9/4/2016.
 */
public class MainClass {

    public static void main(String args[]){

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
    }
}
