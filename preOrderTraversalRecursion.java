/**
This algorithm is to implement pre-Order traversal of a tree using one stack. 
This method is same as postOrderTraversal.java (please check the class for details.
The example tree is as following: using this algorithm, we get the expected result: 1 2 6 10 -1 9 3 4 7 8 5 

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


public class inOrderTraversalRecursion {

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
        ArrayList<Integer> list = solution.getList(root);
        solution.preOrderTraversal(root);
        /*while (!solution.s.isEmpty()) {
            TreeNode t = solution.s.pop();
            solution.list.add(t.val);
        }*/
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
   // TreeNode tmp = null;
    ArrayList<Integer> list = new ArrayList<>();

    public void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        preOrderTraversal(root.right);
        s.push(root);
        preOrderTraversal(root.left);
    }
    public ArrayList<Integer> getList(TreeNode root) {
        preOrderTraversal(root);
        while (!s.isEmpty()) {
            list.add(s.pop().val);
        }
        return list;
    }
}
