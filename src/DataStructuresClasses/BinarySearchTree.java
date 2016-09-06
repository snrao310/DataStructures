package DataStructuresClasses;

/**
 * Created by S N Rao on 9/4/2016.
 */
public class BinarySearchTree {

    private static class BinaryTreeNode{
        int data;
        BinaryTreeNode right;
        BinaryTreeNode left;

        public BinaryTreeNode(int data){
            this.data=data;
            right=null;
            left=null;
        }
    }

    public BinaryTreeNode root;

    public void addNode(int data){
        root=addNode(root,data);
    }

    public boolean deleteNode(int data){
        return deleteNode(root,data);
    }

    public boolean search(int data){
        return search(root,data);
    }

    public void inOrderTraverse(){
        System.out.println();
        inOrderTraverse(root);
    }

    public void preOrderTraverse(){
        System.out.println();
        preOrderTraverse(root);
    }

    public void postOrderTraverse(){
        System.out.println();
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
                return node;
            }
            else if(data<node.data){
                node.left=addNode(node.left,data);
                return node;
            }
            else{
                return node;
            }
        }
    }

    public boolean deleteNode(BinaryTreeNode node, int data){
        if(node==null){
            return false;
        }
        if(data>node.data){
            return deleteNode(node.right,data);
        }
        else if(data<node.data){
            return deleteNode(node.left, data);
        }
        else{
            if(node.right==null && node.left==null){
                node=null;
                return true;
            }
            else if(node.right==null){
                node=node.left;
                return true;
            }
            else if(node.left==null){
                node=node.right;
                return true;
            }
            else{
                int val=minValue(node.right);
                node.data=val;
                deleteNode(node.right,val);
                return true;
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
        inOrderTraverse(node.left);
        System.out.print(node.data+" ");
        inOrderTraverse(node.right);
    }

    public void preOrderTraverse(BinaryTreeNode node){
        System.out.print(node.data+" ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public void postOrderTraverse(BinaryTreeNode node){
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data+" ");
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
