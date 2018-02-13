/**
This algorithm is to implement reverse level traversal of tree, unlike level order traversal, which follows up-to-down manner, 
this does bottom-up manner. So I use one stack and one queue.

First, offer root into queue, then poll it into stack, if it has right child, offer into queue, then come left child.
Then, we follow the same procedure as above until queue is empty.
Finally, we take out all nodes from stack.
The example tree is as following: using this algorithm, we get the expected result: -1 10 7 8 6 9 4 5 2 3 1 
               1
            /     \
           2       3
         /  \     / \
        6   9    4   5
         \      / \
          10   7   8
          /
         -1



*/

import java.util.*;


public class Main {

    public static void main(String[] args) {
        // write your code here
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(10);
        root.left.left.right.left = new TreeNode(-1);
        root.left.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
      
        solution.stackList(root);
        for (int i = 0 ; i < solution.list.size(); i++) System.out.print(solution.list.get(i) + " ");
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
    Queue<TreeNode> q = new LinkedList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public void reverseLevelTraversal(TreeNode root) {
        if (root == null) return;
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode tmp = q.poll();
            s.push(tmp);
            if (tmp.right != null) q.offer(tmp.right);
            if (tmp.left != null) q.offer(tmp.left);
        }
    }
    public void stackList(TreeNode root) {
        reverseLevelTraversal(root);
        while (!s.isEmpty()) list.add(s.pop().val);
    }
}
