package DataStructuresClasses;

import java.util.HashMap;

/**
 * Created by S N Rao on 9/4/2016.
 */
public class Graph {

    HashMap<Integer, LinkedList> nodes;

    public void addNode(int newNode){
        nodes.put(newNode, null);
    }

    public void removeNode(int node){
        if(nodes.containsKey(node)) {
            nodes.remove(node);
        }
    }

    public void addEdge(int node1, int node2){
        if(nodes.containsKey(node1)&& nodes.containsKey(node2)){
            nodes.get(node1).insertToEnd(node2);
        }
    }

    public void deleteEdge(int node1, int node2){
        if(nodes.containsKey(node1) && nodes.containsKey(node2)){
            nodes.get(node1).deleteNodeValue(node2);
        }
    }

    public LinkedList getConnectedEdges(int node){
        return nodes.get(node);
    }

    public void BFS(int start){

    }

    public void DFS(int start){

    }
}
