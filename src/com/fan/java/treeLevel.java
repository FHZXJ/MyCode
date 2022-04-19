package com.fan.java;

import com.sun.org.apache.bcel.internal.generic.NEW;


import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author AIZXJ
 * @create 2022-04-19 14:32
 */
public class treeLevel {
    static class TNode  {
        String    value;
        TNode   left,right;
        TNode(String value){
            this.value = value;
        }
    }

    public static List treeLevel(TNode root, int level){
        List item = new ArrayList();
        LinkedList<TNode> list = new LinkedList();//队列
        if (root != null) list.add(root);
        int size = list.size();
        int count=1;
        while (size > 0) {
            for (int i = 0; i < size; i++) {
                TNode node = list.remove();
                if (count==level) item.add(node.value);
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
            count++;
            size = list.size();

        }
        return item;
    }


    public static void main(String[] args) {
        TNode tNode = new TNode("1");
        TNode tNode1 = new TNode("2");
        TNode tNode2 = new TNode("3");
        TNode tNode3 = new TNode("4");
        TNode tNode4 = new TNode("5");
        TNode tNode5 = new TNode("6");
        tNode.left = tNode1;
        tNode.right = tNode2;
        tNode1.left = tNode3;
        tNode1.right = tNode4;
        tNode2.left = tNode5;
        System.out.println(tNode.value);
        System.out.println(treeLevel(tNode,3));
    }
}
