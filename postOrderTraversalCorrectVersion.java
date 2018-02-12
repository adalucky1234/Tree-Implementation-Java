/**
for this version, we implement post Order Traversal of tree using one stack, simply just push current root node, 
then recursively push its right subtree, then recursively push its left subtree.

For this example tree, we get the expected result: 6 9 2 7 8 4 5 3 1 

      1
    /  \
   2    3
 /  \   / \
6   9   4  5
    / \
   7   8

*/



public class postOrderTraversalCorrectVersion {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        solution.postOrderTraversal(root);
        while (!solution.s.isEmpty()) {
            TreeNode t = solution.s.pop();
            solution.list.add(t.val);
        }
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
    ArrayList<Integer> list = new ArrayList<>();

    public void postOrderTraversal(TreeNode root) {
        if(root == null) return;
        s.push(root); // push root first, guarentee it's been poped out lastly
        if (root.right != null) {
            postOrderTraversal(root.right); // if has right child, then recursively push into stack
        }
        if (root.left != null) {
            postOrderTraversal(root.left); // if has left child, then recursively push into stack
        }
    }
}
