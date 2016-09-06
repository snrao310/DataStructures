package DataStructuresClasses;

import sun.awt.image.ImageWatched;
import sun.awt.image.IntegerComponentRaster;

/**
 * Created by S N Rao on 9/4/2016.
 */
public class LinkNode {
    public int data;
    public LinkNode next;

    public LinkNode(){
        data= Integer.MIN_VALUE;
        next=null;
    }

    public LinkNode(int data){
        this.data=data;
        next=null;
    }
}
