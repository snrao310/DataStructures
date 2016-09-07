package DataStructuresClasses;

/**
 * Created by S N Rao on 9/4/2016.
 */
public class BinarySearchTree {

    private static class BinaryTreeNode{
        int data;
        BinaryTreeNode right;
        BinaryTreeNode left;
        BinaryTreeNode parent;

        public BinaryTreeNode(int data){
            this.data=data;
            right=null;
            left=null;
            parent=null;
        }
    }

    public BinaryTreeNode root;

    public void addNode(int data){
        root=addNode(root,data);
    }

    public boolean deleteNode(int data){
        return (deleteNode(root,data)!=null);
    }

    public boolean search(int data){
        return search(root,data);
    }

    public void inOrderTraverse(){
        System.out.println("Inorder Traversal: ");
        inOrderTraverse(root);
    }

    public void preOrderTraverse(){
        System.out.println("PreOrder Traversal: ");;
        preOrderTraverse(root);
    }

    public void postOrderTraverse(){
        System.out.println("postOrder Traversal: ");;
        postOrderTraverse(root);
    }


    public BinaryTreeNode addNode(BinaryTreeNode node, int data){
        if(node==null){
            node=new BinaryTreeNode(data);
            return node;
        }
        else{
            if(data>node.data){
                node.right=addNode(node.right,data);
                node.right.parent=node;
                return node;
            }
            else if(data<node.data){
                node.left=addNode(node.left,data);
                node.left.parent=node;
                return node;
            }
            else{
                return node;
            }
        }
    }

    public BinaryTreeNode deleteNode(BinaryTreeNode node, int data){
        if(node==null){
            return null;
        }
        if(data>node.data){
            node.right= deleteNode(node.right,data);
            return node;
        }
        else if(data<node.data){
            node.left= deleteNode(node.left, data);
            return node;
        }
        else{
            if(node.right==null && node.left==null){
                return null;
            }
            else if(node.right==null){
                node.left.parent=node.parent;
                return node.left;
            }
            else if(node.left==null){
                node.right.parent=node.parent;
                return node.right;
            }
            else{
                int val=minValue(node.right);
                node.data=val;
                node.right=deleteNode(node.right,val);
                return node;
            }
        }
    }

    public boolean search(BinaryTreeNode node, int data){
        if(node==null){
            return false;
        }
        else if(node.data==data){
            return true;
        }
        else if(data>node.data){
            return search(node.right,data);
        }
        else if(node.left!=null){
            return search(node.left,data);
        }
        return false;
    }

    public void inOrderTraverse(BinaryTreeNode node){
        if(node!=null) {
            inOrderTraverse(node.left);
            System.out.print(node.data + " ");
            inOrderTraverse(node.right);
        }
    }

    public void preOrderTraverse(BinaryTreeNode node){
        if(node!=null) {
            System.out.print(node.data + " ");
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public void postOrderTraverse(BinaryTreeNode node){
        if(node!=null) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.print(node.data + " ");
        }
    }


    public void levelOrderTraverse(){
        Queue<BinaryTreeNode> queue=new Queue<BinaryTreeNode>();
        System.out.println();
        queue.enqueue(root);
        BinaryTreeNode node;

        while (!queue.isEmpty()){
            node=queue.dequeue();
            System.out.print(node.data+" ");
            if(node.left!=null) {
                queue.enqueue(node.left);
            }
            if(node.right!=null) {
                queue.enqueue(node.right);
            }
        }
    }

    public int minValue(BinaryTreeNode node){
        if(node.left==null){
            return node.data;
        }
        return minValue(node.left);
    }
}
