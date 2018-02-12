package com.company;

import com.sun.deploy.resources.Deployment_pt_BR;

import java.lang.annotation.ElementType;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        ArrayList<Integer> list = s.StackList(root);
        for (int i = 0 ; i < list.size(); i++) System.out.print(list.get(i) + " ");
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    Stack<TreeNode> s = new Stack<>();

    public void postOrder(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        TreeNode parent = null;
        s.push(cur);
        while (cur.right != null) {
            s.push(cur.right);
            parent = cur;
            cur = cur.right;
        }
        //if (cur.right == null) return;
        if (parent != null && parent.left != null) {
            postOrder(parent.left);
        }
    }
    public ArrayList<Integer> StackList(TreeNode root) {
        postOrder(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            list.add(node.val);
        }
        return list;
    }
}