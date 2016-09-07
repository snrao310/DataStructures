package DataStructuresClasses;

import java.util.HashMap;

/**
 * Created by S N Rao on 9/4/2016.
 */
public class Graph {

    HashMap<Integer, LinkedList> nodes=new HashMap<Integer,LinkedList>();

    public void addNode(int newNode) {
        nodes.put(newNode, new LinkedList());
    }

    public void removeNode(int node) {
        if (nodes.containsKey(node)) {
            nodes.remove(node);
        }
        for(int i:nodes.keySet()){
            LinkedList ll=nodes.get(i);
            ll.deleteNodeValue(node);
        }
    }

    public void addEdge(int node1, int node2) {
        if (nodes.containsKey(node1) && nodes.containsKey(node2)) {
            nodes.get(node1).insertToEnd(node2);
        }
    }

    public void deleteEdge(int node1, int node2) {
        if (nodes.containsKey(node1) && nodes.containsKey(node2)) {
            nodes.get(node1).deleteNodeValue(node2);
        }
    }

    public LinkedList getConnectedEdges(int node) {
        return nodes.get(node);
    }

    public void BFS(int start) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(start);
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

        for (int node : nodes.keySet()) {
            visited.put(node, false);
        }

        while (!queue.isEmpty()) {
            int currNode = queue.dequeue();
            visited.put(currNode, true);
            System.out.println("Visited " + currNode);
            LinkedList ll = getConnectedEdges(currNode);
            LinkNode node = ll.head;
            while (node != null) {
                if (!visited.get(node.data))
                    queue.enqueue(node.data);
                node=node.next;
            }
        }

        System.out.println();
    }

    public void DFS(int start) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

        for (int node : nodes.keySet()) {
            visited.put(node, false);
        }

        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            visited.put(currNode, true);
            System.out.println("Visited " + currNode);
            LinkedList ll = getConnectedEdges(currNode);
            LinkNode node = ll.head;
            while (node != null) {
                if (!visited.get(node.data))
                    stack.push(node.data);
                node=node.next;
            }
        }
        System.out.println();
    }
}
